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

public class MyMetaUser_RoleCode
    extends KmMetaStringProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "roleCode";
    }

    @Override
    public String getLabel()
    {
        return "Role";
    }

    @Override
    public String getHelp()
    {
        return "The user's global access role.\n Developer, has full access to all data and functions in the app.\n Admin, has access to admin functions e.g. adding/editing users and projects.\n Other, any other user.";
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
        return MyUserValidator.instance.getRoleCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "roleCode";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
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
        e.addOptions(MyUserRole.values());
        return e;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyUser model)
    {
        return model.getRoleCode();
    }

    @Override
    public void setValueFor(MyUser model, String value)
    {
        model.setRoleCode(value);
    }

    @Override
    public boolean hasValueFor(MyUser model, String value)
    {
        return model.hasRoleCode(value);
    }

}
