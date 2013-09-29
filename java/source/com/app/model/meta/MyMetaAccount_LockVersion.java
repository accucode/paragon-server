//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyAccountDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

public class MyMetaAccount_LockVersion
    extends KmMetaIntegerProperty<MyAccount>
    implements KmMetaDaoPropertyIF<MyAccount,Integer>
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
        return MyAccountValidator.instance.getLockVersionValidator();
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
    public MyAccountDao getDao()
    {
        return getAccess().getAccountDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyAccount model)
    {
        return model.getLockVersion();
    }
    
    @Override
    public void setValueFor(MyAccount model, Integer value)
    {
        model.setLockVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccount model, Integer value)
    {
        return model.hasLockVersion(value);
    }
    
    @Override
    public int compareValues(MyAccount o1, MyAccount o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
