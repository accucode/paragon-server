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

public class MyMetaProduct_Category
    extends KmMetaDaoAssociation<MyProduct,MyCategory>
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
    public MyCategory getValueFor(MyProduct model)
    {
        return model.getCategory();
    }
    
    @Override
    public void setValueFor(MyProduct model, MyCategory value)
    {
        model.setCategory(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, MyCategory value)
    {
        return model.hasCategory(value);
    }
}
