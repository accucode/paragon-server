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

public class MyMetaPerformanceLogSummary_UtcDate
    extends KmMetaDateProperty<MyPerformanceLogSummary>
    implements KmMetaDaoPropertyIF<MyPerformanceLogSummary,KmDate>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "utcDate";
    }

    @Override
    public String getLabel()
    {
        return "Utc Date";
    }

    @Override
    public String getHelp()
    {
        return "The day being summarized.";
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
    public KmDateValidator getValidator()
    {
        return MyPerformanceLogSummaryValidator.instance.getUtcDateValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "utcDate";
    }

    @Override
    public MyPerformanceLogSummaryDao getDao()
    {
        return getAccess().getPerformanceLogSummaryDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmDate getValueFor(MyPerformanceLogSummary model)
    {
        return model.getUtcDate();
    }
    
    @Override
    public void setValueFor(MyPerformanceLogSummary model, KmDate value)
    {
        model.setUtcDate(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLogSummary model, KmDate value)
    {
        return model.hasUtcDate(value);
    }
    
}
