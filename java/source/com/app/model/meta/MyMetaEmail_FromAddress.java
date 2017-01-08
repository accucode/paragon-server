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

public class MyMetaEmail_FromAddress
    extends KmMetaStringProperty<MyEmail>
    implements KmMetaDaoPropertyIF<MyEmail,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fromAddress";
    }

    @Override
    public String getLabel()
    {
        return "From";
    }

    @Override
    public String getHelp()
    {
        return "The from address.";
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
        return MyEmailValidator.instance.getFromAddressValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "fromAddress";
    }

    @Override
    public MyEmailDao getDao()
    {
        return getAccess().getEmailDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEmail model)
    {
        return model.getFromAddress();
    }

    @Override
    public void setValueFor(MyEmail model, String value)
    {
        model.setFromAddress(value);
    }

    @Override
    public boolean hasValueFor(MyEmail model, String value)
    {
        return model.hasFromAddress(value);
    }

}
