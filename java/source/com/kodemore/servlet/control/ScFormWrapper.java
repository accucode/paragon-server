package com.kodemore.servlet.control;

import java.util.Iterator;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;

/**
 * I am effectively just a form, but I WRAP the form rather than EXTENDing it.
 * This allows for me to provide all of the convenient functionality of a form internally,
 * but to hide the form's methods from clients.
 */
public class ScFormWrapper
    extends ScControl
    implements ScHtmlIdIF, ScStyledControlIF
{
    //##################################################
    //# variables
    //##################################################

    private ScForm _inner;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _inner = new ScForm();
        _inner.setParent(this);
    }

    //##################################################
    //# components
    //##################################################

    protected ScForm getInner()
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
