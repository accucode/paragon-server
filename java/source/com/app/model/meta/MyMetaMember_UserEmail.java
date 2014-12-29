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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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

public class MyMetaMember_UserEmail
    extends KmMetaStringProperty<MyMember>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userEmail";
    }

    @Override
    public String getLabel()
    {
        return "Email";
    }

    @Override
    public String getHelp()
    {
        return "Used both to sign in, and to send emails to this user.";
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

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyMember model)
    {
        return model.getUserEmail();
    }
    
    @Override
    public void setValueFor(MyMember model, String value)
    {
        model.setUserEmail(value);
    }
    
    @Override
    public boolean hasValueFor(MyMember model, String value)
    {
        return model.hasUserEmail(value);
    }
    
    @Override
    public int compareValues(MyMember o1, MyMember o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
