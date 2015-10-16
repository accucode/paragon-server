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

public class MyMetaSalesOrderLine_Tax
    extends KmMetaMoneyProperty<MySalesOrderLine>
    implements KmMetaDaoPropertyIF<MySalesOrderLine,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "tax";
    }

    @Override
    public String getLabel()
    {
        return "Tax";
    }

    @Override
    public String getHelp()
    {
        return "The amount of tax due for this line. The tax is based on multiple factors including: whether the item is taxable, whether the order is tax exempt, and the tax rate associated with the order.";
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
        return MySalesOrderLineValidator.instance.getTaxValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "tax";
    }

    @Override
    public MySalesOrderLineDao getDao()
    {
        return getAccess().getSalesOrderLineDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmMoney getValueFor(MySalesOrderLine model)
    {
        return model.getTax();
    }
    
    @Override
    public void setValueFor(MySalesOrderLine model, KmMoney value)
    {
        model.setTax(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderLine model, KmMoney value)
    {
        return model.hasTax(value);
    }
    
}
