//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyAccountUserDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaAccountUser_Uid
    extends KmMetaStringProperty<MyAccountUser>
    implements KmMetaDaoPropertyIF<MyAccountUser,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "uid";
    }

    @Override
    public String getLabel()
    {
        return "Uid";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyAccountUserValidator.instance.getUidValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "uid";
    }

    @Override
    public MyAccountUserDao getDao()
    {
        return getAccess().getAccountUserDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAccountUser model)
    {
        return model.getUid();
    }
    
    @Override
    public void setValueFor(MyAccountUser model, String value)
    {
        model.setUid(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccountUser model, String value)
    {
        return model.hasUid(value);
    }
    
    @Override
    public int compareValues(MyAccountUser o1, MyAccountUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
