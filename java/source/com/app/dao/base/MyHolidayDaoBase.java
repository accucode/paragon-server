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
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyHolidayDaoBase
    extends MyAbstractDao<MyHoliday,String>
    implements MyHolidayDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHolidayDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyHoliday> getPersistentClass()
    {
        return MyHoliday.class;
    }

    @Override
    protected String getTableName()
    {
        return "holiday";
    }

    @Override
    public MyHolidayCriteria createCriteria()
    {
        return new MyHolidayCriteria(_createCriteria());
    }

    @Override
    public MyHolidayCriteria createDetachedCriteria(String alias)
    {
        return new MyHolidayCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaHoliday getMeta()
    {
        return MyHoliday.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyHoliday findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyHoliday> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyHoliday> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyHoliday> findUids(KmList<String> uids, boolean ordered)
    {
        MyHolidayCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyHoliday> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyHoliday m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
