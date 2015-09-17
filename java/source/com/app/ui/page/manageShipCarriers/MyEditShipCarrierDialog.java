package com.app.ui.page.manageShipCarriers;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyShipCarrier;
import com.app.model.MyShipMethod;
import com.app.model.meta.MyMetaShipCarrier;
import com.app.ui.control.MyEditDialog;

public class MyEditShipCarrierDialog
    extends MyEditDialog<MyShipCarrier>
{
    //##################################################
    //# constants
    //##################################################

    private static final int METHOD_COUNT = MyShipCarrier.MAX_PER_PROJECT;

    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _uidField;
    private ScTextField[]         _methodFields;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("EDIT Ship Carrier");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaShipCarrier x = MyShipCarrier.Meta;

        ScDiv body;
        body = getBody();
        body.css().gap();

        _uidField = body.addHiddenField(x.Uid);

        installGeneral();
        installMethods();
    }

    private void installGeneral()
    {
        MyMetaShipCarrier x = MyShipCarrier.Meta;

        ScFieldset set;
        set = getBody().addFieldset("General");

        ScFieldLayout fields;
        fields = set.addFieldLayout();
        fields.addField(x.Name);
    }

    private void installMethods()
    {
        ScFieldset set;
        set = getBody().addFieldset("Methods");

        ScFieldTable fields;
        fields = set.addFieldTable();

        int n = METHOD_COUNT;
        _methodFields = new ScTextField[n];

        for ( int i = 0; i < n; i++ )
        {
            ScTextField e;
            e = fields.addTextField();
            e.setLabel("Method %s: ", i + 1);
            _methodFields[i] = e;
        }
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare(MyShipCarrier e)
    {
        applyFromModel(e);

        prepareMethods(e);
    }

    private void prepareMethods(MyShipCarrier e)
    {
        for ( ScTextField f : _methodFields )
            f.clearValue();

        KmList<MyShipMethod> v = e.getShipMethodsByName();

        int n = v.size();
        for ( int i = 0; i < n; i++ )
        {
            ScTextField field = _methodFields[i];
            String name = v.get(i).getName();
            field.setValue(name);
        }
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyShipCarrier save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyShipCarrier e;
        e = getAccess().findShipCarrierUid(uid);
        e.applyFrom(this);

        applyMethodsTo(e);

        e.validate();

        flushDao();

        return e;
    }

    private void applyMethodsTo(MyShipCarrier e)
    {
        e.clearShipMethods();

        int n = METHOD_COUNT;
        for ( int i = 0; i < n; i++ )
        {
            ScTextField f;
            f = _methodFields[i];

            if ( f.hasValue() )
            {
                String name = f.getValue();
                e.addShipMethod(name);
            }
        }
    }
}
