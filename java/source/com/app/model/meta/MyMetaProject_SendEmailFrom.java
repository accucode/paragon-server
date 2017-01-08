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

public class MyMetaProject_SendEmailFrom
    extends KmMetaStringProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "sendEmailFrom";
    }

    @Override
    public String getLabel()
    {
        return "Send Email From";
    }

    @Override
    public String getHelp()
    {
        return "The email address that all project emails will be sent FROM.";
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
        return MyProjectValidator.instance.getSendEmailFromValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "sendEmailFrom";
    }

    @Override
    public MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyProject model)
    {
        return model.getSendEmailFrom();
    }

    @Override
    public void setValueFor(MyProject model, String value)
    {
        model.setSendEmailFrom(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, String value)
    {
        return model.hasSendEmailFrom(value);
    }

}
