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

public class MyMetaCustomer_AddressStreet1
    extends KmMetaStringProperty<MyCustomer>
    implements KmMetaDaoPropertyIF<MyCustomer,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "addressStreet1";
    }

    @Override
    public String getLabel()
    {
        return "Address Street1";
    }

    @Override
    public String getHelp()
    {
        return "The first line of the street address.";
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
        return MyCustomerValidator.instance.getAddressStreet1Validator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "addressStreet1";
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
        return model.getAddressStreet1();
    }
    
    @Override
    public void setValueFor(MyCustomer model, String value)
    {
        model.setAddressStreet1(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomer model, String value)
    {
        return model.hasAddressStreet1(value);
    }
    
}
