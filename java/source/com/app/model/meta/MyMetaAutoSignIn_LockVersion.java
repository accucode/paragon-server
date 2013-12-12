//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

import com.app.dao.MyAutoSignInDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAutoSignIn;
import com.app.model.MyAutoSignInValidator;
import com.app.utility.MyGlobals;

public class MyMetaAutoSignIn_LockVersion
    extends KmMetaIntegerProperty<MyAutoSignIn>
    implements KmMetaDaoPropertyIF<MyAutoSignIn,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lockVersion";
    }

    @Override
    public String getLabel()
    {
        return "Lock Version";
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MyAutoSignInValidator.instance.getLockVersionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lockVersion";
    }

    @Override
    public MyAutoSignInDao getDao()
    {
        return getAccess().getAutoSignInDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyAutoSignIn model)
    {
        return model.getLockVersion();
    }
    
    @Override
    public void setValueFor(MyAutoSignIn model, Integer value)
    {
        model.setLockVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, Integer value)
    {
        return model.hasLockVersion(value);
    }
    
    @Override
    public int compareValues(MyAutoSignIn o1, MyAutoSignIn o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
