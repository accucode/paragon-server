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

public abstract class MySettingsDaoBase
    extends MyAbstractDao<MySettings,Integer>
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
        return new MySettingsCriteria(_createCriteria());
    }

    @Override
    public MySettingsCriteria createDetachedCriteria(String alias)
    {
        return new MySettingsCriteria(_createDetachedCriteria(alias));
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

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MySettings> findCodes(KmList<Integer> codes)
    {
        return findCodes(codes, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MySettings> findOrderedCodes(KmList<Integer> codes)
    {
        return findCodes(codes, true);
    }

    public KmList<MySettings> findCodes(KmList<Integer> codes, boolean ordered)
    {
        MySettingsCriteria c;
        c = createCriteria();
        c.whereCode().isIn(codes);
        KmList<MySettings> v = c.findAll();

        return ordered
            ? v.toOrderedList(codes, e -> e.getCode())
            : v;
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
