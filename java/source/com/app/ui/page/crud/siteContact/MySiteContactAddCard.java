package com.app.ui.page.crud.siteContact;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.model.meta.MyMetaSiteContact;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.page.crud.abstractBase.MyCrudSaveEvent;

public class MySiteContactAddCard
    extends MyCrudAddCard<MySite,MySiteContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;

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

    public MySiteContactAddCard()
    {
        super(new MySiteContactBuilder());
    }

    public MySiteContactAddCard(MySiteContactBuilder e)
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
        e.add(createRoleSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createFirstNameField());
        e.add(createLastNameField());
        e.add(createNicknameField());
        e.addSpace();
        e.addField(x.Title);
        e.addField(x.Phone);
        e.addSpace();
        e.addField(x.Email);
        return e;
    }

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

    //==================================================
    //= install :: role
    //==================================================

    private ScControl createRoleSection()
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

        ScTable table;
        table = new ScTable();
        table.setLabel("Is Primary For");
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

        return table;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MySite job)
    {
        super.preRenderDetails(job);

        _mainContactText.setValue(job.getMainContactFullName());
        _installContactText.setValue(job.getEffectiveInstallContactFullName());
        _technicalContactText.setValue(job.getEffectiveTechnicalContactFullName());
        _schedulingContactText.setValue(job.getEffectiveSchedulingContactFullName());
        _salesContactText.setValue(job.getEffectiveSalesContactFullName());
        _requesterContactText.setValue(job.getEffectiveRequesterContactFullName());
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
    protected MySiteContact saveNewChildOn(MySite parent)
    {
        MySiteContact e;
        e = parent.addContact();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

    /**
     * Adding a new contact can change the roles of existing contacts.
     * This notifies the list view to update the existing contacts in
     * the list so they display the correct role information.
     */
    @Override
    protected void preFireSaved(MyCrudSaveEvent<MySiteContact> ev)
    {
        ev.setUpdateList(true);
    }

    //##################################################
    //# post save
    //##################################################

    @Override
    protected void postSave(MySiteContact e)
    {
        clearMainContact(e);
        clearInstallContact(e);
        clearTechnicalContact(e);
        clearSchedulingContact(e);
        clearSalesContact(e);
        clearJobContact(e);
    }

    private void clearMainContact(MySiteContact e)
    {
        MySite site = e.getSite();

        if ( _mainContactCheckbox.getValue() )
            site.setMainContact(e);
        else
            if ( site.hasMainContact(e) )
                site.clearMainContact();
    }

    private void clearInstallContact(MySiteContact e)
    {
        MySite site = e.getSite();

        if ( _installContactCheckbox.getValue() )
            site.setInstallContact(e);
        else
            if ( site.hasInstallContact(e) )
                site.clearInstallContact();
    }

    private void clearTechnicalContact(MySiteContact e)
    {
        MySite site = e.getSite();

        if ( _technicalContactCheckbox.getValue() )
            site.setTechnicalContact(e);
        else
            if ( site.hasTechnicalContact(e) )
                site.clearTechnicalContact();
    }

    private void clearSchedulingContact(MySiteContact e)
    {
        MySite site = e.getSite();

        if ( _schedulingContactCheckbox.getValue() )
            site.setSchedulingContact(e);
        else
            if ( site.hasSchedulingContact(e) )
                site.clearSchedulingContact();
    }

    private void clearSalesContact(MySiteContact e)
    {
        MySite site = e.getSite();

        if ( _salesContactCheckbox.getValue() )
            site.setSalesContact(e);
        else
            if ( site.hasSalesContact(e) )
                site.clearSalesContact();
    }

    private void clearJobContact(MySiteContact e)
    {
        MySite site = e.getSite();

        if ( _requesterContactCheckbox.getValue() )
            site.setRequesterContact(e);
        else
            if ( site.hasRequesterContact(e) )
                site.clearRequesterContact();
    }
}
