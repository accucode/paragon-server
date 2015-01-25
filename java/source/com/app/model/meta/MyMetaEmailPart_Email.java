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

public class MyMetaEmailPart_Email
    extends KmMetaDaoAssociation<MyEmailPart,MyEmail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "email";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyEmail getValueFor(MyEmailPart model)
    {
        return model.getEmail();
    }
    
    @Override
    public void setValueFor(MyEmailPart model, MyEmail value)
    {
        model.setEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailPart model, MyEmail value)
    {
        return model.hasEmail(value);
    }
}
