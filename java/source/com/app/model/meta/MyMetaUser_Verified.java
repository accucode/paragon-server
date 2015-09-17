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

public class MyMetaUser_Verified
    extends KmMetaBooleanProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "verified";
    }

    @Override
    public String getLabel()
    {
        return "Verified";
    }

    @Override
    public String getHelp()
    {
        return "Indicates if this user's email address has been verified. We require the email address to be verified before the user is allowed to log in.";
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
        return MyUserValidator.instance.getVerifiedValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "verified";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyUser model)
    {
        return model.getVerified();
    }
    
    @Override
    public void setValueFor(MyUser model, Boolean value)
    {
        model.setVerified(value);
    }
    
    @Override
    public boolean hasValueFor(MyUser model, Boolean value)
    {
        return model.hasVerified(value);
    }
    
}
