package com.app.ui.page.test;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.script.ScDelayedScript;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.property.MyPropertyRegistry;

/**
 * Automatically, and repeatedly, loop through page content
 * to see if a client browser memory leak manifests.
 */
public class MyMemoryLeakTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMemoryLeakTestPage instance = new MyMemoryLeakTestPage();

    private MyMemoryLeakTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private Runnable    _loopAction;
    private ScDateField _field;

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
        _field = new ScDateField();
        _field.setLabel("Some field");

        ScForm form;
        form = root.addForm();
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Memory Leak Test");
        group.getBody().addPad().addFieldTable().add(_field);

        form.add(newUserGrid());

        _loopAction = this::handleLoop;
    }

    private ScGrid<MyUser> newUserGrid()
    {
        MyMetaUser x = MyUser.Meta;

        ScGrid<MyUser> grid;
        grid = new ScGrid<>();
        grid.addColumn(x.Uid);
        grid.addColumn(x.Email);
        grid.addColumn(x.Name);
        grid.setFilterFactory(newFetcher());
        grid.setWidthAuto();

        return grid;
    }

    private KmFilterFactoryIF<MyUser> newFetcher()
    {
        return new KmFilterFactoryIF<MyUser>()
        {
            @Override
            public KmFilter<MyUser> createFilter()
            {
                return getAccess().getUserDao().findAll().toFilter();
            }
        };
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        checkLoop();
    }

    private void checkLoop()
    {
        MyPropertyRegistry p = getProperties();

        boolean enabled = p.getMemoryLeakLoopEnabled();
        Integer ms = p.getMemoryLeakLoopSpeedMs();

        if ( !enabled )
            return;

        ScDelayedScript delay;
        delay = ajax().runDelayed();
        delay.setDelayMs(ms);
        delay.getScript().run(this, _loopAction);
    }

    private void handleLoop()
    {
        KmLog.info("MyMemoryLeakTestActivity.handleLoop");
        print();
    }

}
