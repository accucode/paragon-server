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

public class MyMetaProduct_PoePortsProduced
    extends KmMetaIntegerProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "poePortsProduced";
    }

    @Override
    public String getLabel()
    {
        return "Poe Ports Produced";
    }

    @Override
    public String getHelp()
    {
        return "The number of Power Over Ethernet ports that this adds to a network topology. Note that this may be different from the number of network ports.  For example an 8-port switch may only support 3 fully powered PoE ports.";
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
        return MyProductValidator.instance.getPoePortsProducedValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "poePortsProduced";
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
        return model.getPoePortsProduced();
    }
    
    @Override
    public void setValueFor(MyProduct model, Integer value)
    {
        model.setPoePortsProduced(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Integer value)
    {
        return model.hasPoePortsProduced(value);
    }
    
}
