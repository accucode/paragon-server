package com.app.ui.page.manageUsers;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewUserCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection   _banner;
    private ScActionButton   _editButton;

    private MyEditUserDialog _editDialog;

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
        MyMetaUser x = MyUser.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
        fields.addText(x.Email);
        fields.addText(x.Phone);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditUserDialog();
        _editDialog.setParent(this);
        _editDialog.addSaveListener(newSaveListener());
    }

    //##################################################
    //# actions
    //##################################################

    private MyModelListener<MyUser> newSaveListener()
    {
        return new MyModelListener<MyUser>()
        {
            @Override
            protected void handle(MyUser e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditUserDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MyUser> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setUser(MyUser e)
    {
        e.applyTo(this);

        _banner.setTitle(e.getName());
        _banner.setSubtitle(e.getEmail());
        _editButton.setArgument(e.getUid());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        String uid = getStringArgument();
        MyUser e = getAccess().findUserUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyUser e)
    {
        setUser(e);
        ajaxPrintFast();
    }

}
