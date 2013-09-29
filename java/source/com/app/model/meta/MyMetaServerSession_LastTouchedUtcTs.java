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
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public class MyMetaServerSession_LastTouchedUtcTs
    extends KmMetaTimestampProperty<MyServerSession>
    implements KmMetaDaoPropertyIF<MyServerSession,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastTouchedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Last Touched Utc Ts";
    }

    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyServerSessionValidator.instance.getLastTouchedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lastTouchedUtcTs";
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
    public KmTimestamp getValueFor(MyServerSession model)
    {
        return model.getLastTouchedUtcTs();
    }
    
    @Override
    public void setValueFor(MyServerSession model, KmTimestamp value)
    {
        model.setLastTouchedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyServerSession model, KmTimestamp value)
    {
        return model.hasLastTouchedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyServerSession o1, MyServerSession o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
