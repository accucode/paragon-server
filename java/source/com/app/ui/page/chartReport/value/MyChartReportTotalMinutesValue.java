package com.app.ui.page.chartReport.value;

import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.utility.Kmu;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public abstract class MyChartReportTotalMinutesValue<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    implements MyChartReportValue<T,C>
{
    //##################################################
    //# apply
    //##################################################

    @Override
    public final void selectValue(C c)
    {
        selectTotalSeconds(c);
    }

    protected abstract void selectTotalSeconds(C c);

    //##################################################
    //# read
    //##################################################

    @Override
    public final Double readValue(KmhProjectionRow row)
    {
        Long i = row.nextLong();
        Double d = Kmu.toDouble(i);
        return d == null
            ? null
            : d / 60.0;
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
