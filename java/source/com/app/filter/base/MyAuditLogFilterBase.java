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

public abstract class MyAuditLogFilterBase
    extends MyBasicFilter<MyAuditLog>
    implements MyAuditLogDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAuditLog> c)
    {
        applyConditionsTo((MyAuditLogCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAuditLog> c)
    {
        applySortsTo((MyAuditLogCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAuditLogCriteria c);

    protected abstract void applySortsTo(MyAuditLogCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAuditLog getMeta()
    {
        return MyAuditLog.Meta;
    }

    @Override
    protected MyAuditLogDao getDao()
    {
        return getAccess().getAuditLogDao();
    }

    @Override
    protected MyAuditLogCriteria createCriteria()
    {
        return new MyAuditLogCriteria(_createCriteria());
    }
}
