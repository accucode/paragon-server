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

import com.app.dao.MyPatchDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPatch;
import com.app.model.MyPatchValidator;
import com.app.utility.MyGlobals;

public class MyMetaPatch_InstalledUtcTs
    extends KmMetaTimestampProperty<MyPatch>
    implements KmMetaDaoPropertyIF<MyPatch,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "installedUtcTs";
    }

    @Override
    public String getLabel()
    {
        return "Installed Utc Ts";
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
        return MyPatchValidator.instance.getInstalledUtcTsValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "installedUtcTs";
    }

    @Override
    public MyPatchDao getDao()
    {
        return getAccess().getPatchDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValueFor(MyPatch model)
    {
        return model.getInstalledUtcTs();
    }
    
    @Override
    public void setValueFor(MyPatch model, KmTimestamp value)
    {
        model.setInstalledUtcTs(value);
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, KmTimestamp value)
    {
        return model.hasInstalledUtcTs(value);
    }
    
    @Override
    public int compareValues(MyPatch o1, MyPatch o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
