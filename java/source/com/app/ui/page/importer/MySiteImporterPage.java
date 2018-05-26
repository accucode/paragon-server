package com.app.ui.page.importer;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public class MySiteImporterPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySiteImporterPage _instance;

    public static void installInstance()
    {
        _instance = new MySiteImporterPage();
    }

    public static MySiteImporterPage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectManager;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().flexColumn();

        MySiteImporterView view;
        view = new MySiteImporterView();
        root.add(view);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }
}
