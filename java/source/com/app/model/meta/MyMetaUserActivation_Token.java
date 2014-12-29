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

public class MyMetaUserActivation_Token
    extends KmMetaStringProperty<MyUserActivation>
    implements KmMetaDaoPropertyIF<MyUserActivation,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "token";
    }

    @Override
    public String getLabel()
    {
        return "Token";
    }

    @Override
    public String getHelp()
    {
        return "A long unique code that allows access without a password.";
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
        return MyUserActivationValidator.instance.getTokenValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "token";
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
        return model.getToken();
    }
    
    @Override
    public void setValueFor(MyUserActivation model, String value)
    {
        model.setToken(value);
    }
    
    @Override
    public boolean hasValueFor(MyUserActivation model, String value)
    {
        return model.hasToken(value);
    }
    
    @Override
    public int compareValues(MyUserActivation o1, MyUserActivation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
