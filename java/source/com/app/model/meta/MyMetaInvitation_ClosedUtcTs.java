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

public class MyMetaInvitation_ClosedUtcTs
    extends KmMetaTimestampProperty<MyInvitation>
    implements KmMetaDaoPropertyIF<MyInvitation,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Closed Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when this invitation was closed (e.g.: accepted).";
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
        return MyInvitationValidator.instance.getClosedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "closedUtcTs";
    }

    @Override
    public MyInvitationDao getDao()
    {
        return getAccess().getInvitationDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyInvitation model)
    {
        return model.getClosedUtcTs();
    }
    
    @Override
    public void setValueFor(MyInvitation model, KmTimestamp value)
    {
        model.setClosedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, KmTimestamp value)
    {
        return model.hasClosedUtcTs(value);
    }
    
}
