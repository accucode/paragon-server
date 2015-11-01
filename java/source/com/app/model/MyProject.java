package com.app.model;

import com.kodemore.collection.KmList;

import com.app.model.base.MyProjectBase;

public class MyProject
    extends MyProjectBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyProject()
    {
        super();
    }

    //##################################################
    //# members
    //##################################################

    public MyMember getMemberFor(MyUser user)
    {
        return getMembers().detect(e -> e.hasUser(user));
    }

    public boolean hasMember(MyUser u)
    {
        return getMemberFor(u) != null;
    }

    public KmList<MyMember> getMembersByName()
    {
        KmList<MyMember> v;
        v = getMembers().toList();
        v.sortOn(MyMember::getUserName);
        return v;
    }

    /**
     * Determines if the user is allowed member-level access to this project.
     */
    public boolean allowsMember(MyUser u)
    {
        return hasMember(u) || u.allowsAdmin();
    }

    public boolean hasManager(MyUser u)
    {
        MyMember e = getMemberFor(u);
        if ( e == null )
            return false;

        return e.isRoleManager();
    }

    //##################################################
    //# convenience
    //##################################################

    public KmList<MyDepot> getDepotsByName()
    {
        return getDepots().toList(MyDepot::getName);
    }

    public KmList<MyVendor> getVendorsByName()
    {
        return getVendors().toList(MyVendor::getName);
    }

    public KmList<MySkill> getSkillsByName()
    {
        return getSkills().toList(MySkill::getName);
    }

    public KmList<MySkill> findSkillUids(KmList<String> uids)
    {
        KmList<MySkill> v = new KmList<>();

        for ( String uid : uids )
            v.add(findSkillUid(uid));

        return v;
    }

    public KmList<String> getSkillNames()
    {
        return getSkillsByName().collect(e -> e.getName());
    }

    public KmList<MyRegion> getRegionsByName()
    {
        return getRegions().toList(MyRegion::getName);
    }

    public MyMember findMember(MyUser e)
    {
        return getAccess().getMemberDao().findMember(this, e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
