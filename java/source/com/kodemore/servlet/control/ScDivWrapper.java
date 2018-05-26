package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;

/**
 * I am effectively just a div, but I WRAP the div rather than EXTENDing it.
 * This allows for me to provide all of the functionality of a div internally,
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
    //# constructor
    //##################################################

    public ScDivWrapper()
    {
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
        out.render(getInner());
    }

    @Override
    public final KmList<ScControl> getChildren()
    {
        return KmList.createWith(getInner());
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public KmCssDefaultBuilder css()
    {
        return getInner().css();
    }

    @Override
    public KmStyleBuilder style()
    {
        return getInner().style();
    }

    //##################################################
    //# ScHtmlIdIF
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getInner().getHtmlId();
    }

    public void setHtmlId(String e)
    {
        getInner().setHtmlId(e);
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
        getInner().setVisible(e);
    }

    @Override
    public final boolean isVisible()
    {
        return getInner().isVisible();
    }
}
