package com.app.model;

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyMemberBase;

public class MyMember
    extends MyMemberBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyMember()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public MyMemberSkill getMemberSkillFor(MySkill skill)
    {
        for ( MyMemberSkill e : getMemberSkills() )
            if ( e.hasSkill(skill) )
                return e;

        return null;
    }

    public MyMemberSkill lazyGetMemberSkillFor(MySkill skill)
    {
        MyMemberSkill e = getMemberSkillFor(skill);
        if ( e == null )
        {
            e = addMemberSkill();
            e.setSkill(skill);
        }
        return e;
    }

    public KmList<MySkill> getSkills()
    {
        return getSortedMemberSkills().collect(e -> e.getSkill());
    }

    @Override
    public String getSkillNames()
    {
        return getSkills().join(e -> e.getName());
    }

    public void setSkills(List<MySkill> v)
    {
        for ( MyMemberSkill ms : getMemberSkills().getShallowCopy() )
            if ( !v.contains(ms.getSkill()) )
                removeMemberSkill(ms);

        int i = 0;
        for ( MySkill s : v )
        {
            MyMemberSkill ms;
            ms = lazyGetMemberSkillFor(s);
            ms.setSequence(i);
            i++;
        }
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getSubtitle()
    {
        return Kmu.format("%s (%s)", getUserEmail(), getRoleName());
    }

    //##################################################
    //# debug
    //##################################################

    public void printSkills()
    {
        KmLog.info("%s: %s", getUserName(), getSkillNames());
    }
}
