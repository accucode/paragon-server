package com.kodemore.servlet.action;

import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSignalingException;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScKeyIF;
import com.kodemore.utility.Kmu;

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
     * Used to check security and handle errors.
     */
    private ScContextSupplierIF _contextSupplier;

    /**
     * An optional name used for logging.  Logs automatically include the
     * name of the context, but in some cases it may be usefult to have a
     * more specific name appended to the context.
     */
    private String   _name;
    /**
     * The behavior to be executed.
     */
    private Runnable _runnable;

    /**
     * If true (the default) the runnable will be executed inside a
     * hibernate (database) transaction.
     */
    private boolean _useTransaction;

    /**
     * If true (the default) the client browser warn the user if there
     * are any dirty fields before submitting the action.
     */
    private boolean _changeTracking;

    /**
     * If true, the slow command warning will be disabled.
     * This is false by default, but is particularly useful for development
     * tools that are expected to take more than a few seconds to run.
     */
    private boolean _disableSlowCommandWarning;

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
        _changeTracking = true;
        _disableSlowCommandWarning = false;
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
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public String getFullName()
    {
        String c = hasContext()
            ? getContext().getClass().getSimpleName()
            : "noContext";

        return hasName()
            ? c + "." + getName()
            : c;
    }

    //##################################################
    //# change tracking
    //##################################################

    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# slow warning
    //##################################################

    public boolean getDisableSlowCommandWarning()
    {
        return _disableSlowCommandWarning;
    }

    public void disableSlowCommandWarning()
    {
        _disableSlowCommandWarning = true;
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
            _runInTransaction();
        else
            _run();
    }

    private void _runInTransaction()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(this::_run);

        if ( _disableSlowCommandWarning )
            cmd.disableWarningThresholdMs();

        cmd.run();
    }

    private void _run()
    {
        ScContextIF ctx = getContext();
        try
        {
            if ( ctx != null )
                ctx.checkSecurity();

            _runnable.run();
        }
        catch ( KmApplicationException ex )
        {
            if ( ctx == null )
                throw ex;

            ctx.handleError(ex);
        }
        catch ( KmSignalingException ex )
        {
            throw ex;
        }
        catch ( RuntimeException ex )
        {
            if ( ctx == null )
                throw ex;

            ctx.handleFatal(ex);
        }
    }
}
