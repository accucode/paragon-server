package com.app.ui.page.crud.siteContact;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.model.meta.MyMetaSiteContact;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MySiteContactEditCard
    extends MyCrudEditCard<MySiteContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;

    private ScCheckboxField _enabledField;

    //==================================================
    //= variables :: roles
    //==================================================

    private ScFieldset _roleFieldset;

    private ScCheckboxField _mainContactCheckbox;
    private ScText          _mainContactText;

    private ScCheckboxField _installContactCheckbox;
    private ScText          _installContactText;

    private ScCheckboxField _technicalContactCheckbox;
    private ScText          _technicalContactText;

    private ScCheckboxField _schedulingContactCheckbox;
    private ScText          _schedulingContactText;

    private ScCheckboxField _salesContactCheckbox;
    private ScText          _salesContactText;

    private ScCheckboxField _requesterContactCheckbox;
    private ScText          _requesterContactText;

    //##################################################
    //# constructor
    //##################################################

    public MySiteContactEditCard()
    {
        super(new MySiteContactBuilder());
    }

    public MySiteContactEditCard(MySiteContactBuilder e)
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
        root.css().flexColumn().columnSpacer20();

        installGeneralFieldsOn(root);
        installRoleFieldsOn(root);
    }

    private void installGeneralFieldsOn(ScDiv root)
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createFirstNameField());
        fields.add(createLastNameField());
        fields.add(createNicknameField());
        fields.addSpace();
        fields.addField(x.Title);
        fields.addField(x.Phone);
        fields.addField(x.Email);
        fields.addSpace();
        fields.add(createEnabledField());
    }

    private void installRoleFieldsOn(ScDiv root)
    {
        _mainContactCheckbox = new ScCheckboxField();
        _mainContactText = new ScText();

        _installContactCheckbox = new ScCheckboxField();
        _installContactText = new ScText();

        _technicalContactCheckbox = new ScCheckboxField();
        _technicalContactText = new ScText();

        _schedulingContactCheckbox = new ScCheckboxField();
        _schedulingContactText = new ScText();

        _salesContactCheckbox = new ScCheckboxField();
        _salesContactText = new ScText();

        _requesterContactCheckbox = new ScCheckboxField();
        _requesterContactText = new ScText();

        ScFieldset set;
        set = root.addFieldset("Is Primary For");
        set.hide();
        _roleFieldset = set;

        ScTable table;
        table = set.addTable();
        table.defaultCellCss().pad5x2();

        ScTableRow row;
        row = table.addRow();
        row.addCell().addText("Role");
        row.addCell().addText("Be Primary");
        row.addCell().addText("Current Primary");

        row = table.addRow();
        row.addCell().addLabel("Main");
        row.addCell().add(_mainContactCheckbox);
        row.addCell().add(_mainContactText);

        table.addRow().addCell().addNonBreakingSpace();

        row = table.addRow();
        row.addCell().addLabel("Install");
        row.addCell().add(_installContactCheckbox);
        row.addCell().add(_installContactText);

        row = table.addRow();
        row.addCell().addLabel("Technical");
        row.addCell().add(_technicalContactCheckbox);
        row.addCell().add(_technicalContactText);

        row = table.addRow();
        row.addCell().addLabel("Scheduling");
        row.addCell().add(_schedulingContactCheckbox);
        row.addCell().add(_schedulingContactText);

        row = table.addRow();
        row.addCell().addLabel("Sales");
        row.addCell().add(_salesContactCheckbox);
        row.addCell().add(_salesContactText);

        row = table.addRow();
        row.addCell().addLabel("Requester");
        row.addCell().add(_requesterContactCheckbox);
        row.addCell().add(_requesterContactText);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createFirstNameField()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScTextField e;
        e = x.FirstName.newField();
        _firstNameField = e;
        return e;
    }

    private ScControl createLastNameField()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScTextField e;
        e = x.LastName.newField();
        _lastNameField = e;
        return e;
    }

    private ScControl createNicknameField()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScTextField e;
        e = x.Nickname.newField();
        _nicknameField = e;
        return e;
    }

    private ScCheckboxField createEnabledField()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScCheckboxField e;
        e = x.Enabled.newField();
        e.onChange(newUncheckedAction(this::handleEnabledChanged));
        _enabledField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MySiteContact contact)
    {
        super.preRenderDetails(contact);

        MySite site = contact.getSite();

        if ( contact.isEnabled() )
            _roleFieldset.show();

        _mainContactCheckbox.setValue(contact.isMainContact());
        _mainContactText.setValue(site.getMainContactFullName());

        _installContactCheckbox.setValue(contact.isInstallContact());
        _installContactText.setValue(site.getEffectiveInstallContactFullName());

        _technicalContactCheckbox.setValue(contact.isTechnicalContact());
        _technicalContactText.setValue(site.getEffectiveTechnicalContactFullName());

        _schedulingContactCheckbox.setValue(contact.isSchedulingContact());
        _schedulingContactText.setValue(site.getEffectiveSchedulingContactFullName());

        _salesContactCheckbox.setValue(contact.isSalesContact());
        _salesContactText.setValue(site.getEffectiveSalesContactFullName());

        _requesterContactCheckbox.setValue(contact.isRequesterContact());
        _requesterContactText.setValue(site.getEffectiveRequesterContactFullName());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEnabledChanged()
    {
        boolean enabled = _enabledField.getValue();
        _roleFieldset.ajaxShow(enabled);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateName();
    }

    private void validateName()
    {
        if ( _firstNameField.hasErrors() )
            return;

        if ( _lastNameField.hasErrors() )
            return;

        if ( _nicknameField.hasErrors() )
            return;

        String first = _firstNameField.getValue();
        String last = _lastNameField.getValue();
        String nick = _nicknameField.getValue();

        boolean none = Kmu.allNulls(first, last, nick);
        if ( none )
            _firstNameField.addError("You must specify a name (first, last, or nickname).");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MySiteContact e)
    {
        e.applyFrom(this);
    }

    //##################################################
    //# post save
    //##################################################

    @Override
    protected void postSave(MySiteContact e)
    {
        MySite site = e.getSite();

        boolean main = _mainContactCheckbox.getValue();
        boolean install = _installContactCheckbox.getValue();
        boolean technical = _technicalContactCheckbox.getValue();
        boolean scheduling = _schedulingContactCheckbox.getValue();
        boolean sales = _salesContactCheckbox.getValue();
        boolean requester = _requesterContactCheckbox.getValue();

        boolean active = _enabledField.getValue();
        if ( !active )
        {
            main = false;
            install = false;
            technical = false;
            scheduling = false;
            sales = false;
            requester = false;
        }

        if ( main )
            site.setMainContact(e);
        else
            if ( site.hasMainContact(e) )
                site.clearMainContact();

        if ( install )
            site.setInstallContact(e);
        else
            if ( site.hasInstallContact(e) )
                site.clearInstallContact();

        if ( technical )
            site.setTechnicalContact(e);
        else
            if ( site.hasTechnicalContact(e) )
                site.clearTechnicalContact();

        if ( scheduling )
            site.setSchedulingContact(e);
        else
            if ( site.hasSchedulingContact(e) )
                site.clearSchedulingContact();

        if ( sales )
            site.setSalesContact(e);
        else
            if ( site.hasSalesContact(e) )
                site.clearSalesContact();

        if ( requester )
            site.setRequesterContact(e);
        else
            if ( site.hasRequesterContact(e) )
                site.clearRequesterContact();

        getCrudBuilder().getSearchView().ajaxRefreshListItems();
    }
}
