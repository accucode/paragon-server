package com.kodemore.servlet.action;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * The single global context.  This is primarily used by a few
 * actions that can safely assume an non-secure context that
 * doesn't display errors to the user.
 */
public class ScGlobalContext
    implements ScContextSupplierIF, ScSecurityManagerIF, ScErrorManagerIF
{
    //##################################################
    //# instance
    //##################################################

    public static void install()
    {
        _instance = new ScGlobalContext();
    }

    public static ScGlobalContext getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    private static ScGlobalContext _instance;

    //##################################################
    //# constructor
    //##################################################

    private ScGlobalContext()
    {
        // private
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public void checkSecurity()
    {
        // no security check
    }

    @Override
    public void handleError(KmApplicationException ex)
    {
        KmLog.error(ex, "Application error in global context.");
        throw Kmu.newRollbackException();
    }

    //##################################################
    //# supplier
    //##################################################

    @Override
    public ScSecurityManagerIF getSecurityManager()
    {
        return this;
    }

    @Override
    public ScErrorManagerIF getErrorManager()
    {
        return this;
    }

    //##################################################
    //# action
    //##################################################

    public ScAction newCheckedAction(Runnable r)
    {
        return new ScAction(this, r);
    }
}
