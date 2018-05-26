package com.app.ui;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;

/**
 * I maintain variables that are saved in the page session but
 * aren't cleared with the page session.
 */
public class MyGlobalSession
{
    //##################################################
    //# singleton
    //##################################################

    private static MyGlobalSession _instance;

    public static void installInstance()
    {
        _instance = new MyGlobalSession();
    }

    public static MyGlobalSession getInstance()
    {
        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _currentProjectUid;

    //##################################################
    //# constructor
    //##################################################

    public MyGlobalSession()
    {
        _currentProjectUid = new ScLocalString();
        _currentProjectUid.setAutoSave();
        _currentProjectUid.setGlobal();
    }

    //##################################################
    //# project
    //##################################################

    public String getCurrentProjectUid()
    {
        return getCurrentProjectUidWrapper().getValue();
    }

    public void setCurrentProjectUid(String e)
    {
        getCurrentProjectUidWrapper().setValue(e);
    }

    public void clearCurrentProject()
    {
        getCurrentProjectUidWrapper().clearValue();
    }

    public ScLocalString getCurrentProjectUidWrapper()
    {
        return _currentProjectUid;
    }

    public MyProject getCurrentProject()
    {
        String uid = getCurrentProjectUid();
        return getAccess().findProjectUid(uid);
    }

    public void setCurrentProject(MyProject e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        setCurrentProjectUid(uid);
    }

    //##################################################
    //# install
    //##################################################

    public void installCurrentProjectFor(MyUser user)
    {
        if ( user == null )
        {
            clearCurrentProject();
            return;
        }

        MyProject p;

        p = getCurrentProject();
        if ( p != null && p.allowsMember(user) )
        {
            setCurrentProject(p);
            return;
        }

        p = user.getLastProject();
        if ( p != null && p.allowsMember(user) )
        {
            setCurrentProject(p);
            return;
        }

        MyMember m = getAccess().getMemberDao().findFirstFor(user);
        if ( m != null )
        {
            setCurrentProject(m.getProject());
            return;
        }

        p = user.getTenant().getEnabledProjectsByName().getFirstSafe();
        if ( p != null && p.allowsMember(user) )
        {
            setCurrentProject(p);
            return;
        }

        clearCurrentProject();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.instance.getAccess();
    }
}
