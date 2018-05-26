package com.app.ui.page.chartReport.value;

import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.utility.Kmu;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public class MyChartReportRowCountValue<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    implements MyChartReportValue<T,C>
{
    @Override
    public String getName()
    {
        return "Count";
    }

    @Override
    public final void selectValue(C c)
    {
        c.selectRowCount();
    }

    @Override
    public final Double readValue(KmhProjectionRow row)
    {
        return Kmu.toDouble(row.nextInteger());
    }

    @Override
    public final int getDecimals()
    {
        return 0;
    }
}
