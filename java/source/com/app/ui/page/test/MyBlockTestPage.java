package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyBlockTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyBlockTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyBlockTestPage();
    }

    public static MyBlockTestPage getInstance()
    {
        return _instance;
    }

    private MyBlockTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final int DELAY_MS = 1000;

    //##################################################
    //# variables
    //##################################################

    private ScGroup     _group;
    private ScTextField _nameField;

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
        installTestGroup(root);
        installFormGroup1(root);
        installFormGroup2(root);
        installFormGroup3(root);
    }

    private void installTestGroup(ScBox root)
    {
        ScBox buttons;
        buttons = root.addButtonBox();
        buttons.addButton("Block Page", this::handleBlockPage);
        buttons.addButton("Block Group", this::handleBlockGroup);
        buttons.addButton("Unblock Group", this::handleUnblockGroup);

        ScActionButton button;
        button = buttons.addButton("Block on Request", this::handleBlockRequest);

        ScGroup group;
        group = root.addPad().addGroup("Block Tests");

        ScBox lines;
        lines = group.getBody().addLines();
        lines.addText("hello world");
        lines.addText("hello world");
        lines.addText("hello world");
        lines.addText("hello world");
        lines.addText("hello world");

        button.setBlockTarget(group);

        _group = group;
    }

    private void installFormGroup1(ScBox root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleFormTest);
        form.css().pad();

        form.addText(
            ""
                + "Various containers (e.g.: Groups and Forms) act as Block Wrappers"
                + " by default. This means that ajax submits initiated from within"
                + " those containers will block only that container, rather than the"
                + " entire page. In this example only the group is blocked.");

        ScGroup group;
        group = form.addGroup("Auto Block (group)");

        ScBox lines;
        lines = group.getBody().addLines();
        lines.addFieldTable().add(_nameField);
        lines.addSubmitButton();
    }

    private void installFormGroup2(ScBox root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleFormTest);
        form.css().pad();

        form.addText(
            ""
                + "In some cases, we don't want the group (or form) to act as a "
                + " Block Wrapper.  This is easy to configure.  In this example, we"
                + " turn of the block wrapper for the group, so blocking will then"
                + " default up the control hierarchy to the form that contains the group.");

        ScGroup group;
        group = form.addGroup("Auto Block (form)");
        group.setBlockWrapper(false); // DISABLE BLOCK WRAPPER

        ScBox lines;
        lines = group.getBody().addLines();
        lines.addFieldTable().add(_nameField);
        lines.addSubmitButton();
    }

    private void installFormGroup3(ScBox root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleFormTest);
        form.setBlockWrapper(false); // DISABLE BLOCK WRAPPER
        form.css().pad();

        form.addText(
            ""
                + "Here we disable block wrapping for both the form and the group,"
                + " so blocking will default to the entire page.");

        ScGroup group;
        group = form.addGroup("Auto Block (page)");
        group.setBlockWrapper(false); // DISABLE BLOCK WRAPPER

        ScBox lines;
        lines = group.getBody().addLines();
        lines.addFieldTable().add(_nameField);
        lines.addSubmitButton();
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

    private void handleBlockPage()
    {
        ajax().blockPage();
    }

    private void handleBlockGroup()
    {
        _group.ajax().block();
    }

    private void handleUnblockGroup()
    {
        _group.ajax().unblock();
    }

    private void handleBlockRequest()
    {
        Kmu.sleepMs(DELAY_MS);
        ajax().toast("Ok");
    }

    private void handleFormTest()
    {
        Kmu.sleepMs(DELAY_MS);
        String name = _nameField.getValue();
        ajax().toast("name = %s.", name);
    }

}
