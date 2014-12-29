package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.match.KmMatchIF;

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
        KmMatchIF<MyMember> match = MyMember.Meta.User.getMatch(user);
        return getMembers().selectFirst(match);
    }

    public boolean hasMember(MyUser u)
    {
        return getMemberFor(u) != null;
    }

    public KmList<MyMember> getMembersByName()
    {
        KmList<MyMember> v;
        v = getMembers().toList();
        v.sortOn(MyMember.Meta.UserName);
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

    public KmList<MyProduct> getProductsByName()
    {
        return getProducts().toList(MyProduct.Meta.Name);
    }

    public KmList<MyDepot> getDepotsByName()
    {
        return getDepots().toList(MyDepot.Meta.Name);
    }

    public KmList<MyShipCarrier> getShipCarriersByName()
    {
        return getShipCarriers().toList(MyShipCarrier.Meta.Name);
    }

    public KmList<MyVendor> getVendorsByName()
    {
        return getVendors().toList(MyVendor.Meta.Name);
    }

    public KmList<MyVisitType> getVisitTypesByName()
    {
        return getVisitTypes().toList(MyVisitType.Meta.Name);
    }

    public KmList<MySkill> getSkillsByName()
    {
        return getSkills().toList(MySkill.Meta.Name);
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
        return getSkillsByName().collect(MySkill.Meta.Name);
    }

    public KmList<MyRegion> getRegionsByName()
    {
        return getRegions().toList(MyRegion.Meta.Name);
    }

    public KmList<MyCategory> getCategoriesByName()
    {
        return getCategories().toList(MyCategory.Meta.Name);
    }

    public KmList<MyPowerType> getPowerTypesByName()
    {
        return getPowerTypes().toList(MyPowerType.Meta.Name);
    }

}
