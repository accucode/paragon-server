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

import com.app.dao.MyPerformanceLogDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPerformanceLog;
import com.app.model.MyPerformanceLogValidator;
import com.app.utility.MyGlobals;

public class MyMetaPerformanceLog_Name
    extends KmMetaStringProperty<MyPerformanceLog>
    implements KmMetaDaoPropertyIF<MyPerformanceLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "name";
    }

    @Override
    public String getLabel()
    {
        return "Name";
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
        return MyPerformanceLogValidator.instance.getNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "name";
    }

    @Override
    public MyPerformanceLogDao getDao()
    {
        return getAccess().getPerformanceLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPerformanceLog model)
    {
        return model.getName();
    }
    
    @Override
    public void setValueFor(MyPerformanceLog model, String value)
    {
        model.setName(value);
    }
    
    @Override
    public boolean hasValueFor(MyPerformanceLog model, String value)
    {
        return model.hasName(value);
    }
    
    @Override
    public int compareValues(MyPerformanceLog o1, MyPerformanceLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
