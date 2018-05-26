package com.kodemore.servlet.field;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

/**
 * I am an abstact control that implements the ScHtmlIdIF.
 */
public abstract class ScHtmlIdControl
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    //##################################################
    //# constructor
    //##################################################

    public ScHtmlIdControl()
    {
        _css = new ScLocalCss();
        _style = new ScLocalStyle();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public final String getHtmlId()
    {
        return getKeyToken();
    }

    @Override
    public final ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    //==================================================
    //= html id :: visible
    //==================================================

    @Override
    public final void setVisible(boolean e)
    {
        style().show(e);
    }

    @Override
    public final boolean isVisible()
    {
        return !style().hasHide();
    }

    //==================================================
    //= html id :: ajax
    //==================================================

    @Override
    public final ScVisibilityScript ajaxShow(boolean e)
    {
        return _htmlIdAjax().show(e);
    }
    //##################################################
    //# css
    //##################################################

    public final String getCss()
    {
        return _css.getValue();
    }

    public final void setCss(String e)
    {
        _css.setValue(e);
    }

    public final KmCssDefaultBuilder css()
    {
        return _css.toDefaultBuilder();
    }

    protected KmCssDefaultBuilder formatCss()
    {
        return css();
    }

    //##################################################
    //# style
    //##################################################

    public final String getStyle()
    {
        return _style.getValue();
    }

    public final void setStyle(String e)
    {
        _style.setValue(e);
    }

    public final KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    protected KmStyleBuilder formatStyle()
    {
        return style();
    }

    //##################################################
    //# children
    //##################################################

    /**
     * Return an empty list by default. Clients should override
     * this as needed. However, consider extended from the ScContainer
     * hierarchy if you just need a generic list of children.
     */
    @Override
    public KmList<ScControl> getChildren()
    {
        return EMPTY_CHILDREN;
    }

    //##################################################
    //# render
    //##################################################

    /**
     * Implement the rendering logic
     * Clients should call renderAttributesOn to include
     * the pertinent htmlId, css, and style attributes.
     */
    @Override
    protected abstract void renderControlOn(KmHtmlBuilder out);

    /**
     * Render the html attributes. Clients may override this
     * but should call super.
     */
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
    }

}
