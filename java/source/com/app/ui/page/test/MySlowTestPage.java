package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

public class MySlowTestPage
    extends MyTestPage
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
    public void initUrlFromSession(ScParameterList v)
    {
        // none
    }

    @Override
    public void initSessionFromUrl(ScParameterList v)
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
        group = root.addGroup("Test slow responses");
        group.addPad().addText(
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

        ScBox buttons;
        buttons = group.addButtonBox();
        buttons.add(newButton(0));
        buttons.add(newButton(10));
        buttons.add(newButton(20));
        buttons.add(newButton(50));
        buttons.add(newButton(100));
        buttons.add(newButton(200));
        buttons.add(newButton(500));
        buttons.add(newButton(1000));
        buttons.add(newButton(2000));
        buttons.add(newButton(5000));
        buttons.add(newButton(10000));
    }

    private ScButton newButton(int ms)
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText(ms + " ms");
        e.setAction(newDelayAction(ms));
        return e;
    }

    private ScActionIF newDelayAction(final int ms)
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDelay(ms);
            }
        };
    }

    private void handleDelay(int ms)
    {
        Kmu.sleepMs(ms);
        ajax().toast("Delayed %s ms.", ms);
    }

}
