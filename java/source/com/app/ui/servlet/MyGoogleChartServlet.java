package com.app.ui.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

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
        try ( InputStream in = getUrl().openStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream() )
        {
            while ( true )
            {
                int i = in.read();
                if ( i < 0 )
                    break;

                out.write((byte)i);
            }

            getData().writeBytes(out.toByteArray());
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private URL getUrl() throws MalformedURLException
    {
        String scheme = "http";
        String host = "chart.apis.google.com";
        int port = 80;
        String file = "/chart?" + getData().getQueryString();

        return new URL(scheme, host, port, file);
    }
}
