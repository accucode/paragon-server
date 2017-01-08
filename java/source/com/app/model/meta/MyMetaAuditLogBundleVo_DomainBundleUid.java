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

public class MyMetaAuditLogBundleVo_DomainBundleUid
    extends KmMetaStringProperty<MyAuditLogBundleVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "domainBundleUid";
    }

    @Override
    public String getLabel()
    {
        return "Domain Bundle Uid";
    }

    @Override
    public String getHelp()
    {
        return "I am used to identity a bundle of logs related to a particular domain. In many cases, a particular domain will have multiple fields modified at the same time.  The bundle identifies this group of changes.  Sometimes multiple bundles may occur within the same transaction for the same domain.";
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

    @Override
    public KmStringValidator getValidator()
    {
        return MyAuditLogBundleVoValidator.instance.getDomainBundleUidValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAuditLogBundleVo model)
    {
        return model.getDomainBundleUid();
    }

    @Override
    public void setValueFor(MyAuditLogBundleVo model, String value)
    {
        model.setDomainBundleUid(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLogBundleVo model, String value)
    {
        return model.hasDomainBundleUid(value);
    }

}
