package com.app.ui.page.manageCategories;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyCategory;
import com.app.model.meta.MyMetaCategory;
import com.app.ui.control.MyCard;
import com.app.ui.page.support.MyTitleSection;

public class MyViewCategoryCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection       _banner;
    private ScActionButton       _editButton;

    private MyEditCategoryDialog _editDialog;

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
        MyMetaCategory x = MyCategory.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditCategoryDialog();
        _editDialog.setParent(this);
        _editDialog.addSaveListener(this::handleSaved);
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditCategoryDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(Consumer<MyCategory> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setCategory(MyCategory e)
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
        MyCategory e = getAccess().findCategoryUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyCategory e)
    {
        setCategory(e);
        ajaxPrintFast();
    }

}