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

public class MyMetaSalesOrder_Number
    extends KmMetaStringProperty<MySalesOrder>
    implements KmMetaDaoPropertyIF<MySalesOrder,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "number";
    }

    @Override
    public String getLabel()
    {
        return "Number";
    }

    @Override
    public String getHelp()
    {
        return "The human-readable number that identifies this order. This value is usually assigned automatically based on the OrderNumber table.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MySalesOrderValidator.instance.getNumberValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "number";
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
    public String getValueFor(MySalesOrder model)
    {
        return model.getNumber();
    }
    
    @Override
    public void setValueFor(MySalesOrder model, String value)
    {
        model.setNumber(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrder model, String value)
    {
        return model.hasNumber(value);
    }
    
}
