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

public class MyMetaProject_OrderNumberPrefix
    extends KmMetaStringProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "orderNumberPrefix";
    }

    @Override
    public String getLabel()
    {
        return "Order Number Prefix";
    }

    @Override
    public String getHelp()
    {
        return "The unique prefix used for all order numbers on this project. This can be changed, but changing it does not affect any orders (or order numbers) already created.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 5;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyProjectValidator.instance.getOrderNumberPrefixValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "orderNumberPrefix";
    }

    @Override
    public MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyProject model)
    {
        return model.getOrderNumberPrefix();
    }
    
    @Override
    public void setValueFor(MyProject model, String value)
    {
        model.setOrderNumberPrefix(value);
    }
    
    @Override
    public boolean hasValueFor(MyProject model, String value)
    {
        return model.hasOrderNumberPrefix(value);
    }
    
}
