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
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.validator.KmIntegerValidator;

import com.app.dao.MySystemLogDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogValidator;
import com.app.utility.MyGlobals;

public class MyMetaSystemLog_LevelCode
    extends KmMetaIntegerProperty<MySystemLog>
    implements KmMetaDaoPropertyIF<MySystemLog,Integer>
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
        return MySystemLogValidator.instance.getLevelCodeValidator();
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
    public Integer getValueFor(MySystemLog model)
    {
        return model.getLevelCode();
    }
    
    @Override
    public void setValueFor(MySystemLog model, Integer value)
    {
        model.setLevelCode(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLog model, Integer value)
    {
        return model.hasLevelCode(value);
    }
    
    @Override
    public int compareValues(MySystemLog o1, MySystemLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
