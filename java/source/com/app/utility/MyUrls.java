package com.app.utility;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.utility.KmAsserts;
import com.kodemore.utility.Kmu;

import com.app.model.MyAttachment;
import com.app.model.MyDownload;
import com.app.model.MyTenant;
import com.app.ui.core.MyServletData;
import com.app.ui.servlet.MyServletConstantsIF;

public class MyUrls
    implements MyServletConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    /**
     * This is used to identify the servlet responsible for
     * rendering the main HTML content. This is typically used
     * to compose the initial GET response, whereas subsequent
     * requests are handled by increment AJAX posts.
     */
    private static final String MAIN_SERVLET = "main";

    //##################################################
    //# urls
    //##################################################

    /**
     * Format a complete URL that can be used to enter the application.
     *
     * Within the application, navigation usually requires only the query string.
     * The complete entry url is mainly required when passing a URL to an external
     * third party, such as another web server, or when embedding the url
     * in an email.
     *
     * REQUIRES an active http request to infer the tenant/host.
     */
    public static String formatEntryUrl()
    {
        return newRequestInfo().formatUrl();
    }

    /**
     * Format a complete URL that can be used to enter the application,
     * for the specified tenant.
     */
    public static String formatEntryUrl(MyTenant tenant, ScParameterList params)
    {
        KmAsserts.isNotNull(tenant);

        MyUrlInfo e;
        e = getDefaultInfo();
        e.setHostFor(tenant);
        e.setPath(formatServletPath(MAIN_SERVLET));
        e.setParameters(params);
        return e.formatUrl();
    }

    //##################################################
    //# paths
    //##################################################

    public static String getCallbackPath()
    {
        return formatServletPath("callback");
    }

    //##################################################
    //# servlet urls
    //##################################################

    public static String getCallbackUrl()
    {
        return formatServletUrl("callback");
    }

    public static String getDownloadUrl(MyDownload e)
    {
        return formatServletUrl("download/" + e.getUid());
    }

    public static String getAttachmentUrl(MyAttachment e)
    {
        return formatServletUrl("attachment/" + e.getUid());
    }

    public static String getOneAllCallbackUrl()
    {
        return formatServletUrl("oneall");
    }

    /**
     * REQUIRES an active http request to infer the tenant/host.
     */
    private static String formatServletUrl(String servlet)
    {
        MyUrlInfo e;
        e = new MyUrlInfo();
        e.setRequestScheme();
        e.setRequestHost();
        e.setRequestPort();
        e.setPath(formatServletPath(servlet));
        return e.formatUrl();
    }

    //##################################################
    //# defaults
    //##################################################

    private static MyUrlInfo getDefaultInfo()
    {
        return hasData()
            ? newRequestInfo()
            : newWebInfo();
    }

    private static MyUrlInfo newWebInfo()
    {
        MyUrlInfo e;
        e = new MyUrlInfo();
        e.setWebPort();
        e.setWebScheme();
        return e;
    }

    private static MyUrlInfo newRequestInfo()
    {
        MyUrlInfo e;
        e = new MyUrlInfo();
        e.setRequestScheme();
        e.setRequestHost();
        e.setRequestPort();
        return e;
    }

    //##################################################
    //# support
    //##################################################

    private static boolean hasData()
    {
        return MyServletData.hasLocal();
    }

    public static String formatServletPath(String servlet)
    {
        return Kmu.joinUrlPath(SERVLET_ROOT, SERVLET_PATH, servlet);
    }

}
