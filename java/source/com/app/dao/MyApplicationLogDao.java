package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyApplicationLogDaoBase;
import com.app.filter.MyApplicationLogFilter;
import com.app.model.MyApplicationLog;

public class MyApplicationLogDao
    extends MyApplicationLogDaoBase
{
    /**
     * Delete a batch of old logs.
     * Logs are generally deleted after about a month.
     * Logs are deleted in small batches.
     *
     * Return true if there may be more logs to delete.
     * Return false if there are no more logs to delete.
     */
    public boolean deleteOldLogs()
    {
        int rowLimit = 100;
        int dayLimit = 30;

        KmTimestamp latest = getNowUtc().subtractDays(dayLimit);

        MyApplicationLogFilter f;
        f = new MyApplicationLogFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyApplicationLog> v = f.findFirst(rowLimit);
        if ( v.isEmpty() )
            return false;

        for ( MyApplicationLog e : v )
            e.deleteDao();

        return true;
    }

}
