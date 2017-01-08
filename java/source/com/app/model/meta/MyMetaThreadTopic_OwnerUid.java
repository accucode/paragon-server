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

public class MyMetaThreadTopic_OwnerUid
    extends KmMetaStringProperty<MyThreadTopic>
    implements KmMetaDaoPropertyIF<MyThreadTopic,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "ownerUid";
    }

    @Override
    public String getLabel()
    {
        return "Owner Uid";
    }

    @Override
    public String getHelp()
    {
        return "The unique id of a particular JVM.  This is typically generated as a random UID within the JVM rather than trying to rely on an externally generated value.  It is understood that restarting a JVM will likely change the ownerUid even if it is the only JVM on that machine.";
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
        return MyThreadTopicValidator.instance.getOwnerUidValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "ownerUid";
    }

    @Override
    public MyThreadTopicDao getDao()
    {
        return getAccess().getThreadTopicDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyThreadTopic model)
    {
        return model.getOwnerUid();
    }

    @Override
    public void setValueFor(MyThreadTopic model, String value)
    {
        model.setOwnerUid(value);
    }

    @Override
    public boolean hasValueFor(MyThreadTopic model, String value)
    {
        return model.hasOwnerUid(value);
    }

}
