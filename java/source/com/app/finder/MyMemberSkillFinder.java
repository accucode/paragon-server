//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public class MyMemberSkillFinder
    implements KmKeyFinderIF<MyMemberSkill,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyMemberSkill staticFind(String key)
    {
        return new MyMemberSkillFinder().find(key);
    }

    public static MyMemberSkill staticFindDao(String key)
    {
        return new MyMemberSkillFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyMemberSkill find(String key)
    {
        return new MyMemberSkillDao().findUid(key);
    }

    public MyMemberSkill findDao(String key)
    {
        MyDaoKeyFinder<MyMemberSkill,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
