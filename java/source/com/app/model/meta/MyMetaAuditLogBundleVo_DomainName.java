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

public class MyMetaAuditLogBundleVo_DomainName
    extends KmMetaStringProperty<MyAuditLogBundleVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "domainName";
    }

    @Override
    public String getLabel()
    {
        return "Domain Name";
    }

    @Override
    public String getHelp()
    {
        return "The common, but non-unique name of the domain. Models generally rely on long UIDs as their unique identifier so we also store a domain's display string as a 'name'.  Although this name is not guaranteed to be unique, it is generally human-readable and is usually sufficient to identify which domain was affected.";
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
        return MyAuditLogBundleVoValidator.instance.getDomainNameValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAuditLogBundleVo model)
    {
        return model.getDomainName();
    }

    @Override
    public void setValueFor(MyAuditLogBundleVo model, String value)
    {
        model.setDomainName(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLogBundleVo model, String value)
    {
        return model.hasDomainName(value);
    }

}
