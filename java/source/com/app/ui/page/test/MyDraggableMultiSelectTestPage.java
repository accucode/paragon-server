package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDraggableMultiSelectList;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.model.MySkill;

public class MyDraggableMultiSelectTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDraggableMultiSelectTestPage instance = new MyDraggableMultiSelectTestPage();

    private MyDraggableMultiSelectTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    private ScDraggableMultiSelectList<MySkill> _list;

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

        ScDiv footer;
        footer = group.getFooter();
        footer.css().smallGap();
        footer.addSubmitButton();
        footer.show();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

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

        KmList<String> names = skills.collect(MySkill.Meta.Name);
        String s = names.format();

        ajax().toast(s);
    }
}
