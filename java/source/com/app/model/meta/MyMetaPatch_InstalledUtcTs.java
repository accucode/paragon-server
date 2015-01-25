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
    public String getHelp()
    {
        return "The date and time when the patch was installed in this database.";
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
