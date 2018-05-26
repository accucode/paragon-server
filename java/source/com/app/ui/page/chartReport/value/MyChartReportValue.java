package com.app.ui.page.chartReport.value;

import com.kodemore.hibernate.KmhProjectionRow;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;
import com.app.ui.page.chartReport.MyChartReportOption;

public interface MyChartReportValue<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    extends MyChartReportOption
{
    void selectValue(C c);

    Double readValue(KmhProjectionRow row);

    int getDecimals();
}
