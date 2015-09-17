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
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaApplicationLogTrace_Sequence
    extends KmMetaIntegerProperty<MyApplicationLogTrace>
    implements KmMetaDaoPropertyIF<MyApplicationLogTrace,Integer>
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
    public String getHelp()
    {
        return "This sorts the traces within the log, but is generally not displayed.";
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
        return MyApplicationLogTraceValidator.instance.getSequenceValidator();
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
    public MyApplicationLogTraceDao getDao()
    {
        return getAccess().getApplicationLogTraceDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyApplicationLogTrace model)
    {
        return model.getSequence();
    }
    
    @Override
    public void setValueFor(MyApplicationLogTrace model, Integer value)
    {
        model.setSequence(value);
    }
    
    @Override
    public boolean hasValueFor(MyApplicationLogTrace model, Integer value)
    {
        return model.hasSequence(value);
    }
    
}
