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

public class MyMetaSystemLogTrace_Value
    extends KmMetaStringProperty<MySystemLogTrace>
    implements KmMetaDaoPropertyIF<MySystemLogTrace,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "value";
    }

    @Override
    public String getLabel()
    {
        return "Value";
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
        return MySystemLogTraceValidator.instance.getValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "value";
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
    public String getValueFor(MySystemLogTrace model)
    {
        return model.getValue();
    }
    
    @Override
    public void setValueFor(MySystemLogTrace model, String value)
    {
        model.setValue(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLogTrace model, String value)
    {
        return model.hasValue(value);
    }
    
    @Override
    public int compareValues(MySystemLogTrace o1, MySystemLogTrace o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
