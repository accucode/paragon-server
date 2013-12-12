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
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

import com.app.dao.MyPerformanceLogDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPerformanceLog;
import com.app.model.MyPerformanceLogValidator;
import com.app.utility.MyGlobals;

public class MyMetaPerformanceLog_DurationMs
    extends KmMetaIntegerProperty<MyPerformanceLog>
    implements KmMetaDaoPropertyIF<MyPerformanceLog,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "durationMs";
    }

    @Override
    public String getLabel()
    {
        return "Duration Ms";
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
        return MyPerformanceLogValidator.instance.getDurationMsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "durationMs";
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
    public Integer getValueFor(MyPerformanceLog model)
    {
        return model.getDurationMs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLog model, Integer value)
    {
        model.setDurationMs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLog model, Integer value)
    {
        return model.hasDurationMs(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLog o1, MyPerformanceLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
