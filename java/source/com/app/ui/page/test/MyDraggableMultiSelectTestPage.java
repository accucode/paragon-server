package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDraggableMultiSelectList;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.model.MySkill;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDraggableMultiSelectTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDraggableMultiSelectTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDraggableMultiSelectTestPage();
    }

    public static MyDraggableMultiSelectTestPage getInstance()
    {
        return _instance;
    }

    private MyDraggableMultiSelectTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDraggableMultiSelectList<MySkill> _list;

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
        root.css().fill();

        ScForm form;
        form = root.addForm();
        form.css().fill().gap();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Skills");
        group.style().width(500).height(300);

        ScDiv body;
        body = group.getBody();
        body.css().relative().noBorder();

        _list = body.addDraggableMultiList();
        _list.layoutFill();
        _list.setKeyAdapter(MySkill.Meta.Uid);
        _list.setTitleAdapter(MySkill.Meta.Name);

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addResetButton();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void preRender()
    {
        KmList<MySkill> avail;
        avail = getCurrentProject().getSkillsByName();

        KmList<MySkill> sel;
        sel = new KmList<>();
        sel.add(avail.removeFirst());

        _list.setSelectedValues(sel);
        _list.setAvailableValues(avail);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        KmList<String> uids = _list.getSelectedKeys();
        KmList<MySkill> skills = new KmList<>();

        for ( String uid : uids )
        {
            MySkill e = getAccess().findSkillUid(uid);
            skills.add(e);
        }

        String s = skills.join(e -> e.getName());

        ajax().toast(s);
    }
}
