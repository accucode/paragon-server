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

public class MyMetaEmailRecipient_TypeCode
    extends KmMetaStringProperty<MyEmailRecipient>
    implements KmMetaDaoPropertyIF<MyEmailRecipient,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "typeCode";
    }

    @Override
    public String getLabel()
    {
        return "Type Code";
    }

    @Override
    public String getHelp()
    {
        return null;
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
        return MyEmailRecipientValidator.instance.getTypeCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "typeCode";
    }

    @Override
    public MyEmailRecipientDao getDao()
    {
        return getAccess().getEmailRecipientDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# enum
    //##################################################

    public ScEnumDropdownField newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScEnumDropdownField newDropdown(String label)
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(this);
        e.addOptions(MyEmailRecipientType.values());
        return e;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEmailRecipient model)
    {
        return model.getTypeCode();
    }

    @Override
    public void setValueFor(MyEmailRecipient model, String value)
    {
        model.setTypeCode(value);
    }

    @Override
    public boolean hasValueFor(MyEmailRecipient model, String value)
    {
        return model.hasTypeCode(value);
    }

}
