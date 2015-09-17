package com.app.ui.page.test;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the layout and usage of the groups.
 */
public final class MyOpenWindowTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyOpenWindowTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyOpenWindowTestPage();
    }

    public static MyOpenWindowTestPage getInstance()
    {
        return _instance;
    }

    private MyOpenWindowTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
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
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
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
