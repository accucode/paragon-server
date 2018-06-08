package com.app.ui.dashboard.core;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.utility.KmResult;

import com.app.model.MyMember;
import com.app.model.MyProject;
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

    private ScActionButton _refreshButton;
    private ScTransientDiv _transient;

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
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.add(createRefreshButton());
        root.add(createTransientDiv());

        installEditDialog();
    }

    private ScControl createRefreshButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setAction(newCheckedAction(this::handleRefresh));
        e.hide();
        _refreshButton = e;
        return e;
    }

    private ScControl createTransientDiv()
    {
        ScTransientDiv e;
        e = new ScTransientDiv();
        e.css().fill();
        _transient = e;
        return e;
    }

    private void installEditDialog()
    {
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
        KmResult<MyMember> result = getMember();

        if ( result.hasError() )
        {
            preRenderError(result.getError());
            return;
        }

        MyMember member = result.getValue();
        preRenderRefreshButtonFor(member);
        preRenderPanelsFor(member);
    }

    private void preRenderError(String msg)
    {
        _transient.addLabel(msg);
    }

    //==================================================
    //= render :: member
    //==================================================

    private void preRenderRefreshButtonFor(MyMember member)
    {
        Integer mins = member.getDashboardRefreshMinutes();
        if ( mins == null )
            return;

        _refreshButton.setAutoRunSeconds(mins * 60);
    }

    private void preRenderPanelsFor(MyMember member)
    {
        preRenderCssFor(member);
        preRenderLayout(member);
    }

    private void preRenderCssFor(MyMember member)
    {
        ScTransientDiv root = _transient;
        MyDashboardOrientationType type = member.getDashboardOrientationType();
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
    }

    private void preRenderLayout(MyMember member)
    {
        ScTransientDiv root = _transient;
        KmList<MyDashboardPanel> panels = getMemberPanels(member);

        int index;
        index = 0;
        index += addLineTo(root, index, member.getDashboardLineCount1(), panels);
        addLineTo(root, index, member.getDashboardLineCount2(), panels);
    }

    private KmList<MyDashboardPanel> getMemberPanels(MyMember member)
    {
        KmList<MyDashboardPanel> v;
        v = new KmList<>();
        v.add(getPanel(member.getDashboardPanelTypeA()));
        v.add(getPanel(member.getDashboardPanelTypeB()));
        v.add(getPanel(member.getDashboardPanelTypeC()));
        v.add(getPanel(member.getDashboardPanelTypeD()));
        v.add(getPanel(member.getDashboardPanelTypeE()));
        v.add(getPanel(member.getDashboardPanelTypeF()));
        v.replaceDuplicatesWithNull();
        return v;
    }

    private MyDashboardPanel getPanel(MyDashboardPanelType e)
    {
        return MyDashboardPanelRegistry.getPanel(e);
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
    //# handle
    //##################################################

    private void handleEdit()
    {
        _editDialog.ajaxOpen();
    }

    private void handleRefresh()
    {
        MyMember member = getCurrentMember();
        if ( member == null )
            return;

        preRenderPanelsFor(member);
        _transient.ajaxReplace();
    }

    //##################################################
    //# support
    //##################################################

    private KmResult<MyMember> getMember()
    {
        MyProject project = getCurrentProject();
        if ( project == null )
            return KmResult.createError("No selected project.");

        MyMember member = getCurrentMember();
        if ( member == null )
            return KmResult.createError("You are not a member of the current project.");

        return KmResult.createValue(member);
    }

}
