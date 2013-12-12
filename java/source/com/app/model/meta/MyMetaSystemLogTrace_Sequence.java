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

import com.app.dao.MySystemLogTraceDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MySystemLogTrace;
import com.app.model.MySystemLogTraceValidator;
import com.app.utility.MyGlobals;

public class MyMetaSystemLogTrace_Sequence
    extends KmMetaIntegerProperty<MySystemLogTrace>
    implements KmMetaDaoPropertyIF<MySystemLogTrace,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "sequence";
    }

    @Override
    public String getLabel()
    {
        return "Sequence";
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
        return MySystemLogTraceValidator.instance.getSequenceValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "sequence";
    }

    @Override
    public MySystemLogTraceDao getDao()
    {
        return getAccess().getSystemLogTraceDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MySystemLogTrace model)
    {
        return model.getSequence();
    }
    
    @Override
    public void setValueFor(MySystemLogTrace model, Integer value)
    {
        model.setSequence(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLogTrace model, Integer value)
    {
        return model.hasSequence(value);
    }
    
    @Override
    public int compareValues(MySystemLogTrace o1, MySystemLogTrace o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
