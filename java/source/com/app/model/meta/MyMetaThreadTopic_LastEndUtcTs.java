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

public class MyMetaThreadTopic_LastEndUtcTs
    extends KmMetaTimestampProperty<MyThreadTopic>
    implements KmMetaDaoPropertyIF<MyThreadTopic,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastEndUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Last End Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The last time the owner ENDED this task. This is only used for auditing; not for coordinating ownership.";
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
        return MyThreadTopicValidator.instance.getLastEndUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lastEndUtcTs";
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
        return model.getLastEndUtcTs();
    }
    
    @Override
    public void setValueFor(MyThreadTopic model, KmTimestamp value)
    {
        model.setLastEndUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
    {
        return model.hasLastEndUtcTs(value);
    }
    
}
