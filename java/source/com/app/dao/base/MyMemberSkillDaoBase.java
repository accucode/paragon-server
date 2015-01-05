//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyMemberSkillCriteria;
import com.app.model.MyMemberSkill;
import com.app.model.meta.MyMetaMemberSkill;

public abstract class MyMemberSkillDaoBase
    extends KmAbstractDao<MyMemberSkill,String>
    implements MyMemberSkillDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSkillDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyMemberSkill> getPersistentClass()
    {
        return MyMemberSkill.class;
    }

    @Override
    protected String getTableName()
    {
        return "memberSkill";
    }

    @Override
    public MyMemberSkillCriteria createCriteria()
    {
        return new MyMemberSkillCriteria(createGenericCriteria());
    }

    protected MyMetaMemberSkill getMeta()
    {
        return MyMemberSkill.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyMemberSkill findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyMemberSkill m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
