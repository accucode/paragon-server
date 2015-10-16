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

public class MyMetaSalesOrder_TotalTax
    extends KmMetaMoneyProperty<MySalesOrder>
    implements KmMetaDaoPropertyIF<MySalesOrder,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "totalTax";
    }

    @Override
    public String getLabel()
    {
        return "Total Tax";
    }

    @Override
    public String getHelp()
    {
        return "The total tax.  This is simply an aggregate of the order's lines.";
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
        return MySalesOrderValidator.instance.getTotalTaxValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "totalTax";
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
    public KmMoney getValueFor(MySalesOrder model)
    {
        return model.getTotalTax();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, KmMoney value)
    {
        model.setTotalTax(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, KmMoney value)
    {
        return model.hasTotalTax(value);
    }
    
}
