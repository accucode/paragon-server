package com.app.ui.page.manage.tenant;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyTenantCriteria;
import com.app.model.MyTenant;
import com.app.model.meta.MyMetaTenant;
import com.app.model.support.MyTheme;
import com.app.ui.page.manage.crud.MyCrudEditCard;
import com.app.ui.page.manage.crud.MyCrudLayout;
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
        installIntacctFieldsOn(root);
    }

    private void installGeneralFieldsOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.css().widthFull();
        fields.add(createNameField());
        fields.add(createHostnameField());
        fields.add(createThemeField());
    }

    private void installIntacctFieldsOn(ScDiv root)
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldset set;
        set = root.addFieldset("Intacct");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.css().widthFull();
        fields.addField(x.IntacctCompanyId, "Company");
        fields.addField(x.IntacctUserId, "User");
        fields.addField(x.IntacctUserPassword, "Password");
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

    private ScControl createThemeField()
    {
        MyMetaTenant x = MyTenant.Meta;

        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
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

        String tenant = getDomainChild().getUid();
        String name = _nameField.getValue();

        MyTenantCriteria c;
        c = getAccess().getTenantDao().createCriteria();
        c.whereName().is(name);
        c.whereUid().isNot(tenant);

        if ( c.exists() )
            _nameField.addError("Duplicate");
    }

    private void validateHostnameQuietly()
    {
        if ( _hostnameField.hasErrors() )
            return;

        String tenant = getDomainChild().getUid();
        String name = _hostnameField.getValue();

        MyTenantCriteria c;
        c = getAccess().getTenantDao().createCriteria();
        c.whereHostname().is(name);
        c.whereUid().isNot(tenant);

        if ( c.exists() )
            _hostnameField.addError("Duplicate");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void updateDomainChild(MyTenant e)
    {
        e.applyFrom(this);

        MyServletFilter.clearCachedThemeUris();
    }

}
