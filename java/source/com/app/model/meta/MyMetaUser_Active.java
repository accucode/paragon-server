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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaUser_Active
    extends KmMetaBooleanProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "active";
    }

    @Override
    public String getLabel()
    {
        return "Active";
    }

    @Override
    public String getHelp()
    {
        return "Indicates if this user is allowed to log in. New users are active by default, but can be de-activated to easily restrict access to the entire system.";
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
        return MyUserValidator.instance.getActiveValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "active";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyUser model)
    {
        return model.getActive();
    }

    @Override
    public void setValueFor(MyUser model, Boolean value)
    {
        model.setActive(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, Boolean value)
    {
        return model.hasActive(value);
    }

}
