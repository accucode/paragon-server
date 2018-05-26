package com.app.ui.page;

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.KmSimpleResult;
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
     * Requires project member.  A project must be selected, and the current user
     * must be a member of the selected project.
     */
    projectMember,

    /**
     * Requires project member.  A project must be selected, and the current user
     * must be a worker of the selected project.  Pages that require a worker may
     * aslo be viewed by managers.
     */
    projectWorker,

    /**
     * Requires project manager.  A project must be selected, and the current user
     * must be a manager of the selected project.
     */
    projectManager,

    /**
     * Requires a tenant admin. The tenant admin functions allow the user to
     * create new projects and perform other operations that affect multiple
     * projects within a single tenant.
     */
    tenantAdmin,

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
            case projectMember:
            case projectWorker:
            case projectManager:
            case tenantAdmin:
            case developer:
                return true;
        }

        return true;
    }

    //##################################################
    //# allows
    //##################################################

    public KmSimpleResult allows(MyUser u, MyProject p)
    {
        MySecurityLevel level = this;
        switch ( level )
        {
            case none:
                return yes();

            case user:
                return allowsUser(u);

            case projectMember:
                return allowsProjectMember(u, p);

            case projectWorker:
                return allowsProjectWorker(u, p);

            case projectManager:
                return allowsProjectManager(u, p);

            case tenantAdmin:
                return allowsTenantAdmin(u);

            case developer:
                return allowsDeveloper(u);
        }
        throw Kmu.newEnumError(this);
    }

    //==================================================
    //= allows :: private
    //==================================================

    private KmSimpleResult allowsUser(MyUser u)
    {
        if ( u == null )
            return no("Requires sign in.");

        if ( !u.isEnabled() )
            return no("Requires active user.");

        return yes();
    }

    private KmSimpleResult allowsProject(MyProject p)
    {
        if ( p == null )
            return no("Requires project.");

        if ( !p.isEnabled() )
            return no("Requires active project.");

        return yes();
    }

    private KmSimpleResult allowsProjectMember(MyUser u, MyProject p)
    {
        KmSimpleResult result;

        result = allowsUser(u);
        if ( result.hasError() )
            return result;

        result = allowsProject(p);
        if ( result.hasError() )
            return result;

        if ( u.allowsDeveloper() )
            return yes();

        if ( u.allowsTenantAdmin() )
            return yes();

        return p.hasMember(u)
            ? yes()
            : no("Requires project member.");
    }

    private KmSimpleResult allowsProjectWorker(MyUser u, MyProject p)
    {
        KmSimpleResult result;

        result = allowsUser(u);
        if ( result.hasError() )
            return result;

        result = allowsProject(p);
        if ( result.hasError() )
            return result;

        if ( p.hasManager(u) )
            return yes();

        if ( u.allowsDeveloper() )
            return yes();

        if ( u.allowsTenantAdmin() )
            return yes();

        return p.hasWorker(u)
            ? yes()
            : no("Requires project worker.");
    }

    private KmSimpleResult allowsProjectManager(MyUser u, MyProject p)
    {
        KmSimpleResult result;

        result = allowsUser(u);
        if ( result.hasError() )
            return result;

        result = allowsProject(p);
        if ( result.hasError() )
            return result;

        if ( u.allowsDeveloper() )
            return yes();

        if ( u.allowsTenantAdmin() )
            return yes();

        return p.hasManager(u)
            ? yes()
            : no("Requires project manager.");
    }

    private KmSimpleResult allowsTenantAdmin(MyUser u)
    {
        KmSimpleResult result;

        result = allowsUser(u);
        if ( result.hasError() )
            return result;

        if ( u.allowsTenantAdmin() )
            return yes();

        return u.allowsTenantAdmin()
            ? yes()
            : no("Requires tenant admin.");
    }

    private KmSimpleResult allowsDeveloper(MyUser u)
    {
        KmSimpleResult result;

        result = allowsUser(u);
        if ( result.hasError() )
            return result;

        return u.allowsDeveloper()
            ? yes()
            : no("Requires developer.");
    }

    private KmSimpleResult yes()
    {
        return KmSimpleResult.OK;
    }

    private KmSimpleResult no(String s)
    {
        return KmSimpleResult.createError(s);
    }
}
