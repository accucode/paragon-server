package com.app.ui.activity.tools;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.script.ScAddContentScript;
import com.kodemore.utility.KmBeanShell;

import com.app.file.MyResourceFiles;
import com.app.ui.activity.MyActivity;

public class MyBeanShellPage
    extends MyAbstractToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyBeanShellPage();

    private MyBeanShellPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextArea _scriptField;
    private ScBox      _resultsBox;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScActionIF submitAction = newSubmitAction();

        _scriptField = new ScTextArea();
        _scriptField.style().height(100);
        _scriptField.setWidthFull();

        ScBox root;
        root = new ScBox();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(submitAction);
        form.css().pad();

        ScGroup group;
        group = form.addGroup("Bean Shell");
        group.addPadSpaced().add(_scriptField);
        group.addDivider();
        group.addButtonBox().addSubmitButton();

        _resultsBox = root.addBox();
        _resultsBox.css().padSpaced();

        return root;
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

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        String script = _scriptField.getValue();
        if ( script == null )
            return;

        KmBeanShell bs;
        bs = evaluate(script);

        ScGroup group;
        group = composeResults(bs);
        group.style().hide();

        ScAddContentScript add;
        add = _resultsBox.ajax().addContents();
        add.setModePrepend();
        add.setContent(group);

        group.ajax().show().slide();
    }

    private KmBeanShell evaluate(String script)
    {
        MyResourceFiles files = MyResourceFiles.getInstance();
        String scriptFolder = files.getBeanShellScriptFolder().getRealPath();
        String scriptInit = "init.bsh";

        KmBeanShell e;
        e = new KmBeanShell();
        e.setScriptFolder(scriptFolder);
        e.runScriptFile(scriptInit);
        e.setValue("data", getData());
        e.eval(script);

        return e;
    }

    private ScGroup composeResults(KmBeanShell bs)
    {
        ScGroup group;
        group = new ScGroup();

        if ( bs.isOk() )
        {
            group.setTitle("Ok");
            group.setFlavorDefault();
        }
        else
        {
            group.setTitle("Error");
            group.setFlavorError();
        }

        ScBox pad;
        pad = group.addPad();
        pad.addText(bs.getSource());

        if ( bs.hasResult() )
        {
            group.addDivider();

            pad = group.addPad();
            pad.addBox().addBold("Results");
            pad.addBox().addText(bs.getResult() + "");
        }

        if ( bs.hasOutput() )
        {
            group.addDivider();

            pad = group.addPad();
            pad.addBox().addBold("Output");
            pad.addText(bs.getOutput());
        }

        if ( bs.hasException() )
        {
            group.addDivider();

            pad = group.addPad();
            pad.addBox().addBold("Exception");
            pad.addText(bs.formatException());
            pad.addBreak();
            pad.addText(bs.getStackTrace());
        }

        return group;
    }
}
