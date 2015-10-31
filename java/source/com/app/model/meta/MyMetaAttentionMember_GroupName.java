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

public class MyMetaAttentionMember_GroupName
    extends KmMetaStringProperty<MyAttentionMember>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "groupName";
    }

    @Override
    public String getLabel()
    {
        return "Group Name";
    }

    @Override
    public String getHelp()
    {
        return "The display name of this group. This should generally be unique within a given project.";
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
        return model.getGroupName();
    }
    
    @Override
    public void setValueFor(MyAttentionMember model, String value)
    {
        model.setGroupName(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttentionMember model, String value)
    {
        return model.hasGroupName(value);
    }
    
}
