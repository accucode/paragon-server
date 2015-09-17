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

public class MyMetaEmail_SentUtcTs
    extends KmMetaTimestampProperty<MyEmail>
    implements KmMetaDaoPropertyIF<MyEmail,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "sentUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Sent Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when the email was last sent.";
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
        return MyEmailValidator.instance.getSentUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "sentUtcTs";
    }

    @Override
    public MyEmailDao getDao()
    {
        return getAccess().getEmailDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyEmail model)
    {
        return model.getSentUtcTs();
    }
    
    @Override
    public void setValueFor(MyEmail model, KmTimestamp value)
    {
        model.setSentUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyEmail model, KmTimestamp value)
    {
        return model.hasSentUtcTs(value);
    }
    
}
