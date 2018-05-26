package com.app.ui.page.general;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;
import com.app.ui.page.crud.project.MyProjectBuilder;

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

    private MyCrudFrame<MyTenant,MyProject> _view;

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
        return MySecurityLevel.projectWorker;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        MyProjectBuilder b;
        b = new MyProjectBuilder();
        _view = b.getFrame();
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
            _view.setDefaultViewCard(e);
    }

}
