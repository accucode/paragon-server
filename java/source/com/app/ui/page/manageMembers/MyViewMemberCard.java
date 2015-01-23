package com.app.ui.page.manageMembers;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyMember;
import com.app.model.meta.MyMetaMember;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewMemberCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection       _banner;
    private ScActionButton       _editButton;
    private ScActionButton       _removeButton;

    private MyEditMemberDialog   _editDialog;
    private MyRemoveMemberDialog _removeDialog;

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
        installRemoveDialog();
    }

    private void installBanner()
    {
        _banner = add(new MyTitleSection());
        _banner.css().flexStatic().formBanner();

        _editButton = _banner.addButton();
        _editButton.styleEdit();
        _editButton.setAction(this::handleEdit);

        _removeButton = _banner.addButton();
        _removeButton.styleRemove();
        _removeButton.setAction(this::handleRemove);
    }

    private void installBody()
    {
        MyMetaMember x = MyMember.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.UserName);
        fields.addText(x.UserEmail);
        fields.addText(x.RoleName);
        fields.addText(x.SkillNames);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditMemberDialog();
        _editDialog.setParent(this);
        _editDialog.addSaveListener(newSaveListener());
    }

    private void installRemoveDialog()
    {
        _removeDialog = new MyRemoveMemberDialog();
        _removeDialog.setParent(this);
        _removeDialog.addRemoveListener(newRemoveListener());
    }

    //##################################################
    //# actions
    //##################################################

    private MyModelListener<MyMember> newSaveListener()
    {
        return new MyModelListener<MyMember>()
        {
            @Override
            protected void handle(MyMember e)
            {
                handleSaved(e);
            }
        };
    }

    private MyModelListener<MyMember> newRemoveListener()
    {
        return new MyModelListener<MyMember>()
        {
            @Override
            protected void handle(MyMember e)
            {
                handleRemoved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public void addSaveListener(MyModelListener<MyMember> e)
    {
        _editDialog.addSaveListener(e);
    }

    public void addRemoveListener(MyModelListener<MyMember> e)
    {
        _removeDialog.addRemoveListener(e);
    }

    public void setMember(MyMember e)
    {
        e.applyTo(this);

        _banner.setTitle(e.getUserName());
        _editButton.setArgument(e.getUid());
        _removeButton.setArgument(e.getUid());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        String uid = getStringArgument();
        MyMember e = getAccess().findMemberUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleRemove()
    {
        String uid = getStringArgument();
        MyMember e = getAccess().findMemberUid(uid);

        _removeDialog.ajaxOpen(e);
    }

    private void handleSaved(MyMember e)
    {
        setMember(e);
        ajaxPrintFast();
    }

    /**
     * @param e
     */
    private void handleRemoved(MyMember e)
    {
        ajaxClose();
    }

}
