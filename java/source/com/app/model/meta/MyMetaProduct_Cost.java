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

public class MyMetaProduct_Cost
    extends KmMetaMoneyProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "cost";
    }

    @Override
    public String getLabel()
    {
        return "Cost";
    }

    @Override
    public String getHelp()
    {
        return "An estimate of the total cost of this product.  By comparing the sale price and cost of each product sold, we can report an estimated profit.";
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
    public KmMoneyValidator getValidator()
    {
        return MyProductValidator.instance.getCostValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "cost";
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
    public KmMoney getValueFor(MyProduct model)
    {
        return model.getCost();
    }
    
    @Override
    public void setValueFor(MyProduct model, KmMoney value)
    {
        model.setCost(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, KmMoney value)
    {
        return model.hasCost(value);
    }
    
}
