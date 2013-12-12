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

public abstract class MyEmailFilterBase
    extends MyBasicFilter<MyEmail>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyEmail> c)
    {
        applyConditionsTo((MyEmailCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyEmail> c)
    {
        applySortsTo((MyEmailCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEmailCriteria c);

    protected abstract void applySortsTo(MyEmailCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEmail getMeta()
    {
        return MyEmail.Meta;
    }

    @Override
    protected MyEmailDao getDao()
    {
        return getAccess().getEmailDao();
    }

    @Override
    protected MyEmailCriteria createCriteria()
    {
        return new MyEmailCriteria(createGenericCriteria());
    }
}
