package com.kodemore.servlet.action;

import com.kodemore.utility.Kmu;

/**
 * Some global actions.
 */
public class ScActions
{
    //##################################################
    //# instance
    //##################################################

    public static void install()
    {
        _instance = new ScActions();
    }

    public static ScActions getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    private static ScActions _instance;

    //##################################################
    //# variables
    //##################################################

    private ScActionIF       _closeDialogAction;

    //##################################################
    //# constructor
    //##################################################

    private ScActions()
    {
        _closeDialogAction = newCloseDialogAction();
    }

    private ScActionIF newCloseDialogAction()
    {
        return new ScAction()
        {
            @Override
            protected void handle()
            {
                ajax().closeDialog();
            }
        };
    }

    //##################################################
    //# accessing
    //##################################################

    public ScActionIF getCloseDialogAction()
    {
        return _closeDialogAction;
    }
}
