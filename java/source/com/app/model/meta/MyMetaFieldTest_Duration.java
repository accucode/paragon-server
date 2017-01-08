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

public class MyMetaFieldTest_Duration
    extends KmMetaDurationProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,KmDuration>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "duration";
    }

    @Override
    public String getLabel()
    {
        return "Duration";
    }

    @Override
    public String getHelp()
    {
        return "Duration in seconds.";
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
    public KmDurationValidator getValidator()
    {
        return MyFieldTestValidator.instance.getDurationValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "duration";
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
    public KmDuration getValueFor(MyFieldTest model)
    {
        return model.getDuration();
    }

    @Override
    public void setValueFor(MyFieldTest model, KmDuration value)
    {
        model.setDuration(value);
    }

    @Override
    public boolean hasValueFor(MyFieldTest model, KmDuration value)
    {
        return model.hasDuration(value);
    }

}
