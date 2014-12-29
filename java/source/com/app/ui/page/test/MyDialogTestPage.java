package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.control.MyDialog;
import com.app.ui.page.tools.MyDevUtilityPage;

public class MyDialogTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDialogTestPage instance = new MyDialogTestPage();

    private MyDialogTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyDialog    _dialog;
    private ScTextField _textField;

    private MyDialog    _nestedDialog;
    private MyDialog    _doubleNestedDialog;

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
        root.css().gap();
        root.addButton("Show", newOpenDialogAction());
        root.onEscape().toast("Page escape");

        installDialog();
        installNestedDialog();
        installDoubleNestedDialog();
    }

    private void installDialog()
    {
        MyDialog dialog;
        dialog = new MyDialog();
        dialog.setLabel("test");
        dialog.setWidth(500);
        dialog.setSubmitAction(newSubmitAction());

        ScDiv body;
        body = dialog.getBody();
        body.css().pad();
        body.addTextParagraph("Hello world");
        body.addBreak();

        ScFieldLayout fields;
        fields = body.addFieldLayout();

        _textField = fields.addTextField();
        _textField.setLabel("Some Text (try: close, confirm, or nav)");

        ScFlexbox footer;
        footer = dialog.showFooter();
        footer.alignEnd();
        footer.css().pad();
        footer.addSubmitButton();

        _dialog = dialog;
    }

    private void installNestedDialog()
    {
        MyDialog dialog;
        dialog = new MyDialog();
        dialog.setLabel("Nested");

        ScDiv body;
        body = dialog.getBody();
        body.css().pad();
        body.addText("Are you sure?");

        ScFlexbox footer;
        footer = dialog.showFooter();
        footer.alignEnd();
        footer.css().buttonBox();
        footer.addButton("Yes", newYesAction()).positive().primary();
        footer.addButton("No", newNoAction()).negative();

        _nestedDialog = dialog;
    }

    private void installDoubleNestedDialog()
    {
        MyDialog dialog;
        dialog = new MyDialog();
        dialog.setLabel("Double Nested");

        ScDiv body;
        body = dialog.getBody();
        body.css().pad();
        body.addText("Are you REALLY sure?");

        ScFlexbox footer;
        footer = dialog.showFooter();
        footer.alignEnd();
        footer.css().buttonBox();
        footer.addButton("Yes", newDoubleYesAction()).positive().primary();
        footer.addButton("No", newDoubleNoAction()).negative();

        _doubleNestedDialog = dialog;
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newOpenDialogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleOpenDialog();
            }
        };
    }

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSubmit();
            }
        };
    }

    private ScActionIF newYesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleYes();
            }
        };
    }

    private ScActionIF newNoAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleNo();
            }
        };
    }

    private ScActionIF newDoubleYesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDoubleYes();
            }
        };
    }

    private ScActionIF newDoubleNoAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDoubleNo();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleOpenDialog()
    {
        _dialog.ajaxOpen();
    }

    private void handleSubmit()
    {
        if ( _textField.isEmpty() )
        {
            ajax().toast("no value");
            return;
        }

        if ( _textField.hasValue("close") )
        {
            _dialog.ajaxClose();
            return;
        }

        if ( _textField.hasValue("confirm") )
        {
            _nestedDialog.ajaxOpen();
            return;
        }

        if ( _textField.hasValue("nav") )
        {
            _dialog.ajaxClose();
            MyDevUtilityPage.instance.ajaxPush();
            return;
        }

        ajax().toast(_textField.getValue());
    }

    private void handleNo()
    {
        _nestedDialog.ajaxClose();
    }

    private void handleYes()
    {
        _doubleNestedDialog.ajaxOpen();
    }

    private void handleDoubleYes()
    {
        _doubleNestedDialog.ajaxClose();
        _nestedDialog.ajaxClose();
        _dialog.ajaxClose();
    }

    private void handleDoubleNo()
    {
        _doubleNestedDialog.ajaxClose();
        _nestedDialog.ajaxClose();
    }
}
