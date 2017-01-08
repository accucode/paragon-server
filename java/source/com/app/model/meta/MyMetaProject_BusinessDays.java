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

public class MyMetaProject_BusinessDays
    extends KmMetaDayFrequencyProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,KmDayFrequency>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "businessDays";
    }

    @Override
    public String getLabel()
    {
        return "Business Days";
    }

    @Override
    public String getHelp()
    {
        return "The nominal business days (e.g.: Monday through Friday). This may be displayed to customers.";
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
        return MyProjectValidator.instance.getBusinessDaysValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "businessDays";
    }

    @Override
    public MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmDayFrequency getValueFor(MyProject model)
    {
        return model.getBusinessDays();
    }

    @Override
    public void setValueFor(MyProject model, KmDayFrequency value)
    {
        model.setBusinessDays(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, KmDayFrequency value)
    {
        return model.hasBusinessDays(value);
    }

}
