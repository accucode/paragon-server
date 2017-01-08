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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaPerformanceLogSummary_TotalMs
    extends KmMetaIntegerProperty<MyPerformanceLogSummary>
    implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "totalMs";
    }

    @Override
    public String getLabel()
    {
        return "Total Ms";
    }

    @Override
    public String getHelp()
    {
        return "Aggregate information about the individual logs.";
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
        return MyPerformanceLogSummaryValidator.instance.getTotalMsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "totalMs";
    }

    @Override
    public MyPerformanceLogSummaryDao getDao()
    {
        return getAccess().getPerformanceLogSummaryDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyPerformanceLogSummary model)
    {
        return model.getTotalMs();
    }

    @Override
    public void setValueFor(MyPerformanceLogSummary model, Integer value)
    {
        model.setTotalMs(value);
    }

    @Override
    public boolean hasValueFor(MyPerformanceLogSummary model, Integer value)
    {
        return model.hasTotalMs(value);
    }

}
