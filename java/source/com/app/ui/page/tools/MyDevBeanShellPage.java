package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.script.ScAddContentScript;
import com.kodemore.utility.KmBeanShell;

import com.app.file.MyResourceFiles;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevBeanShellPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevBeanShellPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevBeanShellPage();
    }

    public static MyDevBeanShellPage getInstance()
    {
        return _instance;
    }

    private MyDevBeanShellPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextArea _scriptField;
    private ScDiv      _resultsBox;

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
        ScAction submitAction = newCheckedAction(this::handleSubmit);

        _scriptField = new ScTextArea();
        _scriptField.layoutBlock(100);
        _scriptField.disableChangeTracking();

        root.css().fill().auto().columnSpacer10();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(submitAction);

        ScGroup group;
        group = form.addGroup("Bean Shell");
        group.getBody().addGap().add(_scriptField);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();

        _resultsBox = root.addDiv();
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
        add = _resultsBox.ajaxAddContents();
        add.setModePrepend();
        add.setContent(group);

        group.ajaxShow().slide();
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

    private ScGroup composeResults(KmBeanShell shell)
    {
        ScGroup group;
        group = new ScGroup();
        group.css().marginBottom10();

        if ( shell.isOk() )
            group.setTitle("Ok");
        else
        {
            group.setTitle("Error");
            group.bannerCss().backgroundRed();
        }

        ScDiv pad;
        pad = group.getBody().addPad();
        pad.addText(shell.getSource());

        if ( shell.hasResult() )
        {
            group.addBodyDivider();

            pad = group.getBody().addPad();
            pad.addDiv().addBold("Results");
            pad.addDiv().addText(shell.getResult() + "");
        }

        if ( shell.hasOutput() )
        {
            group.addBodyDivider();

            pad = group.getBody().addPad();
            pad.addDiv().addBold("Output");
            pad.addText(shell.getOutput());
        }

        if ( shell.hasException() )
        {
            group.addBodyDivider();

            pad = group.getBody().addPad();
            pad.addDiv().addBold("Exception");
            pad.addText(shell.formatException());
            pad.addBreak();
            pad.addText(shell.getStackTrace());
        }

        return group;
    }
}
