package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteCallbackIF;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScLongField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyUser;

/**
 * Test the various form fields.
 */
public class MyFieldTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyFieldTestPage instance = new MyFieldTestPage();

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
    private ScListField         _listField;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

        installFieldGroup(root);
        installFieldsets(root);

        return root;
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
        _autoCompleteField.setCallback(newCallback());

        _dropdown = new ScDropdown();
        _dropdown.setLabel("Dropdown");

        _checkboxField = new ScCheckboxField();
        _checkboxField.setLabel("Checkbox");

        _listField = new ScListField();
        _listField.setLabel("List");
        _listField.addOption("1", "one");
        _listField.addOption("2", "two");
        _listField.addOption("3", "three");
        _listField.addOption("4", "four");

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newValidateAction());

        ScGroup group;
        group = form.addGroup("Field Samples");

        ScBox body;
        body = group.addPad();

        ScFieldTable fields;
        fields = body.addFields();
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
        fields.add(_listField);

        group.addDivider();

        ScBox footer;
        footer = group.addButtonBox();
        footer.addSubmitButton("Validate");
        footer.addButton("Reset", newResetValuesAction());

        _fieldGroup = group;
    }

    private ScAutoCompleteCallbackIF newCallback()
    {
        return new ScAutoCompleteCallbackIF()
        {
            @Override
            public KmList<String> getOptionsFor(String term)
            {
                return getAutoCompleteOptions(term);
            }
        };
    }

    private KmList<String> getAutoCompleteOptions(String term)
    {
        KmList<String> v;
        v = new KmList<String>();

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
        group = root.addGroup("Fieldset Samples");

        ScBox body;
        body = group.addPadSpaced();

        ScFieldset box;
        box = body.addFieldset("Name");
        box.css().floatLeft().pad();

        ScFieldTable fields;
        fields = box.addFields();
        fields.addTextField().setLabel("First");
        fields.addTextField().setLabel("Middle");

        ScTextField field;
        field = fields.addTextField();
        field.setLabel("Last");
        field.setValue("readonly");
        field.setReadOnly();

        box = body.addFieldset("Phone");
        box.css().floatLeft().pad();

        fields = box.addFields();
        fields.addTextField().setLabel("Home");
        fields.addTextField().setLabel("Work");
        fields.addTextField().setLabel("Cell");
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newValidateAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleValidate();
            }
        };
    }

    private ScActionIF newResetValuesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleResetValues();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleValidate()
    {
        ajax().hideAllErrors();

        _fieldGroup.validate();

        ajax().toast("Ok").success();
    }

    private void handleResetValues()
    {
        ajax().hideAllErrors();

        _fieldGroup.resetFieldValues();
        _fieldGroup.ajaxUpdateValues();
    }

}
