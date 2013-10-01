package com.app.ui.servlet;

import com.app.file.MyResourceFiles;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyServletData;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyUrlBridge;
import com.app.utility.MyUrls;

import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.json.KmJsonUtility;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.utility.Kmu;

/**
 * Handle entry into the application, typically initiated
 * from an HTTP GET.  
 * 
 * -- Redirect to a standard url.      
 * -- Redirect the GET with a POST.
 * -- Begin the server session and register the cookie.
 * -- Generate the minimal html page, just enough to bootstrap the first ajax request.
 */
public class MyMainServlet
    extends MyServlet
    implements MyServletConstantsIF
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        MyServletData data = getData();

        if ( handleRedirectUrl(data) )
            return;

        data.redirectWithPost();
    }

    @Override
    protected void doPost()
    {
        beginServerSession();
        String html = formatHtml();
        getData().setHtmlResult(html);
    }

    /**
     * Redirect the client to a standard url.
     * If the user accessed the site via IP, this will redirect
     * to a standard host name.  This will also force the user
     * to https (if enabled).
     */
    protected boolean handleRedirectUrl(MyServletData data)
    {
        MyPropertyRegistry p = getProperties();

        if ( !p.getServletRedirect() )
            return false;

        String scheme = p.getServletScheme();
        String host = p.getServletHost();
        String port = p.getServletPort();

        String requestScheme = data.getRequestScheme();
        String requestHost = data.getRequestServerName();
        String requestPath = data.getRequestUri();
        KmMap<String,String> requestParams = data.getParameterMap();

        boolean schemeMatches = requestScheme.equalsIgnoreCase(scheme);
        boolean hostMatches = requestHost.equalsIgnoreCase(host);

        if ( schemeMatches && hostMatches )
            return false;

        String url;
        url = MyUrls.formatUrl(scheme, host, port, requestPath, requestParams);

        data.redirectTo(url);

        return true;
    }

    //##################################################
    //# format html
    //##################################################

    private String formatHtml()
    {
        KmFile file = MyResourceFiles.getInstance().getPageLayout();

        String name = MyConstantsIF.APPLICATION_NAME;
        String version = MyConstantsIF.APPLICATION_VERSION;
        String versionFolder = MyUrlBridge.getInstance().getVersionFolder();
        String params = formatParameters();

        String s;
        s = file.readString();
        s = Kmu.replaceAll(s, "${applicationName}", name);
        s = Kmu.replaceAll(s, "${applicationVersion}", version);
        s = Kmu.replaceAll(s, "${versionFolder}", versionFolder);
        s = Kmu.replaceAll(s, "${params}", params);
        return s;
    }

    /**
     * Encode any parameters into the initial structure. 
     */
    private String formatParameters()
    {
        MyServletData data = getData();
        if ( !data.hasParameters() )
            return "";

        KmMap<String,String> map = data.getParameterMap();
        String encoded = ScEncoder.staticEncode(map);
        String wrapped = KmJsonUtility.format(encoded);

        return wrapped;
    }

}
