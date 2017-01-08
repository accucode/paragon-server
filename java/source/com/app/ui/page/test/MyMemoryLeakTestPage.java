package com.app.ui.page.test;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.script.ScDelayedScript;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.property.MyProperties;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Automatically, and repeatedly, loop through page content
 * to see if a client browser memory leak manifests.
 */
public final class MyMemoryLeakTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyMemoryLeakTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyMemoryLeakTestPage();
    }

    public static MyMemoryLeakTestPage getInstance()
    {
        return _instance;
    }

    private MyMemoryLeakTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScAction    _loopAction;
    private ScDateField _field;

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
        _field = new ScDateField();
        _field.setLabel("Some field");
        _field.disableChangeTracking();

        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.css().columnSpacer10();

        ScGroup group;
        group = form.addGroup("Memory Leak Test");
        group.getBody().addPad().addFieldTable().add(_field);

        form.add(newUserGrid());

        _loopAction = newCheckedAction(this::handleLoop);
    }

    private ScGrid<MyUser> newUserGrid()
    {
        MyMetaUser x = MyUser.Meta;

        ScGrid<MyUser> grid;
        grid = new ScGrid<>();
        grid.addColumn(x.Uid);
        grid.addColumn(x.Email);
        grid.addColumn(x.FullName);
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
        MyProperties p = getProperties();

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
        ajaxPrint();
    }

}
