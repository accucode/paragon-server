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
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaEndUserSite_EndUser
    extends KmMetaDaoAssociation<MyEndUserSite,MyEndUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "endUser";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyEndUser getValueFor(MyEndUserSite model)
    {
        return model.getEndUser();
    }
    
    @Override
    public void setValueFor(MyEndUserSite model, MyEndUser value)
    {
        model.setEndUser(value);
    }
    
    @Override
    public boolean hasValueFor(MyEndUserSite model, MyEndUser value)
    {
        return model.hasEndUser(value);
    }
}
