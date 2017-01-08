package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.intacct.KmIntacctRequest;
import com.kodemore.utility.KmEnumIF;

import com.app.model.base.MyTenantBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.model.support.MyTheme;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public class MyTenant
    extends MyTenantBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String SYSTEM_UID = "system";

    //##################################################
    //# constructor
    //##################################################

    public MyTenant()
    {
        super();
    }

    //##################################################
    //# tenant
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return this;
    }

    //##################################################
    //# theme
    //##################################################

    public MyTheme getTheme()
    {
        return MyTheme.findCode(getThemeCode());
    }

    public void setTheme(MyTheme e)
    {
        setThemeCode(KmEnumIF.getCodeFor(e));
    }

    @Override
    public String getThemeName()
    {
        return getTheme().getLabel();
    }

    //##################################################
    //# intacct
    //##################################################

    public boolean hasIntacctConfiguration()
    {
        return hasIntacctCompanyId() && hasIntacctUserId() && hasIntacctUserPassword();
    }

    public KmIntacctRequest createIntacctRequest()
    {
        MyProperties p = MyGlobals.getProperties();

        KmIntacctRequest e;
        e = new KmIntacctRequest();
        e.setSenderId(p.getIntacctSenderId());
        e.setSenderPassword(p.getIntacctSenderPassword());
        e.setCompanyId(getIntacctCompanyId());
        e.setUserId(getIntacctUserId());
        e.setUserPassword(getIntacctUserPassword());
        return e;
    }

    //##################################################
    //# users
    //##################################################

    public KmList<MyUser> getUsersByFullName()
    {
        return getUsers().toList(e -> e.getFullName());
    }

    public MyUser findUserEmail(String email)
    {
        for ( MyUser e : getBaseUsers() )
            if ( e.hasEmail(email) )
                return e;
        return null;
    }

    //##################################################
    //# convenience
    //##################################################

    public KmList<MyProject> getProjectsByName()
    {
        return getProjects().toList(e -> e.getName().toLowerCase());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return hasName()
            ? getName()
            : "<none>";
    }
}
