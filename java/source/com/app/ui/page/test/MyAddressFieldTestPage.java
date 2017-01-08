package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.address.MyAddressIF;
import com.app.model.address.MyAddressVo;
import com.app.ui.control.MyAddressField;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAddressFieldTestPage
    extends MyPage
{
    //##################################################
    //# variables
    //##################################################

    private MyAddressField                _addressField;

    //##################################################
    //# singleton
    //##################################################

    private static MyAddressFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyAddressFieldTestPage();
    }

    public static MyAddressFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyAddressFieldTestPage()
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
        _addressField = new MyAddressField();

        installFieldGroup(root);
    }

    private void installFieldGroup(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Address Field");

        ScDiv body;
        body = group.getBody();
        body.css().gap();
        body.add(_addressField);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addButton("Set Sample", newUncheckedAction(this::handleSetSample));
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
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        MyAddressIF e = _addressField.getValue();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println(e.getStreet1());

        if ( Kmu.hasValue(e.getStreet2()) )
            out.println(e.getStreet2());

        out.printfln("%s, %s, %s", e.getCity(), e.getRegion(), e.getPostalCode());
        out.println(e.getCountry());

        ajax().toast(out.toString());
    }

    private void handleSetSample()
    {
        _addressField.setValue(getSampleAddress());
        _addressField.ajaxUpdateFieldValues();
    }

    private void handleClear()
    {
        _addressField.clearValue();
        _addressField.ajaxUpdateFieldValues();
    }

    private void handleHide()
    {
        _addressField.ajaxHide();
    }

    private void handleShow()
    {
        _addressField.ajaxShow();
    }

    //##################################################
    //# support
    //##################################################

    private MyAddressIF getSampleAddress()
    {
        MyAddressVo vo;
        vo = new MyAddressVo();
        vo.setStreet1("6886 S Yosemite St");
        vo.setStreet2("Suite 21132");
        vo.setCity("Centennial");
        vo.setRegion("Colorado");
        vo.setPostalCode("20112");
        vo.setCountry("USA");
        return vo;
    }
}
