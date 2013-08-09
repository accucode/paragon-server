package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;

import com.app.model.MyEmailStatus;

public class MyChosenTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyChosenTestPage instance = new MyChosenTestPage();

    private MyChosenTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        ScGroup group;
        group = root.addGroup("Chose Dropdown");
        group.addPad().addText(
            "Below are dropdowns, one of which uses Chosen.  Chosen dropdowns seem "
                + "to have issues displaying properly when inside a group.");
        group.addDivider();

        ScDropdown normal;
        normal = new ScDropdown();
        normal.setLabel("Normal");
        normal.addOptions(MyEmailStatus.values());

        ScDropdown chosen;
        chosen = new ScDropdown();
        chosen.setLabel("Chosen");
        chosen.setUsesChosen();
        chosen.addOptions(MyEmailStatus.values());

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(normal);
        fields.add(chosen);

        ScDropdown chosenOut;
        chosenOut = new ScDropdown();
        chosenOut.setLabel("Chosen");
        chosenOut.setUsesChosen();
        chosenOut.addOptions(MyEmailStatus.values());

        fields = root.addPad().addFields();
        fields.add(chosenOut);

        return root;
    }
}
