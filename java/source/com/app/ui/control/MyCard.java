package com.app.ui.control;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

/**
 * Used to wrap dynamic ajax content.
 */
public class MyCard
    extends ScCard
{
    public MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    public static MyDaoAccess getAccess()
    {
        return MyDaoAccess.getInstance();
    }

    public MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }

    protected KmDate getTodayUtc()
    {
        return getNowUtc().getDate();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected MySettings getSettings()
    {
        return getAccess().getSettingsDao().getSettings();
    }

    protected KmDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected void daoFlush()
    {
        getDaoSession().flush();
    }

}
