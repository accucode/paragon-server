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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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

public class MyMetaUserActivation_CreatedUtcTs
    extends KmMetaTimestampProperty<MyUserActivation>
    implements KmMetaDaoPropertyIF<MyUserActivation,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Created Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when the activation was created.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyUserActivationValidator.instance.getCreatedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "createdUtcTs";
    }

    @Override
    public MyUserActivationDao getDao()
    {
        return getAccess().getUserActivationDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyUserActivation model)
    {
        return model.getCreatedUtcTs();
    }
    
    @Override
    public void setValueFor(MyUserActivation model, KmTimestamp value)
    {
        model.setCreatedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
    {
        return model.hasCreatedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyUserActivation o1, MyUserActivation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
