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

public class MyMetaTenant_IntacctUserId
    extends KmMetaStringProperty<MyTenant>
    implements KmMetaDaoPropertyIF<MyTenant,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "intacctUserId";
    }

    @Override
    public String getLabel()
    {
        return "Intacct User Id";
    }

    @Override
    public String getHelp()
    {
        return "The intacct user, used for integration. This is the user id entered on the Intacct login page. Intacct's recommendation is to use 'xml_gateway'. However, any valid Intacct user can be used.";
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
        return MyTenantValidator.instance.getIntacctUserIdValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "intacctUserId";
    }

    @Override
    public MyTenantDao getDao()
    {
        return getAccess().getTenantDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyTenant model)
    {
        return model.getIntacctUserId();
    }

    @Override
    public void setValueFor(MyTenant model, String value)
    {
        model.setIntacctUserId(value);
    }

    @Override
    public boolean hasValueFor(MyTenant model, String value)
    {
        return model.hasIntacctUserId(value);
    }

}
