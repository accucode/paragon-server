package com.app.ui.core;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.servlet.ScServletData;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmClock;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.property.MyPropertyRegistry;
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
    public void setHtmlResult(String value)
    {
        super.setHtmlResult(value);
        writeLastReults(value, "html");
    }

    @Override
    public void setTextResult(String value)
    {
        super.setTextResult(value);
        writeLastReults(value, "txt");
    }

    @Override
    public void setCssResult(String value)
    {
        super.setCssResult(value);
        writeLastReults(value, "css");
    }

    @Override
    public void setXmlResult(String value)
    {
        super.setXmlResult(value);
        writeLastReults(value, "xml");
    }

    private void writeLastReults(String value, String ext)
    {
        MyPropertyRegistry p = getProperties();
        if ( p.getWriteLastServletResults() )
        {
            String name = getLastName() + "." + ext;
            String path = MyFilePaths.getWebPath(name);
            Kmu.writeFile(path, value);
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

        String file;
        file = MyFilePaths.getAjaxLogFile();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println();
        out.println();
        out.println(Kmu.dashes(80));
        out.println(KmClock.getNowUtc().format_m_d_yyyy_hh_mm_ss());
        out.println("bytes: " + s.length());
        out.println(Kmu.dashes(80));
        out.println(s);

        Kmu.appendToFile(file, out.toString());
    }

    //##################################################
    //# support
    //##################################################

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected void error(String msg, Object... args)
    {
        Kmu.error(msg, args);
    }

}
