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

public class MyMetaServerSession_Active
    extends KmMetaBooleanProperty<MyServerSession>
    implements KmMetaDaoPropertyIF<MyServerSession,Boolean>
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
        return "This indicates if the session is currently active, or if it has expired.";
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
        return MyServerSessionValidator.instance.getActiveValidator();
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
    public Boolean getValueFor(MyServerSession model)
    {
        return model.getActive();
    }

    @Override
    public void setValueFor(MyServerSession model, Boolean value)
    {
        model.setActive(value);
    }

    @Override
    public boolean hasValueFor(MyServerSession model, Boolean value)
    {
        return model.hasActive(value);
    }

}
