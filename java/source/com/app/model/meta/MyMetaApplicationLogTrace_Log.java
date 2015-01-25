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

public class MyMetaApplicationLogTrace_Log
    extends KmMetaDaoAssociation<MyApplicationLogTrace,MyApplicationLog>
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
    public MyApplicationLog getValueFor(MyApplicationLogTrace model)
    {
        return model.getLog();
    }
    
    @Override
    public void setValueFor(MyApplicationLogTrace model, MyApplicationLog value)
    {
        model.setLog(value);
    }
    
    @Override
    public boolean hasValueFor(MyApplicationLogTrace model, MyApplicationLog value)
    {
        return model.hasLog(value);
    }
}
