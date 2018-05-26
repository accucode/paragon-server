package com.app.ui.page.crud.tenant;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyTenant;
import com.app.model.meta.MyMetaTenant;
import com.app.model.support.MyTheme;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;
import com.app.ui.servlet.MyServletFilter;

public class MyTenantEditCard
    extends MyCrudEditCard<MyTenant>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScTextField _hostnameField;

    //##################################################
    //# constructor
    //##################################################

    public MyTenantEditCard()
    {
        super(new MyTenantBuilder());
    }

    public MyTenantEditCard(MyTenantBuilder e)
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

        installGeneralFieldsOn(root);
        installBusinessHoursOn(root);
        installMemoFieldsOn(root);
    }

    private void installGeneralFieldsOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createNameField());
        fields.add(createHostnameField());
        fields.add(createThemeField());
    }

    private void installBusinessHoursOn(ScDiv root)
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldset set;
        set = root.addFieldset("Business Hours");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(x.TimeZoneCode.newTimeZoneDropdown());
        fields.addSpace();
        fields.addField(x.BusinessDays, "Days");
        fields.addField(x.BusinessStartTime, "Start Time");
        fields.addField(x.BusinessEndTime, "End Time");
    }

    private void installMemoFieldsOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Memo");
        set.add(createMemoField());
    }

    //==================================================
    //= install :: fields
    //==================================================

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

    private ScTextArea createMemoField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScTextArea e;
        e = x.Memo.newMultilineField();
        e.layoutBlock();
        return e;
    }

    private ScControl createThemeField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Theme");
        e.setHelp(x.ThemeCode);
        e.setValueAdaptor(x.ThemeCode);
        e.setOptions(MyTheme.values());
        e.setValue(MyTheme.Default);
        e.setRequired();
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

        MyTenant tenant = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getTenantDao().isDuplicateName(tenant, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateHostname()
    {
        ScTextField field = _hostnameField;
        if ( field.hasErrors() )
            return;

        MyTenant tenant = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getTenantDao().isDuplicateHostname(tenant, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyTenant e)
    {
        e.applyFrom(this);

        MyServletFilter.clearCachedThemeUris();
    }

}
