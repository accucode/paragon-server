package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
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

    private ScRichTextEditor _editor;
    private ScDiv            _previewDiv;
    private ScDiv            _valueDiv;

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
        root.css().fill().flexRow().rowSpacer10();

        installEditorOn(root);

        ScDiv col;
        col = root.addFlexColumn();
        col.css().columnSpacer10().flexChildBasis0().flexChildFiller();
        installPreviewOn(col);
        installValueOn(col);
    }

    private void installEditorOn(ScContainer root)
    {
        _editor = new ScRichTextEditor();
        _editor.setFill();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);
        form.css().flexChildBasis0().flexChildFiller().relative();

        ScGroup group;
        group = form.addGroup("Rich Text Editor");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.add(_editor);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.css().auto();
        buttons.addSubmitButton();
        buttons.addButton("Add Sample Content", this::handleSetSampleContent);
        buttons.addResetButton();
    }

    private void installPreviewOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Preview");
        group.css().flexChildBasis0().flexChildFiller();

        ScDiv body;
        body = group.getBody();
        body.css().gap().auto();
        _previewDiv = body.addDiv();
    }

    private void installValueOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Value");
        group.css().flexChildBasis0().flexChildFiller();

        ScDiv body;
        body = group.getBody();
        body.css().gap().auto();
        _valueDiv = body.addDiv();
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
        _editor.validate();
        _editor.ajaxUpdateFieldValues();

        String text = _editor.getValue();

        if ( Kmu.isEmpty(text) )
            text = "null";

        _previewDiv.ajaxSetHtml(text);
        _valueDiv.ajaxSetText(text);
    }

    private void handleSetSampleContent()
    {
        _editor.ajaxSetFieldValue(getSampleContent());
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
