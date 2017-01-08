package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmTimestamp;

import com.app.criteria.MyServerSessionCriteria;
import com.app.dao.base.MyServerSessionDaoBase;
import com.app.model.MyServerSession;
import com.app.model.MyUser;

public class MyServerSessionDao
    extends MyServerSessionDaoBase
{
    /**
     * Delete a batch of old sessions.
     * Sessions are generally deleted after about a week.
     * Logs are deleted in small batches.
     *
     * Return true if there may be more records to delete.
     * Return false if there are no more records to delete.
     */
    public boolean deleteOldSessions()
    {
        int limit = 100;
        KmTimestamp lastMonth = getNowUtc().subtractDays(30).getStartOfDay();

        MyServerSessionCriteria c;
        c = createCriteria();
        c.whereCreatedUtcTs().isLessThan(lastMonth);
        c.sortOnCreatedUtcTs();
        c.setMaxResults(limit);

        KmList<MyServerSession> v = c.findAll();
        if ( v.isEmpty() )
            return false;

        for ( MyServerSession e : v )
            e.daoDelete();

        return true;
    }

    /**
     * Find the last touched server session for a user
     */
    public MyServerSession findLastTouchedFor(MyUser user)
    {
        MyServerSessionCriteria c;
        c = createCriteria();
        c.whereUserIs(user);
        c.whereActive().isTrue();
        c.sortOnLastTouchedUtcTs(false);
        return c.findFirst();
    }
}
