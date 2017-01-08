package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScDurationField;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScLongField;
import com.kodemore.servlet.field.ScRadioField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the various form fields.
 */
public final class MyFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyFieldTestPage();
    }

    public static MyFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroup                 _fieldGroup;
    private ScTextField             _textField;
    private ScTextField             _requiredTextField;
    private ScTextField             _readOnlyField;
    private ScIntegerField          _integerField;
    private ScDurationField         _durationField;
    private ScDoubleField           _doubleField;
    private ScLongField             _longField;
    private ScDateField             _dateField;
    private ScColorField            _colorField;
    private ScAutoCompleteField     _autoCompleteField;
    private ScDropdownField<String> _dropdown;
    private ScCheckboxField         _checkboxField;
    private ScRadioField            _radio1Field;
    private ScRadioField            _radio2Field;
    private ScRadioField            _radio3Field;
    private ScListField<String>     _listField;
    private ScTextArea              _textArea;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        ScForm form;
        form = root.addForm();
        form.css().fill();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Field Test");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().autoY();

        installFieldsOn(body);

        ScDiv footer;
        footer = group.showFooter().addButtonBox();
        footer.addSubmitButton();
        footer.addResetButton();
        footer.addButton("Reinitialize", this::handleReinitialize);

        _fieldGroup = group;
    }

    private void installFieldsOn(ScContainer root)
    {
        _textField = new ScTextField();
        _textField.setLabel("Text");
        _textField.setWidthFull();

        _requiredTextField = new ScTextField();
        _requiredTextField.setLabel("Required");
        _requiredTextField.setWidthFull();
        _requiredTextField.setRequired();

        _readOnlyField = new ScTextField();
        _readOnlyField.setLabel("Text");
        _readOnlyField.setValue("readonly");
        _readOnlyField.setReadOnly();
        _readOnlyField.setWidthFull();

        _integerField = new ScIntegerField();
        _integerField.setLabel("Integer");
        _integerField.setWidthFull();

        _durationField = new ScDurationField();
        _durationField.setLabel("Duration (secs)");
        _durationField.setWidthFull();

        _doubleField = new ScDoubleField();
        _doubleField.setLabel("Double");
        _doubleField.setWidthFull();

        _longField = new ScLongField();
        _longField.setLabel("Long");
        _longField.setWidthFull();

        _dateField = new ScDateField();
        _dateField.setLabel("Date");
        _dateField.setWidthFull();

        _colorField = new ScColorField();
        _colorField.setLabel("Color");
        _colorField.setWidthFull();

        _autoCompleteField = new ScAutoCompleteField();
        _autoCompleteField.setLabel("AutoComplete");
        _autoCompleteField.setCallback(this::getAutoCompleteOptions);

        _dropdown = new ScDropdownField<>();
        _dropdown.setLabel("Dropdown");
        _dropdown.setNullAnyPrefix();
        _dropdown.addOption("Red");
        _dropdown.addOption("Blue");
        _dropdown.addOption("Green");

        _checkboxField = new ScCheckboxField();
        _checkboxField.setLabel("Checkbox");

        String radioName = "radioField";

        _radio1Field = new ScRadioField();
        _radio1Field.setLabel("Radio1");
        _radio1Field.setOptionValue("Radio1");
        _radio1Field.setHtmlName(radioName);

        _radio2Field = new ScRadioField();
        _radio2Field.setLabel("Radio2");
        _radio2Field.setOptionValue("Radio2");
        _radio2Field.setHtmlName(radioName);

        _radio3Field = new ScRadioField();
        _radio3Field.setLabel("Radio3");
        _radio3Field.setOptionValue("Radio3");
        _radio3Field.setHtmlName(radioName);

        _listField = new ScListField<>();
        _listField.setLabel("List");
        _listField.addOption(null, "-select-");
        _listField.addOption("1", "one");
        _listField.addOption("2", "two");
        _listField.addOption("3", "three");
        _listField.addOption("4", "four");

        _textArea = new ScTextArea();
        _textArea.setLabel("Text Area");
        _textArea.layoutInline(300, 100);

        ScFieldTable fields;
        fields = root.addPad().addFieldTable();
        fields.add(_textField);
        fields.add(_requiredTextField);
        fields.add(_readOnlyField);
        fields.add(_integerField);
        fields.add(_durationField);
        fields.add(_doubleField);
        fields.add(_longField);
        fields.add(_dateField);
        fields.add(_colorField);
        fields.add(_autoCompleteField);
        fields.add(_dropdown);
        fields.add(_checkboxField);
        fields.addSpace();
        fields.add(_radio1Field);
        fields.add(_radio2Field);
        fields.add(_radio3Field);
        fields.addSpace();
        fields.add(_listField);
        fields.addSpace();
        fields.add(_textArea);
    }

    private KmList<String> getAutoCompleteOptions(String term)
    {
        KmList<String> v;
        v = new KmList<>();

        KmList<MyUser> users;
        users = getAccess().findAllUsers();

        for ( MyUser e : users )
            if ( e.getFullName().toLowerCase().contains(term.toLowerCase()) )
                v.add(e.getFullName());

        return v;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        ajax().hideAllErrors();
        validate();

        getRoot().ajaxUpdateFieldValues();
        ajax().toast("Ok").success();
    }

    private void handleReinitialize()
    {
        ajax().hideAllErrors();

        _fieldGroup.resetFieldValues();
        _fieldGroup.ajaxUpdateFieldValues();
    }
}
