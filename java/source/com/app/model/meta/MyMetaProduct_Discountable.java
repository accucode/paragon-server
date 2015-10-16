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

public class MyMetaProduct_Discountable
    extends KmMetaBooleanProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "discountable";
    }

    @Override
    public String getLabel()
    {
        return "Discountable";
    }

    @Override
    public String getHelp()
    {
        return "In many cases, a customer-specific discount is applied to the list price in order to determine the actual sell price of the item for a particular order. However, in some cases the item is NOT subject to discounts.\n For example, we may define an product called \"$50 Delayed Install Discount\" with a price -100.00.  This product provide a convenient way to give customers a standard discount for delayed installations.  But we would NOT want to apply the customer's discount rate to the list price defined for this item.";
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
    public KmBooleanValidator getValidator()
    {
        return MyProductValidator.instance.getDiscountableValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "discountable";
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
    public Boolean getValueFor(MyProduct model)
    {
        return model.getDiscountable();
    }
    
    @Override
    public void setValueFor(MyProduct model, Boolean value)
    {
        model.setDiscountable(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Boolean value)
    {
        return model.hasDiscountable(value);
    }
    
}
