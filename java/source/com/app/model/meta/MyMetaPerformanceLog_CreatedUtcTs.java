//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyPerformanceLogDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPerformanceLog;
import com.app.model.MyPerformanceLogValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public class MyMetaPerformanceLog_CreatedUtcTs
    extends KmMetaTimestampProperty<MyPerformanceLog>
    implements KmMetaDaoPropertyIF<MyPerformanceLog,KmTimestamp>
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
        return MyPerformanceLogValidator.instance.getCreatedUtcTsValidator();
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
    public MyPerformanceLogDao getDao()
    {
        return getAccess().getPerformanceLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyPerformanceLog model)
    {
        return model.getCreatedUtcTs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLog model, KmTimestamp value)
    {
        model.setCreatedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLog model, KmTimestamp value)
    {
        return model.hasCreatedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLog o1, MyPerformanceLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
