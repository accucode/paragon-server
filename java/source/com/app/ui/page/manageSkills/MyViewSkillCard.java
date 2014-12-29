package com.app.ui.page.manageSkills;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MySkill;
import com.app.model.meta.MyMetaSkill;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewSkillCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection    _banner;
    private ScActionButton    _editButton;

    private MyEditSkillDialog _editDialog;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        css().fill().flex().flexColumn();

        installBanner();
        installBody();
        installEditDialog();
    }

    private void installBanner()
    {
        _banner = add(new MyTitleSection());
        _banner.css().flexStatic().formBanner();

        _editButton = _banner.addButton();
        _editButton.styleEdit();
        _editButton.setAction(newEditAction());
    }

    private void installBody()
    {
        MyMetaSkill x = MySkill.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditSkillDialog();
        _editDialog.setParent(this);
        _editDialog.addSaveListener(newSaveListener());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newEditAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEdit();
            }
        };
    }

    private MyModelListener<MySkill> newSaveListener()
    {
        return new MyModelListener<MySkill>()
        {
            @Override
            protected void handle(MySkill e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditSkillDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MySkill> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setSkill(MySkill e)
    {
        e.applyTo(this);

        _banner.setTitle(e.getName());
        _editButton.setArgument(e.getUid());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        String uid = getStringArgument();
        MySkill e = getAccess().findSkillUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MySkill e)
    {
        setSkill(e);
        ajaxPrintFast();
    }

}
