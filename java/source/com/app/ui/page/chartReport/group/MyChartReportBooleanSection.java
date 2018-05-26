package com.app.ui.page.chartReport.group;

import com.kodemore.hibernate.KmhProjectionRow;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public abstract class MyChartReportBooleanSection<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    implements MyChartReportSection<T,C>
{
    //##################################################
    //# select
    //##################################################

    @Override
    public final void applyTo(C c)
    {
        groupByBoolean(c);
    }

    protected abstract void groupByBoolean(C c);

    //##################################################
    //# read
    //##################################################

    @Override
    public final String readFrom(KmhProjectionRow row)
    {
        Boolean e = row.nextBoolean();
        return e == null
            ? null
            : formatBoolean(e);
    }

    protected String formatBoolean(Boolean e)
    {
        return e
            ? "Yes"
            : "No";
    }
}
