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

public abstract class MyAttentionGroupFilterBase
    extends MyBasicFilter<MyAttentionGroup>
    implements MyAttentionGroupDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyAttentionGroup> c)
    {
        applyConditionsTo((MyAttentionGroupCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyAttentionGroup> c)
    {
        applySortsTo((MyAttentionGroupCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAttentionGroupCriteria c);

    protected abstract void applySortsTo(MyAttentionGroupCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAttentionGroup getMeta()
    {
        return MyAttentionGroup.Meta;
    }

    @Override
    protected MyAttentionGroupDao getDao()
    {
        return getAccess().getAttentionGroupDao();
    }

    @Override
    protected MyAttentionGroupCriteria createCriteria()
    {
        return new MyAttentionGroupCriteria(createGenericCriteria());
    }
}
