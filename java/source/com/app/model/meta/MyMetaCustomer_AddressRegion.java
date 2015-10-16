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

public class MyMetaCustomer_AddressRegion
    extends KmMetaStringProperty<MyCustomer>
    implements KmMetaDaoPropertyIF<MyCustomer,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "addressRegion";
    }

    @Override
    public String getLabel()
    {
        return "Address Region";
    }

    @Override
    public String getHelp()
    {
        return "The name or abbreviation of the of the region (or state).";
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

    @Override
    public KmStringValidator getValidator()
    {
        return MyCustomerValidator.instance.getAddressRegionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "addressRegion";
    }

    @Override
    public MyCustomerDao getDao()
    {
        return getAccess().getCustomerDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyCustomer model)
    {
        return model.getAddressRegion();
    }
    
    @Override
    public void setValueFor(MyCustomer model, String value)
    {
        model.setAddressRegion(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomer model, String value)
    {
        return model.hasAddressRegion(value);
    }
    
}
