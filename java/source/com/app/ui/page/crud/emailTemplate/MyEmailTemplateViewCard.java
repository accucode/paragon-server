package com.app.ui.page.crud.emailTemplate;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.string.KmStringTokenizer;

import com.app.model.MyDefaultRecipient;
import com.app.model.MyEmail;
import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaEmailTemplate;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.utility.MyGlobals;

public class MyEmailTemplateViewCard
    extends MyCrudViewCard<MyEmailTemplate>
{
    //##################################################
    //# variables
    //##################################################

    private ScForm      _sendForm;
    private ScTextField _sendToField;

    private ScFieldText _toListText;
    private ScFieldText _ccListText;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateViewCard()
    {
        super(new MyEmailTemplateBuilder());
    }

    public MyEmailTemplateViewCard(MyEmailTemplateBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(createNotebook());
    }

    private ScControl createNotebook()
    {
        ScDomainNotebook<MyEmailTemplate> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyEmailTemplate.Finder);
        e.add(createDetailsTab());
        e.add(createPreviewTab());
        return e;
    }

    //==================================================
    //= install :: details tab
    //==================================================

    private ScControl createDetailsTab()
    {
        ScGroup group;
        group = new ScGroup();
        group.setNotebookTab("Details");

        ScDiv body;
        body = group.getBody();
        body.css().gap20().auto();

        installGeneralOn(body);
        installRecipientsOn(body);
        installTemplateOn(body);

        return group;
    }

    private void installGeneralOn(ScDiv root)
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScDiv activeRow;
        activeRow = new ScDiv();
        activeRow.setLabel("Enabled");
        activeRow.addFieldText(x.EnabledStatus);
        activeRow.addSpace();
        activeRow.addLink("toggle", newCheckedAction(this::handleToggleEnabled));

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.addFieldText(x.Name);
        fields.addFieldText(x.ContextTypeName, "Type");
        fields.add(activeRow);
    }

    private void installRecipientsOn(ScDiv root)
    {
        ScFieldText toListText;
        toListText = new ScFieldText();
        toListText.setLabel("To");
        _toListText = toListText;

        ScFieldText ccListText;
        ccListText = new ScFieldText();
        ccListText.setLabel("CC");
        _ccListText = ccListText;

        ScFieldset set;
        set = root.addFieldset("Default Recipients");

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.add(toListText);
        fields.add(ccListText);
    }

    private void installTemplateOn(ScDiv root)
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScFieldset set;
        set = root.addFieldset("Template");

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.addFieldText(x.SubjectText, "Subject");
        fields.addLiteral(x.BodyHtml, "Body");
    }

    //==================================================
    //= install :: preview tab
    //==================================================

    private ScDiv createPreviewTab()
    {
        ScDiv tab;
        tab = new ScDiv();
        tab.setLabel("Preview");

        ScGroup group;
        group = tab.addGroup("Preview");
        group.setFlavorDetail();
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().gap20().auto();
        body.add(createSendPreview());
        body.add(createViewPreview());

        return tab;
    }

    //==================================================
    //= install :: send preview
    //==================================================

    private ScControl createSendPreview()
    {
        ScFieldset set;
        set = new ScFieldset();
        set.setLabel("Send");
        set.add(createForm());
        return set;
    }

    private ScForm createForm()
    {
        ScForm e;
        e = new ScForm();
        e.css().flexColumn().columnSpacer5().flexCrossAlignStart();
        e.addText("This will email the preview to the address(es) provided.");
        e.addFullWidthFieldTable().add(createToRow());
        e.addButton("Send", newUncheckedAction(this::handleSend));
        _sendForm = e;
        return e;
    }

    private ScDiv createToRow()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5();
        e.setLabel("To");
        e.add(createToField());
        e.addLink("me", newUncheckedAction(this::handleToMe));
        return e;
    }

    private ScTextField createToField()
    {
        ScTextField e;
        e = new ScTextField();
        e.disableChangeTracking();
        e.layoutFlexFiller();
        e.setRequired();
        _sendToField = e;
        return e;
    }

    //==================================================
    //= install :: view preview
    //==================================================

    private ScControl createViewPreview()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScFieldset set;
        set = new ScFieldset();
        set.setLabel("View");

        ScFieldLayout fields;
        fields = set.addFieldLayout();
        fields.addText(x.SampleSubjectText);
        fields.addLiteral(x.SampleBodyHtml);

        return set;
    }

    //##################################################
    //# pre render
    //##################################################

    @Override
    protected void preRenderDetails(MyEmailTemplate child)
    {
        super.preRenderDetails(child);

        preRenderToRecipients(child);
        preRenderCcRecipients(child);
    }

    private void preRenderToRecipients(MyEmailTemplate child)
    {
        KmList<MyDefaultRecipient> v = child.getDefaultToRecipients();
        _toListText.setValue(v.collect(e -> e.getContactTypeName()).join());
    }

    private void preRenderCcRecipients(MyEmailTemplate child)
    {
        KmList<MyDefaultRecipient> v = child.getDefaultCcRecipients();
        _ccListText.setValue(v.collect(e -> e.getContactTypeName()).join());
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        validateToEmails();
    }

    private void validateToEmails()
    {
        if ( _sendToField.hasErrors() )
            return;

        if ( getTos().isEmpty() )
            _sendToField.addError("Enter an email address.");
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToMe()
    {
        MyUser user = MyGlobals.getCurrentUser();
        String email = user.getEmail();

        _sendForm.ajaxHideAllErrors();
        _sendToField.ajaxSetFieldValue(email);
    }

    private void handleSend()
    {
        ajaxHideAllErrors();
        validateAndCheck();

        MyEmailTemplate template = getDomainChild();
        MyProject project = template.getProject();

        MyEmail email;
        email = new MyEmail();
        email.addToRecipients(getTos());
        email.setFromAddress(project.getSendEmailFrom());
        email.setSubject(template.getSampleSubjectText());
        email.addHtmlPart(template.getSampleBodyHtml(), true);
        email.setStatusReady();
        email.daoAttach();

        ajaxToast("Email sent.");
    }

    //##################################################
    //# support
    //##################################################

    private KmList<String> getTos()
    {
        String value = _sendToField.getValue();

        KmStringTokenizer t;
        t = new KmStringTokenizer();
        t.setIgnoreEmptyValues();
        t.setTrimValues();
        t.addCommaDelimiter();
        t.addSemicolonDelimiter();
        t.addWhitespaceDelimiters();

        return t.split(value);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyEmailTemplate e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        ajaxReplace();
        fireChildChanged(getDomainChild());
    }
}
