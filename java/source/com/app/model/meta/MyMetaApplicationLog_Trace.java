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

public class MyMetaApplicationLog_Trace
    extends KmMetaStringProperty<MyApplicationLog>
    implements KmMetaDaoPropertyIF<MyApplicationLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "trace";
    }

    @Override
    public String getLabel()
    {
        return "Trace";
    }

    @Override
    public String getHelp()
    {
        return "The full text of the exception trace.  This can be quite long.";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyApplicationLogValidator.instance.getTraceValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "trace";
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
    public String getValueFor(MyApplicationLog model)
    {
        return model.getTrace();
    }

    @Override
    public void setValueFor(MyApplicationLog model, String value)
    {
        model.setTrace(value);
    }

    @Override
    public boolean hasValueFor(MyApplicationLog model, String value)
    {
        return model.hasTrace(value);
    }

}
