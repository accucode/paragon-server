package com.kodemore.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

public class ScEchoServlet
    extends ScServlet
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
    //# handle
    //##################################################

    private void handle()
    {
        ScServletData data = getData();
        KmHtmlBuilder out = new KmHtmlBuilder();

        printBackLink(out);
        printParameters(data, out);

        String html = out.toString();
        boolean noCache = true;

        data.setHtmlResult(html, noCache);
    }

    private void printBackLink(KmHtmlBuilder out)
    {
        out.open("a");
        out.printAttribute("href", "javascript:history.back(-1);");
        out.close();
        out.print("<< BACK");
        out.end("a");
    }

    private void printParameters(ScServletData data, KmHtmlBuilder out)
    {
        out.printHeader1("Parameters");

        KmList<String> keys;
        keys = data.getParameterKeys();
        keys.sort();
        for ( String key : keys )
        {
            String value = data.getParameter(key);
            String hex = Kmu.formatHexString(value, " ");
            out.printfln("%s = %s (%s)", key, value, hex);
        }
    }

}
