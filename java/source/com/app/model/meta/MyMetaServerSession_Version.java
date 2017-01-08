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

public class MyMetaServerSession_Version
    extends KmMetaStringProperty<MyServerSession>
    implements KmMetaDaoPropertyIF<MyServerSession,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "version";
    }

    @Override
    public String getLabel()
    {
        return "Version";
    }

    @Override
    public String getHelp()
    {
        return "The application version. The server session is only valid if its version matches the application's current version. This is used to catch stale sessions when the application is upgraded.";
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
        return MyServerSessionValidator.instance.getVersionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "version";
    }

    @Override
    public MyServerSessionDao getDao()
    {
        return getAccess().getServerSessionDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyServerSession model)
    {
        return model.getVersion();
    }

    @Override
    public void setValueFor(MyServerSession model, String value)
    {
        model.setVersion(value);
    }

    @Override
    public boolean hasValueFor(MyServerSession model, String value)
    {
        return model.hasVersion(value);
    }

}
