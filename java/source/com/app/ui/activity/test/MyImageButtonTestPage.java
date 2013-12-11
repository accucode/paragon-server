package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

public class MyImageButtonTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyImageButtonTestPage instance = new MyImageButtonTestPage();

    private MyImageButtonTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScForm      _form;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScGroup group = root.addGroup();

        ScImage image;
        image = group.addImage();
        image.setSource(getCommonImageUrl("smiley.png"));
        image.setHoverText("Smile!");

        ScBox box;
        box = group.addPadSpaced();
        box.addBox().addText(
            "Show hover text over the icon, form, field, and button using the title attribute");
        box.addFields().add(_nameField);
        group.addDivider();

        ScButton button;
        button = group.addButtonBox().addButton("Clear", newClearAction());
        button.setHoverText("This button is used for clearing the field.");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        _form.ajax().tooltip();
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newClearAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleClear();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleClear()
    {
        _nameField.clearText();
        _nameField.ajaxUpdateValue();
    }
}
