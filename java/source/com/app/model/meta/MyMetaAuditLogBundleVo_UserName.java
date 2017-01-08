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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaAuditLogBundleVo_UserName
    extends KmMetaStringProperty<MyAuditLogBundleVo>
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
        return "The user's name (denormalized).";
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

    @Override
    public KmStringValidator getValidator()
    {
        return MyAuditLogBundleVoValidator.instance.getUserNameValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAuditLogBundleVo model)
    {
        return model.getUserName();
    }

    @Override
    public void setValueFor(MyAuditLogBundleVo model, String value)
    {
        model.setUserName(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLogBundleVo model, String value)
    {
        return model.hasUserName(value);
    }

}
