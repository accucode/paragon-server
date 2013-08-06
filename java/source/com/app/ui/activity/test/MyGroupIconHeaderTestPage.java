package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupIconHeader;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;

public class MyGroupIconHeaderTestPage
    extends MyAbstractTestPage
{
    /**
     * this is an example of how to use the ScGroupIconHeadder
     * to dynamically change the title and icon in a group's 
     * headder.
     */
    //##################################################
    //# singleton
    //##################################################

    public static final MyGroupIconHeaderTestPage instance = new MyGroupIconHeaderTestPage();

    private MyGroupIconHeaderTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroupIconHeader _groupHeader;
    private ScDropdown        _dropdown;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        ScForm form = root.addForm();

        KmList<String> list = new KmList<String>();
        list.add("house");
        list.add("smiley");
        list.add("squares");

        _dropdown = new ScDropdown();
        _dropdown.setOptions(list);
        _dropdown.setAction(newChangeIconAction());

        ScGroup group;
        group = form.addGroup();

        _groupHeader = group.setTitleWithIcon("source ", "welcome");

        ScBox body;
        body = group.addPad();
        body.addButton("change Icon", newChangeIconAction());
        body.add(_dropdown);

        return root;
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newChangeIconAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleChangeIcon();
            }
        };
    }

    //##################################################
    //# start
    //##################################################//

    @Override
    public void start()
    {
        _groupHeader.setText("Welcome " + getCurrentUser().getName());
        _groupHeader.setImageSource(getCommonImageUrl("smiley.png"));
        _groupHeader.ajaxUpdateValues();

        super.start();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleChangeIcon()
    {
        String house = getCommonImageUrl("house.png");
        String smiley = getCommonImageUrl("smiley.png");
        String squares = getCommonImageUrl("squares.png");

        _groupHeader.setText("Welcome " + getCurrentUser().getName());

        if ( _dropdown.getStringValue().equals("house") )
            _groupHeader.setImageSource(house);

        if ( _dropdown.getStringValue().equals("smiley") )
            _groupHeader.setImageSource(smiley);

        if ( _dropdown.getStringValue().equals("squares") )
            _groupHeader.setImageSource(squares);

        _groupHeader.ajax().replace();
    }
}
