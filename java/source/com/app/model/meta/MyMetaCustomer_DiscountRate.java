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

public class MyMetaCustomer_DiscountRate
    extends KmMetaDoubleProperty<MyCustomer>
    implements KmMetaDaoPropertyIF<MyCustomer,Double>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "discountRate";
    }

    @Override
    public String getLabel()
    {
        return "Discount Rate";
    }

    @Override
    public String getHelp()
    {
        return "The discount rate applied to new orders for this customer. This rate is typically defaulted based on the customer's tier, but can be overridden for each customer.  The rate defined here is used as the default for each new order associated with that customer.";
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
    public KmDoubleValidator getValidator()
    {
        return MyCustomerValidator.instance.getDiscountRateValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "discountRate";
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
    public Double getValueFor(MyCustomer model)
    {
        return model.getDiscountRate();
    }
    
    @Override
    public void setValueFor(MyCustomer model, Double value)
    {
        model.setDiscountRate(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomer model, Double value)
    {
        return model.hasDiscountRate(value);
    }
    
}
