package com.app.ui.page.chartReport;

import com.kodemore.collection.KmList;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.MyNamedDoubleVo;
import com.app.model.core.MyAbstractDomain;

public abstract class MySimpleChartReportPage<T extends MyAbstractDomain, C extends MyAbstractCriteria<T>>
    extends MyChartReportPage<T,C>
{
    //##################################################
    //# chart :: value
    //##################################################

    protected abstract MyChartReportValue<T,C>[] getChartValueOptions();

    @Override
    protected final MyChartReportValue<T,C>[] getPieChartValueOptions()
    {
        return getChartValueOptions();
    }

    @Override
    protected final MyChartReportValue<T,C>[] getBarChartValueOptions()
    {
        return getChartValueOptions();
    }

    //##################################################
    //# chart :: group
    //##################################################

    protected abstract MyChartReportGroup<T,C>[] getChartGroupOptions();

    @Override
    protected final MyChartReportGroup<T,C>[] getPieChartGroupOptions()
    {
        return getChartGroupOptions();
    }

    @Override
    protected final MyChartReportGroup<T,C>[] getBarChartGroupOptions()
    {
        return getChartGroupOptions();
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
