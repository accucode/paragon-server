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

public class MyMetaShipment_Account
    extends KmMetaDaoAssociation<MyShipment,MyShipAccount>
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
    public MyShipAccount getValueFor(MyShipment model)
    {
        return model.getAccount();
    }
    
    @Override
    public void setValueFor(MyShipment model, MyShipAccount value)
    {
        model.setAccount(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, MyShipAccount value)
    {
        return model.hasAccount(value);
    }
}
