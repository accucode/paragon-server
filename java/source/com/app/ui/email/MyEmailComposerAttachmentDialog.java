package com.app.ui.email;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyAttachmentFilter;
import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.model.MyEmailTemplateContextIF;
import com.app.ui.control.MyFormDialog;

/**
 * I am used to edit the default recipients for an email template.
 */
public class MyEmailComposerAttachmentDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private MyEmailComposerForm _emailComposerForm;

    private ScDomainDropdownField<MyAttachment,String> _attachment1Field;
    private ScDomainDropdownField<MyAttachment,String> _attachment2Field;
    private ScDomainDropdownField<MyAttachment,String> _attachment3Field;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailComposerAttachmentDialog(MyEmailComposerForm form)
    {
        _emailComposerForm = form;
        install();
    }

    //##################################################
    //# accessing
    //##################################################

    public MyEmailComposerForm getEmailComposerForm()
    {
        return _emailComposerForm;
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("Choose Attachments");
        setWidth(400);

        installForm();
        installBody();
        installFooter();
    }

    private void installForm()
    {
        ScForm form;
        form = getDialogRoot();
        form.onSubmit(newUncheckedAction(this::handleApply));
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().flexColumn().columnSpacer20().pad20();

        _attachment1Field = body.add(createAttachmentField("1"));
        _attachment2Field = body.add(createAttachmentField("2"));
        _attachment3Field = body.add(createAttachmentField("3"));
    }

    private ScDomainDropdownField<MyAttachment,String> createAttachmentField(String label)
    {
        ScDomainDropdownField<MyAttachment,String> e;
        e = MyAttachment.Tools.newDomainDropdown();
        e.setOptionSupplier(this::findAttachments);
        e.setLabel(label);
        e.setNullNonePrefix();
        return e;
    }

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton("Apply");
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //==================================================
    //= install :: filter
    //==================================================

    private KmList<MyAttachment> findAttachments()
    {
        MyAttachmentOwnerIF owner = getAttachmentOwner();

        MyAttachmentFilter f;
        f = new MyAttachmentFilter();
        f.setOwner(owner);
        f.setEnabled();
        f.sortOnName();
        f.sortAscending();
        return f.findAll();
    }

    private MyAttachmentOwnerIF getAttachmentOwner()
    {
        MyEmailComposerForm form = getEmailComposerForm();
        MyEmailTemplateContextIF e = form.getContext();

        return e instanceof MyAttachmentOwnerIF
            ? (MyAttachmentOwnerIF)e
            : null;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleApply()
    {
        MyAttachment attachment1 = _attachment1Field.getValue();
        MyAttachment attachment2 = _attachment2Field.getValue();
        MyAttachment attachment3 = _attachment3Field.getValue();

        MyEmailComposerForm form;
        form = getEmailComposerForm();
        form.ajaxSetAttachment1(attachment1);
        form.ajaxSetAttachment2(attachment2);
        form.ajaxSetAttachment3(attachment3);
        form.ajaxUpdateAttachmentText();

        ajaxClose();
    }

    //##################################################
    //# prerender
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyEmailComposerForm form;
        form = getEmailComposerForm();

        _attachment1Field.setValue(form.getAttachment1());
        _attachment2Field.setValue(form.getAttachment2());
        _attachment3Field.setValue(form.getAttachment3());
    }
}
