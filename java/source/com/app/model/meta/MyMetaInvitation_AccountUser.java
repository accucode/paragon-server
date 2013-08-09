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

public class MyMetaInvitation_AccountUser
    extends KmMetaDaoAssociation<MyInvitation,MyAccountUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "accountUser";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAccountUser getValueFor(MyInvitation model)
    {
        return model.getAccountUser();
    }
    
    @Override
    public void setValueFor(MyInvitation model, MyAccountUser value)
    {
        model.setAccountUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, MyAccountUser value)
    {
        return model.hasAccountUser(value);
    }
}
