package com.app.ui.core;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.servlet.ScServletData;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.thread.KmThread;
import com.kodemore.time.KmClock;
import com.kodemore.utility.KmFiles;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.model.MyTenant;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public class MyServletData
    extends ScServletData
{
    //##################################################
    //# static
    //##################################################

    public static MyServletData install(
        HttpServlet servlet,
        HttpServletRequest request,
        HttpServletResponse response)
    {
        MyServletData data;
        data = new MyServletData(servlet, request, response);

        _install(data);

        return data;
    }

    public static MyServletData getLocal()
    {
        return (MyServletData)ScServletData.getLocal();
    }

    //##################################################
    //# variables
    //##################################################

    private String _cachedServerSessionUid;

    //##################################################
    //# constructor
    //##################################################

    private MyServletData(
        HttpServlet servlet,
        HttpServletRequest request,
        HttpServletResponse response)
    {
        super(servlet, request, response);
    }

    //##################################################
    //# cached ssid
    //##################################################

    public String getCachedServerSessionUid()
    {
        return _cachedServerSessionUid;
    }

    public void setCachedServerSessionUid(String e)
    {
        _cachedServerSessionUid = e;
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    public void appendLogIdentification(StringBuilder sb)
    {
        // none
    }

    @Override
    public int getSessionTimeoutSeconds()
    {
        // We manage our own session;
        // We don't use the container managed http virtual session.
        // This is set to a low value so that it ~immediately times out.
        return 1;
    }

    public boolean isRecommendedBrowser()
    {
        return isUserAgentFirefox();
    }

    //##################################################
    //# results
    //##################################################

    @Override
    protected void writeLastResults(CharSequence value, String ext)
    {
        MyProperties p = getProperties();
        if ( p.getWriteLastServletResults() )
        {
            String name = getLastName() + "." + ext;
            String path = MyFilePaths.getWebPath(name);
            KmFiles.writeString(path, value);
        }
    }

    private static int lastId = 0;

    private String getLastName()
    {
        if ( !getProperties().getWriteLastServletResultsCounter() )
            return "last";

        return "last_" + Kmu.leftPad(lastId++, 3);
    }

    //##################################################
    //# log
    //##################################################

    @Override
    public void logResults(String s)
    {
        boolean enabled = getProperties().getAjaxLogEnabled();
        if ( !enabled )
            return;

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println();
        out.println();
        out.println(Kmu.dashes(80));
        out.println(KmClock.getUtcTimestamp().format_m_d_yyyy_hh_mm_ss());
        out.println("bytes: " + s.length());
        out.println(Kmu.dashes(80));
        out.println(s);

        writeLogFile(out.toString());
    }

    /**
     * Append the message to a log file.
     * This is run in a background thread to minimize the impact
     * on the servlet timing. This only affects local development testing
     * since the log file is not written in production.
     */
    private void writeLogFile(String msg)
    {
        String file = MyFilePaths.getAjaxLogFile();

        KmThread t;
        t = new KmThread(() -> KmFiles.appendString(file, msg));
        t.startYield();
    }

    //##################################################
    //# tenant
    //##################################################

    /**
     * Determine the tenant based on the hostname.
     * This REQUIRES a preexisting hibernate session.
     */
    public final MyTenant getTenant()
    {
        String host = getRequestServerHostName();
        return MyGlobals.getAccess().getTenantDao().findHostname(host);
    }

    //##################################################
    //# support
    //##################################################

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

}
