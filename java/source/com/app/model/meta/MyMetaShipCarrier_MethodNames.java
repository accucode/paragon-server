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
import com.kodemore.match.*;
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

public class MyMetaShipCarrier_MethodNames
    extends KmMetaStringProperty<MyShipCarrier>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "methodNames";
    }

    @Override
    public String getLabel()
    {
        return "Method Names";
    }

    @Override
    public String getHelp()
    {
        return "The names of my shipping methods in a comma delimited list.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyShipCarrier model)
    {
        return model.getMethodNames();
    }
    
    @Override
    public boolean hasValueFor(MyShipCarrier model, String value)
    {
        return model.hasMethodNames(value);
    }
    
    @Override
    public int compareValues(MyShipCarrier o1, MyShipCarrier o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
