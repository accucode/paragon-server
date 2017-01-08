package com.kodemore.servlet.control;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScErrorManagerIF;

/**
 * I extend the basic dialog to include a default layout.  I define
 * a header, body, and footer; organized in a flexbox column.
 *
 * The header and footer are initially hidden, but configured for static
 * sizing if displayed.  This means that if the header is shown it will
 * automatically grow to accommodate the content you add to it.
 *
 * A The outer form is set to NOT scroll, and the inner body is configured
 * to stretch/shrink/scroll to fit the dialog.  It is assumed that the size
 * of the outer dialog is explicitly set to some specific size.
 *
 * The various sections are styled with standard background colors and borders.
 */
public class ScDialog
    extends ScBareDialog
    implements ScErrorManagerIF
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv _header;
    private ScDiv _error;
    private ScDiv _body;
    private ScDiv _footer;

    //##################################################
    //# constructor
    //##################################################

    public ScDialog()
    {
        ScForm form;
        form = getForm();
        form.css().flexColumn();
        form.style().overflowHidden();

        _error = form.addDiv();
        _error.css().error().formError().flexChildStatic();
        _error.hide();

        _header = form.addDiv();
        _header.css().dialog_header().flexChildStatic();
        _header.hide();

        _body = form.addDiv();
        _body.css().dialog_body().flexChildFiller().auto();

        _footer = form.addDiv();
        _footer.css().dialog_footer().flexChildStatic();
        _footer.hide();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScDiv getHeader()
    {
        return _header;
    }

    public ScDiv showHeader()
    {
        ScDiv e;
        e = getHeader();
        e.show();
        return e;
    }

    public ScDiv getBody()
    {
        return _body;
    }

    public ScDiv getFooter()
    {
        return _footer;
    }

    public ScDiv showFooter()
    {
        ScDiv e;
        e = getFooter();
        e.show();
        return e;
    }

    //##################################################
    //# flavor
    //##################################################

    // low_wyatt: dialog flavor
    public void setFlavorCaution()
    {
        ScDiv body;
        body = getBody();
        body.css().remove().formBody();
        body.css().formBodyCaution();
    }

    // low_wyatt: dialog flavor
    public void setFlavorAlert()
    {
        ScDiv body;
        body = getBody();
        body.css().remove().formBody();
        body.css().formBodyAlert();
    }

    //##################################################
    //# error
    //##################################################

    @Override
    public void handleError(KmApplicationException ex)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.print(ex.formatMultiLineMessage());

        _error.ajaxSetHtml(out);
        _error.ajaxShow();
    }
}
