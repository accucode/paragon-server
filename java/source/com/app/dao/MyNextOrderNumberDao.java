package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyNextOrderNumberCriteria;
import com.app.dao.base.MyNextOrderNumberDaoBase;
import com.app.model.MyNextOrderNumber;
import com.app.model.MyProject;

public class MyNextOrderNumberDao
    extends MyNextOrderNumberDaoBase
{
    //##################################################
    //# convenience
    //##################################################

    /**
     * Get a single unique order number for the specified project.
     * @see #getNextNumbersFor
     */
    public String getNextNumberFor(MyProject project)
    {
        int count = 1;
        return getNextNumbersFor(project, count).getFirst();
    }

    /**
     * Get a batch of unique preformatted orders numbers for the
     * specified project.
     *
     * This may result in an optimistic lock failure, but it should
     * not result in a key violation as long as the numbers are
     * prepopulated once a day.  The number of numbers returns will
     * always exactly match the requested count.
     */
    public KmList<String> getNextNumbersFor(MyProject project, int count)
    {
        KmList<String> v = new KmList<>();

        KmDate date = KmClock.getTodayUtc();

        MyNextOrderNumber e;
        e = lazyFind(project, date);
        int next = e.getNextNumber();
        e.incrementNextNumberBy(count);

        int n = count;
        for ( int i = 0; i < n; i++ )
        {
            int num = next + i;
            String s = formatNumber(project, date, num);
            v.add(s);
        }

        return v;
    }

    //##################################################
    //# support
    //##################################################

    private MyNextOrderNumber find(MyProject p, KmDate d)
    {
        MyNextOrderNumberCriteria c;
        c = createCriteria();
        c.whereProjectIs(p);
        c.whereDate().is(d);
        return c.findFirst();
    }

    private MyNextOrderNumber lazyFind(MyProject p, KmDate d)
    {
        MyNextOrderNumber e = find(p, d);
        if ( e != null )
            return e;

        e = new MyNextOrderNumber();
        e.setProject(p);
        e.setDate(d);
        e.attachDao();
        return e;
    }

    private String formatNumber(MyProject p, KmDate d, int num)
    {
        String prefix = p.getOrderNumberPrefix();
        String day = d.format_yymmdd();
        String suffix = Kmu.leftPad(num, 3);
        return Kmu.format("%s-%s-%s", prefix, day, suffix);
    }

}
