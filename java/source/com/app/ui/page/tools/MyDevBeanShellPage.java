package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.script.ScAddContentScript;
import com.kodemore.utility.KmBeanShell;

import com.app.file.MyResourceFiles;

public class MyDevBeanShellPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevBeanShellPage instance = new MyDevBeanShellPage();

    private MyDevBeanShellPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextArea _scriptField;
    private ScBox      _resultsBox;

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
        _scriptField = new ScTextArea();
        _scriptField.style().height(100);
        _scriptField.setWidthFull();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);
        form.css().pad();

        ScGroup group;
        group = form.addGroup("Bean Shell");
        group.getBody().addGap().add(_scriptField);
        group.addBodyDivider();
        group.getBody().addButtonBox().addSubmitButton();

        _resultsBox = root.addBox();
        _resultsBox.css().gap();
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
            group.setTitle("Ok");
        else
        {
            group.setTitle("Error");
            group.bannerCss().backgroundRed();
        }

        ScBox pad;
        pad = group.getBody().addPad();
        pad.addText(bs.getSource());

        if ( bs.hasResult() )
        {
            group.addBodyDivider();

            pad = group.getBody().addPad();
            pad.addBox().addBold("Results");
            pad.addBox().addText(bs.getResult() + "");
        }

        if ( bs.hasOutput() )
        {
            group.addBodyDivider();

            pad = group.getBody().addPad();
            pad.addBox().addBold("Output");
            pad.addText(bs.getOutput());
        }

        if ( bs.hasException() )
        {
            group.addBodyDivider();

            pad = group.getBody().addPad();
            pad.addBox().addBold("Exception");
            pad.addText(bs.formatException());
            pad.addBreak();
            pad.addText(bs.getStackTrace());
        }

        return group;
    }
}
