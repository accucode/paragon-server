package com.app.ui.page.chartReport.value;

import com.kodemore.hibernate.KmhProjectionRow;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public abstract class MyChartReportDoubleValue<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    implements MyChartReportValue<T,C>
{
    //##################################################
    //# apply
    //##################################################

    @Override
    public final void selectValue(C c)
    {
        selectDouble(c);
    }

    protected abstract void selectDouble(C c);

    //##################################################
    //# read
    //##################################################

    @Override
    public final Double readValue(KmhProjectionRow row)
    {
        return row.nextDouble();
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public int getDecimals()
    {
        return 1;
    }
}
