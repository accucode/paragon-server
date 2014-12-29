package com.kodemore.servlet.action;

import com.kodemore.command.KmDaoRollbackException;
import com.kodemore.exception.KmApplicationException;

public abstract class ScAction
    extends ScAbstractAction
{
    //##################################################
    //# constructor
    //##################################################

    protected ScAction(ScActionContextIF context)
    {
        super(context);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void run()
    {
        try
        {
            getContext().checkSecurity();
            handle();
        }
        catch ( KmApplicationException ex )
        {
            if ( !hasContext() )
                throw ex;

            getContext().handleError(ex);
        }
        catch ( KmDaoRollbackException ex )
        {
            throw ex;
        }
        catch ( RuntimeException ex )
        {
            if ( !hasContext() )
                throw ex;

            getContext().handleFatal(ex);
        }
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getJavascriptFunction()
    {
        return "Kmu.ajaxRequest";
    }
}
