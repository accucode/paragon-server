package com.app.ui.servlet;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import com.app.ui.core.MyServletData;

import com.kodemore.utility.Kmu;

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
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try
        {
            MyServletData data = getData();
            String scheme = "http";
            String host = "chart.apis.google.com";
            int port = 80;
            String file = "/chart?" + data.getQueryString();
            URL url = new URL(scheme, host, port, file);

            in = url.openStream();
            out = new ByteArrayOutputStream();
            while ( true )
            {
                int i = in.read();
                if ( i < 0 )
                    break;
                out.write((byte)i);
            }

            data.writeBytes(out.toByteArray());
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            Kmu.closeSafely(in);
            Kmu.closeSafely(out);
        }
    }
}
