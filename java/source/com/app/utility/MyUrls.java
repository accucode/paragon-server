package com.app.utility;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.utility.Kmu;

import com.app.model.MyDownload;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyPasswordReset;
import com.app.property.MyPropertyRegistry;
import com.app.ui.page.login.MyAcceptNewUserInvitationPage;
import com.app.ui.servlet.MyServletConstantsIF;

public class MyUrls
    implements MyServletConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String PARAMETER_INVITATION     = "invitation";
    public static final String PARAMETER_PASSWORD_RESET = "passwordReset";

    //##################################################
    //# top urls
    //##################################################

    public static String getEntryUrl()
    {
        return formatUrl("");
    }

    public static String getEntryUrl(ScParameterList params)
    {
        if ( params == null || params.isEmpty() )
            return formatUrl("");

        return formatServletUrl("main", params);
    }

    public static String getInvitationUrl(MyInvitation e)
    {
        MyInvitationType type = e.getType();
        switch ( type )
        {
            case User:
                return MyAcceptNewUserInvitationPage.instance.formatEntryUrl();

            case Join:
            case Transfer:
                ScParameterList params;
                params = new ScParameterList();
                params.setValue(PARAMETER_INVITATION, e.getAccessKey());

                return getEntryUrl(params);
        }

        return null;
    }

    public static String getPasswordResetUrl(MyPasswordReset e)
    {
        ScParameterList params;
        params = new ScParameterList();
        params.setValue(PARAMETER_PASSWORD_RESET, e.getAccessKey());

        return getEntryUrl(params);
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

    private static String formatUrl(String path)
    {
        ScParameterList params = null;
        return formatUrl(path, params);
    }

    private static String formatUrl(String path, ScParameterList params)
    {
        MyPropertyRegistry p = getProperties();
        String scheme = p.getServletScheme();
        String host = p.getServletHost();
        String port = p.getServletPort();
        return formatUrl(scheme, host, port, path, params);
    }

    public static String formatUrl(
        String scheme,
        String host,
        String port,
        String path,
        ScParameterList requestParams)
    {
        StringBuilder out = new StringBuilder();
        if ( Kmu.hasValue(scheme) )
        {
            out.append(scheme);
            out.append("://");
        }

        out.append(host);

        if ( Kmu.hasValue(port) )
        {
            out.append(":");
            out.append(port);
        }

        if ( Kmu.hasValue(path) )
            out.append(path);

        if ( requestParams != null )
            out.append(requestParams.formatUrl());

        return out.toString();
    }

    private static MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
