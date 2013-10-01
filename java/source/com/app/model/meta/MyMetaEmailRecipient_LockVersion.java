//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyEmailRecipientDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyEmailRecipient;
import com.app.model.MyEmailRecipientValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

public class MyMetaEmailRecipient_LockVersion
    extends KmMetaIntegerProperty<MyEmailRecipient>
    implements KmMetaDaoPropertyIF<MyEmailRecipient,Integer>
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
        return MyEmailRecipientValidator.instance.getLockVersionValidator();
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
    public MyEmailRecipientDao getDao()
    {
        return getAccess().getEmailRecipientDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyEmailRecipient model)
    {
        return model.getLockVersion();
    }
    
    @Override
    public void setValueFor(MyEmailRecipient model, Integer value)
    {
        model.setLockVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailRecipient model, Integer value)
    {
        return model.hasLockVersion(value);
    }
    
    @Override
    public int compareValues(MyEmailRecipient o1, MyEmailRecipient o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
