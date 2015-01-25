//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.dao.base;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MySettingsDaoBase
    extends KmAbstractDao<MySettings,Integer>
    implements MySettingsDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySettingsDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySettings> getPersistentClass()
    {
        return MySettings.class;
    }

    @Override
    protected String getTableName()
    {
        return "settings";
    }

    @Override
    public MySettingsCriteria createCriteria()
    {
        return new MySettingsCriteria(createGenericCriteria());
    }

    protected MyMetaSettings getMeta()
    {
        return MySettings.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySettings findCode(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteCode(Integer e)
    {
        MySettings m = findCode(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
