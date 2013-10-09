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

public abstract class MyPatchFilterBase
    extends MyBasicFilter<MyPatch>
    implements MyPatchDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyPatch> c)
    {
        applyConditionsTo((MyPatchCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyPatch> c)
    {
        applySortsTo((MyPatchCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPatchCriteria c);

    protected abstract void applySortsTo(MyPatchCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPatch getMeta()
    {
        return MyPatch.Meta;
    }

    @Override
    protected MyPatchDao getDao()
    {
        return getAccess().getPatchDao();
    }

    @Override
    protected MyPatchCriteria createCriteria()
    {
        return new MyPatchCriteria(createGenericCriteria());
    }
}
