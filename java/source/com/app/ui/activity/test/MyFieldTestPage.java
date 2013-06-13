package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScTextField;

/**
 * Test the various form fields.
 */
public class MyFieldTestPage
    extends MyAbstractTestPage
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

    private ScGroup         _fieldGroup;
    private ScTextField     _textField;
    private ScIntegerField  _integerField;
    private ScDoubleField   _doubleField;
    private ScDateField     _dateField;
    private ScColorField    _colorField;
    private ScCheckboxField _checkboxField;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        installFieldGroup(root);
        installFieldsets(root);

        return root;
    }

    private void installFieldGroup(ScBox root)
    {
        _textField = new ScTextField();
        _textField.setLabel("Text");
        _textField.setWidthFull();

        _integerField = new ScIntegerField();
        _integerField.setLabel("Integer");
        _integerField.setWidthFull();

        _doubleField = new ScDoubleField();
        _doubleField.setLabel("Double");
        _doubleField.setWidthFull();

        _dateField = new ScDateField();
        _dateField.setLabel("Date");
        _dateField.setWidthFull();

        _colorField = new ScColorField();
        _colorField.setLabel("Color");
        _colorField.setWidthFull();

        _checkboxField = new ScCheckboxField();
        _checkboxField.setLabel("Checkbox");

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
        fields.add(_integerField);
        fields.add(_doubleField);
        fields.add(_dateField);
        fields.add(_colorField);
        fields.add(_checkboxField);

        group.addDivider();

        ScBox footer;
        footer = group.addButtonBox();
        footer.addSubmitButton("Validate");
        footer.addButton("Reset", newResetValuesAction());

        _fieldGroup = group;
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
        fields.addTextField().setLabel("Last");

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
