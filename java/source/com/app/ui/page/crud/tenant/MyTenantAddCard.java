package com.app.ui.page.crud.tenant;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.types.KmDayFrequency;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.model.meta.MyMetaTenant;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

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
    protected void installBody(ScDiv body)
    {
        body.add(createLayout());
    }

    private ScControl createLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createBusinessHoursSection());
        e.add(createMemoSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createNameField());
        e.add(createHostnameField());
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    private ScControl createHostnameField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScTextField e;
        e = x.Hostname.newField();
        _hostnameField = e;
        return e;
    }

    //==================================================
    //= install :: business hours
    //==================================================

    private ScControl createBusinessHoursSection()
    {
        MyMetaTenant x = MyTenant.Meta;

        KmTimeZone defaultZone = MyTenant.DEFAULT_TIME_ZONE;
        KmDayFrequency defaultDays = MyTenant.DEFAULT_BUSINESS_DAYS;
        KmTime defaultStart = MyTenant.DEFAULT_BUSINESS_START;
        KmTime defaultEnd = MyTenant.DEFAULT_BUSINESS_END;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Business Hours");
        e.add(x.TimeZoneCode.newTimeZoneDropdown()).setTimeZone(defaultZone);
        e.addSpace();
        e.addField(x.BusinessDays, "Days").setValue(defaultDays);
        e.addField(x.BusinessStartTime, "Start Time").setValue(defaultStart);
        e.addField(x.BusinessEndTime, "End Time").setValue(defaultEnd);
        return e;
    }

    //==================================================
    //= install :: memo
    //==================================================

    private ScControl createMemoSection()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScTextArea e;
        e = x.Memo.newMultilineField();
        e.layoutBlock();
        return e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateName();
        validateHostname();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        String name = field.getValue();

        boolean dup = getAccess().getTenantDao().isDuplicateName(name);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateHostname()
    {
        ScTextField field = _hostnameField;
        if ( field.hasErrors() )
            return;

        String name = field.getValue();

        boolean dup = getAccess().getTenantDao().isDuplicateHostname(name);
        if ( dup )
            field.addError("Duplicate.");
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
