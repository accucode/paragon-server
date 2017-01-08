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

public class MyMetaProject_BusinessEndTime
    extends KmMetaTimeProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,KmTime>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "businessEndTime";
    }

    @Override
    public String getLabel()
    {
        return "Business End Time";
    }

    @Override
    public String getHelp()
    {
        return "The nominal end of business hours. This may be displayed to customers.";
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
    public KmTimeValidator getValidator()
    {
        return MyProjectValidator.instance.getBusinessEndTimeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "businessEndTime";
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
    public KmTime getValueFor(MyProject model)
    {
        return model.getBusinessEndTime();
    }

    @Override
    public void setValueFor(MyProject model, KmTime value)
    {
        model.setBusinessEndTime(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, KmTime value)
    {
        return model.hasBusinessEndTime(value);
    }

}
