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

public class MyMetaAutoLogin_TenantName
    extends KmMetaStringProperty<MyAutoLogin>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "tenantName";
    }

    @Override
    public String getLabel()
    {
        return "Tenant";
    }

    @Override
    public String getHelp()
    {
        return "The short display name of this tenant.";
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
    public String getValueFor(MyAutoLogin model)
    {
        return model.getTenantName();
    }

    @Override
    public void setValueFor(MyAutoLogin model, String value)
    {
        model.setTenantName(value);
    }

    @Override
    public boolean hasValueFor(MyAutoLogin model, String value)
    {
        return model.hasTenantName(value);
    }

}
