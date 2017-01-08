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

public class MyMetaPasswordReset_Email
    extends KmMetaStringProperty<MyPasswordReset>
    implements KmMetaDaoPropertyIF<MyPasswordReset,String>
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
        return "The email to be reset.";
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
        return MyPasswordResetValidator.instance.getEmailValidator();
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
    public MyPasswordResetDao getDao()
    {
        return getAccess().getPasswordResetDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPasswordReset model)
    {
        return model.getEmail();
    }

    @Override
    public void setValueFor(MyPasswordReset model, String value)
    {
        model.setEmail(value);
    }

    @Override
    public boolean hasValueFor(MyPasswordReset model, String value)
    {
        return model.hasEmail(value);
    }

}
