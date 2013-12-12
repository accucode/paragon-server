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
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

import com.app.dao.MyAutoSignInDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAutoSignIn;
import com.app.model.MyAutoSignInValidator;
import com.app.utility.MyGlobals;

public class MyMetaAutoSignIn_Uid
    extends KmMetaStringProperty<MyAutoSignIn>
    implements KmMetaDaoPropertyIF<MyAutoSignIn,String>
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
        return MyAutoSignInValidator.instance.getUidValidator();
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
    public String getValueFor(MyAutoSignIn model)
    {
        return model.getUid();
    }
    
    @Override
    public void setValueFor(MyAutoSignIn model, String value)
    {
        model.setUid(value);
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, String value)
    {
        return model.hasUid(value);
    }
    
    @Override
    public int compareValues(MyAutoSignIn o1, MyAutoSignIn o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
