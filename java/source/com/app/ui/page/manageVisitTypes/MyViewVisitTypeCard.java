package com.app.ui.page.manageVisitTypes;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyVisitType;
import com.app.model.meta.MyMetaVisitType;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewVisitTypeCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private MyTitleSection        _banner;
    private ScActionButton        _editButton;

    private MyEditVisitTypeDialog _editDialog;

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
        MyMetaVisitType x = MyVisitType.Meta;

        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditVisitTypeDialog();
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

    private MyModelListener<MyVisitType> newSaveListener()
    {
        return new MyModelListener<MyVisitType>()
        {
            @Override
            protected void handle(MyVisitType e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditVisitTypeDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MyVisitType> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setVisitType(MyVisitType e)
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
        MyVisitType e = getAccess().findVisitTypeUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyVisitType e)
    {
        setVisitType(e);
        ajaxPrintFast();
    }

}
