package com.kodemore.servlet.action;

import com.kodemore.command.KmDaoRollbackException;
import com.kodemore.exception.KmApplicationException;

public abstract class ScAction
    extends ScAbstractAction
{
    //##################################################
    //# instance creation
    //##################################################

    public static ScAction create(ScContextSupplierIF ctx, Runnable r)
    {
        return new ScAction(ctx)
        {
            @Override
            public void handle()
            {
                r.run();
            }
        };
    }

    //##################################################
    //# constructor
    //##################################################

    protected ScAction(ScContextSupplierIF e)
    {
        super(e);
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
