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

public class MyMetaServerSession_AutoSignIn
    extends KmMetaDaoAssociation<MyServerSession,MyAutoSignIn>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "autoSignIn";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAutoSignIn getValueFor(MyServerSession model)
    {
        return model.getAutoSignIn();
    }
    
    @Override
    public void setValueFor(MyServerSession model, MyAutoSignIn value)
    {
        model.setAutoSignIn(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, MyAutoSignIn value)
    {
        return model.hasAutoSignIn(value);
    }
}
