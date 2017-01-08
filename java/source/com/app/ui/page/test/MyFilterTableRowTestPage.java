package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyFilterTableRowTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyFilterTableRowTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyFilterTableRowTestPage();
    }

    public static MyFilterTableRowTestPage getInstance()
    {
        return _instance;
    }

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
        root.css().fill().auto();

        installBuildingSearchBox(root);
    }

    private void installBuildingSearchBox(ScDiv root)
    {
        _searchAddressField = new ScTextField();
        _searchAddressField.setLabel("Address contains ");
        _searchAddressField.disableChangeTracking();

        _searchMinSquareFootageField = new ScIntegerField();
        _searchMinSquareFootageField.setLabel("Minimum Square Footage is ");
        _searchMinSquareFootageField.disableChangeTracking();

        _searchMaxSquareFootageField = new ScIntegerField();
        _searchMaxSquareFootageField.setLabel("Maximum Square Footage is ");
        _searchMaxSquareFootageField.disableChangeTracking();

        _searchRoomNumberField1 = new ScTextField();
        _searchRoomNumberField1.setLabel("Room Number contains ");
        _searchRoomNumberField1.disableChangeTracking();

        ScFilterBox box;
        box = root.addFilterBox();
        box.setTitle("Filter");

        ScFieldTable fields;
        fields = box.addFieldTable();
        fields.add(_searchAddressField);

        ScDiv row;
        row = fields.addFlexRow();
        row.css().flexCrossAlignCenter();
        row.setLabel("Square Footage");
        row.add(_searchMinSquareFootageField);
        row.addNonBreakingSpace();
        row.addText("-");
        row.addNonBreakingSpace();
        row.add(_searchMaxSquareFootageField);

        fields.add(_searchRoomNumberField1);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
