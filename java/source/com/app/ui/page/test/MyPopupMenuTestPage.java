package com.app.ui.page.test;

import com.kodemore.servlet.ScMenuItem;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTopMenu;

import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.core.MyActions;
import com.app.ui.page.MyPage;
import com.app.utility.MyGlobals;

public class MyPopupMenuTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPage instance = new MyPopupMenuTestPage();

    private MyPopupMenuTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDiv     _topRightDiv;
    private ScTopMenu _menu;

    //##################################################
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _topRightDiv = new ScDiv();
        _topRightDiv.css().pad10();

        _menu = new ScTopMenu();

        ScForm form;
        form = root.addForm();
        form.add(_menu);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        renderMenu();
    }

    private void renderMenu()
    {
        _menu.ajaxRender(getMenu());
    }

    private ScMenuItem getMenu()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return null;

        MyActions actions = MyActions.getInstance();

        ScMenuItem root;
        root = new ScMenuItem();

        ScMenuItem m;
        m = root.addChild(u.getName());
        m.addChild("Settings", actions.getSettingsAction());
        m.addChild("Sign Out", actions.getSignOutAction());

        return root;
    }
}
