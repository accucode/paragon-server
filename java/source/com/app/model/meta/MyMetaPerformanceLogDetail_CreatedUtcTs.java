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

public class MyMetaPerformanceLogDetail_CreatedUtcTs
    extends KmMetaTimestampProperty<MyPerformanceLogDetail>
    implements KmMetaDaoPropertyIF<MyPerformanceLogDetail,KmTimestamp>
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
        return "The time when this log was created.  This is usually very very close to when the task ended (not started).";
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
        return MyPerformanceLogDetailValidator.instance.getCreatedUtcTsValidator();
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
    public MyPerformanceLogDetailDao getDao()
    {
        return getAccess().getPerformanceLogDetailDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyPerformanceLogDetail model)
    {
        return model.getCreatedUtcTs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogDetail model, KmTimestamp value)
    {
        model.setCreatedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogDetail model, KmTimestamp value)
    {
        return model.hasCreatedUtcTs(value);
    }
    
}
