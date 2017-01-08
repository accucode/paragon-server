package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyCookieTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyCookieTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyCookieTestPage();
    }

    public static MyCookieTestPage getInstance()
    {
        return _instance;
    }

    private MyCookieTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _keyField;
    private ScTextField _valueField;

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
        _keyField = new ScTextField();
        _keyField.setLabel("Key");
        _keyField.disableChangeTracking();

        _valueField = new ScTextField();
        _valueField.setLabel("Value");
        _valueField.disableChangeTracking();

        ScGroup group;
        group = root.addForm().addGroup("Cookies");

        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(_keyField);
        fields.add(_valueField);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Get", this::handleGet);
        buttons.addButton("Set", this::handleSet);
        buttons.addButton("Clear", this::handleClear);
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

    private void handleGet()
    {
        String key = checkKey();
        if ( key == null )
            return;

        String value = getData().getCookie(key);
        ajax().toast("%s = %s", key, value);
    }

    private void handleSet()
    {
        String key = checkKey();
        if ( key == null )
            return;

        String value = _valueField.getValue();
        ajax().setCookie(key, value);
        ajax().toast("%s = %s", key, value);
    }

    private void handleClear()
    {
        String key = checkKey();
        if ( key == null )
            return;

        _valueField.ajaxClearFieldValue();
        ajax().clearCookie(key);
        ajax().toast("%s cleared", key);
    }

    //##################################################
    //# support
    //##################################################

    private String checkKey()
    {
        String key = _keyField.getValue();
        if ( Kmu.hasValue(key) )
            return key;

        ajax().toast("no key");
        return null;
    }

}
