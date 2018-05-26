package com.app.utility;

import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.model.base.MyChoiceType;

/**
 * I act as a proxy for a user, am used to simplify the
 * logic for checking tenant/project level access permissions.
 */
public class MyUserProxy
{
    //##################################################
    //# instance creation
    //##################################################

    public static MyUserProxy createProxy()
    {
        MyUser user = MyGlobals.getCurrentUser();
        MyProject project = MyGlobals.getCurrentProject();
        return createProxy(user, project);
    }

    public static MyUserProxy createProxy(MyProject project)
    {
        MyUser user = MyGlobals.getCurrentUser();
        return createProxy(user, project);
    }

    public static MyUserProxy createProxy(MyUser user, MyProject project)
    {
        MyMember member = project == null
            ? null
            : project.getMemberFor(user);

        MyUserProxy e;
        e = new MyUserProxy();
        e._user = user;
        e._member = member;
        e._project = project;
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private MyUser    _user;
    private MyMember  _member;
    private MyProject _project;

    //##################################################
    //# constructor
    //##################################################

    private MyUserProxy()
    {
        // private
    }

    //##################################################
    //# user
    //##################################################

    public MyUser getUser()
    {
        return _user;
    }

    public boolean hasUser()
    {
        return _user != null;
    }

    public KmSimpleResult hasEnabledUser()
    {
        if ( !hasUser() )
            return no("Requires sign in.");

        if ( !getUser().isEnabled() )
            return no("Requires active user.");

        return yes();
    }

    //##################################################
    //# member
    //##################################################

    public MyMember getMember()
    {
        return _member;
    }

    public boolean hasMember()
    {
        return _member != null;
    }

    public KmSimpleResult hasEnabledMember()
    {
        if ( !hasMember() )
            return no("Requires project member.");

        if ( !getMember().isEnabled() )
            return no("Requires active project member.");

        return yes();
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return _project;
    }

    public boolean hasProject()
    {
        return _project != null;
    }

    public KmSimpleResult hasEnabledProject()
    {
        if ( !hasProject() )
            return no("Requires project.");

        if ( !getProject().isEnabled() )
            return no("Requires enabled project.");

        return yes();
    }

    //##################################################
    //# allows
    //##################################################

    public KmSimpleResult allowsDeveloper()
    {
        KmSimpleResult result;

        result = hasEnabledUser();
        if ( result.hasError() )
            return result;

        if ( !getUser().allowsDeveloper() )
            return no("Requires developer.");

        return yes();
    }

    public KmSimpleResult allowsTenantAdmin()
    {
        KmSimpleResult result;

        result = hasEnabledUser();
        if ( result.hasError() )
            return result;

        if ( !getUser().allowsTenantAdmin() )
            return no("Requires tenant admin.");

        return yes();
    }

    public boolean allowsProjectMember()
    {
        return checkProjectMember().isOk();
    }

    private KmSimpleResult checkProjectMember()
    {
        KmSimpleResult result;

        result = hasEnabledUser();
        if ( result.hasError() )
            return result;

        result = hasEnabledProject();
        if ( result.hasError() )
            return result;

        result = allowsTenantAdmin();
        if ( result.isOk() )
            return yes();

        result = allowsDeveloper();
        if ( result.isOk() )
            return yes();

        return hasEnabledMember();
    }

    public boolean allowsProjectManager()
    {
        return checkProjectManager().isOk();
    }

    private KmSimpleResult checkProjectManager()
    {
        KmSimpleResult result;

        result = hasEnabledUser();
        if ( result.hasError() )
            return result;

        result = hasEnabledProject();
        if ( result.hasError() )
            return result;

        result = allowsTenantAdmin();
        if ( result.isOk() )
            return yes();

        result = allowsDeveloper();
        if ( result.isOk() )
            return yes();

        if ( hasMember() && getMember().allowsManager() )
            return yes();

        return no("Requires project manager.");
    }

    public boolean allowsManageVendors()
    {
        return checkProjectManager().isOk();
    }

    public boolean allowsManageCustomerTiers()
    {
        return checkProjectManager().isOk();
    }

    public boolean allowsManageCustomers()
    {
        return checkProjectManager().isOk();
    }

    public boolean allowsManageSiteTypes()
    {
        return checkProjectManager().isOk();
    }

    public boolean allowsManageUsers()
    {
        return allowsTenantAdmin().isOk();
    }

    public boolean allowsManageSites()
    {
        return checkProjectManager().isOk();
    }

    public boolean allowsManageChoiceType(MyChoiceType type)
    {
        switch ( type )
        {
            case SiteType:
                return checkProjectMember().isOk();
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# support
    //##################################################

    private KmSimpleResult yes()
    {
        return KmSimpleResult.OK;
    }

    private KmSimpleResult no(String s)
    {
        return KmSimpleResult.createError(s);
    }
}
