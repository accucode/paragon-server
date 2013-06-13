package com.kodemore.jasper;

public abstract class KmJasperElement
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperReportBuilder _builder;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperElement(KmJasperReportBuilder e)
    {
        _builder = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmJasperReportBuilder getBuilder()
    {
        return _builder;
    }
}
