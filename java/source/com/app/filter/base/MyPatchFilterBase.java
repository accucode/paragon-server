//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyPatchCriteria;
import com.app.dao.MyPatchDao;
import com.app.dao.base.MyPatchDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyPatch;
import com.app.model.meta.MyMetaPatch;

import com.kodemore.hibernate.criteria.KmModelCriteria;

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
