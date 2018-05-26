package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;

/**
 * I am effectively just a fieldset, but I WRAP the fieldset rather than
 * EXTENDing it. This allows for me to provide all of the functionality
 * of a fieldset internally, but to hide the fieldset's methods from clients.
 */
public class ScFieldsetWrapper
    extends ScControl
    implements ScHtmlIdIF, ScStyledControlIF
{
    //##################################################
    //# variables
    //##################################################

    private ScFieldset _inner;

    //##################################################
    //# constructor
    //##################################################

    public ScFieldsetWrapper()
    {
        _inner = new ScFieldset();
        _inner.setParent(this);
    }

    //##################################################
    //# components
    //##################################################

    protected ScFieldset getInner()
    {
        return _inner;
    }

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.render(_inner);
    }

    @Override
    public final KmList<ScControl> getChildren()
    {
        return KmList.createWith(_inner);
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
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxHideAllErrors()
    {
        _htmlIdAjax().hideAllErrors();
    }

    //##################################################
    //# visible
    //##################################################

    @Override
    public final void setVisible(boolean e)
    {
        _inner.setVisible(e);
    }

    @Override
    public final boolean isVisible()
    {
        return _inner.isVisible();
    }
}
