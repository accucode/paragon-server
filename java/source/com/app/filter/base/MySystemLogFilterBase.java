//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MySystemLogFilterBase
    extends MyBasicFilter<MySystemLog>
    implements MySystemLogDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MySystemLog> c)
    {
        applyConditionsTo((MySystemLogCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MySystemLog> c)
    {
        applySortsTo((MySystemLogCriteria)c);
    }

    protected abstract void applyConditionsTo(MySystemLogCriteria c);

    protected abstract void applySortsTo(MySystemLogCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSystemLog getMeta()
    {
        return MySystemLog.Meta;
    }

    @Override
    protected MySystemLogDao getDao()
    {
        return getAccess().getSystemLogDao();
    }

    @Override
    protected MySystemLogCriteria createCriteria()
    {
        return new MySystemLogCriteria(createGenericCriteria());
    }
}
