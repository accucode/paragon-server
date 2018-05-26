package com.app.ui.dashboard.core;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScSpacedRow;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;

public abstract class MyDashboardPanel
    extends ScGroup
{
    //##################################################
    //# constructor
    //##################################################

    public MyDashboardPanel()
    {
        install();
    }

    //##################################################
    //# setup
    //##################################################

    protected abstract MyDashboardPanelType getType();

    public final boolean hasType(MyDashboardPanelType e)
    {
        return Kmu.isEqual(getType(), e);
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        installBanner();
        installPanelOn(getBody());
    }

    private void installBanner()
    {
        ScAction editAction = MyDashboardPage.getInstance().getEditAction();

        setTitle(formatTitle());

        ScSpacedRow banner;
        banner = getBanner();
        banner.css().flexCrossAlignCenter();

        ScActionButton button;
        button = banner.getRight().addEditButton(editAction);
        button.setIcon().nameEdit().styleLight();
    }

    protected String formatTitle()
    {
        return getType().getLabel();
    }

    protected abstract void installPanelOn(ScDiv root);

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        super.preRender();

        preRenderPanel();
    }

    protected abstract void preRenderPanel();

    //##################################################
    //# support
    //##################################################

    protected MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected MyDaoAccess getAccess()
    {
        return getGlobals().getAccess();
    }

    protected MyProject getProject()
    {
        return getGlobals().getCurrentProject();
    }

    protected MyUser getUser()
    {
        return getGlobals().getCurrentUser();
    }

    protected MyMember getMember()
    {
        return getProject().getMemberFor(getUser());
    }
}
