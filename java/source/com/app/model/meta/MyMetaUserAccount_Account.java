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

public class MyMetaUserAccount_Account
    extends KmMetaDaoAssociation<MyUserAccount,MyAccount>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "account";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyAccount getValueFor(MyUserAccount model)
    {
        return model.getAccount();
    }
    
    @Override
    public void setValueFor(MyUserAccount model, MyAccount value)
    {
        model.setAccount(value);
    }
    
    @Override
    public boolean hasValueFor(MyUserAccount model, MyAccount value)
    {
        return model.hasAccount(value);
    }
}
