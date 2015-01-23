package com.app.ui.page.test;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

/**
 * Test the layout and usage of the groups.
 */
public class MyOpenWindowTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyOpenWindowTestPage instance = new MyOpenWindowTestPage();

    private MyOpenWindowTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();
        root.addButton("Open Window", this::handleTest);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTest()
    {
        KmTimestamp ts = KmTimestamp.createNowLocal();

        String title = Kmu.format("New Window, %s:%s", ts.getMinute(), ts.getSecond());

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();
        out.printTitle(title);
        out.beginBody();
        out.println("This is a popup window!");
        out.println(ts);
        out.endBody();
        out.endHtml();

        String html;
        html = out.toString();

        KmJsonMap args;
        args = new KmJsonMap();
        args.setString("name", "myWindow");
        args.setString("html", html);

        String json;
        json = args.formatJson();

        ajax().run("Kmu.openWindow(%s);", json);
    }

}
