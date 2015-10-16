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

public class MyMetaMasterProduct_PublishedVersion
    extends KmMetaDaoAssociation<MyMasterProduct,MyProduct>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "publishedVersion";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProduct getValueFor(MyMasterProduct model)
    {
        return model.getPublishedVersion();
    }
    
    @Override
    public void setValueFor(MyMasterProduct model, MyProduct value)
    {
        model.setPublishedVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MyMasterProduct model, MyProduct value)
    {
        return model.hasPublishedVersion(value);
    }
}
