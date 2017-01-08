package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScCheckboxList;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyCheckboxListTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyCheckboxListTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyCheckboxListTestPage();
    }

    public static MyCheckboxListTestPage getInstance()
    {
        return _instance;
    }

    private MyCheckboxListTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScCheckboxList<String> _checkboxList;

    //##################################################
    //# settings
    //##################################################S

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
        root.css().fill().auto();

        _checkboxList = new ScCheckboxList<>();
        _checkboxList.layoutBlockMultiColumn(100);

        _checkboxList.addOption("a", "apple", "help");
        _checkboxList.addOption("b", "banana", "help");
        _checkboxList.addOption("c", "carrot", "help");
        _checkboxList.addOption("d", "durian");
        _checkboxList.addOption("e", "eggplant");
        _checkboxList.addOption("f", "fig");
        _checkboxList.addOption("g", "grape");
        _checkboxList.addOption("h", "horseradish", "help");
        _checkboxList.addOption("i", "ice plant");
        _checkboxList.addOption("j", "jackfruit");
        _checkboxList.addOption("k", "kale");
        _checkboxList.addOption("l", "leek", "help");
        _checkboxList.addOption("m", "mango");
        _checkboxList.addOption("n", "nectarine");
        _checkboxList.addOption("o", "okra");
        _checkboxList.addOption("p", "pear", "help");
        _checkboxList.addOption("r", "radish", "help");
        _checkboxList.addOption("s", "saffron");
        _checkboxList.addOption("t", "tomato");
        _checkboxList.addOption("u", "upland cress");
        _checkboxList.addOption("v", "valerian");
        _checkboxList.addOption("w", "watercress");
        _checkboxList.addOption("x", "xeris", "help");
        _checkboxList.addOption("y", "yam", "help");
        _checkboxList.addOption("z", "zucchini");

        _checkboxList.setValue(KmList.createWith("b", "d"));

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScFieldset set;
        set = form.addFieldset("checkbox list");
        set.setHelp("This contains a single checkbox list.");
        set.add(_checkboxList);
        set.addBreak();

        ScDiv buttons;
        buttons = set.addFlexRow();
        buttons.css().rowSpacer5();
        buttons.addSubmitButton();
        buttons.addResetButton();
        buttons.addButton("Toast Value", newUncheckedAction(this::handleToastValue));
        buttons.addButton("Ajax Set Value (c,e)", newUncheckedAction(this::handleAjaxSetValue));
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

    private void handleSubmit()
    {
        KmList<String> v = _checkboxList.getValue();
        ajax().toast(v.join());
        _checkboxList.ajaxUpdateFieldValues();
    }

    private void handleToastValue()
    {
        KmList<String> v = _checkboxList.getValue();
        ajax().toast(v.join());
    }

    private void handleAjaxSetValue()
    {
        KmList<String> v = KmList.createStrings("c", "e");
        _checkboxList.ajaxSetFieldValue(v);
    }

}
