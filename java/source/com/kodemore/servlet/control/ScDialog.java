package com.kodemore.servlet.control;

/**
 * I extend the basic dialog to include a default layout.  I define
 * a header, body, and footer; organized in a flexbox column.  The
 * header and footer are initially hidden, but configured for static
 * sizing if displayed.  The body is visible by default, and configured
 * to stretch and shrink if the dialog is resized.  The various
 * sections are styled with standard background colors and borders.
 * Finally, the outer form is set to NOT scroll, and the inner body
 * section is to set to scroll if needed (overflow:auto).
 */
public class ScDialog
    extends ScBareDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScFlexbox _header;
    private ScDiv     _body;
    private ScFlexbox _footer;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        ScForm form;
        form = getForm();
        form.css().flex().flexColumn().noScroll();

        _header = form.addRow();
        _header.css().formHeader().flexStatic();
        _header.hide();

        _body = form.addDiv();
        _body.css().formBody().flexFiller().auto();

        _footer = form.addRow();
        _footer.css().formFooter().flexStatic();
        _footer.hide();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScFlexbox getHeader()
    {
        return _header;
    }

    public ScFlexbox showHeader()
    {
        ScFlexbox e;
        e = getHeader();
        e.show();
        return e;
    }

    public ScDiv getBody()
    {
        return _body;
    }

    public ScFlexbox getFooter()
    {
        return _footer;
    }

    public ScFlexbox showFooter()
    {
        ScFlexbox e;
        e = getFooter();
        e.show();
        return e;
    }

    public void setFlavorWarning()
    {
        ScDiv body;
        body = getBody();
        body.css().remove().formBody();
        body.css().formBodyWarning();
    }

}
