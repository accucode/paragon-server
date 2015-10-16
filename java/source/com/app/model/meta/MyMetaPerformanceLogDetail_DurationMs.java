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

public class MyMetaPerformanceLogDetail_DurationMs
    extends KmMetaIntegerProperty<MyPerformanceLogDetail>
    implements KmMetaDaoPropertyIF<MyPerformanceLogDetail,Integer>
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
    public String getHelp()
    {
        return "The duration of the task in milliseconds.";
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
        return MyPerformanceLogDetailValidator.instance.getDurationMsValidator();
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
    public Integer getValueFor(MyPerformanceLogDetail model)
    {
        return model.getDurationMs();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogDetail model, Integer value)
    {
        model.setDurationMs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogDetail model, Integer value)
    {
        return model.hasDurationMs(value);
    }
    
}
