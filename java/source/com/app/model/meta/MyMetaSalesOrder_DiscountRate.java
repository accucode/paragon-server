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

public class MyMetaSalesOrder_DiscountRate
    extends KmMetaDoubleProperty<MySalesOrder>
    implements KmMetaDaoPropertyIF<MySalesOrder,Double>
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
        return "The default discount rate used for customers associated with this tier. This is typically defaulted based on the customer's discount rate.";
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
        return MySalesOrderValidator.instance.getDiscountRateValidator();
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
    public MySalesOrderDao getDao()
    {
        return getAccess().getSalesOrderDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Double getValueFor(MySalesOrder model)
    {
        return model.getDiscountRate();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, Double value)
    {
        model.setDiscountRate(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, Double value)
    {
        return model.hasDiscountRate(value);
    }
    
}
