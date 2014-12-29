package com.app.ui.page.manageRegions;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyRegion;
import com.app.model.meta.MyMetaRegion;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewRegionCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection     _banner;
    private ScActionButton     _editButton;

    private MyEditRegionDialog _editDialog;

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
        MyMetaRegion x = MyRegion.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditRegionDialog();
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

    private MyModelListener<MyRegion> newSaveListener()
    {
        return new MyModelListener<MyRegion>()
        {
            @Override
            protected void handle(MyRegion e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditRegionDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MyRegion> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setRegion(MyRegion e)
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
        MyRegion e = getAccess().findRegionUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyRegion e)
    {
        setRegion(e);
        ajaxPrintFast();
    }

}
