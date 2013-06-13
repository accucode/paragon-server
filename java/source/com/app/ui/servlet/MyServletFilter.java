package com.app.ui.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

import com.app.utility.MyUrlBridge;

/**
 * I am used to rewrite all of the application uri's.  More 
 * specifically, I look for uri's that contain the application
 * version and rewrite them in a normalized format.  Thus...
 * 
 *      Change: /app/static/version-Build-120701-1/app/theme/default/image/a.png
 *      To:     /app/static/version/app/theme/default/image/a.png
 */
public class MyServletFilter
    implements Filter, KmConstantsIF
{
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
        String newUri = fixRequestUri(oldUri);

        if ( newUri.equals(oldUri) )
        {
            chain.doFilter(req, res);
            return;
        }

        String fwd = removeContext(newUri);

        req.getRequestDispatcher(fwd).forward(req, res);
    }

    //##################################################
    //# support
    //##################################################

    private String fixRequestUri(String uri)
    {
        return MyUrlBridge.getInstance().fixRequestUri(uri);
    }

    private String removeContext(String s)
    {
        String prefix = SLASH + MyServletConstantsIF.SERVLET_CONTEXT;
        String fullPrefix = prefix + SLASH;

        if ( s.startsWith(fullPrefix) )
            s = Kmu.removePrefix(s, prefix);

        return s;
    }
}
