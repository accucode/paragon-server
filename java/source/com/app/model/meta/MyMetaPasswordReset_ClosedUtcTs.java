//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyPasswordResetDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPasswordReset;
import com.app.model.MyPasswordResetValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public class MyMetaPasswordReset_ClosedUtcTs
    extends KmMetaTimestampProperty<MyPasswordReset>
    implements KmMetaDaoPropertyIF<MyPasswordReset,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Closed Utc Ts";
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
        return MyPasswordResetValidator.instance.getClosedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "closedUtcTs";
    }

    @Override
    public MyPasswordResetDao getDao()
    {
        return getAccess().getPasswordResetDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyPasswordReset model)
    {
        return model.getClosedUtcTs();
    }
    
    @Override
    public void setValueFor(MyPasswordReset model, KmTimestamp value)
    {
        model.setClosedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
    {
        return model.hasClosedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyPasswordReset o1, MyPasswordReset o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
