package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBorderLayout;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;
import com.app.utility.MyConstantsIF;

public class MyHomePage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHomePage instance = new MyHomePage();

    private MyHomePage()
    {
        // singleton
    }

    //##################################################
    //# setup
    //##################################################

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.home;
    }

    //##################################################
    //# navigation
    //##################################################

    public void push()
    {
        _push();
    }

    public String formatQueryString()
    {
        return _formatQueryString();
    }

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
        ScBorderLayout border;
        border = root.addBorderLayout();
        border.pad();

        ScDiv top = border.addTop(100);
        border.padTop();

        ScDiv center = border.addCenter();

        installTop(top);
        installCenter(center);
    }

    private void installTop(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup();
        group.layoutFill();
        group.setTitle("Welcome");
        group.bodyCss().pad();
        group.addText("Welcome to " + MyConstantsIF.APPLICATION_NAME);
    }

    private void installCenter(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup();
        group.setTitle("Center");
        group.layoutFill();
        group.bodyCss().pad();

        int n = 100;
        for ( int i = 0; i < n; i++ )
            group.addParagraph("line " + i);
    }
}
