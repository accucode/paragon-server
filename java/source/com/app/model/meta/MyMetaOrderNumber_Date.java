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

public class MyMetaOrderNumber_Date
    extends KmMetaDateProperty<MyOrderNumber>
    implements KmMetaDaoPropertyIF<MyOrderNumber,KmDate>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "date";
    }

    @Override
    public String getLabel()
    {
        return "Date";
    }

    @Override
    public String getHelp()
    {
        return "The date associated with this order number.";
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
    public KmDateValidator getValidator()
    {
        return MyOrderNumberValidator.instance.getDateValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "date";
    }

    @Override
    public MyOrderNumberDao getDao()
    {
        return getAccess().getOrderNumberDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmDate getValueFor(MyOrderNumber model)
    {
        return model.getDate();
    }
    
    @Override
    public void setValueFor(MyOrderNumber model, KmDate value)
    {
        model.setDate(value);
    }
    
    @Override
    public boolean hasValueFor(MyOrderNumber model, KmDate value)
    {
        return model.hasDate(value);
    }
    
}
