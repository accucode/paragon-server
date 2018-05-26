//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyUserRecentProjectFilterBase
    extends MyBasicFilter<MyUserRecentProject>
    implements MyUserRecentProjectDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyUserRecentProject> c)
    {
        applyConditionsTo((MyUserRecentProjectCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyUserRecentProject> c)
    {
        applySortsTo((MyUserRecentProjectCriteria)c);
    }

    protected abstract void applyConditionsTo(MyUserRecentProjectCriteria c);

    protected abstract void applySortsTo(MyUserRecentProjectCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaUserRecentProject getMeta()
    {
        return MyUserRecentProject.Meta;
    }

    @Override
    protected MyUserRecentProjectDao getDao()
    {
        return getAccess().getUserRecentProjectDao();
    }

    @Override
    protected MyUserRecentProjectCriteria createCriteria()
    {
        return new MyUserRecentProjectCriteria(_createCriteria());
    }
}
