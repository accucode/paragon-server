package com.kodemore.html;

import com.kodemore.collection.KmList;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.utility.KmValueHolderIF;

public class KmCssMarginBuilder
{
    //##################################################
    //# variables
    //##################################################

    private KmCssDefaultBuilder _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmCssMarginBuilder()
    {
        _inner = new KmCssDefaultBuilder();
    }

    public KmCssMarginBuilder(KmValueHolderIF<String> holder)
    {
        _inner = new KmCssDefaultBuilder(holder);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<String> getSelectors()
    {
        return _inner.getSelectors();
    }

    //##################################################
    //# styles
    //##################################################

    public KmCssMarginBuilder all()
    {
        _inner.margin();
        return this;
    }

    public KmCssMarginBuilder all5()
    {
        _inner.margin5();
        return this;
    }

    public KmCssMarginBuilder all10()
    {
        _inner.margin10();
        return this;
    }

    public KmCssMarginBuilder left()
    {
        _inner.marginLeft();
        return this;
    }

    public KmCssMarginBuilder left5()
    {
        _inner.marginLeft5();
        return this;
    }

    public KmCssMarginBuilder right()
    {
        _inner.marginRight();
        return this;
    }

    public KmCssMarginBuilder right5()
    {
        _inner.marginRight5();
        return this;
    }

    public KmCssMarginBuilder top()
    {
        _inner.marginTop();
        return this;
    }

    public KmCssMarginBuilder top5()
    {
        _inner.marginTop();
        return this;
    }

    public KmCssMarginBuilder bottom()
    {
        _inner.marginBottom();
        return this;
    }

    public KmCssMarginBuilder bottom5()
    {
        _inner.marginBottom();
        return this;
    }

}
