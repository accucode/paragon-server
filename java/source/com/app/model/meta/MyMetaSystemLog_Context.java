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

public class MyMetaSystemLog_Context
    extends KmMetaStringProperty<MySystemLog>
    implements KmMetaDaoPropertyIF<MySystemLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "context";
    }

    @Override
    public String getLabel()
    {
        return "Context";
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
        return MySystemLogValidator.instance.getContextValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "context";
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
        return model.getContext();
    }
    
    @Override
    public void setValueFor(MySystemLog model, String value)
    {
        model.setContext(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLog model, String value)
    {
        return model.hasContext(value);
    }
    
    @Override
    public int compareValues(MySystemLog o1, MySystemLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
