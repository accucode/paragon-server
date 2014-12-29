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

public class MyMetaHibernateCacheTest_Data
    extends KmMetaStringProperty<MyHibernateCacheTest>
    implements KmMetaDaoPropertyIF<MyHibernateCacheTest,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "data";
    }

    @Override
    public String getLabel()
    {
        return "Data";
    }

    @Override
    public String getHelp()
    {
        return "Random data used for testing.";
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
        return MyHibernateCacheTestValidator.instance.getDataValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "data";
    }

    @Override
    public MyHibernateCacheTestDao getDao()
    {
        return getAccess().getHibernateCacheTestDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyHibernateCacheTest model)
    {
        return model.getData();
    }
    
    @Override
    public void setValueFor(MyHibernateCacheTest model, String value)
    {
        model.setData(value);
    }
    
    @Override
    public boolean hasValueFor(MyHibernateCacheTest model, String value)
    {
        return model.hasData(value);
    }
    
    @Override
    public int compareValues(MyHibernateCacheTest o1, MyHibernateCacheTest o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
