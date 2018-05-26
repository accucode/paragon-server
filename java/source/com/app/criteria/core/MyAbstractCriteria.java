package com.app.criteria.core;

import java.sql.Date;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhModelCriteria;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.hibernate.basic.KmhCriteria;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmMonth;

import com.app.model.MyDatedCountVo;
import com.app.model.MyMonthlyCountVo;
import com.app.model.MyNamedDoubleVo;
import com.app.model.MyNamedIntegerVo;

public abstract class MyAbstractCriteria<T>
    extends KmhModelCriteria<T>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAbstractCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# convenience
    //##################################################

    public KmList<MyNamedIntegerVo> findNamedIntegers()
    {
        KmList<MyNamedIntegerVo> v = new KmList<>();

        for ( KmhProjectionRow row : findResults() )
        {
            String name = row.nextString();
            Integer count = row.nextInteger();

            MyNamedIntegerVo e;
            e = new MyNamedIntegerVo();
            e.setName(name);
            e.setValue(count);

            v.add(e);
        }

        return v;
    }

    public KmList<MyNamedDoubleVo> findNamedDoubles()
    {
        KmList<MyNamedDoubleVo> v = new KmList<>();

        for ( KmhProjectionRow row : findResults() )
        {
            String name = row.nextString();
            Double value = row.nextDouble();

            MyNamedDoubleVo e;
            e = new MyNamedDoubleVo();
            e.setName(name);
            e.setValue(value);

            v.add(e);
        }

        return v;
    }

    public KmList<MyDatedCountVo> findDatedCounts()
    {
        KmList<MyDatedCountVo> v = new KmList<>();

        for ( KmhProjectionRow row : findResults() )
        {
            MyDatedCountVo e;
            e = new MyDatedCountVo();
            e.setDate(row.nextDate());
            e.setCount(row.nextInteger());
            v.add(e);
        }

        return v;
    }

    public KmList<MyDatedCountVo> findSqlDatedCounts()
    {
        KmList<MyDatedCountVo> v = new KmList<>();

        for ( KmhProjectionRow row : findResults() )
        {
            Date sqlDate = row.nextSqlDate();
            KmDate date = KmDate.fromSqlDate(sqlDate);
            Integer count = row.nextInteger();

            MyDatedCountVo e;
            e = new MyDatedCountVo();
            e.setDate(date);
            e.setCount(count);
            v.add(e);
        }

        return v;
    }

    public KmList<MyMonthlyCountVo> findMonthlyCounts()
    {
        KmList<MyMonthlyCountVo> v = new KmList<>();

        for ( KmhProjectionRow row : findResults() )
        {
            Integer yy = row.nextInteger();
            Integer mm = row.nextInteger();
            Integer count = row.nextInteger();

            KmMonth month = KmMonth.fromYearMonth(yy, mm);

            MyMonthlyCountVo e;
            e = new MyMonthlyCountVo();
            e.setMonth(month);
            e.setCount(count);
            v.add(e);
        }

        return v;
    }

}
