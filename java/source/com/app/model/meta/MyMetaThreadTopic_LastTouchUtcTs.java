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

public class MyMetaThreadTopic_LastTouchUtcTs
    extends KmMetaTimestampProperty<MyThreadTopic>
    implements KmMetaDaoPropertyIF<MyThreadTopic,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Last Touch Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The last time the owner TOUCHED this task. This is used to coordinate ownership. JVM may shutdown, get restarted, or simply hang completely. If the current owner has not touched the record in the last 10 minutes, then it is assumed that the owner has died and that someone else should be assigned as the owner.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyThreadTopicValidator.instance.getLastTouchUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lastTouchUtcTs";
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
    public KmTimestamp getValueFor(MyThreadTopic model)
    {
        return model.getLastTouchUtcTs();
    }
    
    @Override
    public void setValueFor(MyThreadTopic model, KmTimestamp value)
    {
        model.setLastTouchUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
    {
        return model.hasLastTouchUtcTs(value);
    }
    
}
