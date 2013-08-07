package com.app.ui.activity.test;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

/**
 * Test the layout and usage of the groups.
 */
public class MyOpenWindowTestPage
    extends MyAbstractTestPage
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
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        root.addButton("Open Window", newTestAction());

        return root;
    }

    private ScActionIF newTestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest();
            }
        };
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

        KmJsonObject args;
        args = new KmJsonObject();
        args.setString("name", "myWindow");
        args.setString("html", html);

        String json;
        json = args.formatJson();

        ajax().run("Kmu.openWindow(%s);", json);
    }

}
