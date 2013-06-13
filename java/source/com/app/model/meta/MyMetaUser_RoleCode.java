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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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
        return "Role Code";
    }

    @Override
    public int getColumnWidth()
    {
        return 3;
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

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# enum
    //##################################################

    public ScDropdown newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScDropdown newDropdown(String label)
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel(label);
        e.setValidator(getValidator());
        e.setValue(getAdaptor());
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
    
    @Override
    public int compareValues(MyUser o1, MyUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
