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

public class MyMetaAuditLogBundleVo_DomainType
    extends KmMetaStringProperty<MyAuditLogBundleVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "domainType";
    }

    @Override
    public String getLabel()
    {
        return "Domain Type";
    }

    @Override
    public String getHelp()
    {
        return "The type of domain; e.g.: project, depot, salesOrderLine, etc.";
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
        return MyAuditLogBundleVoValidator.instance.getDomainTypeValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAuditLogBundleVo model)
    {
        return model.getDomainType();
    }

    @Override
    public void setValueFor(MyAuditLogBundleVo model, String value)
    {
        model.setDomainType(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLogBundleVo model, String value)
    {
        return model.hasDomainType(value);
    }

}
