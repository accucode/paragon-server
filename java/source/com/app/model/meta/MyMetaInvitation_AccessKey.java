//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyInvitationDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaInvitation_AccessKey
    extends KmMetaStringProperty<MyInvitation>
    implements KmMetaDaoPropertyIF<MyInvitation,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "accessKey";
    }

    @Override
    public String getLabel()
    {
        return "Access Key";
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
        return MyInvitationValidator.instance.getAccessKeyValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "accessKey";
    }

    @Override
    public MyInvitationDao getDao()
    {
        return getAccess().getInvitationDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyInvitation model)
    {
        return model.getAccessKey();
    }
    
    @Override
    public void setValueFor(MyInvitation model, String value)
    {
        model.setAccessKey(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, String value)
    {
        return model.hasAccessKey(value);
    }
    
    @Override
    public int compareValues(MyInvitation o1, MyInvitation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
