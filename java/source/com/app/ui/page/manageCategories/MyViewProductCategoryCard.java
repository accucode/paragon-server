package com.app.ui.page.manageCategories;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyProductCategory;
import com.app.model.meta.MyMetaProductCategory;
import com.app.ui.control.MyCard;
import com.app.ui.page.support.MyTitleSection;

public class MyViewProductCategoryCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection _banner;
    private ScActionButton _editButton;

    private MyEditProductCategoryDialog _editDialog;

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
        MyMetaProductCategory x = MyProductCategory.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditProductCategoryDialog();
        _editDialog.setParent(this);
        _editDialog.addSavedListener(this::handleSaved);
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditProductCategoryDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(Consumer<MyProductCategory> e)
    {
        getEditDialog().addSavedListener(e);
    }

    public void setProductCategory(MyProductCategory e)
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
        MyProductCategory e = getAccess().findProductCategoryUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyProductCategory e)
    {
        setProductCategory(e);
        ajaxPrintFast();
    }

}
