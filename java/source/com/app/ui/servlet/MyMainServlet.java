package com.app.ui.servlet;

import com.kodemore.collection.KmMap;
import com.kodemore.command.KmDao;
import com.kodemore.file.KmFile;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.utility.Kmu;

import com.app.dao.MyTenantDao;
import com.app.file.MyResourceFiles;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.property.MyProperties;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.login.MyLoginUtility;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrlBridge;
import com.app.utility.MyUrls;

/**
 * Handle entry into the application, typically initiated
 * from an HTTP GET.
 *
 * -- Redirect to a standard url.
 * -- Redirect the GET with a POST (to avoid caching).
 * -- Begin the server session and register the cookie.
 * -- Generate the minimal html page, just enough to bootstrap the first ajax request.
 */
public class MyMainServlet
    extends MyServlet
    implements MyServletConstantsIF
{
    //##################################################
    //# get
    //##################################################

    @Override
    protected void doGet()
    {
        MyServletData data = getData();

        if ( handleLocalhostCheck(data) )
            return;

        if ( handleTenantCheck(data) )
            return;

        if ( handleSslRedirect(data) )
            return;

        data.redirectWithPost();
    }

    /**
     * In development, redirect "localhost" to the system tenant.
     */
    private boolean handleLocalhostCheck(MyServletData data)
    {
        MyProperties p = getProperties();

        boolean dev = p.isEnvironmentDevelopment();
        if ( !dev )
            return false;

        String host = data.getRequestServerHostName();
        boolean isLocalhost = host.equalsIgnoreCase("localhost");

        if ( !isLocalhost )
            return false;

        redirectToSystemTenant(data);
        return true;
    }

    private void redirectToSystemTenant(MyServletData data)
    {
        MyTenantDao dao = MyGlobals.getAccess().getTenantDao();
        MyTenant tenant = KmDao.fetch(dao::findSystemTenant);

        String scheme = data.getRequestScheme();
        String host = tenant.getHostname();
        int port = data.getRequestServerPort();

        String url = Kmu.format("%s://%s:%s", scheme, host, port);
        data.redirectTo(url);
    }

    /**
     * Confirm the request is for a valid tenant.
     * The tenant is determined by the URL hostname.
     */
    private boolean handleTenantCheck(MyServletData data)
    {
        MyTenant tenant = KmDao.fetch(data::getTenant);
        if ( tenant != null )
            return false;

        printUnknownTenantPage(data);
        return true;
    }

    private void printUnknownTenantPage(MyServletData data)
    {
        String appName = MyConstantsIF.APPLICATION_NAME;
        String marketingUrl = getProperties().getMarketingUrl();
        String supportUrl = getProperties().getSupportUrl();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();

        out.beginHead();
        out.printMetaCharsetUtf8();
        out.printTitle(appName);
        out.endHead();

        out.beginBody();

        out.printHeader(1, "Welcome to " + appName);
        out.printHeader(2, "The requested tenant is not available.");
        out.println();
        out.print("For sales and marketing use: ");
        out.printLink(marketingUrl);
        out.println();
        out.println();
        out.print("For technical issues and assistance, contact our support team: ");
        out.printLink(supportUrl);

        out.endBody();
        out.endHtml();

        data.setHtmlResult(out);
    }

    /**
     * Redirect the client to a standard url.
     * If the user accessed the site via IP, this will redirect
     * to a standard host name.  This will also force the user
     * to https (if enabled).
     */
    protected boolean handleSslRedirect(MyServletData data)
    {
        MyProperties p = getProperties();

        if ( !p.getServletSslRedirect() )
            return false;

        if ( data.hasSecureRequest() )
            return false;

        String requestHost = data.getRequestServerHostName();
        String requestPath = data.getRequestUri();
        ScParameterList requestParams = data.getParameterList();

        String sslScheme = "https";
        int sslPort = 443;

        String url;
        url = MyUrls.formatUrl(sslScheme, requestHost, sslPort, requestPath, requestParams);

        data.redirectTo(url);
        return true;
    }

    //##################################################
    //# post
    //##################################################

    @Override
    protected void doPost()
    {
        MyServerSession ss = beginServerSession();
        String html = formatAppPage(ss);
        getData().setHtmlResult(html);
    }

    //##################################################
    //# app page
    //##################################################

    private String formatAppPage(MyServerSession ss)
    {
        MyResourceFiles files = MyResourceFiles.getInstance();
        KmFile file = files.getPageLayout();

        String s;
        s = file.readString();
        s = Kmu.replaceAll(s, getAppMacros(ss));
        return s;
    }

    private KmMap<String,String> getAppMacros(MyServerSession ss)
    {
        KmMap<String,String> map;
        map = new KmMap<>();
        map.put("${applicationName}", MyConstantsIF.APPLICATION_NAME);
        map.put("${applicationVersion}", MyConstantsIF.APPLICATION_VERSION);
        map.put("${versionFolder}", MyUrlBridge.getInstance().getVersionFolder());
        map.put("${query}", formatAppQueryString());
        map.put("${html}", MyPageLayout.getInstance().renderHtml());
        map.put("${bodyClass}", MyLoginUtility.getEnvironmentCssFor(ss.getUser()));
        map.put("${oneAllHead}", formatAppOneAllHead());
        map.put("${themeToken}", MyServletConstantsIF.THEME_TOKEN);
        map.put("${pageMenuFieldId}", MyPageLayout.getInstance().getMenu().getPageMenuFieldId());
        map.put("${initialGlobalSession}", getData().getPageSession().formatGlobalValues());
        map.put("${initialPageSession}", getData().getPageSession().formatSessionValues());
        return map;
    }

    private String formatAppQueryString()
    {
        String s = getData().formatParametersAsQueryString();

        if ( Kmu.isEmpty(s) )
            s = MyAppNavigator.formatEntryPageQueryString();

        return s;
    }

    private String formatAppOneAllHead()
    {
        boolean enabled = getProperties().getOneAllEnabled();
        if ( !enabled )
            return "";

        MyResourceFiles files = MyResourceFiles.getInstance();
        String template = files.getOneAllHead().readString();

        String host = getProperties().getOneAllHost();
        if ( host == null )
            host = "";

        return Kmu.replaceAll(template, "${oneAllHost}", host);
    }
}
