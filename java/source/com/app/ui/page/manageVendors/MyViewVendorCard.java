package com.app.ui.page.manageVendors;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewVendorCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection     _banner;
    private ScActionButton     _editButton;

    private MyEditVendorDialog _editDialog;

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
        MyMetaVendor x = MyVendor.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditVendorDialog();
        _editDialog.setParent(this);
        _editDialog.addSaveListener(newSaveListener());
    }

    //##################################################
    //# actions
    //##################################################

    private MyModelListener<MyVendor> newSaveListener()
    {
        return new MyModelListener<MyVendor>()
        {
            @Override
            protected void handle(MyVendor e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditVendorDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MyVendor> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setVendor(MyVendor e)
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
        MyVendor e = getAccess().findVendorUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyVendor e)
    {
        setVendor(e);
        ajaxPrintFast();
    }

}
