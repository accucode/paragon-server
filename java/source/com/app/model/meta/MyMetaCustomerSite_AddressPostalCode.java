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

public class MyMetaCustomerSite_AddressPostalCode
    extends KmMetaStringProperty<MyCustomerSite>
    implements KmMetaDaoPropertyIF<MyCustomerSite,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "addressPostalCode";
    }

    @Override
    public String getLabel()
    {
        return "Address Postal Code";
    }

    @Override
    public String getHelp()
    {
        return "The zip/postal code.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyCustomerSiteValidator.instance.getAddressPostalCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "addressPostalCode";
    }

    @Override
    public MyCustomerSiteDao getDao()
    {
        return getAccess().getCustomerSiteDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyCustomerSite model)
    {
        return model.getAddressPostalCode();
    }
    
    @Override
    public void setValueFor(MyCustomerSite model, String value)
    {
        model.setAddressPostalCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomerSite model, String value)
    {
        return model.hasAddressPostalCode(value);
    }
    
}
