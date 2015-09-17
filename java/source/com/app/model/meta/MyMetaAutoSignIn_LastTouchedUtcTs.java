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

public class MyMetaAutoSignIn_LastTouchedUtcTs
    extends KmMetaTimestampProperty<MyAutoSignIn>
    implements KmMetaDaoPropertyIF<MyAutoSignIn,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Last Touched Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The date and time the user logged in.  This is generally updated each time the user logs in either manaully or automatically.";
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
        return MyAutoSignInValidator.instance.getLastTouchedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lastTouchedUtcTs";
    }

    @Override
    public MyAutoSignInDao getDao()
    {
        return getAccess().getAutoSignInDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyAutoSignIn model)
    {
        return model.getLastTouchedUtcTs();
    }
    
    @Override
    public void setValueFor(MyAutoSignIn model, KmTimestamp value)
    {
        model.setLastTouchedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, KmTimestamp value)
    {
        return model.hasLastTouchedUtcTs(value);
    }
    
}
