package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupBannerIcon;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * This is an example of how to use the ScGroupIconHeadder
 * to change the title and icon in a group's header.
 */
public final class MyGroupIconHeaderTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyGroupIconHeaderTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyGroupIconHeaderTestPage();
    }

    public static MyGroupIconHeaderTestPage getInstance()
    {
        return _instance;
    }

    private MyGroupIconHeaderTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroupBannerIcon _groupHeader;
    private ScDropdown        _dropdown;

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

        ScForm form = root.addForm();

        KmList<String> list = new KmList<>();
        list.add("house");
        list.add("smiley");
        list.add("squares");

        _dropdown = new ScDropdown();
        _dropdown.setOptions(list);
        _dropdown.setOnChangeAction(this::handleChangeIcon);

        ScGroup group;
        group = form.addGroup();

        _groupHeader = group.setTitleWithIcon("source ", "welcome");

        ScBox body;
        body = group.getBody().addPad();
        body.addButton("change Icon", this::handleChangeIcon);
        body.add(_dropdown);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        _groupHeader.setText("Welcome " + getCurrentUser().getName());
        _groupHeader.setImageSource(getCommonImageUrl("smiley.png"));
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
