//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

import com.app.dao.MySystemLogDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogValidator;
import com.app.utility.MyGlobals;

public class MyMetaSystemLog_Message
    extends KmMetaStringProperty<MySystemLog>
    implements KmMetaDaoPropertyIF<MySystemLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "message";
    }

    @Override
    public String getLabel()
    {
        return "Message";
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
        return MySystemLogValidator.instance.getMessageValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "message";
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
        return model.getMessage();
    }
    
    @Override
    public void setValueFor(MySystemLog model, String value)
    {
        model.setMessage(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLog model, String value)
    {
        return model.hasMessage(value);
    }
    
    @Override
    public int compareValues(MySystemLog o1, MySystemLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
