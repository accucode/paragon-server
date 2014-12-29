package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyHibernateCacheTest;

public class MyDevHibernateCachePage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevHibernateCachePage instance = new MyDevHibernateCachePage();

    private MyDevHibernateCachePage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScIntegerField _recordCount;
    private ScBox          _results;
    private ScIntegerField _runCount;

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

        _results = new ScBox();

        root.css().pad();

        ScForm form;
        form = root.addForm();

        ScGroup group = form.addGroup("Hibernate Cache Test");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(createInsertDataBox());
        fields.add(createRunTestBox());

        root.add(_results);

    }

    private ScControl createRunTestBox()
    {
        _runCount = new ScIntegerField();
        _runCount.setLabel("Run Count");
        _runCount.setValue(20);

        ScBox box;
        box = new ScBox();
        box.setLabel("Run Test");
        box.css().marginRightChildren5();

        box.add(_runCount);
        box.addButton("Run Test", runTest());

        return box;
    }

    public ScBox createInsertDataBox()
    {
        _recordCount = new ScIntegerField();
        _recordCount.setLabel("Record Count");
        _recordCount.setValue(100);

        ScBox box;
        box = new ScBox();
        box.setLabel("Insert Data");
        box.css().marginRightChildren5();

        box.add(_recordCount);
        box.addButton("Add Records", insertNewRecords());

        return box;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF insertNewRecords()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleInsertNewRecords();
            }
        };
    }

    private ScActionIF runTest()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTestRun();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleInsertNewRecords()
    {
        int n = _recordCount.getValue();
        for ( int i = 0; i < n; i++ )
        {
            MyHibernateCacheTest e;
            e = new MyHibernateCacheTest();
            e.setData(Kmu.getLoremIpsum(100));
            e.saveDao();
        }
        _results.ajax().setHtml(n + " inserted into database");
    }

    private void handleTestRun()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.println("hostname: " + Kmu.getCanonicalLocalHostName());

        int n = _runCount.getValue();
        for ( int i = 0; i < n; i++ )
        {
            KmTimer t = KmTimer.run();
            readTestData();
            out.printfln("%s test run, %.1f ms.", i + 1, t.getMilliseconds());
        }

        _results.ajax().setHtml(out);
    }

    private void readTestData()
    {
        KmList<MyHibernateCacheTest> v = MyDaoRegistry.getInstance().findAllHibernateCacheTests();
        int n = v.size();
        for ( int i = 0; i < n; i++ )
        {
            MyHibernateCacheTest e = v.getAt(i);
            e.getData();
        }
    }
}
