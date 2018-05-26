package com.app.ui.email;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScErrorWrapper;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScRichTextEditor;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScToastScript;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.macro.MyMacroDocumentFormatter;
import com.app.model.MyAttachment;
import com.app.model.MyContactIF;
import com.app.model.MyCustomer;
import com.app.model.MyDefaultRecipient;
import com.app.model.MyEmail;
import com.app.model.MyEmailTemplate;
import com.app.model.MyEmailTemplateContextIF;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyDefaultRecipientContactType;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.dialog.MyNotifyDialog;
import com.app.utility.MyGlobals;

public class MyEmailComposerForm
    extends ScForm
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _contextTypeCode;
    private ScLocalString _contextUid;

    private ScHiddenField<String> _toField;
    private ScFieldText           _toText;

    private ScHiddenField<String> _ccField;
    private ScFieldText           _ccText;

    private ScHiddenField<String> _mandatoryCcField;
    private ScFieldText           _mandatoryCcText;

    private ScFieldText           _attachmentText;
    private ScHiddenField<String> _attachment1Field;
    private ScHiddenField<String> _attachment2Field;
    private ScHiddenField<String> _attachment3Field;

    private ScStaticDropdownField<String> _templateDropdown;
    private ScTextField                   _subjectField;
    private ScRichTextEditor              _bodyField;

    private MyEmailComposerToRecipientDialog _toRecipientDialog;
    private MyEmailComposerCcRecipientDialog _ccRecipientDialog;
    private MyEmailComposerAttachmentDialog  _attachmentDialog;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailComposerForm()
    {
        _contextTypeCode = new ScLocalString();
        _contextTypeCode.setAutoSave();

        _contextUid = new ScLocalString();
        _contextUid.setAutoSave();

        installGroup();
        installRecipientDialogs();
    }

    //##################################################
    //# install
    //##################################################

    private void installGroup()
    {
        MyEmailComposerForm form;
        form = this;
        form.css().relative();
        form.setLabel("Email");

        ScGroup group;
        group = form.addGroup();
        group.css().fill();
        group.setTitle("Email");
        group.setFlavorDetail();

        installLayoutOn(group);
        installButtonsOn(group);
    }

    private void installLayoutOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().flexColumn().columnSpacer10().pad10().clip();

        installMessageOn(body);
        installAttachmentsOn(body);
    }

    //==================================================
    //= install :: attachments
    //==================================================

    private void installAttachmentsOn(ScDiv root)
    {
        _attachment1Field = root.addHiddenField();
        _attachment2Field = root.addHiddenField();
        _attachment3Field = root.addHiddenField();

        ScFieldset set;
        set = root.addFieldset("Attachments");

        ScDiv row;
        row = set.addDiv();
        row.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        row.add(createAttachmentText());
        row.addEditButton(newUncheckedAction(this::handleEditAttachments));
    }

    private ScFieldText createAttachmentText()
    {
        ScFieldText e;
        e = new ScFieldText();
        e.setValue(KmConstantsIF.NONE);
        _attachmentText = e;
        return e;
    }

    //==================================================
    //= install :: message
    //==================================================

    private void installMessageOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Message");
        set.css().flexChildFiller0().relative().clip();

        ScDiv col;
        col = set.addDiv();
        col.css().flexColumn().fieldsetFillOffset10();

        ScFieldTable fields;
        fields = col.addFullWidthFieldTable();
        fields.add(createTemplateDropdown());

        col.addFlexGap(5);

        installRecipientsOn(col);

        col.addFlexGap(5);

        fields = col.addFullWidthFieldTable();
        fields.add(createSubjectField());

        col.addRequiredLabel("Body");

        ScErrorWrapper errorWrapper;
        errorWrapper = col.addErrorWrapper();
        errorWrapper.css().flexChildFiller().flexColumn();

        ScDiv bodyWrapper;
        bodyWrapper = errorWrapper.setChildDiv();
        bodyWrapper.css().flexChildFiller().relative();
        bodyWrapper.add(createBodyField());
    }

    private void installButtonsOn(ScGroup group)
    {
        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Send", newUncheckedAction(this::handleSend));
        buttons.addButton("Reset", newUncheckedAction(this::handleReset)).applyNegativeFlavor();
    }

    //==================================================
    //= install :: recipients
    //==================================================

    private void installRecipientsOn(ScDiv col)
    {
        ScFieldTable fields;
        fields = col.addFullWidthFieldTable();

        fields.add(createToRow());
        fields.add(createCcRow());
        fields.add(createMandatoryCcRow());
    }

    private ScDiv createToRow()
    {
        ScHiddenField<String> field;
        field = new ScHiddenField<>();
        _toField = field;

        ScFieldText text;
        text = new ScFieldText();
        text.css().flexChildFiller();
        _toText = text;

        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().flexCrossAlignCenter();
        row.setLabel("To");
        row.add(_toField);
        row.add(_toText);
        row.addFlexGap(5);
        row.addEditButton(newUncheckedAction(this::handleChooseToRecipients));
        return row;
    }

    private ScDiv createCcRow()
    {
        ScHiddenField<String> field;
        field = new ScHiddenField<>();
        _ccField = field;

        ScFieldText text;
        text = new ScFieldText();
        text.css().flexChildFiller();
        _ccText = text;

        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().flexCrossAlignCenter();
        row.setLabel("CC");
        row.add(_ccField);
        row.add(_ccText);
        row.addFlexGap(5);
        row.addEditButton(newUncheckedAction(this::handleChooseCcRecipients));
        return row;
    }

    private ScDiv createMandatoryCcRow()
    {
        ScHiddenField<String> field;
        field = new ScHiddenField<>();
        field.disableChangeTracking();
        _mandatoryCcField = field;

        ScFieldText text;
        text = new ScFieldText();
        text.css().flexChildFiller();
        _mandatoryCcText = text;

        ScDiv row;
        row = new ScDiv();
        row.css().flexRow();
        row.setLabel("CC (Mandatory)");
        row.add(_mandatoryCcField);
        row.add(_mandatoryCcText);
        return row;
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScDropdownField<String> createTemplateDropdown()
    {
        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel("Template");
        e.setNullNonePrefix();
        e.onChange(newCheckedAction(this::handleTemplateChanged));
        e.disableChangeTracking();
        _templateDropdown = e;
        return e;
    }

    private ScTextField createSubjectField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Subject");
        e.setRequired();
        e.layoutBlock();
        _subjectField = e;
        return e;
    }

    private ScRichTextEditor createBodyField()
    {
        ScRichTextEditor e;
        e = new ScRichTextEditor();
        e.setRequired();
        e.setFill();
        _bodyField = e;
        return e;
    }

    //##################################################
    //# install :: dialog
    //##################################################

    private void installRecipientDialogs()
    {
        _toRecipientDialog = new MyEmailComposerToRecipientDialog(this);
        _ccRecipientDialog = new MyEmailComposerCcRecipientDialog(this);
        _attachmentDialog = new MyEmailComposerAttachmentDialog(this);
    }

    //##################################################
    //# context
    //##################################################

    public MyEmailTemplateContextIF getContext()
    {
        MyEmailTemplateContextType type = getContextType();
        return type == null
            ? null
            : type.findContextUid(getContextUid());
    }

    public void setContext(MyEmailTemplateContextIF e)
    {
        setContextType(e.getEmailTemplateContextType());
        setContextUid(e.getUid());
    }

    //==================================================
    //= context :: type
    //==================================================

    private void setContextType(MyEmailTemplateContextType e)
    {
        String code = KmEnumIF.getCodeFor(e);
        _contextTypeCode.setValue(code);
    }

    public MyEmailTemplateContextType getContextType()
    {
        String code = _contextTypeCode.getValue();
        return MyEmailTemplateContextType.findCode(code);
    }

    //==================================================
    //= context :: uid
    //==================================================

    private String getContextUid()
    {
        return _contextUid.getValue();
    }

    private void setContextUid(String e)
    {
        _contextUid.setValue(e);
    }

    //==================================================
    //= context :: find
    //==================================================

    public MyProject findProject()
    {
        MyEmailTemplateContextIF ctx = getContext();
        return ctx == null
            ? null
            : ctx.getProject();
    }

    public MySite findSite()
    {
        MyEmailTemplateContextType type = getContextType();
        String uid = getContextUid();

        if ( type == null || uid == null )
            return null;

        switch ( type )
        {
            case Project:
                return null;

            case Site:
                return getAccess().findSiteUid(uid);
        }

        throw Kmu.newEnumError(type);
    }

    private MyCustomer findCustomer()
    {
        MyEmailTemplateContextType type = getContextType();
        String uid = getContextUid();

        if ( type == null || uid == null )
            return null;

        switch ( type )
        {
            case Site:
                return findSite().getCustomer();

            case Project:
                return null;
        }

        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderRecipients();
        preRenderTemplates();
    }

    private void preRenderRecipients()
    {
        String mandatoryCcs = getMandatoryCcs().join();
        _mandatoryCcField.setValue(mandatoryCcs);
        updateMandatoryCcTextFor(mandatoryCcs);
    }

    private void preRenderTemplates()
    {
        MyEmailTemplateContextType type = getContextType();
        if ( type == null )
            return;

        MyProject project = findProject();

        KmList<MyEmailTemplate> v;
        v = project.getEnabledEmailTemplatesByNameFor(type);

        for ( MyEmailTemplate e : v )
            _templateDropdown.addOption(e.getUid(), e.getName());
    }

    //##################################################
    //# tempalte (public)
    //##################################################

    public void setTemplate(MyEmailTemplateContextType type, MyEmailTemplate template)
    {
        if ( template == null )
            return;

        _templateDropdown.setValue(template.getUid());
        setMessageFrom(type, template);

        setRecipientsFrom(template);
    }

    private void setMessageFrom(MyEmailTemplateContextType type, MyEmailTemplate template)
    {
        KmTuple<String,String> email;
        email = getMessageFor(type, template);
        String subject = email.getKey();
        String body = email.getValue();

        _subjectField.setValue(subject);
        _bodyField.setValue(body);
    }

    private void setRecipientsFrom(MyEmailTemplate e)
    {
        updateToRecipientsFor(e);
        updateCcRecipientsFor(e);
        updateRecipientText();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        validateTos();
    }

    private void validateTos()
    {
        if ( _toField.hasErrors() )
            return;

        if ( getToEmails().isEmpty() )
            _toField.addError("You must specify at least one valid 'to'.");
    }

    //##################################################
    //# handle
    //##################################################

    private void handleChooseToRecipients()
    {
        _toRecipientDialog.ajaxOpen();
    }

    private void handleChooseCcRecipients()
    {
        _ccRecipientDialog.ajaxOpen();
    }

    private void handleEditAttachments()
    {
        _attachmentDialog.ajaxOpen();
    }

    private void handleTemplateChanged()
    {
        String uid = _templateDropdown.getValue();
        if ( uid == null )
        {
            ajaxClearAll();
            return;
        }

        MyEmailTemplate template = getAccess().findEmailTemplateUid(uid);
        if ( template == null )
        {
            ajaxToastWarn("Invalid template.");
            return;
        }

        MyEmailTemplateContextType type = getContextType();
        if ( type == null )
        {
            ajaxToastWarn("Invalid context.");
            return;
        }

        ajaxUpdateMesasgeFor(template, type);
        ajaxUpdateRecipientsFor(template);
    }

    private void handleSend()
    {
        ajaxHideAllErrors();
        validateAndCheck();

        KmList<String> tos;
        tos = getToEmails();

        KmList<String> ccs;
        ccs = getCcEmails();
        ccs.addAllDistinct(getMandatoryCcs());

        String subject = _subjectField.getValue();
        String body = _bodyField.getValue();

        MyEmail e;
        e = new MyEmail();
        e.addToRecipients(tos);
        e.addCcRecipients(ccs);
        e.setFromAddress(getFromEmail());
        e.setSubject(subject);
        e.addHtmlPart(body, true);
        e.setStatusReady();
        applyAttachmentsTo(e);
        e.daoAttach();

        MyNotifyDialog d;
        d = MyDialogs.getNotifyDialog();
        d.setTitle("Email Sent");
        d.setSubtitle("The email has been sent.");
        d.ajaxOpen();

        ajaxClearAll();
    }

    private void applyAttachmentsTo(MyEmail e)
    {
        applyAttachmentTo(_attachment1Field.getValue(), e);
        applyAttachmentTo(_attachment2Field.getValue(), e);
        applyAttachmentTo(_attachment3Field.getValue(), e);
    }

    private void applyAttachmentTo(String attachmentUid, MyEmail e)
    {
        MyAttachment attachment;
        attachment = getAccess().findAttachmentUid(attachmentUid);

        if ( attachment == null )
            return;

        String name = attachment.getName();
        byte[] bytes = attachment.getContentBytes();

        e.addAttachmentPart(bytes, name);
    }

    private void handleReset()
    {
        ajaxClearAll();
    }

    private void ajaxClearAll()
    {
        _templateDropdown.clearValue();
        _templateDropdown.ajaxClearFieldValue();

        _subjectField.clearValue();
        _subjectField.ajaxClearFieldValue();

        _bodyField.clearValue();
        _bodyField.ajaxClearFieldValue();

        _toField.clearValue();
        _toField.ajaxClearFieldValue();

        _ccField.clearValue();
        _ccField.ajaxClearFieldValue();

        updateRecipientText();
        _toText.ajaxReplace();
        _ccText.ajaxReplace();
        _mandatoryCcText.ajaxReplace();
    }

    //##################################################
    //# update message
    //##################################################

    private KmTuple<String,String> getMessageFor(
        MyEmailTemplateContextType type,
        MyEmailTemplate template)
    {
        switch ( type )
        {
            case Project:
                return getMessageFor(findProject(), template);

            case Site:
                return getMessageFor(findSite(), template);
        }
        throw Kmu.newEnumError(type);
    }

    private KmTuple<String,String> getMessageFor(MyProject project, MyEmailTemplate template)
    {
        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setContext(project);

        String subject = f.formatText(template.getSubjectText());
        String body = f.formatHtml(template.getBodyHtml());

        return createTupleFor(subject, body);
    }

    private KmTuple<String,String> getMessageFor(MySite site, MyEmailTemplate template)
    {
        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setContext(site);

        String subject = f.formatText(template.getSubjectText());
        String body = f.formatHtml(template.getBodyHtml());

        return createTupleFor(subject, body);
    }

    private KmTuple<String,String> createTupleFor(String subject, String body)
    {
        KmTuple<String,String> email;
        email = new KmTuple<>();
        email.setKey(subject);
        email.setValue(body);
        return email;
    }

    private void ajaxUpdateMessage(String subject, String body)
    {
        _subjectField.ajaxSetFieldValue(subject);
        _bodyField.ajaxSetFieldValue(body);
    }

    //##################################################
    //# update recipients
    //##################################################

    private void updateToTextFor(String tos)
    {
        String s = truncateRecipientText(tos);

        _toText.setValue(s);
        _toText.setHelp(tos);
    }

    private void updateCcTextFor(String ccs)
    {
        String s = truncateRecipientText(ccs);

        _ccText.setValue(s);
        _ccText.setHelp(ccs);
    }

    private void updateMandatoryCcTextFor(String ccs)
    {
        String s = truncateRecipientText(ccs);

        _mandatoryCcText.setValue(s);
        _mandatoryCcText.setHelp(ccs);
    }

    //==================================================
    //= update recipients :: templates
    //==================================================

    private void ajaxUpdateRecipientsFor(MyEmailTemplate template)
    {
        updateToRecipientsFor(template);
        updateCcRecipientsFor(template);
        updateRecipientText();

        _toField.ajaxReplace();
        _toText.ajaxReplace();
        _ccField.ajaxReplace();
        _ccText.ajaxReplace();
        _mandatoryCcText.ajaxReplace();
    }

    private void updateToRecipientsFor(MyEmailTemplate template)
    {
        KmList<String> emails = new KmList<>();
        KmList<MyDefaultRecipient> tos = template.getDefaultToRecipients();

        for ( MyDefaultRecipient e : tos )
            if ( e.isContactTypeCustom() )
                emails.add(e.getCustomEmail());
            else
                emails.addAll(getEmailsFor(e.getContactType()));

        emails.removeDuplicates();
        setToRecipients(emails.join());
    }

    private void updateCcRecipientsFor(MyEmailTemplate template)
    {
        KmList<String> emails = new KmList<>();
        KmList<MyDefaultRecipient> ccs = template.getDefaultCcRecipients();

        for ( MyDefaultRecipient e : ccs )
            if ( e.isContactTypeCustom() )
                emails.add(e.getCustomEmail());
            else
                emails.addAll(getEmailsFor(e.getContactType()));

        emails.removeDuplicates();
        setCcRecipients(emails.join());
    }

    //==================================================
    //= update recipients :: ajax
    //==================================================

    private void updateRecipientText()
    {
        String tos = _toField.getValue();
        String ccs = _ccField.getValue();
        String mandatoryCcs = _mandatoryCcField.getValue();

        updateToTextFor(tos);
        updateCcTextFor(ccs);
        updateMandatoryCcTextFor(mandatoryCcs);
    }

    private String truncateRecipientText(String s)
    {
        return Kmu.truncate(s, 50, true);
    }

    private KmList<String> getMandatoryCcs()
    {
        return KmList.createEmpty();
    }

    //##################################################
    //# get contact for
    //##################################################

    private KmList<String> getEmailsFor(MyDefaultRecipientContactType contactType)
    {
        return getContactsFor(contactType).collect(x -> x.getEmail());
    }

    private KmList<MyContactIF> getContactsFor(MyDefaultRecipientContactType contactType)
    {
        KmList<MyContactIF> v = new KmList<>();

        MyEmailTemplateContextType contextType = getContextType();
        switch ( contextType )
        {
            case Project:
                v.addAll(getProjectContactsFor(contactType));
                break;

            case Site:
                v.addAll(getSiteContactsFor(contactType));
                break;
        }

        v.removeDuplicates();
        v.removeNulls();
        v.removeIf(e -> Kmu.isEmpty(e.getEmail()));
        v.sortOn(e -> e.getFullName());
        return v;
    }

    private KmList<MyContactIF> getProjectContactsFor(MyDefaultRecipientContactType contactType)
    {
        switch ( contactType )
        {
            case ProjectSupport:
                return KmList.createWith(findProject().getSupportContact());

            case Custom:
            case CustomerApproval:
            case CustomerBilling:
            case CustomerNotifications:
            case Install:
            case Main:
            case JobNotifications:
            case ProjectNotifications:
            case Requester:
            case Sales:
            case Scheduling:
            case Technical:
                return KmList.createEmpty();
        }

        throw Kmu.newError("Unknown Email Context Type: %s", contactType);
    }

    private KmList<MyContactIF> getSiteContactsFor(MyDefaultRecipientContactType contactType)
    {
        switch ( contactType )
        {
            case ProjectSupport:
                return KmList.createWith(findProject().getSupportContact());

            case CustomerApproval:
                return KmList.createWith(findCustomer().getApprovalContact());

            case CustomerBilling:
                return KmList.createWith(findCustomer().getBillingContact());

            case CustomerNotifications:
                return getCustomerContactsFor(findCustomer());

            case ProjectNotifications:
                return getProjectContactsFor(findProject());

            case Install:
            case Main:
            case JobNotifications:
            case Requester:
            case Sales:
            case Scheduling:
            case Technical:
            case Custom:
                return KmList.createEmpty();
        }
        throw Kmu.newEnumError(contactType);
    }

    private KmList<MyContactIF> getProjectContactsFor(MyProject project)
    {
        KmList<MyContactIF> v;
        v = new KmList<>();
        v.addAll(project.getContactsByFullName());
        return v;
    }

    private KmList<MyContactIF> getCustomerContactsFor(MyCustomer customer)
    {
        if ( customer == null )
            return KmList.createEmpty();

        KmList<MyContactIF> v;
        v = new KmList<>();
        v.addAll(customer.getContactsByFullName());
        return v;
    }

    //##################################################
    //# recipients
    //##################################################

    public void ajaxSetToRecipients(String s)
    {
        setToRecipients(s);

        _toField.ajaxReplace();
        _toText.ajaxReplace();
    }

    public void ajaxSetCcRecipients(String s)
    {
        setCcRecipients(s);

        _ccField.ajaxReplace();
        _ccText.ajaxReplace();
    }

    private void setToRecipients(String s)
    {
        _toField.setValue(s);
        updateToTextFor(s);
    }

    private void setCcRecipients(String s)
    {
        _ccField.setValue(s);
        updateCcTextFor(s);
    }

    public KmList<String> getToEmails()
    {
        return Kmu.parseEmails(_toField.getValue());
    }

    public KmList<String> getCcEmails()
    {
        return Kmu.parseEmails(_ccField.getValue());
    }

    //##################################################
    //# attachments :: public
    //##################################################

    public void ajaxSetAttachment1(MyAttachment e)
    {
        if ( e == null )
        {
            _attachment1Field.clearValue();
            _attachment1Field.ajaxClearFieldValue();
            return;
        }

        _attachment1Field.setValue(e.getUid());
        _attachment1Field.ajaxSetFieldValue(e.getUid());
    }

    public void ajaxSetAttachment2(MyAttachment e)
    {
        if ( e == null )
        {
            _attachment2Field.clearValue();
            _attachment2Field.ajaxClearFieldValue();
            return;
        }

        _attachment2Field.setValue(e.getUid());
        _attachment2Field.ajaxSetFieldValue(e.getUid());
    }

    public void ajaxSetAttachment3(MyAttachment e)
    {
        if ( e == null )
        {
            _attachment3Field.clearValue();
            _attachment3Field.ajaxClearFieldValue();
            return;
        }

        _attachment3Field.setValue(e.getUid());
        _attachment3Field.ajaxSetFieldValue(e.getUid());
    }

    public void ajaxUpdateAttachmentText()
    {
        MyAttachment a1 = getAccess().findAttachmentUid(_attachment1Field.getValue());
        MyAttachment a2 = getAccess().findAttachmentUid(_attachment2Field.getValue());
        MyAttachment a3 = getAccess().findAttachmentUid(_attachment3Field.getValue());

        KmList<MyAttachment> v;
        v = new KmList<>();
        v.addNonNull(a1);
        v.addNonNull(a2);
        v.addNonNull(a3);

        int count = v.size();

        String msg = "";
        String help = v.join(e -> e.getName());

        if ( count == 0 )
            msg = KmConstantsIF.NONE;

        if ( count == 1 )
            msg = "1 Attachment";

        if ( count > 1 )
            msg = Kmu.format("%s Attachments", count);

        _attachmentText.setValue(msg);

        if ( Kmu.isNotEmpty(help) )
            _attachmentText.setHelp(help);

        _attachmentText.ajaxReplace();
    }

    public MyAttachment getAttachment1()
    {
        return getAccess().findAttachmentUid(_attachment1Field.getValue());
    }

    public MyAttachment getAttachment2()
    {
        return getAccess().findAttachmentUid(_attachment2Field.getValue());
    }

    public MyAttachment getAttachment3()
    {
        return getAccess().findAttachmentUid(_attachment3Field.getValue());
    }

    //##################################################
    //# support
    //##################################################

    private MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    private MyDaoAccess getAccess()
    {
        return getGlobals().getAccess();
    }

    private ScToastScript ajaxToastWarn(String msg, Object... args)
    {
        return ajaxToast(msg, args).warn();
    }

    private String getFromEmail()
    {
        return findProject().getSendEmailFrom();
    }

    private void ajaxUpdateMesasgeFor(MyEmailTemplate template, MyEmailTemplateContextType type)
    {
        KmTuple<String,String> email;
        email = getMessageFor(type, template);
        String subject = email.getKey();
        String body = email.getValue();

        ajaxUpdateMessage(subject, body);
    }

}
