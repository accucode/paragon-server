package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScMultiTupleView;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.types.KmStringTuple;
import com.kodemore.validator.KmStringValidator;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyMultiTupleViewTestPage
    extends MyPage
{
    //##################################################
    //# variables
    //##################################################

    private ScMultiTupleView                _multiTupleView;

    //##################################################
    //# singleton
    //##################################################

    private static MyMultiTupleViewTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyMultiTupleViewTestPage();
    }

    public static MyMultiTupleViewTestPage getInstance()
    {
        return _instance;
    }

    private MyMultiTupleViewTestPage()
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
        createField();
        installFieldGroup(root);
    }

    private void createField()
    {
        KmStringValidator validator;
        validator = new KmStringValidator();
        validator.allowAll();
        // validator.setRequired();
        validator.setMaximumLength(25);

        _multiTupleView = new ScMultiTupleView();
        _multiTupleView.setValidator(validator);
        _multiTupleView.setLabel("Multi Tuple View");
    }

    private void installFieldGroup(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Multi Tuple View");

        ScDiv body;
        body = group.getBody();
        body.css().gap();

        ScFieldTable fields = body.addFieldTable();

        fields.add(_multiTupleView);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addButton("Set Value", newUncheckedAction(this::handleSetValue));
        buttons.addButton("Clear", newUncheckedAction(this::handleClear));
        buttons.addButton("Hide", newUncheckedAction(this::handleHide));
        buttons.addButton("Show", newUncheckedAction(this::handleShow));
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        _multiTupleView.setOptions(getSampleOptions());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        ajaxHideAllErrors();
        validate();

        KmList<KmStringTuple> v = _multiTupleView.getValue();

        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( KmStringTuple e : v )
            out.printfln("%s - %s", e.getKey(), e.getValue());

        _multiTupleView.ajaxSetFieldValue(v);
        ajax().toast(out.toString());
    }

    private void handleSetValue()
    {
        ajaxHideAllErrors();
        _multiTupleView.ajaxSetFieldValue(getSampleValue());
    }

    private void handleClear()
    {
        ajaxHideAllErrors();
        _multiTupleView.ajaxClearFieldValue();
    }

    private void handleHide()
    {
        _multiTupleView.ajaxHide();
    }

    private void handleShow()
    {
        _multiTupleView.ajaxShow();
    }

    //##################################################
    //# support
    //##################################################

    private KmList<ScOption<String>> getSampleOptions()
    {
        KmList<ScOption<String>> v;
        v = new KmList<>();
        v.add(ScOption.create("1", "Option 1"));
        v.add(ScOption.create("2", "Option 2"));
        v.add(ScOption.create("3", "Option 3"));
        v.add(ScOption.create("4", "Option 4"));
        return v;
    }

    private KmList<KmStringTuple> getSampleValue()
    {
        KmList<KmStringTuple> v;
        v = new KmList<>();
        v.add(KmStringTuple.createStrings("1", "Value 1"));
        v.add(KmStringTuple.createStrings("2", "Value 2"));
        v.add(KmStringTuple.createStrings("3", "Value 3"));
        v.add(KmStringTuple.createStrings("4", "Value 4"));
        return v;
    }

    private void ajaxHideAllErrors()
    {
        getRoot().ajaxHideAllErrors();
    }
}
