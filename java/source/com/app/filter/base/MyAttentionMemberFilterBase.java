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

public abstract class MyAttentionMemberFilterBase
    extends MyBasicFilter<MyAttentionMember>
    implements MyAttentionMemberDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAttentionMember> c)
    {
        applyConditionsTo((MyAttentionMemberCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAttentionMember> c)
    {
        applySortsTo((MyAttentionMemberCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAttentionMemberCriteria c);

    protected abstract void applySortsTo(MyAttentionMemberCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAttentionMember getMeta()
    {
        return MyAttentionMember.Meta;
    }

    @Override
    protected MyAttentionMemberDao getDao()
    {
        return getAccess().getAttentionMemberDao();
    }

    @Override
    protected MyAttentionMemberCriteria createCriteria()
    {
        return new MyAttentionMemberCriteria(_createCriteria());
    }
}
