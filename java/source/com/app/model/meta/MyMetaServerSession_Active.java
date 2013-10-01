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
import com.kodemore.meta.KmMetaBooleanProperty;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.validator.KmBooleanValidator;

public class MyMetaServerSession_Active
    extends KmMetaBooleanProperty<MyServerSession>
    implements KmMetaDaoPropertyIF<MyServerSession,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "active";
    }

    @Override
    public String getLabel()
    {
        return "Active";
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmBooleanValidator getValidator()
    {
        return MyServerSessionValidator.instance.getActiveValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "active";
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
    public Boolean getValueFor(MyServerSession model)
    {
        return model.getActive();
    }
    
    @Override
    public void setValueFor(MyServerSession model, Boolean value)
    {
        model.setActive(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, Boolean value)
    {
        return model.hasActive(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
