package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;

import com.app.model.MyEmailStatus;

public class MyChosenTestPage
    extends MyTestPage
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
    //# variables
    //##################################################

    private ScDropdown _defaultDropdown;
    private ScDropdown _normalDropdown;
    private ScDropdown _chosenDropdown;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

        ScGroup group;
        group = root.addGroup("Chosen Dropdown");
        group.addPad().addText(
            ""
                + "Below are dropdowns, one of which uses Chosen. "
                + "Chosen dropdowns seem to have issues displaying properly when inside a group.");
        group.addDivider();

        group.addButton("Toggle Visibility", newToggleAction());
        group.addBreak();

        ScDropdown def;
        def = new ScDropdown();
        def.setLabel("Default");
        def.addOptions(MyEmailStatus.values());
        _defaultDropdown = def;

        ScDropdown normal;
        normal = new ScDropdown();
        normal.setLabel("Normal");
        normal.setUsesChosen(false);
        normal.addOptions(MyEmailStatus.values());
        _normalDropdown = normal;

        ScDropdown chosen;
        chosen = new ScDropdown();
        chosen.setLabel("Chosen");
        chosen.setUsesChosen(true);
        chosen.addOptions(MyEmailStatus.values());
        _chosenDropdown = chosen;

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(def);
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

    //##################################################
    //# action
    //##################################################

    private ScActionIF newToggleAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleToggle();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggle()
    {
        _defaultDropdown.ajax().toggle();
        _normalDropdown.ajax().toggle();
        _chosenDropdown.ajax().toggle();
    }
}
