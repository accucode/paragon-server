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
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaEmailRecipient_Email
    extends KmMetaDaoAssociation<MyEmailRecipient,MyEmail>
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
    public MyEmail getValueFor(MyEmailRecipient model)
    {
        return model.getEmail();
    }
    
    @Override
    public void setValueFor(MyEmailRecipient model, MyEmail value)
    {
        model.setEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmailRecipient model, MyEmail value)
    {
        return model.hasEmail(value);
    }
}
