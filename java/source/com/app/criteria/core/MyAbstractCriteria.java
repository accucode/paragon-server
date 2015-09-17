package com.app.criteria.core;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhModelCriteria;
import com.kodemore.hibernate.KmhProjectionResult;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.hibernate.basic.KmhCriteria;

import com.app.model.MyNamedCountVo;

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

    public KmList<MyNamedCountVo> findNamedCounts()
    {
        KmList<MyNamedCountVo> v = new KmList<>();

        KmhProjectionResult results = findResults();

        for ( KmhProjectionRow row : results )
        {
            String name = row.nextString();
            Integer count = row.nextInteger();

            MyNamedCountVo e;
            e = new MyNamedCountVo();
            e.setName(name);
            e.setCount(count);
            v.add(e);
        }
        return v;
    }

}
