package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyHoverTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyHoverTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyHoverTestPage();
    }

    public static MyHoverTestPage getInstance()
    {
        return _instance;
    }

    private MyHoverTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

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
        _nameField = new ScTextField();
        _nameField.setLabel("Name");
        _nameField.setHoverText("Please enter a name here.");
        _nameField.cssMargin().left5();
        _nameField.disableChangeTracking();

        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.setHoverText("This is text that shows when hovering over the entire form.");
        form.getPostRenderScript().tooltip();

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Hover Test");

        ScDiv bannerRight;
        bannerRight = group.getBanner().getRight();
        bannerRight.css().pad5();

        ScImage image;
        image = bannerRight.addImage();
        image.setSource(getCommonImageUrl("smiley.png"));
        image.setHoverText("Smile!");

        ScDiv body;
        body = group.getBody();
        body.css().gap();
        body.addParagraph("Show hover text over various elements using the title attribute.");
        body.addFieldTable().add(_nameField);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();

        ScActionButton clearButton;
        clearButton = buttons.addButton("Clear", this::handleClear);
        clearButton.setHoverText("This button is used for clearing the field.");
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

    private void handleClear()
    {
        _nameField.ajaxClearFieldValue();
    }
}
