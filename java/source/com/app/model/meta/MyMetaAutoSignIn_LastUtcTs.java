//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.dao.MyAutoSignInDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAutoSignIn;
import com.app.model.MyAutoSignInValidator;
import com.app.utility.MyGlobals;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public class MyMetaAutoSignIn_LastUtcTs
    extends KmMetaTimestampProperty<MyAutoSignIn>
    implements KmMetaDaoPropertyIF<MyAutoSignIn,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "lastUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Last Utc Ts";
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
        return MyAutoSignInValidator.instance.getLastUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "lastUtcTs";
    }

    @Override
    public MyAutoSignInDao getDao()
    {
        return getAccess().getAutoSignInDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyAutoSignIn model)
    {
        return model.getLastUtcTs();
    }
    
    @Override
    public void setValueFor(MyAutoSignIn model, KmTimestamp value)
    {
        model.setLastUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyAutoSignIn model, KmTimestamp value)
    {
        return model.hasLastUtcTs(value);
    }
    
    @Override
    public int compareValues(MyAutoSignIn o1, MyAutoSignIn o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
