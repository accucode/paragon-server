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
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    private static ScActions _instance;

    //##################################################
    //# variables
    //##################################################

    /**
     * A global noop (Non Operation).
     */
    private ScAction         _noopAction;

    //##################################################
    //# constructor
    //##################################################

    private ScActions()
    {
        ScGlobalContext globalCtx = ScGlobalContext.getInstance();

        _noopAction = new ScAction(globalCtx, this::handleNoop);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScAction getNoopAction()
    {
        return _noopAction;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleNoop()
    {
        // do nothing
    }

}
