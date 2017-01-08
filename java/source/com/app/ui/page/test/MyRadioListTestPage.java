package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScRadioList;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the radioList control.
 */
public final class MyRadioListTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyRadioListTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyRadioListTestPage();
    }

    public static MyRadioListTestPage getInstance()
    {
        return _instance;
    }

    private MyRadioListTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScRadioList<String> _radioList;

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
        root.css().fill().auto();

        _radioList = new ScRadioList<>();
        _radioList.layoutBlockMultiColumn(100);

        _radioList.addOption("a", "apple");
        _radioList.addOption("b", "banana");
        _radioList.addOption("c", "carrot");
        _radioList.addOption("d", "durian");
        _radioList.addOption("e", "eggplant");
        _radioList.addOption("f", "fig");
        _radioList.addOption("g", "grape");
        _radioList.addOption("h", "horseradish");
        _radioList.addOption("i", "ice plant");
        _radioList.addOption("j", "jackfruit");
        _radioList.addOption("k", "kale");
        _radioList.addOption("l", "leek");
        _radioList.addOption("m", "mango");
        _radioList.addOption("n", "nectarine");
        _radioList.addOption("o", "okra");
        _radioList.addOption("p", "pear");
        _radioList.addOption("r", "radish");
        _radioList.addOption("s", "saffron");
        _radioList.addOption("t", "tomato");
        _radioList.addOption("u", "upland cress");
        _radioList.addOption("v", "valerian");
        _radioList.addOption("w", "watercress");
        _radioList.addOption("x", "xeris");
        _radioList.addOption("y", "yam");
        _radioList.addOption("z", "zucchini");

        _radioList.setValue("c");

        ScFieldset set;
        set = root.addForm().addFieldset("radio list");
        set.setHelp("This contains a single radio list.");
        set.add(_radioList);
        set.addBreak();

        ScDiv buttons;
        buttons = set.addFlexRow();
        buttons.css().rowSpacer5();
        buttons.addButton("Toast Value", this::handleToastValue);
        buttons.addButton("Ajax Set Value (g)", this::handleAjaxSetValue);
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

    private void handleToastValue()
    {
        String e = _radioList.getValue();
        ajax().toast(e);
    }

    private void handleAjaxSetValue()
    {
        _radioList.ajaxSetFieldValue("g");
    }

}
