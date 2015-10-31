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

public class MyMetaAttentionMember_UserName
    extends KmMetaStringProperty<MyAttentionMember>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userName";
    }

    @Override
    public String getLabel()
    {
        return "User Name";
    }

    @Override
    public String getHelp()
    {
        return "The user's full name.  E.g.: \"John Doe\".";
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

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAttentionMember model)
    {
        return model.getUserName();
    }
    
    @Override
    public void setValueFor(MyAttentionMember model, String value)
    {
        model.setUserName(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttentionMember model, String value)
    {
        return model.hasUserName(value);
    }
    
}
