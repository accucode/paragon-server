package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyHibernateCacheTest;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyHibernateCacheTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyHibernateCacheTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyHibernateCacheTestPage();
    }

    public static MyHibernateCacheTestPage getInstance()
    {
        return _instance;
    }

    private MyHibernateCacheTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScIntegerField _recordCountField;
    private ScIntegerField _runCountField;
    private ScDiv          _resultBox;

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
        _resultBox = new ScDiv();

        root.css().fill().auto();

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup("Hibernate Cache Test");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(createInsertDataBox());
        fields.add(createRunTestBox());

        root.add(_resultBox);
    }

    public ScDiv createInsertDataBox()
    {
        _recordCountField = new ScIntegerField();
        _recordCountField.setLabel("Record Count");
        _recordCountField.setValue(100);
        _recordCountField.disableChangeTracking();

        ScDiv box;
        box = new ScDiv();
        box.setLabel("Insert Data");
        box.css().marginRightChildren5();
        box.add(_recordCountField);
        box.addButton("Add Records", this::handleInsertNewRecords);
        return box;
    }

    private ScControl createRunTestBox()
    {
        _runCountField = new ScIntegerField();
        _runCountField.setLabel("Run Count");
        _runCountField.setValue(20);
        _runCountField.disableChangeTracking();

        ScDiv box;
        box = new ScDiv();
        box.setLabel("Run Test");
        box.css().marginRightChildren5();
        box.add(_runCountField);
        box.addButton("Run Test", this::handleTestRun);
        return box;
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

    private void handleInsertNewRecords()
    {
        int n = _recordCountField.getValue();
        for ( int i = 0; i < n; i++ )
        {
            MyHibernateCacheTest e;
            e = new MyHibernateCacheTest();
            e.setData(Kmu.getLoremIpsum(100));
            e.daoAttach();
        }
        _resultBox.ajaxSetHtml(n + " inserted into database");
    }

    private void handleTestRun()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.println("hostname: " + Kmu.getCanonicalLocalHostName());

        int n = _runCountField.getValue();
        for ( int i = 0; i < n; i++ )
        {
            KmTimer t = KmTimer.run();
            readTestData();
            out.printfln("%s test run, %.1f ms.", i + 1, t.getMilliseconds());
        }

        _resultBox.ajaxSetHtml(out);
    }

    private void readTestData()
    {
        KmList<MyHibernateCacheTest> v = MyDaoAccess.getInstance().findAllHibernateCacheTests();
        for ( MyHibernateCacheTest e : v )
            e.getData();
    }
}
