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

public class MyMetaProduct_NetworkPortsConsumed
    extends KmMetaIntegerProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "networkPortsConsumed";
    }

    @Override
    public String getLabel()
    {
        return "Network Ports Consumed";
    }

    @Override
    public String getHelp()
    {
        return "The number of network (cat5) ports that this device uses/removes from a network topology.";
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
        return MyProductValidator.instance.getNetworkPortsConsumedValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "networkPortsConsumed";
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
        return model.getNetworkPortsConsumed();
    }
    
    @Override
    public void setValueFor(MyProduct model, Integer value)
    {
        model.setNetworkPortsConsumed(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Integer value)
    {
        return model.hasNetworkPortsConsumed(value);
    }
    
}
