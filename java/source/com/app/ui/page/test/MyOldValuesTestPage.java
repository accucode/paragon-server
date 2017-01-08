package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyOldValuesTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyOldValuesTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyOldValuesTestPage();
    }

    public static MyOldValuesTestPage getInstance()
    {
        return _instance;
    }

    private MyOldValuesTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroup _greenGroup;
    private ScGroup _blueGroup;

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
        root.css().fill().flexColumn().columnSpacer20().auto();

        ScDiv row;
        row = root.addFlexRow();
        row.css().rowSpacer20();
        installGreenGroupOn(row);
        installBlueGroupOn(row);

        installPageActionsOn(root);
    }

    private void installPageActionsOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Page");

        ScDiv body;
        body = group.getBody();

        ScDiv buttons;
        buttons = body.addButtonBox();
        buttons.addResetButton();
        buttons.addResetButton(_greenGroup).setText("Reset Green");
        buttons.addResetButton(_blueGroup).setText("Reset Blue");
        buttons.addButton("Action", this::handleOk);
        buttons.addButton("Restore", newUncheckedAction(this::handleRestorePage));
    }

    private void installGreenGroupOn(ScDiv root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmitGreen);

        ScGroup group;
        group = form.addGroup("Green");
        group.setChangeTrackingScope(true);
        _greenGroup = group;

        ScDiv body;
        body = group.getBody();
        body.css().boxGreen().gap();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(newField("aaa"));
        fields.add(newField("bbb"));

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.css().boxGray();
        buttons.addSubmitButton();
        buttons.addResetButton();
        buttons.addButton("Action", this::handleOk);
        buttons.addButton("Restore", newUncheckedAction(this::handleRestoreGreen));
    }

    private void installBlueGroupOn(ScDiv root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmitBlue);

        ScGroup group;
        group = form.addGroup("Blue");
        group.setChangeTrackingScope(true);
        _blueGroup = group;

        ScDiv body;
        body = group.getBody();
        body.css().boxBlue().gap();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(newField("ccc"));
        fields.add(newField("ddd"));

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.css().boxGray();
        buttons.addSubmitButton();
        buttons.addResetButton();
        buttons.addButton("Action", this::handleOk);
        buttons.addButton("Restore", newUncheckedAction(this::handleRestoreBlue));
    }

    private ScTextField newField(String s)
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel(s);
        e.setValue(s);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleOk()
    {
        ajax().toast("ok");
    }

    private void handleSubmitGreen()
    {
        _greenGroup.ajaxHideAllErrors();
        _greenGroup.validate();
        _greenGroup.ajaxUpdateFieldValues();

        ajax().toast("green updated");
    }

    private void handleSubmitBlue()
    {
        _blueGroup.ajaxHideAllErrors();
        _blueGroup.validate();
        _blueGroup.ajaxUpdateFieldValues();

        ajax().toast("blue updated");
    }

    private void handleRestorePage()
    {
        getRoot().ajaxResetFieldValues();
        ajax().toast("page restored");
    }

    private void handleRestoreGreen()
    {
        _greenGroup.ajaxResetFieldValues();
        ajax().toast("green restored");
    }

    private void handleRestoreBlue()
    {
        _blueGroup.ajaxResetFieldValues();
        ajax().toast("blue restored");
    }

}
