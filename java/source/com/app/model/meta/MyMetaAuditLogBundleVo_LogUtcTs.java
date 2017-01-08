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

public class MyMetaAuditLogBundleVo_LogUtcTs
    extends KmMetaTimestampProperty<MyAuditLogBundleVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "logUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Log Utc Ts";
    }

    @Override
    public String getHelp()
    {
        return "The time this change was made.";
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
        return MyAuditLogBundleVoValidator.instance.getLogUtcTsValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyAuditLogBundleVo model)
    {
        return model.getLogUtcTs();
    }

    @Override
    public void setValueFor(MyAuditLogBundleVo model, KmTimestamp value)
    {
        model.setLogUtcTs(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLogBundleVo model, KmTimestamp value)
    {
        return model.hasLogUtcTs(value);
    }

}
