//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaBooleanProperty;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.validator.KmBooleanValidator;

import com.app.dao.MyUserDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyUser;
import com.app.model.MyUserValidator;
import com.app.utility.MyGlobals;

public class MyMetaUser_Verified
    extends KmMetaBooleanProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "verified";
    }

    @Override
    public String getLabel()
    {
        return "Verified";
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
    public KmBooleanValidator getValidator()
    {
        return MyUserValidator.instance.getVerifiedValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "verified";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyUser model)
    {
        return model.getVerified();
    }
    
    @Override
    public void setValueFor(MyUser model, Boolean value)
    {
        model.setVerified(value);
    }
    
    @Override
    public boolean hasValueFor(MyUser model, Boolean value)
    {
        return model.hasVerified(value);
    }
    
    @Override
    public int compareValues(MyUser o1, MyUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
