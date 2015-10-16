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

public class MyMetaCustomerContact_Email
    extends KmMetaStringProperty<MyCustomerContact>
    implements KmMetaDaoPropertyIF<MyCustomerContact,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "email";
    }

    @Override
    public String getLabel()
    {
        return "Email";
    }

    @Override
    public String getHelp()
    {
        return "The person's email address.  E.g.: john.doe@example.com.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyCustomerContactValidator.instance.getEmailValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "email";
    }

    @Override
    public MyCustomerContactDao getDao()
    {
        return getAccess().getCustomerContactDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyCustomerContact model)
    {
        return model.getEmail();
    }
    
    @Override
    public void setValueFor(MyCustomerContact model, String value)
    {
        model.setEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyCustomerContact model, String value)
    {
        return model.hasEmail(value);
    }
    
}
