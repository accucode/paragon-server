package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test of the ScLocal pattern.
 */
public final class MyLocalValueTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyLocalValueTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyLocalValueTestPage();
    }

    public static MyLocalValueTestPage getInstance()
    {
        return _instance;
    }

    private MyLocalValueTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroup        _fieldGroup;
    private ScTextField    _textField;
    private ScIntegerField _integerField;

    private ScLocalStringList _listValues1;
    private ScTextArea        _listField1;

    private ScLocalStringList _listValues2;
    private ScTextArea        _listField2;

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
        installListGroup(root);
    }

    private void installFieldGroup(ScBox root)
    {
        _textField = new ScTextField();
        _textField.setLabel("Text");
        _textField.setWidthFull();

        _integerField = new ScIntegerField();
        _integerField.setLabel("Integer");
        _integerField.setWidthFull();

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup("Local Value Tests");

        ScBox body;
        body = group.getBody().addPad();
        body.addBox()
            .addText(
                ""
                    + "'Local' variables allow the developer to manage state in multi-tenant "
                    + "servlets similar to managing state in single-threaded, "
                    + "single-user, desktop apps.  Each local value has a default "
                    + "state that is defined during the application installation. "
                    + "Subsequent changes during http requests are kept private to "
                    + "the current thread (request).  Additionally, state can be 'saved' "
                    + "to the page session so that the value is retained across multiple "
                    + "http requests for a given user session.");

        body.addBreak();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(_textField);
        fields.add(_integerField);

        ScDiv footer;
        footer = group.getFooter();
        footer.show();
        footer.css().buttonGap();
        footer.addButton("Save", this::handleSaveFields);
        footer.addButton("Reset", this::handleResetFields);
        footer.addButton("Reset & Save", this::handleResetAndSaveFields);

        _fieldGroup = group;
    }

    private void installListGroup(ScBox root)
    {
        _listField1 = new ScTextArea();
        _listValues1 = new ScLocalStringList();

        _listValues2 = new ScLocalStringList();
        _listValues2.add("a");
        _listValues2.add("b");
        _listValues2.add("c");

        _listField1.setLabel("List (empty)");
        _listField1.style().width(150).height(100);

        _listField2 = new ScTextArea();
        _listField2.setLabel("List (a,b,c)");
        _listField2.style().width(150).height(100);

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup("... With Lists");

        ScBox body;
        body = group.getBody().addPad();
        body.addBox()
            .addText(
                ""
                    + "This sample tests ScLocalList directly, the field is used "
                    + "only to update and display the stored values. Enter multiple "
                    + "values separated by commas or new lines.");

        body.addBreak();

        ScFlexbox col;
        col = body.addInlineColumn();
        col.addLabelFor(_listField1);
        col.add(_listField1);

        body.addNonBreakingSpace();

        col = body.addInlineColumn();
        col.addLabelFor(_listField2);
        col.add(_listField2);

        ScDiv footer;
        footer = group.getFooter();
        footer.show();
        footer.css().buttonGap();
        footer.addButton("Save", this::handleSaveList);
        footer.addButton("Reset", this::handleResetList);
        footer.addButton("Reset & Save", this::handleResetAndSaveList);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        updateLists();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSaveFields()
    {
        _fieldGroup.ajax().hideAllErrors();
        _fieldGroup.validate();
        _fieldGroup.saveFieldValues();

        ajaxUpdateFields();
    }

    private void handleResetFields()
    {
        _fieldGroup.ajax().hideAllErrors();
        _fieldGroup.resetFieldValues();

        ajaxUpdateFields();
    }

    private void handleResetAndSaveFields()
    {
        _fieldGroup.ajax().hideAllErrors();
        _fieldGroup.resetFieldValues();
        _fieldGroup.saveFieldValues();

        ajaxUpdateFields();
    }

    private void handleSaveList()
    {
        _listValues1.setValue(parseList(_listField1));
        _listValues1.saveValue();

        _listValues2.setValue(parseList(_listField2));
        _listValues2.saveValue();

        ajaxUpdateLists();
    }

    private void handleResetList()
    {
        _listValues1.resetValue();
        _listValues2.resetValue();

        ajaxUpdateLists();
    }

    private void handleResetAndSaveList()
    {
        _listValues1.resetValue();
        _listValues1.saveValue();

        _listValues2.resetValue();
        _listValues2.saveValue();

        ajaxUpdateLists();
    }

    //##################################################
    //# support
    //##################################################

    private void ajaxUpdateFields()
    {
        _fieldGroup.ajaxUpdateValues();
        _fieldGroup.ajax().focus();
    }

    private void ajaxUpdateLists()
    {
        updateLists();
        _listField1.ajaxUpdateValues();
        _listField2.ajaxUpdateValues();
    }

    private void updateLists()
    {
        String s;

        s = _listValues1.getValue().join("\n");
        _listField1.setValue(s);

        s = _listValues2.getValue().join("\n");
        _listField2.setValue(s);
    }

    private KmList<String> parseList(ScTextArea field)
    {
        KmList<String> v = new KmList<>();

        String csv = field.getValue();
        KmList<String> lines = Kmu.parseLines(csv);

        for ( String line : lines )
        {
            KmList<String> tokens = Kmu.tokenize(line);
            v.addAll(tokens);
        }

        Kmu.trimValues(v);
        Kmu.removeEmptyValues(v);

        return v;
    }

}
