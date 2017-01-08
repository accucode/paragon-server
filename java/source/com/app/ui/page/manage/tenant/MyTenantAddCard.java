package com.app.ui.page.manage.tenant;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyTenantCriteria;
import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.model.meta.MyMetaTenant;
import com.app.ui.page.manage.crud.MyCrudAddCard;
import com.app.ui.page.manage.crud.MyCrudLayout;

public class MyTenantAddCard
    extends MyCrudAddCard<MyNullDomain,MyTenant>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScTextField _hostnameField;

    //##################################################
    //# constructor
    //##################################################

    public MyTenantAddCard()
    {
        super(new MyTenantBuilder());
    }

    public MyTenantAddCard(MyTenantBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        root.css().gap20();

        installGeneralOn(root);
    }

    private void installGeneralOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.css().widthFull();
        fields.add(createNameField());
        fields.add(createHostnameField());
    }

    private ScTextField createNameField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScTextField e;
        e = x.Name.newField();
        e.setWidthFull();
        _nameField = e;
        return e;
    }

    private ScTextField createHostnameField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScTextField e;
        e = x.Hostname.newField();
        e.setWidthFull();
        _hostnameField = e;
        return e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected void validateDetails()
    {
        validateQuietly();
        validateNameQuietly();
        validateHostnameQuietly();
        checkErrors();
    }

    private void validateNameQuietly()
    {
        if ( _nameField.hasErrors() )
            return;

        String name = _nameField.getValue();

        MyTenantCriteria c;
        c = getAccess().getTenantDao().createCriteria();
        c.whereName().is(name);

        if ( c.exists() )
            _nameField.addError("Duplicate");
    }

    private void validateHostnameQuietly()
    {
        if ( _hostnameField.hasErrors() )
            return;

        String name = _hostnameField.getValue();

        MyTenantCriteria c;
        c = getAccess().getTenantDao().createCriteria();
        c.whereHostname().is(name);

        if ( c.exists() )
            _hostnameField.addError("Duplicate");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyTenant saveNewChildOn(MyNullDomain ignored)
    {
        MyTenant e;
        e = new MyTenant();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
