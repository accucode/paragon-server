package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.model.MyProject;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.manage.crud.MyCrudViewCard;
import com.app.ui.page.manage.project.MyProjectBuilder;

public final class MyProjectPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectPage();
    }

    public static MyProjectPage getInstance()
    {
        return _instance;
    }

    private MyProjectPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyCrudViewCard<MyProject> _view;

    //##################################################
    //# settings
    //##################################################

    @Override
    public String getTitle()
    {
        return "My Project";
    }

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
        MyProjectBuilder b;
        b = new MyProjectBuilder();
        b.setEditCard(null);
        _view = b.getViewCard();
        _view.css().fill();

        root.css().fill().flexRow().rowSpacer20();
        root.add(_view);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyProject e = getCurrentProject();
        if ( e != null )
            _view.applyFromModel(e);
    }

}
