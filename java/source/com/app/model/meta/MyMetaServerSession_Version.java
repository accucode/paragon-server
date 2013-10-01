//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyServerSessionDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyServerSession;
import com.app.model.MyServerSessionValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.validator.KmStringValidator;

public class MyMetaServerSession_Version
    extends KmMetaStringProperty<MyServerSession>
    implements KmMetaDaoPropertyIF<MyServerSession,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "version";
    }

    @Override
    public String getLabel()
    {
        return "Version";
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
        return MyServerSessionValidator.instance.getVersionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "version";
    }

    @Override
    public MyServerSessionDao getDao()
    {
        return getAccess().getServerSessionDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyServerSession model)
    {
        return model.getVersion();
    }
    
    @Override
    public void setValueFor(MyServerSession model, String value)
    {
        model.setVersion(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, String value)
    {
        return model.hasVersion(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
