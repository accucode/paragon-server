package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;

/**
 * I am effectively just a form, but I WRAP the form rather than EXTENDing it.
 * This allows for me to provide all of the convenient functionality of a form
 * internally, but to hide the form's methods from clients.
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
    //# constructor
    //##################################################

    public ScFormWrapper()
    {
        _inner = new ScForm();
        _inner.setParent(this);
    }

    //##################################################
    //# components
    //##################################################

    protected final ScForm getInner()
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
        return _inner.getHtmlId();
    }

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    @Override
    public boolean getVisible()
    {
        return _inner.getVisible();
    }

    @Override
    public void setVisible(boolean e)
    {
        _inner.setVisible(e);
    }

    @Override
    public ScVisibilityScript ajaxShow(boolean e)
    {
        return _inner.ajaxShow(e);
    }
}
