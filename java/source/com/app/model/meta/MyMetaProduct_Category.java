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

public class MyMetaProduct_Category
    extends KmMetaDaoAssociation<MyProduct,MyProductCategory>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "category";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyProductCategory getValueFor(MyProduct model)
    {
        return model.getCategory();
    }
    
    @Override
    public void setValueFor(MyProduct model, MyProductCategory value)
    {
        model.setCategory(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, MyProductCategory value)
    {
        return model.hasCategory(value);
    }
}
