package com.app.ui.page.crud.panels;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.field.ScTimeZoneCodeField;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaSite;
import com.app.ui.control.MyAddressField;
import com.app.ui.selector.MyChoiceSelector;
import com.app.utility.MyGlobals;

public class MySiteEditPanel
    extends ScLayout
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _siteUid;

    private ScTextField      _numberField;
    private MyChoiceSelector _typeField;

    //##################################################
    //# constructor
    //##################################################

    public MySiteEditPanel()
    {
        installSiteUid();

        setTypeFieldset();
        // external css set by parent
        add(createGeneralSection());
        add(createPrioritySection());
        add(createAddressSection());
    }

    private void installSiteUid()
    {
        _siteUid = new ScLocalString();
        _siteUid.setAutoSave();
    }

    //##################################################
    //# install
    //##################################################

    private ScControl createGeneralSection()
    {
        MyMetaSite x = MySite.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.CustomerName);
        e.addField(x.Enabled);
        e.addSpace();
        e.add(createNumberField());
        e.add(createNameField());
        e.add(createTypeField());
        e.addSpace();
        e.add(createTimeZoneField());
        return e;
    }

    private ScControl createPrioritySection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Priority");
        e.add(createPriorityField());
        return e;
    }

    private ScControl createAddressSection()
    {
        MyAddressField e;
        e = new MyAddressField();
        e.setLabel("Address");
        e.setValueAdaptor(MySite.getAddressAdaptor());
        return e;
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createNumberField()
    {
        MyMetaSite x = MySite.Meta;

        ScTextField e;
        e = x.Number.newField();
        _numberField = e;
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaSite x = MySite.Meta;

        ScTextField e;
        e = x.Name.newField();
        return e;
    }

    private ScControl createTypeField()
    {
        MyMetaSite x = MySite.Meta;

        MyChoiceSelector e;
        e = new MyChoiceSelector();
        e.setMeta(x.Type);
        e.setChoiceType(MyChoiceType.SiteType);
        _typeField = e;
        return e;
    }

    private ScControl createTimeZoneField()
    {
        MyMetaSite x = MySite.Meta;

        ScTimeZoneCodeField e;
        e = x.TimeZoneCode.newTimeZoneDropdown();
        e.setLabel("Time Zone");
        return e;
    }

    private ScControl createPriorityField()
    {
        MyMetaSite x = MySite.Meta;

        ScDomainDropdownField<MyPriority,String> e;
        e = MyPriority.Tools.newDomainDropdown();
        e.setOptionSupplier(this::findPriorities);
        e.setLabel(x.Priority);
        e.setHelp(x.Priority);
        e.setValueAdaptor(x.Priority);
        e.setNullSelectPrefix();
        e.setRequired();
        return e;
    }

    private KmList<MyPriority> findPriorities()
    {
        return getSite().getProject().getPriorityListBySequence();
    }

    //##################################################
    //# site
    //##################################################

    private MySite getSite()
    {
        String uid = _siteUid.getValue();
        return getAccess().findSiteUid(uid);
    }

    private void setSite(MySite e)
    {
        _siteUid.setValue(e.getUid());
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        if ( model instanceof MySite )
        {
            setSite((MySite)model);
            return super.applyFromModel_here(model);
        }

        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyProject project = getSite().getProject();
        _typeField.setProject(project);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateNumber();
    }

    private void validateNumber()
    {
        ScTextField f = _numberField;
        if ( f.hasErrors() )
            return;

        MySite site = getSite();
        String number = f.getValue();

        boolean dup = getAccess().getSiteDao().isDuplicateNumber(site, number);
        if ( dup )
            f.addError("Duplicate");
    }

    //##################################################
    //# save
    //##################################################

    public void saveDomainChild(MySite e)
    {
        e.applyFrom(this);
        e.validateAndCheck();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
