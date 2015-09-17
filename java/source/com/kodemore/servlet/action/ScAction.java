package com.kodemore.servlet.action;

import com.kodemore.command.KmDao;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSignalingException;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScKeyIF;

public class ScAction
    implements ScKeyIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The unique, and permanent identifier of this action.
     * Keys must be consistently assigned and registered during application
     * startup so that all JVMs use the same keys for the same actions.
     */
    private String _key;

    /**
     * Used to find the context when checking security or processing errors.
     */
    private ScContextSupplierIF _contextSupplier;

    /**
     * The behavior to be executed.
     */
    private Runnable _runnable;

    /**
     * If true (the default) the runnable will be executed inside a hibernate
     * transaction.
     */
    private boolean _useTransaction;

    //##################################################
    //# constructor
    //##################################################

    public ScAction(ScContextSupplierIF ctx, Runnable r)
    {
        ScControlRegistry reg = ScControlRegistry.getInstance();
        _key = reg.getNextPersistentKey();
        reg.register(this);

        _contextSupplier = ctx;
        _runnable = r;
        _useTransaction = true;
    }

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
        if ( _useTransaction )
            KmDao.run(this::_run);
        else
            _run();
    }

    public void _run()
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
        catch ( KmSignalingException ex )
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
