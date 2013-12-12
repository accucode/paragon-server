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

import com.app.dao.MyPasswordResetDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPasswordReset;
import com.app.model.MyPasswordResetValidator;
import com.app.utility.MyGlobals;

public class MyMetaPasswordReset_AccessKey
    extends KmMetaStringProperty<MyPasswordReset>
    implements KmMetaDaoPropertyIF<MyPasswordReset,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "accessKey";
    }

    @Override
    public String getLabel()
    {
        return "Access Key";
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
        return MyPasswordResetValidator.instance.getAccessKeyValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "accessKey";
    }

    @Override
    public MyPasswordResetDao getDao()
    {
        return getAccess().getPasswordResetDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPasswordReset model)
    {
        return model.getAccessKey();
    }
    
    @Override
    public void setValueFor(MyPasswordReset model, String value)
    {
        model.setAccessKey(value);
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, String value)
    {
        return model.hasAccessKey(value);
    }
    
    @Override
    public int compareValues(MyPasswordReset o1, MyPasswordReset o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
