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

public class MyMetaSalesOrderContact_OrderNotifications
    extends KmMetaBooleanProperty<MySalesOrderContact>
    implements KmMetaDaoPropertyIF<MySalesOrderContact,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "orderNotifications";
    }

    @Override
    public String getLabel()
    {
        return "Order Notifications";
    }

    @Override
    public String getHelp()
    {
        return "If true, we will attempt to send notifications about orders.";
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
        return MySalesOrderContactValidator.instance.getOrderNotificationsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "orderNotifications";
    }

    @Override
    public MySalesOrderContactDao getDao()
    {
        return getAccess().getSalesOrderContactDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MySalesOrderContact model)
    {
        return model.getOrderNotifications();
    }
    
    @Override
    public void setValueFor(MySalesOrderContact model, Boolean value)
    {
        model.setOrderNotifications(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderContact model, Boolean value)
    {
        return model.hasOrderNotifications(value);
    }
    
}
