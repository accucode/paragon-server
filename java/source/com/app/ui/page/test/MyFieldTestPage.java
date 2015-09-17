package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScLongField;
import com.kodemore.servlet.field.ScRadioField;
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

    private ScGroup             _fieldGroup;
    private ScTextField         _textField;
    private ScTextField         _readOnlyField;
    private ScIntegerField      _integerField;
    private ScDoubleField       _doubleField;
    private ScLongField         _longField;
    private ScDateField         _dateField;
    private ScColorField        _colorField;
    private ScAutoCompleteField _autoCompleteField;
    private ScDropdown          _dropdown;
    private ScCheckboxField     _checkboxField;
    private ScRadioField        _radio1Field;
    private ScRadioField        _radio2Field;
    private ScRadioField        _radio3Field;
    private ScListField         _listField;

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
        root.css().gap();

        installFieldGroup(root);
        installFieldsets(root);
    }

    private void installFieldGroup(ScBox root)
    {
        _textField = new ScTextField();
        _textField.setLabel("Text");
        _textField.setWidthFull();

        _readOnlyField = new ScTextField();
        _readOnlyField.setLabel("Text");
        _readOnlyField.setValue("readonly");
        _readOnlyField.setReadOnly();
        _readOnlyField.setWidthFull();

        _integerField = new ScIntegerField();
        _integerField.setLabel("Integer");
        _integerField.setWidthFull();

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

        _dropdown = new ScDropdown();
        _dropdown.setLabel("Dropdown");

        _checkboxField = new ScCheckboxField();
        _checkboxField.setLabel("Checkbox");

        String radioName = "radioField";

        _radio1Field = new ScRadioField();
        _radio1Field.setLabel("Radio1");
        _radio1Field.setValue("Radio1");
        _radio1Field.setHtmlName(radioName);

        _radio2Field = new ScRadioField();
        _radio2Field.setLabel("Radio2");
        _radio2Field.setValue("Radio2");
        _radio2Field.setHtmlName(radioName);

        _radio3Field = new ScRadioField();
        _radio3Field.setLabel("Radio3");
        _radio3Field.setValue("Radio3");
        _radio3Field.setHtmlName(radioName);

        _listField = new ScListField();
        _listField.setLabel("List");
        _listField.addOption("1", "one");
        _listField.addOption("2", "two");
        _listField.addOption("3", "three");
        _listField.addOption("4", "four");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleValidate);

        ScGroup group;
        group = form.addGroup("Field Test");

        ScBox body;
        body = group.getBody().addPad();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(_textField);
        fields.add(_readOnlyField);
        fields.add(_integerField);
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

        group.addBodyDivider();

        ScBox footer;
        footer = group.getBody().addButtonBox();
        footer.addSubmitButton("Validate");
        footer.addButton("Reset", this::handleResetValues);

        _fieldGroup = group;
    }

    private KmList<String> getAutoCompleteOptions(String term)
    {
        KmList<String> v;
        v = new KmList<>();

        KmList<MyUser> users;
        users = getAccess().findAllUsers();

        for ( MyUser e : users )
            if ( e.getName().toLowerCase().contains(term.toLowerCase()) )
                v.add(e.getName());

        return v;
    }

    private void installFieldsets(ScBox root)
    {
        ScGroup group;
        group = root.addGroup("Fieldsets");

        ScBox body;
        body = group.getBody().addGap();

        ScFieldset box;
        box = body.addFieldset("Name");
        box.css().floatLeft().pad();

        ScFieldTable fields;
        fields = box.addFieldTable();
        fields.addTextField().setLabel("First");
        fields.addTextField().setLabel("Middle");

        ScTextField field;
        field = fields.addTextField();
        field.setLabel("Last");
        field.setValue("readonly");
        field.setReadOnly();

        box = body.addFieldset("Phone");
        box.css().floatLeft().pad();

        fields = box.addFieldTable();
        fields.addTextField().setLabel("Home");
        fields.addTextField().setLabel("Work");
        fields.addTextField().setLabel("Cell");
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

    private void handleValidate()
    {
        ajax().hideAllErrors();

        _fieldGroup.validate();

        if ( _radio1Field.isChecked() )
            ajax().toast(_radio1Field.getValue());

        if ( _radio2Field.isChecked() )
            ajax().toast(_radio2Field.getValue());

        if ( _radio3Field.isChecked() )
            ajax().toast(_radio3Field.getValue());

        ajax().toast("Ok").success();
    }

    private void handleResetValues()
    {
        ajax().hideAllErrors();

        _fieldGroup.resetFieldValues();
        _fieldGroup.ajaxUpdateValues();
    }

}
