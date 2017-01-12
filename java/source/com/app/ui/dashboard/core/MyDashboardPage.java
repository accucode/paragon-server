package com.app.ui.dashboard.core;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTransientDiv;

import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.ui.dashboard.MyEmptyPanel;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDashboardPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDashboardPage _instance;

    public static void installInstance()
    {
        _instance = new MyDashboardPage();
    }

    public static MyDashboardPage getInstance()
    {
        return _instance;
    }

    private MyDashboardPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTransientDiv    _transient;

    private MyDashboardDialog _editDialog;
    private ScAction          _editAction;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
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
        root.css();
        _transient = root.addTransientDiv();
        _transient.css().fill();

        _editDialog = new MyDashboardDialog();
        _editAction = newCheckedAction(this::handleEdit);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScAction getEditAction()
    {
        return _editAction;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        ScTransientDiv root = _transient;

        MyProject project = getCurrentProject();
        if ( project == null )
        {
            root.addLabel("No selected project.");
            return;
        }

        KmList<MyDashboardPanel> panels = getPanels();
        MyDashboardOrientationType type = getOrientationType();

        switch ( type )
        {
            case Auto:
                root.css().dashboard().dashboard_auto();
                break;

            case Landsapce:
                root.css().dashboard().dashboard_landscape();
                break;

            case Portrait:
                root.css().dashboard().dashboard_portrait();
                break;
        }

        int index;
        index = 0;
        index += addLineTo(root, index, getLineCount1(), panels);
        index += addLineTo(root, index, getLineCount2(), panels);
    }

    private int addLineTo(ScTransientDiv root, int index, int n, KmList<MyDashboardPanel> panels)
    {
        if ( n == 0 )
            return 0;

        ScDiv line;
        line = root.addDiv();
        line.css().dashboard_line();

        for ( int i = 0; i < n; i++ )
        {
            ScGroup group = panels.get(index + i);

            if ( group == null )
                group = createStub();

            group.css().dashboard_panel();
            line.add(group);
        }

        return n;
    }

    private ScGroup createStub()
    {
        return new MyEmptyPanel();
    }

    //##################################################
    //# hooks
    //##################################################

    private KmList<MyDashboardPanel> getPanels()
    {
        MyUser user = getCurrentUser();

        KmList<MyDashboardPanel> v;
        v = new KmList<>();
        v.add(getPanel(user.getDashboardPanelTypeA()));
        v.add(getPanel(user.getDashboardPanelTypeB()));
        v.add(getPanel(user.getDashboardPanelTypeC()));
        v.add(getPanel(user.getDashboardPanelTypeD()));
        v.add(getPanel(user.getDashboardPanelTypeE()));
        v.add(getPanel(user.getDashboardPanelTypeF()));
        v.replaceDuplicatesWithNull();
        return v;
    }

    private MyDashboardPanel getPanel(MyDashboardPanelType e)
    {
        return MyDashboardPanelRegistry.getPanel(e);
    }

    private MyDashboardOrientationType getOrientationType()
    {
        return getCurrentUser().getDashboardOrientationType();
    }

    private int getLineCount1()
    {
        return getCurrentUser().getDashboardLineCount1();
    }

    private int getLineCount2()
    {
        return getCurrentUser().getDashboardLineCount2();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        _editDialog.ajaxOpen();
    }

}
