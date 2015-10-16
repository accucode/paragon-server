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

public class MyMetaCustomerTier_DiscountRate
    extends KmMetaDoubleProperty<MyCustomerTier>
    implements KmMetaDaoPropertyIF<MyCustomerTier,Double>
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
        return "The default discount rate used for customers associated with this tier. This determines the discount amount off of list price. For example, suppose the list price is $100, and the discount rate is 0.25 (25%); then the discount will be $25 ($100 * .25) and the effective unit price will be $75.";
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
        return MyCustomerTierValidator.instance.getDiscountRateValidator();
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
    public MyCustomerTierDao getDao()
    {
        return getAccess().getCustomerTierDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Double getValueFor(MyCustomerTier model)
    {
        return model.getDiscountRate();
    }
    
    @Override
    public void setValueFor(MyCustomerTier model, Double value)
    {
        model.setDiscountRate(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomerTier model, Double value)
    {
        return model.hasDiscountRate(value);
    }
    
}
