package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.install.MyResetDatabaseTool;
import com.app.tools.MySampleDataTool;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevSampleDataPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevSampleDataPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevSampleDataPage();
    }

    public static MyDevSampleDataPage getInstance()
    {
        return _instance;
    }

    private MyDevSampleDataPage()
    {
        // singleton
    }

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
        root.css().gap();

        installResetGroupOn(root);
    }

    private void installResetGroupOn(ScContainer root)
    {
        ScAction resetAction;
        resetAction = newAction(this::handleResetData);
        resetAction.disableSlowCommandWarning();

        ScAction resetSampleAction;
        resetSampleAction = newAction(this::handleResetDataWithSamples);
        resetSampleAction.disableSlowCommandWarning();

        ScGroup group;
        group = root.addGroup("Reset");
        group.getBody().addPad().addText("These will reset all data, and terminate your session.");

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();

        ScActionButton button;
        button = buttons.addButton("Reset", resetAction);
        button.setConfirmationMessage("Reset ALL Data?");

        button = buttons.addButton("Reset With Samples", resetSampleAction);
        button.setConfirmationMessage("Reset ALL Data?");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleResetData()
    {
        checkProduction();

        MyResetDatabaseTool.run();
        ajax().toast("The database has been reset.");
    }

    private void handleResetDataWithSamples()
    {
        MyResetDatabaseTool.run();
        MySampleDataTool.run();

        ajax().toast("The database has been reset with sample data.");
    }

    //##################################################
    //# support
    //##################################################

    private void checkProduction()
    {
        boolean isProduction = getProperties().isEnvironmentProduction();
        if ( isProduction )
            throw Kmu.newError("Not allowed in PRODUCTION.");

    }
}
