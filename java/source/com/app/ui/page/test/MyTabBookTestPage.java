package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTabBook;
import com.kodemore.servlet.control.ScTabBookItem;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyTabBookTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTabBookTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyTabBookTestPage();
    }

    public static MyTabBookTestPage getInstance()
    {
        return _instance;
    }

    private MyTabBookTestPage()
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
        root.css().flexColumn().columnSpacer20();

        root.add(createAutoBook());
        root.add(createNormalBook());
        root.add(createTallBook());
    }

    //==================================================
    //= install :: create book
    //==================================================

    private ScTabBook createNormalBook()
    {
        ScTabBook e;
        e = createBook();
        e.setFlavorWide();
        return e;
    }

    private ScTabBook createTallBook()
    {
        ScTabBook e;
        e = createBook();
        e.setFlavorTall();
        return e;
    }

    private ScTabBook createAutoBook()
    {
        ScTabBook e;
        e = createBook();
        e.setFlavorAuto();
        return e;
    }

    private ScTabBook createBook()
    {
        ScTabBook book;
        book = new ScTabBook();
        book.css().height300();

        addTab(book, "Order");
        addTab(book, "Lines");
        addTab(book, "Shipments");
        addTab(book, "Contacts");
        addTab(book, "Requests");
        addTab(book, "Visits");
        addTab(book, "Surveys");
        addTab(book, "Checks");
        addTab(book, "Tasks").setSecondary();
        addTab(book, "Attachments").setSecondary();
        addTab(book, "Email").setSecondary();
        addTab(book, "Blurbs").setSecondary();
        addTab(book, "Notes").setSecondary();

        return book;
    }

    private ScTabBookItem addTab(ScTabBook book, String label)
    {
        String text = Kmu.repeat(label + " ", 3).trim();

        ScDiv tab;
        tab = new ScDiv();
        tab.css().fill().boxBlue().pad20();
        tab.setLabel(label);
        tab.addText(text);

        return book.addTab(tab);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }
}
