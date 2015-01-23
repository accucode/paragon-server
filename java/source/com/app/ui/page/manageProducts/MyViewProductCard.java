package com.app.ui.page.manageProducts;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyProduct;
import com.app.model.meta.MyMetaProduct;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewProductCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection      _banner;
    private ScActionButton      _editButton;

    private MyEditProductDialog _editDialog;

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
        MyMetaProduct x = MyProduct.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
        fields.addText(x.CategoryName);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditProductDialog();
        _editDialog.setParent(this);
        _editDialog.addSaveListener(newSaveListener());
    }

    //##################################################
    //# actions
    //##################################################

    private MyModelListener<MyProduct> newSaveListener()
    {
        return new MyModelListener<MyProduct>()
        {
            @Override
            protected void handle(MyProduct e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditProductDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MyProduct> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setProduct(MyProduct e)
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
        MyProduct e = getAccess().findProductUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyProduct e)
    {
        setProduct(e);
        ajaxPrintFast();
    }

}
