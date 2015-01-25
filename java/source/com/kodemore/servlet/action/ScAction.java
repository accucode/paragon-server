package com.kodemore.servlet.action;

import com.kodemore.command.KmDaoRollbackException;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScKeyIF;

public class ScAction
    implements ScKeyIF
{
    //##################################################
    //# constructor
    //##################################################

    public ScAction(ScContextSupplierIF ctx, Runnable r)
    {
        _key = ScControlRegistry.getInstance().getNextPersistentKey();
        _contextSupplier = ctx;
        _runnable = r;

        ScControlRegistry.getInstance().register(this);
    }

    //##################################################
    //# variables
    //##################################################

    private String              _key;
    private ScContextSupplierIF _contextSupplier;
    private Runnable            _runnable;

    //##################################################
    //# key
    //##################################################

    @Override
    public String getKey()
    {
        return _key;
    }

    public boolean hasKey(String s)
    {
        return _key.equals(s);
    }

    //##################################################
    //# context
    //##################################################

    public ScContextIF getContext()
    {
        if ( _contextSupplier == null )
            return null;

        return _contextSupplier.getContext();
    }

    public boolean hasContext()
    {
        return getContext() != null;
    }

    //##################################################
    //# equals
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( e instanceof ScAction )
            return ((ScAction)e).hasKey(_key);

        return false;
    }

    @Override
    public int hashCode()
    {
        return _key.hashCode();
    }

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        try
        {
            getContext().checkSecurity();
            _runnable.run();
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
}
