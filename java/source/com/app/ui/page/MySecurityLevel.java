package com.app.ui.page;

import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyUser;

public enum MySecurityLevel
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
     * Requires project member.  A project must be selected, and the current user
     * must be a member of the selected project.
     */
    member,

    /**
     * Requires project manager.  A project must be selected, and the current user
     * must be a manager of the selected project.
     */
    manager,

    /**
     * Requires an admin.  The global admin functions, generally limited to a few
     * features such as creating new projects and managing user profiles across
     * multiple projects.
     */
    admin,

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
            case member:
            case manager:
            case admin:
            case developer:
                return true;
        }

        return true;
    }

    public void check(MyUser u, MyProject p)
    {
        MySecurityLevel e = this;
        switch ( e )
        {
            case none:
                checkAny();
                break;

            case user:
                checkUser(u);
                break;

            case member:
                checkMember(u, p);
                break;

            case manager:
                checkManager(u, p);
                break;

            case admin:
                checkAdmin(u);
                break;

            case developer:
                checkDeveloper(u);
                break;
        }
    }

    //##################################################
    //# support
    //##################################################

    private void checkAny()
    {
        // none
    }

    private void checkUser(MyUser u)
    {
        if ( u == null )
            securityError("Requires sign in.");
    }

    private void checkProject(MyProject p)
    {
        if ( p == null )
            securityError("Requires project.");
    }

    private void checkMember(MyUser u, MyProject p)
    {
        checkUser(u);
        checkProject(p);

        if ( p.hasMember(u) || u.allowsAdmin() )
            return;

        securityError("Requires project member");
    }

    private void checkManager(MyUser u, MyProject p)
    {
        checkUser(u);
        checkProject(p);

        if ( p.hasManager(u) || u.allowsAdmin() )
            return;

        securityError("Requires project manager");
    }

    private void checkAdmin(MyUser u)
    {
        checkUser(u);

        if ( u.allowsAdmin() )
            return;

        securityError("Requires admin.");
    }

    private void checkDeveloper(MyUser u)
    {
        checkUser(u);

        if ( u.allowsDeveloper() )
            return;

        securityError("Requires developer.");
    }

    private void securityError(String msg)
    {
        Kmu.throwSecurityError(msg);
    }

}
