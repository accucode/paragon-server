//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaCustomerContact_LockVersion
    extends KmMetaIntegerProperty<MyCustomerContact>
    implements KmMetaDaoPropertyIF<MyCustomerContact,Integer>
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
    public String getHelp()
    {
        return "This is used to coordinate optimistic locking in the database. This is usually not displayed.";
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
        return MyCustomerContactValidator.instance.getLockVersionValidator();
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
    public MyCustomerContactDao getDao()
    {
        return getAccess().getCustomerContactDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyCustomerContact model)
    {
        return model.getLockVersion();
    }
    
    @Override
    public void setValueFor(MyCustomerContact model, Integer value)
    {
        model.setLockVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomerContact model, Integer value)
    {
        return model.hasLockVersion(value);
    }
    
}
