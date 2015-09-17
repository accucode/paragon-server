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

public class MyMetaInvitation_FromUser
    extends KmMetaDaoAssociation<MyInvitation,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fromUser";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyInvitation model)
    {
        return model.getFromUser();
    }
    
    @Override
    public void setValueFor(MyInvitation model, MyUser value)
    {
        model.setFromUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, MyUser value)
    {
        return model.hasFromUser(value);
    }
}
