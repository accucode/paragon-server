//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.dao.base;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MySkillDaoBase
    extends KmAbstractDao<MySkill,String>
    implements MySkillDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySkillDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySkill> getPersistentClass()
    {
        return MySkill.class;
    }

    @Override
    protected String getTableName()
    {
        return "skill";
    }

    @Override
    public MySkillCriteria createCriteria()
    {
        return new MySkillCriteria(createGenericCriteria());
    }

    protected MyMetaSkill getMeta()
    {
        return MySkill.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySkill findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySkill m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
