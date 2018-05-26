package com.app.ui.email;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScCheckboxList;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.utility.KmEmailAddressParser;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyDefaultRecipientContactType;
import com.app.ui.control.MyFormDialog;
import com.app.ui.page.crud.emailTemplate.MyEmailTemplateEditCard;

/**
 * I am used to edit the default recipients for an email template.
 */
public class MyEmailTemplateRecipientDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private MyEmailTemplateEditCard _card;

    ScCheckboxList<String> _toList;
    ScTextArea             _toCustomEmailField;

    ScCheckboxList<String> _ccList;
    ScTextArea             _ccCustomEmailField;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateRecipientDialog(MyEmailTemplateEditCard card)
    {
        _card = card;
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("Modify Default Recipients");

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
        body.css().pad20().columnSpacer20();

        installTosOn(body);
        installCcsOn(body);
    }

    private void installTosOn(ScDiv root)
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.layoutBlockMultiColumn(80);
        _toList = list;

        ScTextArea field;
        field = new ScTextArea();
        field.setLabel("Custom");
        field.setHelp(getCustomEmailHelp());
        field.layoutBlock(65);
        _toCustomEmailField = field;

        ScFieldset set;
        set = root.addFieldset("To");
        set.add(list);

        set.addFieldLayout().add(field);
    }

    private void installCcsOn(ScDiv root)
    {
        ScCheckboxList<String> list;
        list = new ScCheckboxList<>();
        list.layoutBlockMultiColumn(80);
        _ccList = list;

        ScTextArea field;
        field = new ScTextArea();
        field.setLabel("Custom");
        field.setHelp(getCustomEmailHelp());
        field.layoutBlock(65);
        _ccCustomEmailField = field;

        ScFieldset set;
        set = root.addFieldset("CC");
        set.add(list);

        set.addFieldLayout().add(field);
    }

    private String getCustomEmailHelp()
    {
        return ""
            + "Specify a custom email address that will be included in the recipients "
            + "for emails using this template.  "
            + "You may enter multiple email addresses in this field.";
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton("Apply");
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _toList.setOptions(getRecipientOptions());
        _toList.setValue(getCurrentToTypeCodes());
        _toCustomEmailField.setValue(getCurrentToCustomEmail());

        _ccList.setOptions(getRecipientOptions());
        _ccList.setValue(getCurrentCcTypeCodes());
        _ccCustomEmailField.setValue(getCurrentCcCustomEmail());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleApply()
    {
        ajaxHideAllErrors();
        validateCustomEmail(_toCustomEmailField);
        validateCustomEmail(_ccCustomEmailField);
        checkErrors();

        applyTos();
        applyCcs();

        ajaxClose();
    }

    private void applyTos()
    {
        KmList<String> typeCodes;
        typeCodes = _toList.getValue();

        KmList<MyDefaultRecipientContactType> types;
        types = findTypesFromCodes(typeCodes);

        _card.setToTypes(types);

        String custom = _toCustomEmailField.getValue();
        custom = normalizeCustomEmails(custom);
        _card.setToCustomEmail(custom);

        String text = _card.getTextFor(types, custom);
        _card.ajaxSetToText(text);
    }

    private void applyCcs()
    {
        KmList<String> typeCodes;
        typeCodes = _ccList.getValue();

        KmList<MyDefaultRecipientContactType> types;
        types = findTypesFromCodes(typeCodes);

        _card.setCcTypes(types);

        String custom = _ccCustomEmailField.getValue();
        custom = normalizeCustomEmails(custom);
        _card.setCcCustomEmail(custom);

        String text = _card.getTextFor(types, custom);
        _card.ajaxSetCcText(text);
    }

    private void validateCustomEmail(ScTextArea field)
    {
        String value = field.getValue();
        KmEmailAddressParser p = KmEmailAddressParser.staticParse(value);

        if ( p.hasErrors() )
            field.addError("Invalid email: %s.", p.getInvalidEmails().join());
    }

    private String normalizeCustomEmails(String s)
    {
        return Kmu.parseEmails(s).join();
    }

    //##################################################
    //# support
    //##################################################

    private KmList<MyDefaultRecipientContactType> findTypesFromCodes(KmList<String> codes)
    {
        KmList<MyDefaultRecipientContactType> v = new KmList<>();

        for ( String e : codes )
            v.add(MyDefaultRecipientContactType.findCode(e));

        return v;
    }

    private KmList<ScOption<String>> getRecipientOptions()
    {
        KmList<MyDefaultRecipientContactType> contactTypes = getContactTypes();

        KmList<ScOption<String>> v = new KmList<>();
        for ( MyDefaultRecipientContactType r : contactTypes )
            v.add(ScOption.create(r.getCode(), r.getLabel()));

        return v;
    }

    private KmList<MyDefaultRecipientContactType> getContactTypes()
    {
        KmList<MyDefaultRecipientContactType> v;
        v = _card.getAvailableContactTypes();
        // Custom is handled by custom email field
        return v.reject(e -> e.isCustom());
    }

    private KmList<String> getCurrentToTypeCodes()
    {
        return _card.getToTypeCodes();
    }

    private String getCurrentToCustomEmail()
    {
        return _card.getToCustomEmail();
    }

    private KmList<String> getCurrentCcTypeCodes()
    {
        return _card.getCcTypeCodes();
    }

    private String getCurrentCcCustomEmail()
    {
        return _card.getCcCustomEmail();
    }
}
