package com.app.ui.page;

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyUser;

public enum MySecurityLevel
                implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    /**
     * No security.
     */
    none,

    /**
     * Requires sign in.  The user must be logged in.
     */
    user,

    /**
     * Requires a developer.  The global developer functions.  This is primarily
     * used for testing and debugging.  Developer access is highly restricted in
     * production as it allows direct access to the database sql console and other
     * sensitive tools.
     */
    developer;

    //##################################################
    //# accessing
    //##################################################

    public boolean requiresUser()
    {
        MySecurityLevel e = this;
        switch ( e )
        {
            case none:
                return false;

            case user:
            case developer:
                return true;
        }

        return true;
    }

    //##################################################
    //# check
    //##################################################

    public void check(MyUser u, MyProject p)
    {
        KmResult<Boolean> result = allows(u, p);
        if ( result.hasError() )
            throw Kmu.newSecurityError(result.getError());
    }

    //##################################################
    //# allows
    //##################################################

    /**
     * @param u The user requesting accessing.
     * @param p The project being accessed.
     */
    public KmResult<Boolean> allows(MyUser u, MyProject p)
    {
        MySecurityLevel level = this;
        switch ( level )
        {
            case none:
                return yes();

            case user:
                return allowsUser(u);

            case developer:
                return allowsDeveloper(u);
        }
        throw Kmu.newEnumError(this);
    }

    //==================================================
    //= allows :: private
    //==================================================

    private KmResult<Boolean> allowsUser(MyUser u)
    {
        if ( u == null )
            return no("Requires sign in.");

        if ( !u.isActive() )
            return no("Requires active user.");

        return yes();
    }

    private KmResult<Boolean> allowsDeveloper(MyUser u)
    {
        KmResult<Boolean> result;

        result = allowsUser(u);
        if ( result.hasError() )
            return result;

        return u.allowsDeveloper()
            ? yes()
            : no("Requires developer.");
    }

    private KmResult<Boolean> yes()
    {
        return KmResult.TRUE;
    }

    private KmResult<Boolean> no(String s)
    {
        return KmResult.createError(s);
    }

}
