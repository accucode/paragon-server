package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

public class MyBlockTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyBlockTestPage instance = new MyBlockTestPage();

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

    private ScGroup          _group;
    private ScTextField      _nameField;

    //##################################################
    //# navigation
    //##################################################

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
        installTestGroup(root);
        installFormGroup1(root);
        installFormGroup2(root);
        installFormGroup3(root);
    }

    private void installTestGroup(ScBox root)
    {
        ScBox buttons;
        buttons = root.addButtonBox();
        buttons.addButton("Block Page", newBlockPageAction());
        buttons.addButton("Block Group", newBlockGroupAction());
        buttons.addButton("Unblock Group", newUnblockGroupAction());

        ScActionButton button;
        button = buttons.addButton("Block on Request", newBlockRequestAction());

        ScGroup group;
        group = root.addPad().addGroup();

        ScBox lines;
        lines = group.addLines();
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
        form.setSubmitAction(newFormTestAction());
        form.css().pad();

        form.addText(""
            + "Various containers (e.g.: Groups and Forms) act as Block Wrappers"
            + " by default. This means that ajax submits initiated from within"
            + " those containers will block only that container, rather than the"
            + " entire page. In this example only the group is blocked.");

        ScGroup group;
        group = form.addGroup();

        ScBox lines;
        lines = group.addLines();
        lines.addFields().add(_nameField);
        lines.addSubmitButton();
    }

    private void installFormGroup2(ScBox root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(newFormTestAction());
        form.css().pad();

        form.addText(""
            + "In some cases, we don't want the group (or form) to act as a "
            + " Block Wrapper.  This is easy to configure.  In this example, we"
            + " turn of the block wrapper for the group, so blocking will then"
            + " default up the control hierarchy to the form that contains the group.");

        ScGroup group;
        group = form.addGroup();
        group.setBlockWrapper(false); // DISABLE BLOCK WRAPPER

        ScBox lines;
        lines = group.addLines();
        lines.addFields().add(_nameField);
        lines.addSubmitButton();
    }

    private void installFormGroup3(ScBox root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(newFormTestAction());
        form.setBlockWrapper(false); // DISABLE BLOCK WRAPPER
        form.css().pad();

        form.addText(""
            + "Here we disable block wrapping for both the form and the group,"
            + " so blocking will default to the entire page.");

        ScGroup group;
        group = form.addGroup();
        group.setBlockWrapper(false); // DISABLE BLOCK WRAPPER

        ScBox lines;
        lines = group.addLines();
        lines.addFields().add(_nameField);
        lines.addSubmitButton();
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newBlockPageAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleBlockPage();
            }
        };
    }

    private ScActionIF newBlockGroupAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleBlockGroup();
            }
        };
    }

    private ScActionIF newUnblockGroupAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleUnblockGroup();
            }
        };
    }

    private ScAction newBlockRequestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleBlockRequest();
            }
        };
    }

    private ScActionIF newFormTestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleFormTest();
            }
        };
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
