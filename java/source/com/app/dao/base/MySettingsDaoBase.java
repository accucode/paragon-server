//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;

import com.app.criteria.MySettingsCriteria;
import com.app.model.MySettings;
import com.app.model.meta.MyMetaSettings;

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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
