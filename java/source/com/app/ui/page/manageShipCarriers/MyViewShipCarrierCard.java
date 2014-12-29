package com.app.ui.page.manageShipCarriers;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScText;

import com.app.model.MyShipCarrier;
import com.app.model.MyShipMethod;
import com.app.model.meta.MyMetaShipCarrier;
import com.app.ui.control.MyCard;
import com.app.ui.control.MyModelListener;
import com.app.ui.page.support.MyTitleSection;

public class MyViewShipCarrierCard
    extends MyCard
{
    //##################################################
    //# constants
    //##################################################

    private static final int        METHOD_COUNT = MyShipCarrier.MAX_PER_PROJECT;

    //##################################################
    //# variables
    //##################################################

    private MyTitleSection          _banner;
    private ScActionButton          _editButton;
    private ScText[]                _methodTexts;

    private MyEditShipCarrierDialog _editDialog;

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
        ScDiv body;
        body = addDiv();
        body.css().flexFiller().formBody().gap();

        installGeneralOn(body);
        installMethodsOn(body);
    }

    private void installGeneralOn(ScDiv body)
    {
        MyMetaShipCarrier x = MyShipCarrier.Meta;

        ScFieldset set;
        set = body.addFieldset("General");

        ScFieldLayout fields;
        fields = set.addFieldLayout();
        fields.addText(x.Name);
    }

    private void installMethodsOn(ScContainer body)
    {
        ScFieldset set;
        set = body.addFieldset("Methods");

        ScFieldTable fields;
        fields = set.addFieldTable();

        int n = METHOD_COUNT;
        _methodTexts = new ScText[n];

        for ( int i = 0; i < n; i++ )
        {
            ScText e;
            e = fields.addText();
            e.setLabel("Method %s: ", i + 1);
            _methodTexts[i] = e;
        }
    }

    private void installEditDialog()
    {
        _editDialog = new MyEditShipCarrierDialog();
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

    private MyModelListener<MyShipCarrier> newSaveListener()
    {
        return new MyModelListener<MyShipCarrier>()
        {
            @Override
            protected void handle(MyShipCarrier e)
            {
                handleSaved(e);
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEditShipCarrierDialog getEditDialog()
    {
        return _editDialog;
    }

    public void addSaveListener(MyModelListener<MyShipCarrier> e)
    {
        getEditDialog().addSaveListener(e);
    }

    public void setShipCarrier(MyShipCarrier e)
    {
        e.applyTo(this);

        _banner.setTitle(e.getName());
        _editButton.setArgument(e.getUid());

        applyMethodsFor(e);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        String uid = getStringArgument();
        MyShipCarrier e = getAccess().findShipCarrierUid(uid);

        _editDialog.ajaxOpen(e);
    }

    private void handleSaved(MyShipCarrier e)
    {
        setShipCarrier(e);
        ajaxPrintFast();
    }

    //##################################################
    //# support
    //##################################################

    private void applyMethodsFor(MyShipCarrier e)
    {
        for ( ScText t : _methodTexts )
            t.clearValue();

        KmList<MyShipMethod> v = e.getShipMethodsByName();

        int n = v.size();
        for ( int i = 0; i < n; i++ )
        {
            ScText field = _methodTexts[i];
            String name = v.get(i).getName();
            field.setValue(name);
        }
    }

}
