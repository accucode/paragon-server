package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

public class MySlowTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySlowTestPage instance = new MySlowTestPage();

    private MySlowTestPage()
    {
        // singleton
    }

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
        root.css().pad();

        ScGroup group;
        group = root.addGroup("Slow Response Tests");
        group.getBody().addPad().addText(
            ""
                + "Test slow server side response.  The framework automatically"
                + " blocks the user interface during ajax submits.  The blocking"
                + " is controlled by client side code.  The general pattern is"
                + " to immediately block the pertinent section BEFORE submiting"
                + " the ajax request.  The initial block is transparent but "
                + " captures all key and mouse input.  Additionally, the tranparent"
                + " block is changed to semi-opaque (with a message) if a client"
                + " side timer expires before the ajax response is received.  The"
                + " timerout is typically set to something like 200ms.  The current"
                + " value can be found in the javascript file KmUtility.js; see"
                + " blockDelayMs variable.");

        ScAction action = createAction(this::handleDelay);

        ScBox buttons;
        buttons = group.getBody().addButtonBox();
        buttons.add(newButton(action, 0));
        buttons.add(newButton(action, 10));
        buttons.add(newButton(action, 20));
        buttons.add(newButton(action, 50));
        buttons.add(newButton(action, 100));
        buttons.add(newButton(action, 200));
        buttons.add(newButton(action, 500));
        buttons.add(newButton(action, 1000));
        buttons.add(newButton(action, 2000));
        buttons.add(newButton(action, 5000));
        buttons.add(newButton(action, 10000));
    }

    private ScButton newButton(ScAction action, int ms)
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText(ms + " ms");
        e.setAction(action, ms);
        return e;
    }

    private void handleDelay()
    {
        Integer ms = getData().getIntegerArgument();
        Kmu.sleepMs(ms);
        ajax().toast("Delayed %s ms.", ms);
    }

}
