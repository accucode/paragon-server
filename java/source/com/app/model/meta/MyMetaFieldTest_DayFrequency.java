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

public class MyMetaFieldTest_DayFrequency
    extends KmMetaDayFrequencyProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,KmDayFrequency>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dayFrequency";
    }

    @Override
    public String getLabel()
    {
        return "Day Frequency";
    }

    @Override
    public String getHelp()
    {
        return "Day frequency (mon, tue, wed, etc)";
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
    public KmDayFrequencyValidator getValidator()
    {
        return MyFieldTestValidator.instance.getDayFrequencyValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "dayFrequency";
    }

    @Override
    public MyFieldTestDao getDao()
    {
        return getAccess().getFieldTestDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmDayFrequency getValueFor(MyFieldTest model)
    {
        return model.getDayFrequency();
    }

    @Override
    public void setValueFor(MyFieldTest model, KmDayFrequency value)
    {
        model.setDayFrequency(value);
    }

    @Override
    public boolean hasValueFor(MyFieldTest model, KmDayFrequency value)
    {
        return model.hasDayFrequency(value);
    }

}
