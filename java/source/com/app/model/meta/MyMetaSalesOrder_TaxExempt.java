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

public class MyMetaSalesOrder_TaxExempt
    extends KmMetaBooleanProperty<MySalesOrder>
    implements KmMetaDaoPropertyIF<MySalesOrder,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "taxExempt";
    }

    @Override
    public String getLabel()
    {
        return "Tax Exempt";
    }

    @Override
    public String getHelp()
    {
        return "Indicates if the order is exempt from sales tax.";
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
        return MySalesOrderValidator.instance.getTaxExemptValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "taxExempt";
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
    public Boolean getValueFor(MySalesOrder model)
    {
        return model.getTaxExempt();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, Boolean value)
    {
        model.setTaxExempt(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, Boolean value)
    {
        return model.hasTaxExempt(value);
    }
    
}
