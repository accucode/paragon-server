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
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaProduct_PartNumber
    extends KmMetaStringProperty<MyProduct>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "partNumber";
    }

    @Override
    public String getLabel()
    {
        return "Part Number";
    }

    @Override
    public String getHelp()
    {
        return "The unique part number shared by all versions of the product.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyProduct model)
    {
        return model.getPartNumber();
    }
    
    @Override
    public void setValueFor(MyProduct model, String value)
    {
        model.setPartNumber(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, String value)
    {
        return model.hasPartNumber(value);
    }
    
}
