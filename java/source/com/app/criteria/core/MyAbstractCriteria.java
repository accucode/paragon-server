package com.app.criteria.core;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmCriteria;
import com.kodemore.hibernate.criteria.KmModelCriteria;
import com.kodemore.hibernate.criteria.KmProjectionResult;
import com.kodemore.hibernate.criteria.KmProjectionRow;

import com.app.model.MyNamedCountVo;

public abstract class MyAbstractCriteria<T>
    extends KmModelCriteria<T>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAbstractCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyAbstractCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# convenience
    //##################################################

    public KmList<MyNamedCountVo> findNamedCounts()
    {
        KmList<MyNamedCountVo> v = new KmList<>();

        KmProjectionResult results = findResults();

        for ( KmProjectionRow row : results )
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
