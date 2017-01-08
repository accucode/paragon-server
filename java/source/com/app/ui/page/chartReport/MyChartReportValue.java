package com.app.ui.page.chartReport;

import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.core.MyAbstractDomain;

public interface MyChartReportValue<T extends MyAbstractDomain, C extends MyAbstractCriteria<T>>
    extends KmEnumIF
{
    void applyTo(C c);

    Double readFrom(KmhProjectionRow row);

    int getDecimals();
}
