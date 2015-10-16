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

public class MyMetaSalesOrderContact_Phone
    extends KmMetaStringProperty<MySalesOrderContact>
    implements KmMetaDaoPropertyIF<MySalesOrderContact,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "phone";
    }

    @Override
    public String getLabel()
    {
        return "Phone";
    }

    @Override
    public String getHelp()
    {
        return "The person's phone number.  E.g.: 303.555.1234.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 12;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MySalesOrderContactValidator.instance.getPhoneValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "phone";
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
        return model.getPhone();
    }
    
    @Override
    public void setValueFor(MySalesOrderContact model, String value)
    {
        model.setPhone(value);
    }
    
    @Override
    public boolean hasValueFor(MySalesOrderContact model, String value)
    {
        return model.hasPhone(value);
    }
    
}
