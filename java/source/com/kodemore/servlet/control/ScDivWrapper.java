package com.kodemore.servlet.control;

import java.util.Iterator;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;

/**
 * I am effectively just a div, but I WRAP the div rather than EXTENDing it.
 * This allows for me to provide all of the convenient functionality of a div internally,
 * but to hide the div's methods from clients.
 */
public class ScDivWrapper
    extends ScControl
    implements ScHtmlIdIF, ScStyledControlIF
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv _inner;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _inner = new ScDiv();
        _inner.setParent(this);
    }

    //##################################################
    //# components
    //##################################################

    protected ScDiv getInner()
    {
        return _inner;
    }

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.render(_inner);
    }

    @Override
    public Iterator<ScControlIF> getComponents()
    {
        return getInner().getComponents();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public KmCssDefaultBuilder css()
    {
        return _inner.css();
    }

    @Override
    public KmStyleBuilder style()
    {
        return _inner.style();
    }

    //##################################################
    //# ScHtmlIdIF
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getInner().getHtmlId();
    }

    @Override
    public String getJquerySelector()
    {
        return getInner().getJquerySelector();
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return getInner().ajax();
    }
}
