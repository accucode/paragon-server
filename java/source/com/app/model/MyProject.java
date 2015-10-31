package com.app.model;

import com.kodemore.collection.KmCollection;
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

    public KmList<MyMasterProduct> getMasterProductsByPartNumber()
    {
        return getMasterProducts().toList(MyMasterProduct::getPartNumber);
    }

    public KmList<MyDepot> getDepotsByName()
    {
        return getDepots().toList(MyDepot::getName);
    }

    public KmList<MyShipCarrier> getShipCarriersByName()
    {
        return getShipCarriers().toList(MyShipCarrier::getName);
    }

    public KmList<MyVendor> getVendorsByName()
    {
        return getVendors().toList(MyVendor::getName);
    }

    public KmList<MyVisitType> getVisitTypesByName()
    {
        return getVisitTypes().toList(MyVisitType::getName);
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

    public KmList<MyAttentionGroup> getAttentionGroupsByName()
    {
        return getAttentionGroups().toList(MyAttentionGroup::getName);
    }

    public KmList<MyPowerType> getPowerTypesByName()
    {
        return getPowerTypes().toList(MyPowerType::getName);
    }

    public KmList<MyProductCategory> getProductCategoriesByName()
    {
        return getProductCategories().toList(MyProductCategory::getName);
    }

    public String getNextOrderNumber()
    {
        return getAccess().getNextOrderNumberDao().getNextNumberFor(this);
    }

    public KmList<String> getNextOrderNumbers(int n)
    {
        return getAccess().getNextOrderNumberDao().getNextNumbersFor(this, n);
    }

    public KmCollection<MyAttributeField> getProductAttributes()
    {
        return getAttributeFields().select(e -> e.isCategoryProduct());
    }

    public MyAttributeField findProductAttributeName(String e)
    {
        return getProductAttributes().selectFirst(x -> x.hasName(e));
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
