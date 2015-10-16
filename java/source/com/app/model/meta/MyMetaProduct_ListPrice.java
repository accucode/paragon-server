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

public class MyMetaProduct_ListPrice
    extends KmMetaMoneyProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "listPrice";
    }

    @Override
    public String getLabel()
    {
        return "List Price";
    }

    @Override
    public String getHelp()
    {
        return "The standard list price as published in the standard catalog.";
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
        return MyProductValidator.instance.getListPriceValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "listPrice";
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
        return model.getListPrice();
    }
    
    @Override
    public void setValueFor(MyProduct model, KmMoney value)
    {
        model.setListPrice(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, KmMoney value)
    {
        return model.hasListPrice(value);
    }
    
}
