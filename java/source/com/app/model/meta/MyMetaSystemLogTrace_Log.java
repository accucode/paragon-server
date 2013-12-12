//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaDaoAssociation;

import com.app.model.MySystemLog;
import com.app.model.MySystemLogTrace;

public class MyMetaSystemLogTrace_Log
    extends KmMetaDaoAssociation<MySystemLogTrace,MySystemLog>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "log";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MySystemLog getValueFor(MySystemLogTrace model)
    {
        return model.getLog();
    }
    
    @Override
    public void setValueFor(MySystemLogTrace model, MySystemLog value)
    {
        model.setLog(value);
    }
    
    @Override
    public boolean hasValueFor(MySystemLogTrace model, MySystemLog value)
    {
        return model.hasLog(value);
    }
}
