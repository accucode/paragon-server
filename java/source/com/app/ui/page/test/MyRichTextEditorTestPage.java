package com.app.ui.page.test;

import com.kodemore.html.KmHtmlCleaner;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAbsoluteLayout;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScRichTextEditor;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyRichTextEditorTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyRichTextEditorTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyRichTextEditorTestPage();
    }

    public static MyRichTextEditorTestPage getInstance()
    {
        return _instance;
    }

    private MyRichTextEditorTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScRichTextEditor _richTextEditor;

    private ScDiv _outputDiv;
    private ScDiv _htmlOutputDiv;

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
        ScAbsoluteLayout layout;
        layout = root.addAbsoluteLayout();

        ScBox left = addLeftPercentPadded(layout, 50);
        installRtePanelOn(left);

        ScBox top = addTopPercentPadded(layout, 50);
        installResultPanelOn(top);

        ScBox center = addCenterPadded(layout);
        installHtmlPanelOn(center);
    }

    private void installRtePanelOn(ScDiv root)
    {
        ScForm form;
        form = root.addForm();
        form.css().fill();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Rich Text Editor");
        group.css().fill();

        _richTextEditor = new ScRichTextEditor();
        _richTextEditor.setRequired();

        ScDiv body;
        body = group.getBody();
        body.css().gap().autoY();
        body.css().auto();

        ScFieldLayout fields = body.addFieldLayout();
        fields.add(_richTextEditor);

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.css().auto();
        buttons.addSubmitButton();
        buttons.addButton("Add Sample Content", this::handleSetSampleContent);
        buttons.addResetButton();
    }

    private void installResultPanelOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Result");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().gap();
        body.css().auto();
        _outputDiv = body.addDiv();
    }

    private void installHtmlPanelOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("HTML");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().gap();
        body.css().auto();
        _htmlOutputDiv = body.addDiv();
    }

    //##################################################
    //# layout
    //##################################################

    private ScBox addLeftPercentPadded(ScAbsoluteLayout root, int percent)
    {
        ScDiv left = root.addLeftPercent(percent);

        ScAbsoluteLayout inner;
        inner = left.addAbsoluteLayout();
        inner.padTop();
        inner.padLeft();
        inner.padBottom();

        ScBox content;
        content = inner.addCenter().addBox();
        content.css().fill();
        return content;
    }

    private ScBox addTopPercentPadded(ScAbsoluteLayout root, int percent)
    {
        ScDiv left = root.addTopPercent(percent);

        ScAbsoluteLayout inner;
        inner = left.addAbsoluteLayout();
        inner.padTop();
        inner.padLeft();
        inner.padRight();

        ScBox content;
        content = inner.addCenter().addBox();
        content.css().fill();
        return content;
    }

    private ScBox addCenterPadded(ScAbsoluteLayout root)
    {
        ScDiv left = root.addCenter();

        ScAbsoluteLayout inner;
        inner = left.addAbsoluteLayout();
        inner.padTop();
        inner.padLeft();
        inner.padBottom();
        inner.padRight();

        ScBox content;
        content = inner.addCenter().addBox();
        content.css().fill();
        return content;
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
        ajax().hideAllErrors();
        _richTextEditor.validate();
        _richTextEditor.ajaxUpdateValue();

        String text = _richTextEditor.getValue();

        if ( Kmu.isEmpty(text) )
            text = "null";

        KmHtmlCleaner c;
        c = new KmHtmlCleaner();
        c.setDefaultWhitelist();
        c.setDefaultBlacklist();

        text = c.clean(text);

        _outputDiv.ajaxSetHtml(text);
        _htmlOutputDiv.ajaxSetText(text);
    }

    private void handleSetSampleContent()
    {
        _richTextEditor.setValue(getSampleContent());
        _richTextEditor.ajaxUpdateValue();
    }

    private String getSampleContent()
    {
        String s = "<p>Here is some sample text illustrating some available styles including "
            + "<strong>bold</strong>, <em>itallic</em>, <s>strikethrough</s>, <sub>subscript</sub>, "
            + "and <sup>superscript</sup>.</p><ol><li>This is a numbered list.</li><li>That has a "
            + "few lines.<ol><li>Lines can be indented.</li></ol></li></ol><ul><li>Bulleted lists "
            + "are also available<ul><li>Lines can also be indented</li></ul></li></ul><p>Pressing "
            + "the enter key starts a new paragraph.</p><p>Lorem ipsum dolor sit amet, consectetur "
            + "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip "
            + "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
            + "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non "
            + "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>";
        return s;
    }
}
