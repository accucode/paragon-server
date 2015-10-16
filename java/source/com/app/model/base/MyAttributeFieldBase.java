//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyAttributeFieldBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAttributeField Meta = MyMetaAttributeField.instance;
    public static final MyAttributeFieldTools Tools = MyAttributeFieldTools.instance;
    public static final MyAttributeFieldValidator Validator = MyAttributeFieldValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String categoryCode;
    private String name;
    private Boolean active;
    private Integer lockVersion;
    private MyProject project;
    private List<MyAttributeValue> values;

    //##################################################
    //# constructor
    //##################################################

    public MyAttributeFieldBase()
    {
        super();
        setUid(newUid());
        setActive(false);
        values = new ArrayList<>();
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        checkReadOnly();
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (categoryCode)
    //##################################################

    public String getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(String e)
    {
        checkReadOnly();
        e = Validator.getCategoryCodeValidator().convertOnly(e);
        categoryCode = e;
    }

    public void clearCategoryCode()
    {
        setCategoryCode(null);
    }

    public boolean hasCategoryCode()
    {
        return Kmu.hasValue(getCategoryCode());
    }

    public boolean hasCategoryCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getCategoryCode(), e);
    }

    public void truncateCategoryCode()
    {
        truncateCategoryCode(false);
    }

    public void truncateCategoryCode(boolean ellipses)
    {
        categoryCode = Kmu.truncate(categoryCode, 1, ellipses);
    }

    public MyAttributeFieldCategory getCategory()
    {
        return MyAttributeFieldCategory.findCode(getCategoryCode());
    }

    public void setCategory(MyAttributeFieldCategory e)
    {
        if ( e == null )
            setCategoryCode(null);
        else
            setCategoryCode(e.getCode());
    }

    public boolean hasCategory()
    {
        return getCategory() != null;
    }

    public boolean hasCategory(MyAttributeFieldCategory e)
    {
        return getCategory() == e;
    }

    public void setCategorySite()
    {
        setCategory(MyAttributeFieldCategory.Site);
    }

    public boolean isCategorySite()
    {
        return hasCategory(MyAttributeFieldCategory.Site);
    }

    public boolean isNotCategorySite()
    {
        return !isCategorySite();
    }

    public void setCategoryProduct()
    {
        setCategory(MyAttributeFieldCategory.Product);
    }

    public boolean isCategoryProduct()
    {
        return hasCategory(MyAttributeFieldCategory.Product);
    }

    public boolean isNotCategoryProduct()
    {
        return !isCategoryProduct();
    }

    public void setCategoryOrderLine()
    {
        setCategory(MyAttributeFieldCategory.OrderLine);
    }

    public boolean isCategoryOrderLine()
    {
        return hasCategory(MyAttributeFieldCategory.OrderLine);
    }

    public boolean isNotCategoryOrderLine()
    {
        return !isCategoryOrderLine();
    }

    //##################################################
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        checkReadOnly();
        e = Validator.getNameValidator().convertOnly(e);
        name = e;
    }

    public void clearName()
    {
        setName(null);
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqualIgnoreCase(getName(), e);
    }

    public void truncateName()
    {
        truncateName(false);
    }

    public void truncateName(boolean ellipses)
    {
        name = Kmu.truncate(name, 50, ellipses);
    }

    //##################################################
    //# field (active)
    //##################################################

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean e)
    {
        checkReadOnly();
        e = Validator.getActiveValidator().convertOnly(e);
        active = e;
    }

    public void clearActive()
    {
        setActive(null);
    }

    public boolean hasActive()
    {
        return getActive() != null;
    }

    public boolean hasActive(Boolean e)
    {
        return Kmu.isEqual(getActive(), e);
    }

    public boolean isActive()
    {
        if ( getActive() == null )
            return false;
        return getActive();
    }

    public boolean isNotActive()
    {
        return !isActive();
    }

    public boolean isActive(Boolean b)
    {
        return Kmu.isEqual(getActive(), b);
    }

    public void toggleActive()
    {
        setActive(!getActive());
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        checkReadOnly();
        e = Validator.getLockVersionValidator().convertOnly(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# field (categoryName)
    //##################################################

    public final String getCategoryName()
    {
        return Kmu.getName(getCategory());
    }

    public boolean hasCategoryName()
    {
        return Kmu.hasValue(getCategoryName());
    }

    public boolean hasCategoryName(String e)
    {
        return Kmu.isEqualIgnoreCase(getCategoryName(), e);
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return project;
    }

    public void setProject(MyProject e)
    {
        checkReadOnly();
        project = e;
    }

    public void _setProject(MyProject e)
    {
        checkReadOnly();
        project = e;
    }

    public void clearProject()
    {
        setProject(null);
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    public boolean hasProject(MyProject e)
    {
        return Kmu.isEqual(getProject(), e);
    }


    //##################################################
    //# Values (collection)
    //##################################################

    public KmCollection<MyAttributeValue> getValues()
    {
        return new KmHibernateCollection<>(
            getBaseValues(),
            (MyAttributeField)this,
            MyAttributeValue.Meta.Field.getAdaptor());
    }

    public boolean hasValues()
    {
        return !getBaseValues().isEmpty();
    }

    public int getValueCount()
    {
        return getBaseValues().size();
    }

    public List<MyAttributeValue> getBaseValues()
    {
        return values;
    }

    public MyAttributeValue addValue()
    {
        MyAttributeValue e;
        e = new MyAttributeValue();
        getValues().add(e);
        return e;
    }

    public void addValue(MyAttributeValue e)
    {
        getValues().add(e);
    }

    public boolean removeValue(MyAttributeValue e)
    {
        return getValues().remove(e);
    }

    public boolean removeValueUid(String myUid)
    {
        MyAttributeValue e = findValueUid(myUid);
        if ( e == null )
            return false;

        return removeValue(e);
    }

    public MyAttributeValue findValueUid(String myUid)
    {
        for ( MyAttributeValue e : getBaseValues() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearValues()
    {
        getValues().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyAttributeField)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAttributeField)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAttributeField)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAttributeField getCopy()
    {
        return (MyAttributeField)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        project = null;

        List<MyAttributeValue> old_values = values;
        values = new ArrayList<>();
        for ( MyAttributeValue e : old_values )
            addValue(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAttributeFieldBase) )
            return false;

        MyAttributeFieldBase e = (MyAttributeFieldBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAttributeField e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAttributeField e)
    {
        if ( !Kmu.isEqual(getCategoryCode(), e.getCategoryCode()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getActive(), e.getActive()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getCategoryName(), e.getCategoryName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAttributeField e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAttributeField e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyAttributeField");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    CategoryCode = " + categoryCode);
        System.out.println("    Name = " + name);
        System.out.println("    Active = " + active);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return uid;
    }


    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getMetaName()
    {
        return Meta.getName();
    }
}
