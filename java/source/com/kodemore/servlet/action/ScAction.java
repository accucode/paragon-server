package com.kodemore.servlet.action;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmCancelException;

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
        catch ( KmCancelException ex )
        {
            // none
        }
        catch ( KmApplicationException ex )
        {
            if ( !hasContext() )
                throw ex;

            getContext().handleError(ex);
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
