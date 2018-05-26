package com.app.ui.servlet;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import com.kodemore.utility.Kmu;

import com.app.ui.core.MyServletData;

public class MyGoogleChartServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# process
    //##################################################

    private void handle()
    {
        try
        {
            MyServletData data = getData();
            String scheme = "http";
            String host = "chart.apis.google.com";
            int port = 80;
            String file = "/chart?" + data.getQueryString();
            URL url = new URL(scheme, host, port, file);
            byte[] bytes = Kmu.readBytes(url);
            data.writeBytes(bytes);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }
}
