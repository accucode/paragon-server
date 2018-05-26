package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.command.KmDao;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.model.meta.MyMetaSiteContact;

/**
 * I am used to edit the default recipients for an email template.
 */
public class MyAddSiteContactDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString           _siteUid;
    private Consumer<MySiteContact> _onSaveListener;

    //##################################################
    //# constructor
    //##################################################

    public MyAddSiteContactDialog()
    {
        install();
    }

    //##################################################
    //# accessing
    //##################################################

    public MySite findSite()
    {
        return getAccess().findSiteUid(getSiteUid());
    }

    private String getSiteUid()
    {
        return _siteUid.getValue();
    }

    //##################################################
    //# on save
    //##################################################

    public void onSaved(Consumer<MySiteContact> e)
    {
        _onSaveListener = e;
    }

    public void fireOnSaved(MySiteContact e)
    {
        fire(_onSaveListener, e);
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        _siteUid = new ScLocalString();
        _siteUid.setAutoSave();

        setLabel("Add Contact");
        setWidth(400);

        installForm();
        installBody();
        installFooter();
    }

    private void installForm()
    {
        ScForm form;
        form = getDialogRoot();
        form.onSubmit(newUncheckedAction(this::handleSave));
    }

    private void installBody()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScDiv body;
        body = getBody();
        body.css().flexColumn().columnSpacer20().pad20();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.addField(x.FirstName);
        fields.addField(x.LastName);
        fields.addField(x.Nickname);
        fields.addSpace();
        fields.addField(x.Title);
        fields.addField(x.Phone);
        fields.addSpace();
        fields.addField(x.Email);
    }

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton("Save");
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxOpen(MySite e)
    {
        _siteUid.setValue(e.getUid());

        ajaxOpen();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        KmDao.run(this::saveDao);
    }

    private void saveDao()
    {
        MySite site = findSite();

        MySiteContact e;
        e = site.addContact();
        e.applyFrom(this);
        e.daoAttach();

        fireOnSaved(e);
        ajaxClose();
    }
}
