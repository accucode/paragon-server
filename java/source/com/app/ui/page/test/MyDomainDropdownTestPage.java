package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDomainDropdownTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDomainDropdownTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDomainDropdownTestPage();
    }

    public static MyDomainDropdownTestPage getInstance()
    {
        return _instance;
    }

    private MyDomainDropdownTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDomainDropdownField<MyUser,String> _field;

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
        root.css().fill().auto().columnSpacer10();

        installFormOn(root);
        installDivLayoutsOn(root);
        installFieldsetLayoutsOn(root);
    }

    private void installFormOn(ScContainer root)
    {
        _field = createDropdown();

        ScForm form = root.addForm();
        ScGroup group = form.addGroup("Form");
        ScDiv body = group.getBody().addPad();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(_field);

        body.addBreak();

        ScDiv buttons;
        buttons = body.addButtonBox();
        buttons.addButton("Get User", this::handleGetValue);
        buttons.addButton("Set User (root)", this::handleSetUser);
    }

    private ScDomainDropdownField<MyUser,String> createDropdown()
    {
        ScDomainDropdownField<MyUser,String> e;
        e = MyUser.Tools.newDomainDropdown();
        e.setFilterFactory(this::getUserFilter);
        e.setNullNonePrefix();
        return e;
    }

    private KmFilter<MyUser> getUserFilter()
    {
        return getUsers().toFilter();
    }

    private void installDivLayoutsOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Div Layouts");

        ScDiv body;
        body = group.getBody().addGap();

        ScDiv div;
        div = body.addDiv();
        div.css().boxGray().pad();
        div.addButton("before");
        div.add(createDropdown()).layoutInline();
        div.addButton("after");

        div = body.addDiv();
        div.css().boxGray().pad();
        div.addButton("before");
        div.add(createDropdown()).layoutBlock();
        div.addButton("after");

        div = body.addDiv();
        div.css().boxGray().pad().flexRow();
        div.addButton("before");
        div.add(createDropdown()).layoutFlexFiller();
        div.addButton("after");
    }

    private void installFieldsetLayoutsOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Fieldset Layouts");

        ScDiv body;
        body = group.getBody().addGap();

        ScFieldset set;
        set = body.addFieldset("inline");
        set.css().pad();
        set.addButton("before");
        set.add(createDropdown()).layoutInline();
        set.addButton("after");

        set = body.addFieldset("block");
        set.css().pad();
        set.addButton("before");
        set.add(createDropdown()).layoutBlock();
        set.addButton("after");

        set = body.addFieldset("flex filler");
        ScDiv row;
        row = set.addFlexRow();
        row.addButton("before");
        row.add(createDropdown()).layoutFlexFiller();
        row.addButton("after");
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

    private void handleGetValue()
    {
        String s = _field.hasValue()
            ? _field.getValue().getFullName()
            : "<none>";

        ajax().toast(s);
    }

    private void handleSetUser()
    {
        MyUser e = getUsers().getFirstSafe();
        _field.ajaxSetFieldValue(e);
    }

    //##################################################
    //# users
    //##################################################

    private KmList<MyUser> getUsers()
    {
        return getCurrentTenant().getUsersByFullName();
    }
}
