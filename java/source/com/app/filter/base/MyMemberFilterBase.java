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

public abstract class MyMemberFilterBase
    extends MyBasicFilter<MyMember>
    implements MyMemberDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyMember> c)
    {
        applyConditionsTo((MyMemberCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyMember> c)
    {
        applySortsTo((MyMemberCriteria)c);
    }

    protected abstract void applyConditionsTo(MyMemberCriteria c);

    protected abstract void applySortsTo(MyMemberCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaMember getMeta()
    {
        return MyMember.Meta;
    }

    @Override
    protected MyMemberDao getDao()
    {
        return getAccess().getMemberDao();
    }

    @Override
    protected MyMemberCriteria createCriteria()
    {
        return new MyMemberCriteria(createGenericCriteria());
    }
}
