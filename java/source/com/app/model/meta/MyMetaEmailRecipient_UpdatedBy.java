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

public class MyMetaEmailRecipient_UpdatedBy
    extends KmMetaDaoAssociation<MyEmailRecipient,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "updatedBy";
    }

    @Override
    public String getLabel()
    {
        return "Updated By";
    }

    @Override
    public String getHelp()
    {
        return "The user that last updated this record, if known.";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyEmailRecipient model)
    {
        return model.getUpdatedBy();
    }

    @Override
    public void setValueFor(MyEmailRecipient model, MyUser value)
    {
        model.setUpdatedBy(value);
    }

    @Override
    public boolean hasValueFor(MyEmailRecipient model, MyUser value)
    {
        return model.hasUpdatedBy(value);
    }
}
