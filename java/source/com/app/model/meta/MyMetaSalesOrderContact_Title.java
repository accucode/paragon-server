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

public class MyMetaSalesOrderContact_Title
    extends KmMetaStringProperty<MySalesOrderContact>
    implements KmMetaDaoPropertyIF<MySalesOrderContact,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "title";
    }

    @Override
    public String getLabel()
    {
        return "Title";
    }

    @Override
    public String getHelp()
    {
        return "The person's business title.  E.g.: Director of Sales.";
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
        return MySalesOrderContactValidator.instance.getTitleValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "title";
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
    public String getValueFor(MySalesOrderContact model)
    {
        return model.getTitle();
    }
    
    @Override
    public void setValueFor(MySalesOrderContact model, String value)
    {
        model.setTitle(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderContact model, String value)
    {
        return model.hasTitle(value);
    }
    
}
