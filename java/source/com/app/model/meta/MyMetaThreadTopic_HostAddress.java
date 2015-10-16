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

public class MyMetaThreadTopic_HostAddress
    extends KmMetaStringProperty<MyThreadTopic>
    implements KmMetaDaoPropertyIF<MyThreadTopic,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "hostAddress";
    }

    @Override
    public String getLabel()
    {
        return "Host Address";
    }

    @Override
    public String getHelp()
    {
        return "The host machine on which the current owner is running. This is only used for auditing; not for coordinating ownership.";
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
        return MyThreadTopicValidator.instance.getHostAddressValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "hostAddress";
    }

    @Override
    public MyThreadTopicDao getDao()
    {
        return getAccess().getThreadTopicDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyThreadTopic model)
    {
        return model.getHostAddress();
    }
    
    @Override
    public void setValueFor(MyThreadTopic model, String value)
    {
        model.setHostAddress(value);
    }
    
    @Override
    public boolean hasValueFor(MyThreadTopic model, String value)
    {
        return model.hasHostAddress(value);
    }
    
}
