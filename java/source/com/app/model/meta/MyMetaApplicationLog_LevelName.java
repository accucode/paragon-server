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

public class MyMetaApplicationLog_LevelName
    extends KmMetaStringProperty<MyApplicationLog>
    implements KmMetaDaoPropertyIF<MyApplicationLog,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "levelName";
    }

    @Override
    public String getLabel()
    {
        return "Level Name";
    }

    @Override
    public String getHelp()
    {
        return "The display name for the severity level. E.g.: info, warn, error.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 5;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyApplicationLogValidator.instance.getLevelNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "levelName";
    }

    @Override
    public MyApplicationLogDao getDao()
    {
        return getAccess().getApplicationLogDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyApplicationLog model)
    {
        return model.getLevelName();
    }
    
    @Override
    public void setValueFor(MyApplicationLog model, String value)
    {
        model.setLevelName(value);
    }
    
    @Override
    public boolean hasValueFor(MyApplicationLog model, String value)
    {
        return model.hasLevelName(value);
    }
    
    @Override
    public int compareValues(MyApplicationLog o1, MyApplicationLog o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
