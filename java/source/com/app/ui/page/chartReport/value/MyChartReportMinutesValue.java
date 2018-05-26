package com.app.ui.page.chartReport.value;

import com.kodemore.hibernate.KmhProjectionRow;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public abstract class MyChartReportMinutesValue<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    implements MyChartReportValue<T,C>
{
    //##################################################
    //# apply
    //##################################################

    @Override
    public final void selectValue(C c)
    {
        selectSeconds(c);
    }

    protected abstract void selectSeconds(C c);

    //##################################################
    //# read
    //##################################################

    @Override
    public final Double readValue(KmhProjectionRow row)
    {
        Double e = row.nextDouble();
        return e == null
            ? null
            : e / 60.0;
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
