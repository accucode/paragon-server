package com.app.utility;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.MyDownload;
import com.app.model.MyPasswordReset;
import com.app.model.MyTenant;
import com.app.ui.core.MyServletData;
import com.app.ui.page.login.MyPasswordResetPage;
import com.app.ui.servlet.MyServletConstantsIF;

public class MyUrls
    implements MyServletConstantsIF
{
    //##################################################
    //# urls
    //##################################################

    /**
     * A entry url that generally leads back to the top of the module
     * you are already in. For example, this will re-enter the main app,
     * developer tools, or onling store that you are already viewing.
     */
    public static String getEntryUrl()
    {
        return formatUrl("");
    }

    public static String getEntryUrl(ScParameterList params)
    {
        return params == null || params.isEmpty()
            ? formatUrl("")
            : formatServletUrl("main", params);
    }

    public static String getEntryUrl(MyTenant tenant, ScParameterList params)
    {
        return formatServletUrl(tenant, "main", params);

    }

    public static String getPasswordResetUrl(MyPasswordReset e)
    {
        return MyPasswordResetPage.getInstance().formatEntryUrl(e);
    }

    public static String getCallbackUrl()
    {
        return formatServletUrl("callback");
    }

    public static String getCallbackPath()
    {
        return formatServletPath("callback");
    }

    public static String getDownloadUrl(MyDownload e)
    {
        return formatServletUrl("download/" + e.getUid());
    }

    public static String getOneAllCallbackUrl()
    {
        return formatServletUrl("oneall");
    }

    //##################################################
    //# private
    //##################################################

    public static String formatServletPath(String servlet)
    {
        // Assumes ROOT (implied) context
        return Kmu.joinUrlPath(SERVLET_ROOT, SERVLET_PATH, servlet);
    }

    private static String formatServletUrl(String servlet)
    {
        ScParameterList params = null;
        return formatServletUrl(servlet, params);
    }

    private static String formatServletUrl(String servlet, ScParameterList params)
    {
        String path = formatServletPath(servlet);
        return formatUrl(path, params);
    }

    private static String formatServletUrl(MyTenant tenant, String servlet, ScParameterList params)
    {
        String path = formatServletPath(servlet);
        return formatUrl(tenant, path, params);
    }

    private static String formatUrl(String path)
    {
        ScParameterList params = null;
        return formatUrl(path, params);
    }

    private static String formatUrl(String path, ScParameterList params)
    {
        MyServletData data = MyServletData.getLocal();

        String scheme = data.getRequestScheme();
        String host = data.getRequestServerHostName();
        int port = data.getRequestServerPort();

        return formatUrl(scheme, host, port, path, params);
    }

    private static String formatUrl(MyTenant tenant, String path, ScParameterList params)
    {
        MyServletData data = MyServletData.getLocal();

        String scheme = data.getRequestScheme();
        String host = tenant.getHostname();
        int port = data.getRequestServerPort();

        return formatUrl(scheme, host, port, path, params);
    }

    public static String formatUrl(
        String scheme,
        String host,
        Integer port,
        String path,
        ScParameterList requestParams)
    {
        KmStringBuilder out = new KmStringBuilder();

        if ( Kmu.hasValue(scheme) )
        {
            out.print(scheme);
            out.print("://");
        }

        out.print(host);

        if ( port != null && port != 80 )
        {
            out.print(":");
            out.print(port);
        }

        if ( Kmu.hasValue(path) )
            out.print(path);

        if ( requestParams != null )
            out.print(requestParams.formatUrl());

        return out.toString();
    }

}
