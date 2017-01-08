package com.app.criteria.core;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhModelCriteria;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.hibernate.basic.KmhCriteria;

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

}
