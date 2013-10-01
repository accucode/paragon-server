//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyAccountUserDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyAccountUserValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.validator.KmStringValidator;

public class MyMetaAccountUser_RoleCode
    extends KmMetaStringProperty<MyAccountUser>
    implements KmMetaDaoPropertyIF<MyAccountUser,String>
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
        return MyAccountUserValidator.instance.getRoleCodeValidator();
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
    public MyAccountUserDao getDao()
    {
        return getAccess().getAccountUserDao();
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
        e.addOptions(MyAccountUserRole.values());
        return e;
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAccountUser model)
    {
        return model.getRoleCode();
    }
    
    @Override
    public void setValueFor(MyAccountUser model, String value)
    {
        model.setRoleCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyAccountUser model, String value)
    {
        return model.hasRoleCode(value);
    }
    
    @Override
    public int compareValues(MyAccountUser o1, MyAccountUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
