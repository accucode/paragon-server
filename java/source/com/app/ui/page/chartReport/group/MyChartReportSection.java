package com.app.ui.page.chartReport.group;

import com.kodemore.hibernate.KmhProjectionRow;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;
import com.app.ui.page.chartReport.MyChartReportOption;

public interface MyChartReportSection<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    extends MyChartReportOption
{
    void applyTo(C c);

    String readFrom(KmhProjectionRow row);
}
