package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableCell;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.field.ScRadioField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyRadioButtonTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyRadioButtonTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyRadioButtonTestPage();
    }

    public static MyRadioButtonTestPage getInstance()
    {
        return _instance;
    }

    private MyRadioButtonTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String RADIO_NAME = "radio";

    //##################################################
    //# variables
    //##################################################

    private ScTableRow _row;
    private ScForm     _form;

    private KmList<ScRadioField> _buttons;

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
        root.css().pad();

        _form = root.addForm();
        _form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = _form.addGroup("Radio Buttons");

        KmList<String> labels;
        labels = new KmList<>();

        for ( int i = 0; i < 10; i++ )
        {
            String s = "Radio " + i;
            labels.add(s);
        }

        ScDiv body;
        body = group.getBody();

        ScTable table = body.addTable();

        _buttons = new KmList<>();

        for ( String label : labels )
        {
            ScRadioField radio;
            radio = new ScRadioField();
            radio.setHtmlName(RADIO_NAME);
            radio.setLabel(label);
            radio.setValue(label);
            _buttons.add(radio);
        }

        for ( int i = 0; i < _buttons.size(); i++ )
        {
            _row = table.addRow();

            addLabelledRadioButton(_buttons, i);

            addEmptyCell();

            i++;

            addLabelledRadioButton(_buttons, i);
        }

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addResetButton();
    }

    private void addLabelledRadioButton(KmList<ScRadioField> buttons, int i)
    {
        ScTableCell cell;
        cell = _row.addCell();
        cell.css().pad3();
        cell.add(buttons.get(i));

        cell = _row.addCell();
        cell.css().pad3();
        cell.addLabel(buttons.get(i).getLabel());
    }

    private void addEmptyCell()
    {
        ScTableCell cell;
        cell = _row.addCell();
        cell.css().pad3();
        cell.addSpace();
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

        KmList<String> values = new KmList<>();

        for ( ScRadioField button : _buttons )
            if ( button.isChecked() )
                values.add(button.getStringValue());

        getRoot().ajaxUpdateValues();

        String msg = "Ok... " + values.join();
        ajax().toast(msg).success();
    }
}
