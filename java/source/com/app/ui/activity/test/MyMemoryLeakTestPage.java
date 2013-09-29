package com.app.ui.activity.test;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.property.MyPropertyRegistry;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.script.ScDelayedScript;

/**
 * Automatically, and repeatedly, loop through page content
 * to see if a client browser memory leak manifests.
 */
public class MyMemoryLeakTestPage
    extends MyTestPage
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

    private ScActionIF  _loopAction;
    private ScDateField _field;

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
        group = form.addGroup("Test");
        group.addPad().addFields().add(_field);

        form.add(newUserGrid());

        _loopAction = newLoopAction();
    }

    private ScGrid<MyUser> newUserGrid()
    {
        MyMetaUser x = MyUser.Meta;

        ScGrid<MyUser> grid;
        grid = new ScGrid<MyUser>();
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
    //# action
    //##################################################

    private ScActionIF newLoopAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleLoop();
            }
        };
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        print();

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
        delay.getScript().run(_loopAction);
    }

    private void handleLoop()
    {
        KmLog.info("MyMemoryLeakTestActivity.handleLoop");
        start();
    }

}
