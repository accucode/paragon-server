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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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

public class MyMetaUserActivation_Email
    extends KmMetaStringProperty<MyUserActivation>
    implements KmMetaDaoPropertyIF<MyUserActivation,String>
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
        return "The email to be activated.";
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
        return MyUserActivationValidator.instance.getEmailValidator();
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
    public MyUserActivationDao getDao()
    {
        return getAccess().getUserActivationDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyUserActivation model)
    {
        return model.getEmail();
    }
    
    @Override
    public void setValueFor(MyUserActivation model, String value)
    {
        model.setEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyUserActivation model, String value)
    {
        return model.hasEmail(value);
    }
    
    @Override
    public int compareValues(MyUserActivation o1, MyUserActivation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
