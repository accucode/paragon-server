//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MySystemLogDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaSystemLog_ThreadName
    extends KmMetaStringProperty<MySystemLog>
    implements KmMetaDaoPropertyIF<MySystemLog,String>
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
        return MySystemLogValidator.instance.getThreadNameValidator();
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
    public MySystemLogDao getDao()
    {
        return getAccess().getSystemLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MySystemLog model)
    {
        return model.getThreadName();
    }
    
    @Override
    public void setValueFor(MySystemLog model, String value)
    {
        model.setThreadName(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLog model, String value)
    {
        return model.hasThreadName(value);
    }
    
    @Override
    public int compareValues(MySystemLog o1, MySystemLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
