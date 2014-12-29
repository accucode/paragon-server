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

public abstract class MyMemberSkillFilterBase
    extends MyBasicFilter<MyMemberSkill>
    implements MyMemberSkillDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyMemberSkill> c)
    {
        applyConditionsTo((MyMemberSkillCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyMemberSkill> c)
    {
        applySortsTo((MyMemberSkillCriteria)c);
    }

    protected abstract void applyConditionsTo(MyMemberSkillCriteria c);

    protected abstract void applySortsTo(MyMemberSkillCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaMemberSkill getMeta()
    {
        return MyMemberSkill.Meta;
    }

    @Override
    protected MyMemberSkillDao getDao()
    {
        return getAccess().getMemberSkillDao();
    }

    @Override
    protected MyMemberSkillCriteria createCriteria()
    {
        return new MyMemberSkillCriteria(createGenericCriteria());
    }
}
