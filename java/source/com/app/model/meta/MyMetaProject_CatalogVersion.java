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
import com.kodemore.exception.*;
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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaProject_CatalogVersion
    extends KmMetaIntegerProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "catalogVersion";
    }

    @Override
    public String getLabel()
    {
        return "Catalog Version";
    }

    @Override
    public String getHelp()
    {
        return "An internal version number for the product catalog.  This is incremented any time a new version of a product or price sheet is published.  This provides a simple way to coordinate in-memory caches.";
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
    public KmIntegerValidator getValidator()
    {
        return MyProjectValidator.instance.getCatalogVersionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "catalogVersion";
    }

    @Override
    public MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyProject model)
    {
        return model.getCatalogVersion();
    }

    @Override
    public void setValueFor(MyProject model, Integer value)
    {
        model.setCatalogVersion(value);
    }

    @Override
    public boolean hasValueFor(MyProject model, Integer value)
    {
        return model.hasCatalogVersion(value);
    }

}
