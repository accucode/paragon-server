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

public abstract class MyEmailPartFilterBase
    extends MyBasicFilter<MyEmailPart>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyEmailPart> c)
    {
        applyConditionsTo((MyEmailPartCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyEmailPart> c)
    {
        applySortsTo((MyEmailPartCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEmailPartCriteria c);

    protected abstract void applySortsTo(MyEmailPartCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEmailPart getMeta()
    {
        return MyEmailPart.Meta;
    }

    @Override
    protected MyEmailPartDao getDao()
    {
        return getAccess().getEmailPartDao();
    }

    @Override
    protected MyEmailPartCriteria createCriteria()
    {
        return new MyEmailPartCriteria(_createCriteria());
    }
}
