package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyOrderNumberCriteria;
import com.app.dao.base.MyOrderNumberDaoBase;
import com.app.model.MyOrderNumber;
import com.app.model.MyProject;

public class MyOrderNumberDao
    extends MyOrderNumberDaoBase
{
    //##################################################
    //# convenience
    //##################################################

    /**
     * Prepopulate order number records for the upcoming week.
     * This prepopulates all projects.  In a multi-thread (multi-jvm)
     * environment, this may result in duplicate key exceptions.
     */
    public void prepopulate()
    {
        KmList<MyProject> v = getAccess().getProjectDao().findAll();
        for ( MyProject e : v )
            prepopulate(e);
    }

    /**
     * Prepopulate order number records for the upcoming week.
     * In a multi-thread (multi-jvm) environment, this may result
     * in duplicate key exceptions.
     */
    public void prepopulate(MyProject project)
    {
        KmDate start = KmClock.getTodayUtc();
        KmDate end = start.addWeek();
        KmDateInterval dates = start.toInterval(end);

        for ( KmDate date : dates )
            lazyFind(project, date);
    }

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

        MyOrderNumber e;
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

    private MyOrderNumber find(MyProject p, KmDate d)
    {
        MyOrderNumberCriteria c;
        c = createCriteria();
        c.whereProjectIs(p);
        c.whereDate().is(d);
        return c.findFirst();
    }

    private MyOrderNumber lazyFind(MyProject p, KmDate d)
    {
        MyOrderNumber e = find(p, d);
        if ( e != null )
            return e;

        e = new MyOrderNumber();
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
