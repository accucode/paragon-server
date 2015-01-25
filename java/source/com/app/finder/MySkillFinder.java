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

public class MySkillFinder
    implements KmKeyFinderIF<MySkill,String>
{
    //##################################################
    //# static
    //##################################################

    public static MySkill staticFind(String key)
    {
        return new MySkillFinder().find(key);
    }

    public static MySkill staticFindDao(String key)
    {
        return new MySkillFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySkill find(String key)
    {
        return new MySkillDao().findUid(key);
    }

    public MySkill findDao(String key)
    {
        MyDaoKeyFinder<MySkill,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
