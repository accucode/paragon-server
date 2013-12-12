//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.comparator.KmCompareUtility;
import com.kodemore.meta.KmMetaDaoPropertyIF;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

import com.app.dao.MyInvitationDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationValidator;
import com.app.utility.MyGlobals;

public class MyMetaInvitation_CreatedUtcTs
    extends KmMetaTimestampProperty<MyInvitation>
    implements KmMetaDaoPropertyIF<MyInvitation,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Created Utc Ts";
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
        return MyInvitationValidator.instance.getCreatedUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "createdUtcTs";
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
    public KmTimestamp getValueFor(MyInvitation model)
    {
        return model.getCreatedUtcTs();
    }
    
    @Override
    public void setValueFor(MyInvitation model, KmTimestamp value)
    {
        model.setCreatedUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, KmTimestamp value)
    {
        return model.hasCreatedUtcTs(value);
    }
    
    @Override
    public int compareValues(MyInvitation o1, MyInvitation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
