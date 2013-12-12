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
import com.kodemore.meta.*;
import com.kodemore.match.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

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
