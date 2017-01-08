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

public class MyMetaApplicationLog_ThreadName
    extends KmMetaStringProperty<MyApplicationLog>
    implements KmMetaDaoPropertyIF<MyApplicationLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "threadName";
    }

    @Override
    public String getLabel()
    {
        return "Thread Name";
    }

    @Override
    public String getHelp()
    {
        return "The java thread name. This is not directly useful except to determine which logs are generated from the same JVM thread.";
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
        return MyApplicationLogValidator.instance.getThreadNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "threadName";
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
        return model.getThreadName();
    }

    @Override
    public void setValueFor(MyApplicationLog model, String value)
    {
        model.setThreadName(value);
    }

    @Override
    public boolean hasValueFor(MyApplicationLog model, String value)
    {
        return model.hasThreadName(value);
    }

}
