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

public abstract class MySkillFilterBase
    extends MyBasicFilter<MySkill>
    implements MySkillDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MySkill> c)
    {
        applyConditionsTo((MySkillCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MySkill> c)
    {
        applySortsTo((MySkillCriteria)c);
    }

    protected abstract void applyConditionsTo(MySkillCriteria c);

    protected abstract void applySortsTo(MySkillCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSkill getMeta()
    {
        return MySkill.Meta;
    }

    @Override
    protected MySkillDao getDao()
    {
        return getAccess().getSkillDao();
    }

    @Override
    protected MySkillCriteria createCriteria()
    {
        return new MySkillCriteria(createGenericCriteria());
    }
}
