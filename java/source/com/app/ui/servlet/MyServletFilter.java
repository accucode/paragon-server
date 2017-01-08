package com.app.ui.servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.collection.KmTwoKeyMap;
import com.kodemore.command.KmDao;
import com.kodemore.utility.KmConstantsIF;

import com.app.model.MyTenant;
import com.app.model.support.MyTheme;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrlBridge;

/**
 * I am used to rewrite all of the application uri's.
 *
 * VERSION
 * We write the application version into the url path.
 * This allows us to set long expirations on all web resources
 * so that browser can cache static content indefinitely.
 * But this also ensures that clients will not continue to
 * cache stale content when we update the application. When
 * serving content, we look for urls that contain the application
 * version and rewrite them in a normalized format that can be
 * served by the web server. Thus...
 *
 *      Changes: /app/static/version-Build-120701-1/.../a.png
 *           to: /app/static/version/.../a.png
 *
 * THEME
 * Each tenant may use a different theme. Theme customization
 * is handled by overwriting selected files. Any file that is
 * not overwritten by the theme is redirected to the common version.
 * Thus if theme XXX does not overwrite the logo, then...
 *
 *      Changes: /app/static/.../[theme]/image/logo.png
 *           to: /app/static/.../theme/XXX/image/logo.png
 *           or: /app/static/.../common/image/logo.png
 */
public class MyServletFilter
    implements Filter, KmConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String                      THEME_TOKEN    = MyServletConstantsIF.THEME_TOKEN;

    //##################################################
    //# static cache
    //##################################################

    /**
     * hostname -> requestedUri -> responseUri
     */
    private static KmTwoKeyMap<String,String,String> _themeUriCache = new KmTwoKeyMap<>();

    //##################################################
    //# interface
    //##################################################

    @Override
    public void init(FilterConfig e) throws ServletException
    {
        // none
    }

    @Override
    public void destroy()
    {
        // none
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;

        String oldUri = req.getRequestURI();
        String newUri = fixRequestUri(req, oldUri);

        if ( newUri.equals(oldUri) )
        {
            chain.doFilter(req, res);
            return;
        }

        //Assumes ROOT (implied) context
        req.getRequestDispatcher(newUri).forward(req, res);
    }

    //##################################################
    //# fix version
    //##################################################

    private String fixRequestUri(HttpServletRequest req, String uri)
    {
        uri = fixRequestUriVersion(uri);
        uri = fixRequestUriTheme(req, uri);
        return uri;
    }

    /**
     * Changes: /app/static/version-Build-120701-1/.../a.png
     *      to: /app/static/version/.../a.png
     */
    private String fixRequestUriVersion(String uri)
    {
        MyUrlBridge urls = MyUrlBridge.getInstance();

        String a = urls.getVersionFolder();
        String b = urls.getStaticVersionFolder();

        if ( a.equals(b) )
            return uri;

        a = SLASH + a + SLASH;
        b = SLASH + b + SLASH;

        return uri.replace(a, b);
    }

    //##################################################
    //# fix theme
    //##################################################

    /**
     * If the url is requesting a 'theme' resource that does not exists,
     * redirect to the corresponding 'base' resource. If a particular
     * tenant uses the 'blue' theme, then...
     *
     * Change: /app/static/.../app/theme/[theme]/image/logo.png
     *     to: /app/static/.../app/theme/blue/image/logo.png
     *     or: /app/static/.../app/theme/base/image/logo.png
     */
    private String fixRequestUriTheme(HttpServletRequest req, String uri)
    {
        int themeIndex = uri.indexOf(THEME_TOKEN);
        return themeIndex < 0
            ? uri
            : getThemeUri(req, uri);
    }

    private String getThemeUri(HttpServletRequest req, String reqUri)
    {
        String host = req.getServerName();

        String resUri = getCachedThemeUri(host, reqUri);
        if ( resUri == null )
        {
            resUri = computeThemeUri(req, reqUri);
            putCachedThemeUri(host, reqUri, resUri);
        }

        return resUri;
    }

    private String computeThemeUri(HttpServletRequest req, String reqUri)
    {
        MyTheme theme = getTheme(req);
        String themeFolder = theme.getWebFolder();
        String themeUri = reqUri.replace(THEME_TOKEN, themeFolder);

        boolean exists = exists(req, themeUri);
        if ( exists )
            return themeUri;

        return reqUri.replace(THEME_TOKEN, "base");
    }

    //==================================================
    //= cached theme uri
    //==================================================

    private static synchronized String getCachedThemeUri(String host, String reqUri)
    {
        return _themeUriCache.get(host, reqUri);
    }

    private static synchronized String putCachedThemeUri(String host, String reqUri, String resUri)
    {
        return _themeUriCache.put(host, reqUri, resUri);
    }

    public static synchronized void clearCachedThemeUris()
    {
        _themeUriCache.clear();
    }

    //##################################################
    //# support
    //##################################################

    private MyTheme getTheme(HttpServletRequest req)
    {
        return KmDao.fetch(this::getThemeDao, req);
    }

    private MyTheme getThemeDao(HttpServletRequest req)
    {
        String host = req.getServerName();
        MyTenant tenant = MyGlobals.getAccess().getTenantDao().findHostname(host);

        return tenant == null
            ? MyTheme.Default
            : tenant.getTheme();
    }

    private boolean exists(HttpServletRequest req, String uri)
    {
        try
        {
            URL url = req.getServletContext().getResource(uri);
            return url != null;
        }
        catch ( MalformedURLException ex )
        {
            return false;
        }

    }
}
