package com.app.ui.page.chartReport;

import com.kodemore.collection.KmList;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.MyNamedDoubleVo;
import com.app.model.core.MyAbstractDomain;
import com.app.ui.page.chartReport.group.MyChartReportSection;
import com.app.ui.page.chartReport.value.MyChartReportValue;

public abstract class MySimpleChartReportPage<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    extends MyChartReportPage<T,C>
{
    //##################################################
    //# chart :: value
    //##################################################

    protected final KmList<MyChartReportValue<T,C>> getChartValues()
    {
        KmList<MyChartReportValue<T,C>> v;
        v = new KmList<>();
        defineChartValues(v);
        return v;
    }

    protected abstract void defineChartValues(KmList<MyChartReportValue<T,C>> v);

    @Override
    protected final KmList<MyChartReportValue<T,C>> getPieChartValues()
    {
        return getChartValues();
    }

    @Override
    protected final KmList<MyChartReportValue<T,C>> getBarChartValues()
    {
        return getChartValues();
    }

    //##################################################
    //# chart :: group
    //##################################################

    protected final KmList<MyChartReportSection<T,C>> getChartGroups()
    {
        KmList<MyChartReportSection<T,C>> v;
        v = new KmList<>();
        defineChartSections(v);
        return v;
    }

    protected abstract void defineChartSections(KmList<MyChartReportSection<T,C>> v);

    @Override
    protected final KmList<MyChartReportSection<T,C>> getPieChartGroups()
    {
        return getChartGroups();
    }

    @Override
    protected final KmList<MyChartReportSection<T,C>> getBarChartGroups()
    {
        return getChartGroups();
    }

    //##################################################
    //# chart :: normalize
    //##################################################

    protected KmList<MyNamedDoubleVo> normalizeChartResults(KmList<MyNamedDoubleVo> v)
    {
        return normalizeNamedDoubles(v);
    }

    @Override
    protected KmList<MyNamedDoubleVo> normalizePieChartResults(KmList<MyNamedDoubleVo> v)
    {
        return normalizeChartResults(v);
    }

    @Override
    protected KmList<MyNamedDoubleVo> normalizeBarChartResults(KmList<MyNamedDoubleVo> v)
    {
        return normalizeChartResults(v);
    }
}
