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

public class MyMetaInvitation_StatusCode
    extends KmMetaStringProperty<MyInvitation>
    implements KmMetaDaoPropertyIF<MyInvitation,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "statusCode";
    }

    @Override
    public String getLabel()
    {
        return "Status Code";
    }

    @Override
    public String getHelp()
    {
        return "The status of this invitation: pending, accepted, rejected, expired, or cancelled.";
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
        return MyInvitationValidator.instance.getStatusCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "statusCode";
    }

    @Override
    public MyInvitationDao getDao()
    {
        return getAccess().getInvitationDao();
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
        e.addOptions(MyInvitationStatus.values());
        return e;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyInvitation model)
    {
        return model.getStatusCode();
    }

    @Override
    public void setValueFor(MyInvitation model, String value)
    {
        model.setStatusCode(value);
    }

    @Override
    public boolean hasValueFor(MyInvitation model, String value)
    {
        return model.hasStatusCode(value);
    }

}
