package com.app.ui.page.crud.emailTemplate;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScRichTextEditor;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.macro.MyMacroContextType;
import com.app.macro.MyMacroDocumentFormatter;
import com.app.model.MyDefaultRecipient;
import com.app.model.MyDefaultRecipientUtility;
import com.app.model.MyEmailTemplate;
import com.app.model.base.MyDefaultRecipientContactType;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.model.meta.MyMetaEmailTemplate;
import com.app.ui.email.MyEmailTemplateRecipientDialog;
import com.app.ui.macro.MyMacroDialog;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyEmailTemplateEditCard
    extends MyCrudEditCard<MyEmailTemplate>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField                _nameField;
    private ScDynamicEnumDropdownField _contextTypeField;

    private ScLocalList<String> _toTypeCodes;
    private ScLocalString       _toCustomEmail;
    private ScLocalList<String> _ccTypeCodes;
    private ScLocalString       _ccCustomEmail;

    private ScFieldText _toListText;
    private ScFieldText _ccListText;

    private ScRichTextEditor _bodyField;
    private ScTextField      _subjectField;

    private ScFieldset     _previewSet;
    private ScTransientDiv _subjectPreview;
    private ScTransientDiv _bodyPreview;

    private MyEmailTemplateRecipientDialog _recipientDialog;
    private MyMacroDialog                  _macroDialog;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateEditCard()
    {
        super(new MyEmailTemplateBuilder());
    }

    public MyEmailTemplateEditCard(MyEmailTemplateBuilder e)
    {
        super(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<String> getToTypeCodes()
    {
        return _toTypeCodes.getValue();
    }

    public void setToTypeCodes(KmList<String> v)
    {
        if ( v == null )
        {
            _ccTypeCodes.clearValue();
            return;
        }

        _toTypeCodes.setValue(v);
    }

    public void setToTypes(KmList<MyDefaultRecipientContactType> v)
    {
        if ( v == null )
        {
            _ccTypeCodes.clearValue();
            return;
        }

        setToTypeCodes(v.collect(e -> e.getCode()));
    }

    public String getToCustomEmail()
    {
        return _toCustomEmail.getValue();
    }

    public void setToCustomEmail(String e)
    {
        _toCustomEmail.setValue(e);
    }

    public KmList<String> getCcTypeCodes()
    {
        return _ccTypeCodes.getValue();
    }

    public void setCcTypeCodes(KmList<String> v)
    {
        if ( v == null )
        {
            _ccTypeCodes.clearValue();
            return;
        }

        _ccTypeCodes.setValue(v);
    }

    public void setCcTypes(KmList<MyDefaultRecipientContactType> v)
    {
        if ( v == null )
        {
            _ccTypeCodes.clearValue();
            return;
        }

        setCcTypeCodes(v.collect(e -> e.getCode()));
    }

    public String getCcCustomEmail()
    {
        return _ccCustomEmail.getValue();
    }

    public void setCcCustomEmail(String e)
    {
        _ccCustomEmail.setValue(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.fill;
    }

    @Override
    protected void installDetailsOn(ScDiv col)
    {
        _toTypeCodes = new ScLocalList<>();
        _toTypeCodes.setAutoSave();

        _toCustomEmail = new ScLocalString();
        _toCustomEmail.setAutoSave();

        _ccTypeCodes = new ScLocalList<>();
        _ccTypeCodes.setAutoSave();

        _ccCustomEmail = new ScLocalString();
        _ccCustomEmail.setAutoSave();

        col.css().flexColumn().columnSpacer20().clip();

        installGeneralRowOn(col);
        installTemplateRowOn(col);

        installRecipientDialog();
        installMacroDialog();
    }

    private void installGeneralRowOn(ScDiv root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer20();

        installGeneralOn(row);
        installRecipientsOn(row);
    }

    private void installGeneralOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("General");
        set.css().flexChildFiller0();

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.css().widthFull();
        fields.add(createNameField());
        fields.add(createTypeField());
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
        set.css().flexChildFiller0();

        ScDiv row;
        row = set.addDiv();
        row.css().flexRow().rowSpacer20();

        ScDiv div;
        div = row.addDiv();
        div.css().flexChildFiller();

        ScFieldTable fields;
        fields = div.addFullWidthFieldTable();
        fields.add(toListText);
        fields.add(ccListText);

        ScAction editAction;
        editAction = newUncheckedAction(this::handleEditRecipients);

        row.addButton("Edit", editAction);
    }

    private void installTemplateRowOn(ScDiv root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer20().flexChildFiller();

        installTemplatesOn(row);
        installPreviewsOn(row);
    }

    private void installTemplatesOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Template");
        set.css().flexChildFiller0().relative().clip();

        ScDiv col;
        col = set.addDiv();
        col.css().flexColumn().fieldsetFillOffset10();
        col.add(createButtons());
        col.addLabel("Subject");
        col.add(createSubjectField());
        col.addFlexGap(20);
        col.addLabel("Body");
        col.add(createBodyWrapper());
    }

    private void installPreviewsOn(ScDiv root)
    {
        _subjectPreview = new ScTransientDiv();
        _subjectPreview.css().flexChildStatic();

        _bodyPreview = new ScTransientDiv();
        _bodyPreview.css().flexChildFiller0().auto();

        ScFieldset set;
        set = root.addFieldset("Preview");
        set.css().flexChildFiller0().relative().clip();
        _previewSet = set;

        ScDiv col;
        col = set.addDiv();
        col.css().flexColumn().fieldsetFillOffset10();
        col.addRefreshButton(newUncheckedAction(this::handleRefreshPreview));
        col.addFlexGap(20);
        col.addLabel("Subject");
        col.add(_subjectPreview);
        col.addFlexGap(20);
        col.addLabel("Body");
        col.add(_bodyPreview);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScTextField createNameField()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScTextField e;
        e = x.Name.newField();
        e.setWidthFull();
        _nameField = e;
        return e;
    }

    private ScDynamicEnumDropdownField createTypeField()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScDynamicEnumDropdownField e;
        e = new ScDynamicEnumDropdownField();
        e.setLabel("Type");
        e.setEnumListSupplier(MyEmailTemplateContextType::getValues);
        e.setNullSelectPrefix();
        e.setValueAdaptor(x.ContextTypeCode);
        e.setRequired();
        e.onChange(newUncheckedAction(this::handleTypeChanged));
        e.setHelp(x.ContextTypeCode);
        _contextTypeField = e;
        return e;
    }

    private ScTextField createSubjectField()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScTextField e;
        e = x.SubjectText.newField();
        e.setWidthFull();
        _subjectField = e;
        return e;
    }

    private ScDiv createBodyWrapper()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexChildFiller().relative();
        e.add(createBodyField());
        return e;
    }

    private ScRichTextEditor createBodyField()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScRichTextEditor e;
        e = new ScRichTextEditor();
        e.setLabel("Body");
        e.setValueAdaptor(x.BodyHtml);
        e.setFill();
        _bodyField = e;
        return e;
    }

    //==================================================
    //= install :: buttons
    //==================================================

    private ScDiv createButtons()
    {
        ScAction macroAction = newUncheckedAction(this::handleOpenMacros);
        ScAction previewAction = newUncheckedAction(this::handleTogglePreview);

        ScDiv div;
        div = new ScDiv();
        div.css().flexRow().rowSpacer5().flexAlignEnd();
        div.addButton("Macros", macroAction);
        div.addButton("Toggle Preview", previewAction);

        return div;
    }

    //==================================================
    //= install :: dialog
    //==================================================

    private void installRecipientDialog()
    {
        MyEmailTemplateRecipientDialog e;
        e = new MyEmailTemplateRecipientDialog(this);
        _recipientDialog = e;
    }

    private void installMacroDialog()
    {
        MyMacroDialog e;
        e = new MyMacroDialog();
        _macroDialog = e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyEmailTemplate child)
    {
        super.preRenderDetails(child);

        preRenderToRecipients(child);
        preRenderCcRecipients(child);

        updatePreview();
    }

    private void preRenderToRecipients(MyEmailTemplate child)
    {
        KmList<MyDefaultRecipient> v = child.getDefaultToRecipients();

        MyDefaultRecipient custom;
        custom = v.selectFirst(e -> e.isContactTypeCustom());
        v.remove(custom);

        String customEmail = custom == null
            ? null
            : custom.getCustomEmail();

        String text = getTextFor(v.collect(e -> e.getContactType()), customEmail);

        _toListText.setValue(text);
        setToTypeCodes(v.collect(e -> e.getContactTypeCode()));
        setToCustomEmail(customEmail);
    }

    private void preRenderCcRecipients(MyEmailTemplate child)
    {
        KmList<MyDefaultRecipient> v = child.getDefaultCcRecipients();

        MyDefaultRecipient custom;
        custom = v.selectFirst(e -> e.isContactTypeCustom());
        v.remove(custom);

        String customEmail = custom == null
            ? null
            : custom.getCustomEmail();

        String text = getTextFor(v.collect(e -> e.getContactType()), customEmail);

        _ccListText.setValue(text);
        setCcTypeCodes(v.collect(e -> e.getContactTypeCode()));
        setCcCustomEmail(customEmail);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTypeChanged()
    {
        ajaxUpdateRecipientText();
    }

    private void handleTogglePreview()
    {
        updatePreview();
        _subjectPreview.ajaxReplace();
        _bodyPreview.ajaxReplace();
        _previewSet.ajaxToggle();
    }

    private void handleRefreshPreview()
    {
        updatePreview();
        _subjectPreview.ajaxReplace();
        _bodyPreview.ajaxReplace();
    }

    private void handleEditRecipients()
    {
        _recipientDialog.ajaxOpen();
    }

    private void handleOpenMacros()
    {
        _macroDialog.ajaxOpen(getMacroContextType());
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
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyEmailTemplate template = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getEmailTemplateDao().isDuplicateName(template, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyEmailTemplate child)
    {
        saveToRecipientsOn(child);
        saveCcRecipientsOn(child);

        child.applyFrom(this);
    }

    private void saveToRecipientsOn(MyEmailTemplate child)
    {
        KmList<String> codes;
        codes = getToTypeCodes();

        KmList<MyDefaultRecipientContactType> types;
        types = findTypesFromCodes(codes);
        types.retainIf(e -> getAvailableContactTypes().contains(e));

        child.setDefaultToRecipientsFrom(types);

        if ( _toCustomEmail.hasValue() )
        {
            MyDefaultRecipient custom;
            custom = new MyDefaultRecipient();
            custom.setTypeTo();
            custom.setContactTypeCustom();
            custom.setCustomEmail(getToCustomEmail());

            child.addDefaultRecipient(custom);
        }
    }

    private void saveCcRecipientsOn(MyEmailTemplate child)
    {
        KmList<String> codes;
        codes = getCcTypeCodes();

        KmList<MyDefaultRecipientContactType> types;
        types = findTypesFromCodes(codes);
        types.retainIf(e -> getAvailableContactTypes().contains(e));

        child.setDefaultCcRecipientsFrom(types);

        if ( _ccCustomEmail.hasValue() )
        {
            MyDefaultRecipient custom;
            custom = new MyDefaultRecipient();
            custom.setTypeCc();
            custom.setContactTypeCustom();
            custom.setCustomEmail(getCcCustomEmail());

            child.addDefaultRecipient(custom);
        }
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxUpdateRecipientText()
    {
        ajaxUpdateToText();
        ajaxUpdateCcText();
    }

    private void ajaxUpdateToText()
    {
        KmList<MyDefaultRecipientContactType> allowedTypes = getAvailableContactTypes();

        KmList<MyDefaultRecipientContactType> types;
        types = findTypesFromCodes(getToTypeCodes());
        types.retainIf(e -> allowedTypes.contains(e));

        String custom = getToCustomEmail();
        ajaxUpdateToTextWith(types, custom);
    }

    private void ajaxUpdateCcText()
    {
        KmList<MyDefaultRecipientContactType> allowedTypes = getAvailableContactTypes();

        KmList<MyDefaultRecipientContactType> types;
        types = findTypesFromCodes(getCcTypeCodes());
        types.retainIf(e -> allowedTypes.contains(e));

        String custom = getCcCustomEmail();
        ajaxUpdateCcTextWith(types, custom);
    }

    private void ajaxUpdateToTextWith(KmList<MyDefaultRecipientContactType> types, String custom)
    {
        String text = getTextFor(types, custom);
        ajaxSetToText(text);
    }

    private void ajaxUpdateCcTextWith(KmList<MyDefaultRecipientContactType> types, String custom)
    {
        String text = getTextFor(types, custom);
        ajaxSetCcText(text);
    }

    public String getTextFor(KmList<MyDefaultRecipientContactType> types, String custom)
    {
        KmList<String> labels;
        labels = types.collect(e -> e.getLabel());
        labels.sort();

        if ( Kmu.hasValue(custom) )
        {
            String s = Kmu.format("Custom (%s)", custom);
            labels.add(s);
        }

        String text = labels.join();
        return text;
    }

    public void ajaxSetToText(String text)
    {
        _toListText.setValue(text);
        _toListText.ajaxReplace();
    }

    public void ajaxSetCcText(String text)
    {
        _ccListText.setValue(text);
        _ccListText.ajaxReplace();
    }

    //##################################################
    //# support
    //##################################################

    public KmList<MyDefaultRecipientContactType> getAvailableContactTypes()
    {
        MyEmailTemplateContextType type = getSelectedContextType();

        if ( type == null )
            return KmList.createEmpty();

        switch ( type )
        {
            case Project:
                return MyDefaultRecipientUtility.getProjectRecipientContactTypes();

            case Site:
                return MyDefaultRecipientUtility.getSiteRecipientContactTypes();
        }
        throw Kmu.newEnumError(type);
    }

    public MyEmailTemplateContextType getSelectedContextType()
    {
        String code = _contextTypeField.getValue();
        return MyEmailTemplateContextType.findCode(code);
    }

    private KmList<MyDefaultRecipientContactType> findTypesFromCodes(KmList<String> codes)
    {
        return codes.collect(e -> MyDefaultRecipientContactType.findCode(e));
    }

    private MyMacroContextType getMacroContextType()
    {
        return getEmailTemplateFormatter().getContextType();
    }

    private void updatePreview()
    {
        String subject = formatPreviewText(_subjectField.getValue());
        _subjectPreview.addText(subject);

        String body = formatPreviewHtml(_bodyField.getValue());
        _bodyPreview.addLiteral().setValue(body);
    }

    private String formatPreviewText(String s)
    {
        MyMacroDocumentFormatter f = getEmailTemplateFormatter();

        String text;
        text = f.formatText(s);
        text = f.markAllText(text);
        return text;
    }

    private String formatPreviewHtml(String s)
    {
        MyMacroDocumentFormatter f = getEmailTemplateFormatter();

        String html;
        html = f.formatHtml(s);
        html = f.markAllHtml(html);
        return html;
    }

    private MyMacroDocumentFormatter getEmailTemplateFormatter()
    {
        String code = _contextTypeField.getValue();
        MyEmailTemplateContextType emailContext = MyEmailTemplateContextType.findCode(code);
        MyMacroContextType macroContext = emailContext.toMacroContextType();

        MyMacroDocumentFormatter f;
        f = new MyMacroDocumentFormatter();
        f.setSampleContext(macroContext);
        return f;
    }
}
