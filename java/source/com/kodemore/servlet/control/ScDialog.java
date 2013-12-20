/*
  Copyright (c) 2005-2013 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.servlet.control;

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.json.KmJsonMap;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;

/**
 * I show a modal dialog.
 * 
 * I rely on the SimpleModal javascript library
 * http://www.ericmmartin.com/projects/simplemodal/
 * 
 * The styling should generally be managed via external 
 * css.  However, it is safe to hide the header and footer
 * sections dynamically.  
 * 
 * An explicit height is required and a plausible default
 * is generally set in the css.  An explicit width is optional
 * but often results in a more consistent layout if the 
 * contents are dynamic.
 * 
 * Both the width and height should be set on the dialog's
 * body element; NOT on the outer div tag that wraps the
 * dialog.
 */
public class ScDialog
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _htmlId;

    private ScLocalString  _flavor;

    /**
     * The width of the body.
     * If not set, the dialog will size based on its children.
     */
    private ScLocalInteger _bodyWidth;

    /**
     * If not set, the dialog will size based on the external css.
     */
    private ScLocalInteger _bodyHeight;

    /**
     * Dialogs always include a form that wraps all three sections
     * (header, body, footer).  This is necessary to ensure that
     * buttons in the footer can submit form content in the body.
     */
    private ScForm         _form;

    private ScBox          _headerBox;
    private ScBox          _errorBox;
    private ScBox          _bodyBox;
    private ScBox          _footerBox;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _htmlId = new ScLocalString(getKey());
        _bodyWidth = new ScLocalInteger();
        _bodyHeight = new ScLocalInteger(300);

        _flavor = new ScLocalStyle();
        _flavor.setValue("default");

        _form = new ScForm();
        _form.setParent(this);

        _headerBox = _form.addBox();

        _errorBox = _form.addBox();
        _errorBox.hide();

        _bodyBox = _form.addBox();
        _footerBox = _form.addBox();
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor.getValue();
    }

    public void setFlavor(String e)
    {
        _flavor.setValue(e);
    }

    //##################################################
    //# size
    //##################################################

    public Integer getBodyWidth()
    {
        return _bodyWidth.getValue();
    }

    public void setBodyWidth(Integer e)
    {
        _bodyWidth.setValue(e);
    }

    public Integer getBodyHeight()
    {
        return _bodyHeight.getValue();
    }

    public void setBodyHeight(Integer e)
    {
        _bodyHeight.setValue(e);
    }

    //##################################################
    //# contents
    //##################################################

    public ScForm getForm()
    {
        return _form;
    }

    public ScBox getHeaderBox()
    {
        return _headerBox;
    }

    public ScBox getErrorBox()
    {
        return _errorBox;
    }

    public ScBox getBodyBox()
    {
        return _bodyBox;
    }

    public ScBox getFooterBox()
    {
        return _footerBox;
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    @Override
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(getRootScript(), this);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        String flavor = getFlavor();

        _headerBox.css().add(
            KmCssDefaultConstantsIF.dialog_prefix,
            KmCssDefaultConstantsIF.dialog_part_header,
            flavor);

        _footerBox.css().add(
            KmCssDefaultConstantsIF.dialog_prefix,
            KmCssDefaultConstantsIF.dialog_part_footer,
            flavor);

        _errorBox.css().add(
            KmCssDefaultConstantsIF.dialog_prefix,
            KmCssDefaultConstantsIF.dialog_part_error,
            flavor);

        _bodyBox.css().add(
            KmCssDefaultConstantsIF.dialog_prefix,
            KmCssDefaultConstantsIF.dialog_part_body,
            flavor);

        _bodyBox.style().width(getBodyWidth());
        _bodyBox.style().height(getBodyHeight());

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute("class", KmCssDefaultConstantsIF.hide);
        out.close();

        out.render(_form);

        out.endDiv();
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControl> getComponents()
    {
        KmCompositeIterator<ScControl> i;
        i = new KmCompositeIterator<ScControl>();

        i.addAll(super.getComponents());
        i.add(_form);

        return i;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxReplace()
    {
        ajax().replace();
    }

    /**
     * Show the modal dialog.  This method assumes that the dialog's
     * html has already been rendered/attached to the DOM.
     * 
     * persist is defaulted to true to avoid incompatibility problems
     * that otherwise occur with some other tools such as the Flexigrid.
     */
    public void ajaxOpen()
    {
        KmJsonMap options;
        options = new KmJsonMap();
        options.setBoolean("persist", true);

        KmJsonMap style;
        style = options.setMap("containerCss");
        style.setString("border", "4px solid #000");

        getRootScript().openDialogTarget(this, options);
    }

    public void ajaxClose()
    {
        getRootScript().closeDialog();
    }

    //##################################################
    //# action context
    //##################################################

    @Override
    public void handleError(KmApplicationException ex)
    {
        _errorBox.ajaxSetText(ex.formatMultiLineMessage());
        _errorBox.ajax().show().slide();
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        KmLog.fatal(ex);

        _errorBox.ajaxSetText(ex.getMessage());
        _errorBox.ajax().show().slide();
    }

    //##################################################
    //# convenience
    //##################################################

    public void setAction(ScActionIF e)
    {
        getForm().setDefaultAction(e);
    }

}
