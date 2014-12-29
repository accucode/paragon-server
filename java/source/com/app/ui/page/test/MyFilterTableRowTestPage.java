package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScTextField;

public class MyFilterTableRowTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyFilterTableRowTestPage instance = new MyFilterTableRowTestPage();

    private MyFilterTableRowTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField    _searchAddressField;
    private ScIntegerField _searchMinSquareFootageField;
    private ScIntegerField _searchMaxSquareFootageField;
    private ScTextField    _searchRoomNumberField1;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
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

        installBuildingSearchBox(root);
    }

    private void installBuildingSearchBox(ScBox root)
    {
        _searchAddressField = new ScTextField();
        _searchAddressField.setLabel("Address contains ");

        _searchMinSquareFootageField = new ScIntegerField();
        _searchMinSquareFootageField.setLabel("Minimum Square Footage is ");

        _searchMaxSquareFootageField = new ScIntegerField();
        _searchMaxSquareFootageField.setLabel("Maximum Square Footage is ");

        _searchRoomNumberField1 = new ScTextField();
        _searchRoomNumberField1.setLabel("Room Number contains ");

        ScFilterBox box;
        box = root.addFilterBox();
        box.setTitle("Filter");

        ScFieldTable fields;
        fields = box.addFieldTable();
        fields.add(_searchAddressField);

        ScFlexbox row;
        row = fields.addRow();
        row.crossAlignCenter();
        row.setLabel("Square Footage");
        row.add(_searchMinSquareFootageField);
        row.addNonBreakingSpace();
        row.addText("-");
        row.addNonBreakingSpace();
        row.add(_searchMaxSquareFootageField);

        fields.add(_searchRoomNumberField1);
    }
}
