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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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
import com.app.model.core.*;
import com.app.utility.*;

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
