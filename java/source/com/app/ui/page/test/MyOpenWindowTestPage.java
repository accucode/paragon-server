package com.app.ui.page.test;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.script.ScOpenWindowScript;
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
        root.css().fill().flexRow().rowSpacer5().auto();
        root.addButton("Open Window", this::handleOpen);
        root.addButton("Print Window", this::handlePrint);
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

    private void handlePrint()
    {
        ajaxOpenWindow(true);
    }

    private void handleOpen()
    {
        ajaxOpenWindow(false);
    }

    private void ajaxOpenWindow(boolean print)
    {
        KmTimestamp now;
        now = getNowUtc().toLocal();

        String title;
        title = Kmu.format("New Window, %s:%s", now.getMinute(), now.getSecond());

        KmHtmlBuilder html;
        html = new KmHtmlBuilder();
        html.printDocType();
        html.beginHtml();
        html.printTitle(title);
        html.beginBody();
        html.println("This is a new window/tab!");
        html.print("You can use ");
        html.printBold("formatted");
        html.println(" html.");
        html.println(now);
        html.endBody();
        html.endHtml();

        ScOpenWindowScript s;
        s = ajax().openWindow();
        s.setHtml(html);
        s.setName("myWindow");
        s.setPrint(print);
    }

}
