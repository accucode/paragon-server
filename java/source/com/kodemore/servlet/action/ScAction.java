package com.kodemore.servlet.action;

import com.kodemore.command.KmDao;
import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.dao.KmDaoSessionManager;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScActionRegistry;
import com.kodemore.utility.Kmu;

public class ScAction
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The unique, and permanent identifier of this action.
     * Keys must be consistently assigned and registered during application
     * startup so that all JVMs use the same keys for the same actions.
     */
    private int _key;

    /**
     * Used to check security and handle errors.
     */
    private ScContextSupplierIF _contextSupplier;

    /**
     * An optional name used for logging.  Logs automatically include the
     * name of the context, but in some cases it may be usefult to have a
     * more specific name appended to the context.
     */
    private String _name;

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
     * By default, action use client-side javascript to check for unsaved changes
     * before posting the ajax action (see changeTracking).
     *
     * The normal behavior uses the _contextSupplier to find an enclosing scope,
     * e.g., an ScNavigator.  If an enclosing scope is found, then we only check
     * for unsaved changes inside that scope. If no scope is found, the entire
     * page is checked for unsaved changes.
     *
     * This value allows us to override the default behavior.
     * If set, then unsaved changes are only checked inside this container.
     */
    private ScHtmlIdIF _changeTrackingScopeOverride;

    /**
     * If true, the slow command warning will be disabled.
     * This is false by default, but is particularly useful for development
     * tools that are expected to take more than a few seconds to run.
     */
    private boolean _disableSlowCommandWarning;

    /**
     * If set this wedge is executed between run() and handle().
     * Clients should generally NOT use this.  It is intended
     * as a way for certain framework code to perform special setup
     * before calling handle.
     */
    private Runnable _wedge;

    //##################################################
    //# constructor
    //##################################################

    public ScAction(ScContextSupplierIF ctx, Runnable r)
    {
        ScActionRegistry reg = ScActionRegistry.getInstance();
        reg.register(this);

        _contextSupplier = ctx;
        _runnable = r;
        _useTransaction = true;
        _changeTracking = true;
        _changeTrackingScopeOverride = null;
        _disableSlowCommandWarning = false;
    }

    //##################################################
    //# key
    //##################################################

    public int getKey()
    {
        return _key;
    }

    public void registerKey(int e)
    {
        _key = e;
    }

    public boolean hasKey(int e)
    {
        return _key == e;
    }

    //##################################################
    //# transaction
    //##################################################

    public boolean getUseTransaction()
    {
        return _useTransaction;
    }

    public void setUseTransaction(boolean e)
    {
        _useTransaction = e;
    }

    public void disableTransaction()
    {
        setUseTransaction(false);
    }

    //##################################################
    //# security manager
    //##################################################

    public ScSecurityManagerIF getSecurityManager()
    {
        return _contextSupplier == null
            ? null
            : _contextSupplier.getSecurityManager();
    }

    public boolean hasSecurityManager()
    {
        return getSecurityManager() != null;
    }

    //##################################################
    //# error manager
    //##################################################

    public ScErrorManagerIF getErrorManager()
    {
        return _contextSupplier == null
            ? null
            : _contextSupplier.getErrorManager();
    }

    public boolean hasErrorManager()
    {
        return getErrorManager() != null;
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
    //# change tracking scope
    //##################################################

    public ScHtmlIdIF getChangeTrackingScope()
    {
        return hasChangeTrackingScopeOverride()
            ? getChangeTrackingScopeOverride()
            : findChangeTrackingScopeWrapper();
    }

    public boolean hasChangeTrackingScope()
    {
        return getChangeTrackingScope() != null;
    }

    //==================================================
    //= override
    //==================================================

    public ScHtmlIdIF getChangeTrackingScopeOverride()
    {
        return _changeTrackingScopeOverride;
    }

    public void setChangeTrackingScopeOverride(ScHtmlIdIF e)
    {
        _changeTrackingScopeOverride = e;
    }

    public boolean hasChangeTrackingScopeOverride()
    {
        return _changeTrackingScopeOverride != null;
    }

    //==================================================
    //= find
    //==================================================

    private ScHtmlIdIF findChangeTrackingScopeWrapper()
    {
        if ( !(_contextSupplier instanceof ScControl) )
            return null;

        ScControl c = (ScControl)_contextSupplier;
        while ( true )
        {
            if ( c == null )
                return null;

            if ( c.isChangeTrackingScope() )
                return c.asChangeTrackingScope();

            c = c.getParent();
        }
    }

    //##################################################
    //# wedge
    //##################################################

    public Runnable getWedge()
    {
        return _wedge;
    }

    public void setWedge(Runnable e)
    {
        _wedge = e;
    }

    public boolean hasWedge()
    {
        return getWedge() != null;
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
        return _key;
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
        try
        {
            checkSecurity();

            if ( hasWedge() )
                getWedge().run();

            _runnable.run();
        }
        catch ( KmApplicationException ex )
        {
            ScErrorManagerIF errMgr = getErrorManager();
            if ( errMgr == null )
                throw ex;

            errMgr.handleError(ex);
        }
    }

    private void checkSecurity()
    {
        ScSecurityManagerIF secMgr = getSecurityManager();
        if ( secMgr == null )
            return;

        if ( KmDaoSessionManager.getInstance().hasSession() )
            secMgr.checkSecurity();
        else
            KmDao.run(secMgr::checkSecurity);
    }
}
