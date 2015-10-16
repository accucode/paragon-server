package com.app.ui.page.manageAttentionGroups;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyAttentionGroup;
import com.app.model.meta.MyMetaAttentionGroup;
import com.app.ui.control.MyCard;
import com.app.ui.page.support.MyTitleSection;

public class MyViewAttentionGroupCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection _banner;
    private ScActionButton _editButton;

    private MyEditAttentionGroupDialog _editDialog;

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
        _editButton.setAction(this::handleEdit);
    }

    private void installBody()
    {
        MyMetaAttentionGroup x = MyAttentionGroup.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditAttentionGroupDialog();
        _editDialog.setParent(this);
        _editDialog.addSavedListener(this::handleSaved);
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditAttentionGroupDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(Consumer<MyAttentionGroup> e)
    {
        getEditDialog().addSavedListener(e);
    }

    public void setAttentionGroup(MyAttentionGroup e)
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
        MyAttentionGroup e = getAccess().findAttentionGroupUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyAttentionGroup e)
    {
        setAttentionGroup(e);
        ajaxPrintFast();
    }

}
