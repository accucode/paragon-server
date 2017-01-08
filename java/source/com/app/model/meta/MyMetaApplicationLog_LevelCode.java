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

public class MyMetaApplicationLog_LevelCode
    extends KmMetaIntegerProperty<MyApplicationLog>
    implements KmMetaDaoPropertyIF<MyApplicationLog,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "levelCode";
    }

    @Override
    public String getLabel()
    {
        return "Level Code";
    }

    @Override
    public String getHelp()
    {
        return "The severity level code. This can be used to find all events that are high or lower than some level.";
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
        return MyApplicationLogValidator.instance.getLevelCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "levelCode";
    }

    @Override
    public MyApplicationLogDao getDao()
    {
        return getAccess().getApplicationLogDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyApplicationLog model)
    {
        return model.getLevelCode();
    }

    @Override
    public void setValueFor(MyApplicationLog model, Integer value)
    {
        model.setLevelCode(value);
    }

    @Override
    public boolean hasValueFor(MyApplicationLog model, Integer value)
    {
        return model.hasLevelCode(value);
    }

}
