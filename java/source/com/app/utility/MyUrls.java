package com.app.utility;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

import com.app.model.MyDownload;
import com.app.model.MyInvitation;
import com.app.model.MyPasswordReset;
import com.app.property.MyPropertyRegistry;
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

    public static String getMainEntryUrl()
    {
        return getMainEntryUrl(null);
    }

    public static String getMainEntryUrl(KmMap<String,String> params)
    {
        return formatServletUrl("main", params);
    }

    public static String getInvitationUrl(MyInvitation e)
    {
        KmMap<String,String> params;
        params = new KmMap<String,String>();
        params.put(PARAMETER_INVITATION, e.getAccessKey());

        return getMainEntryUrl(params);
    }

    public static String getPasswordResetUrl(MyPasswordReset e)
    {
        KmMap<String,String> params;
        params = new KmMap<String,String>();
        params.put(PARAMETER_PASSWORD_RESET, e.getAccessKey());

        return getMainEntryUrl(params);
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
        return Kmu.joinUrlPath(SERVLET_ROOT, SERVLET_CONTEXT, SERVLET_PATH, servlet);
    }

    private static String formatServletUrl(String servlet)
    {
        KmMap<String,String> params = null;
        return formatServletUrl(servlet, params);
    }

    private static String formatServletUrl(String servlet, KmMap<String,String> params)
    {
        String path = formatServletPath(servlet);
        return formatUrl(path, params);
    }

    private static String formatUrl(String path)
    {
        KmMap<String,String> params = null;
        return formatUrl(path, params);
    }

    private static String formatUrl(String path, KmMap<String,String> params)
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
        KmMap<String,String> params)
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

        if ( params != null )
        {
            KmList<String> keys = params.getKeys();
            if ( keys.isNotEmpty() )
            {
                out.append("?");
                Iterator<String> i = keys.iterator();
                while ( i.hasNext() )
                {
                    String key = i.next();
                    out.append(key);
                    out.append("=");
                    out.append(params.get(key));
                    if ( i.hasNext() )
                        out.append("&");
                }
            }
        }

        return out.toString();
    }

    private static MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
