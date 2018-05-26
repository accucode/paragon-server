package com.app.ui.page.chartReport.group;

import com.kodemore.hibernate.KmhProjectionRow;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public abstract class MyChartReportStringSection<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    implements MyChartReportSection<T,C>
{
    //##################################################
    //# select
    //##################################################

    @Override
    public final void applyTo(C c)
    {
        groupByString(c);
    }

    protected abstract void groupByString(C c);

    //##################################################
    //# read
    //##################################################

    @Override
    public final String readFrom(KmhProjectionRow row)
    {
        String s = row.nextString();
        return s == null
            ? null
            : formatString(s);
    }

    protected String formatString(String s)
    {
        return s;
    }
}
