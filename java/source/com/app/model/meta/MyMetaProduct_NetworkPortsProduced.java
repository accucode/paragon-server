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

public class MyMetaProduct_NetworkPortsProduced
    extends KmMetaIntegerProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "networkPortsProduced";
    }

    @Override
    public String getLabel()
    {
        return "Network Ports Produced";
    }

    @Override
    public String getHelp()
    {
        return "The number of network (cat5) ports that this device adds to a network topology.  For example, this is used to help warn when an order may be missing a switch, or when the switch doesn't have enough ports for the number of access points.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmIntegerValidator getValidator()
    {
        return MyProductValidator.instance.getNetworkPortsProducedValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "networkPortsProduced";
    }

    @Override
    public MyProductDao getDao()
    {
        return getAccess().getProductDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyProduct model)
    {
        return model.getNetworkPortsProduced();
    }
    
    @Override
    public void setValueFor(MyProduct model, Integer value)
    {
        model.setNetworkPortsProduced(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Integer value)
    {
        return model.hasNetworkPortsProduced(value);
    }
    
}
