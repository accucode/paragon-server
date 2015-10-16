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

public class MyMetaProduct_Master
    extends KmMetaDaoAssociation<MyProduct,MyMasterProduct>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "master";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyMasterProduct getValueFor(MyProduct model)
    {
        return model.getMaster();
    }
    
    @Override
    public void setValueFor(MyProduct model, MyMasterProduct value)
    {
        model.setMaster(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, MyMasterProduct value)
    {
        return model.hasMaster(value);
    }
}
