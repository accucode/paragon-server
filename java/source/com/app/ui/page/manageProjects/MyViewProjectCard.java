package com.app.ui.page.manageProjects;

import java.util.function.Consumer;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyCard;
import com.app.ui.page.support.MyTitleSection;

public class MyViewProjectCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection _banner;
    private ScActionButton _editButton;

    private MyEditProjectDialog _editDialog;

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
        MyMetaProject x = MyProject.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditProjectDialog();
        _editDialog.setParent(this);
        _editDialog.addSavedListener(this::handleSaved);
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditProjectDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(Consumer<MyProject> e)
    {
        getEditDialog().addSavedListener(e);
    }

    public void setProject(MyProject e)
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
        MyProject e = getAccess().findProjectUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyProject e)
    {
        setProject(e);
        ajaxPrintFast();
    }

}
