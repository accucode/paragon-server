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

public abstract class MyApplicationLogFilterBase
    extends MyBasicFilter<MyApplicationLog>
    implements MyApplicationLogDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyApplicationLog> c)
    {
        applyConditionsTo((MyApplicationLogCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyApplicationLog> c)
    {
        applySortsTo((MyApplicationLogCriteria)c);
    }

    protected abstract void applyConditionsTo(MyApplicationLogCriteria c);

    protected abstract void applySortsTo(MyApplicationLogCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaApplicationLog getMeta()
    {
        return MyApplicationLog.Meta;
    }

    @Override
    protected MyApplicationLogDao getDao()
    {
        return getAccess().getApplicationLogDao();
    }

    @Override
    protected MyApplicationLogCriteria createCriteria()
    {
        return new MyApplicationLogCriteria(_createCriteria());
    }
}
