/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmHtmlCleaner;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * This is a rich text editor that currently uses the CkEditor library.
 *
 * A handy tool for customizing the editor toolbar can be found in
 * /version/ckeditor/samples/index.html.  Updates to the toolbar must be
 * made to /version/ckeditor/config.js.
 */
public class ScRichTextEditor
    extends ScField<String>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _text;
    private ScLocalBoolean _readOnly;

    /**
     * The default functionality of the ckEditor does not support
     * a flexible/fill height.  However, if fill is set to true,
     * a custom script will attempt to manually adjust the html
     * dom so that the ckeditor fills its parent.
     *
     * See Kmu.js > ckEditorFill()
     *
     * This relies on the use of absolute positioning, so it should
     * only be used if the editor is the single child of a container
     * that has non-static (e.g.: relative) positioning.
     *
     * In many cases, we put the editor inside the body of an ScGroup,
     * so this criteria is usually met without any special handling.
     *
     * The fill script will likely stop working correctly if we change
     * versions of ckEditor. The script uses a fairly conservative
     * approach, and if the dom doesn't match the expected structure
     * is simply logs a console message and exits without changing
     * anything.
     *
     * Fill is disabled by default.
     */
    private boolean _fill;

    //##################################################
    //# constructor
    //##################################################

    public ScRichTextEditor()
    {
        _text = new ScLocalString();
        _readOnly = new ScLocalBoolean(false);
        _fill = false;
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    public String getHtmlName()
    {
        return getHtmlId();
    }

    //##################################################
    //# fill
    //##################################################

    public void setFill()
    {
        _fill = true;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        return _text.hasValue()
            ? _text.getValue()
            : null;
    }

    @Override
    public void setValue(String e)
    {
        if ( Kmu.hasValue(e) )
            _text.setValue(e);
        else
            _text.clearValue();
    }

    public boolean isEmpty()
    {
        return _text.isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _text.saveValue();
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    //##################################################
    //# read only
    //##################################################

    public void setReadOnly(boolean b)
    {
        _readOnly.setValue(b);
    }

    public boolean isReadOnly()
    {
        return _readOnly.getValue();
    }

    public void setReadOnly()
    {
        setReadOnly(true);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderTextArea(out);

        out.getPostRender().run(getRenderScript());
    }

    private void renderTextArea(KmHtmlBuilder out)
    {
        out.open("textarea");
        renderAttributesOn(out);
        out.close();

        if ( hasValue() )
            out.printWithoutBreaks(getValue());

        out.end("textarea");
    }

    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute("name", getHtmlName());

        if ( isReadOnly() )
            out.printAttribute("readonly", "readonly");

        printOldValueAttributeOn(out, getValue());
    }

    private String getRenderScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printf("$('%s').ckeditor(function(){", getJquerySelector());
        out.print("this.on('change',function(ev){this.updateElement();});");

        if ( _fill )
            out.printf("Kmu.ckEditorFill('%s');", getHtmlId());

        out.print("},");
        out.printf("{%s}", formatContentsCss());
        out.print(");");
        return out.toString();
    }

    private String formatContentsCss()
    {
        ScUrlBridge urls = ScUrlBridge.getInstance();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print("contentsCss : [ ");
        out.printf("'%s',", urls.getResetCss());
        out.printf("'%s',", urls.getThemeCss());
        out.printf("'%s'", urls.getCkEditorOverridesCss());
        out.print("]");
        return out.toString();
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String name = getHtmlName();
        if ( !data.hasParameter(name) )
            return;

        String raw = data.getParameter(name);
        if ( raw == null )
            return;

        KmHtmlCleaner c;
        c = new KmHtmlCleaner();
        c.setDefaultWhitelist();
        c.setDefaultBlacklist();
        c.allowImages();
        c.allowLinks();

        String clean = c.clean(raw);

        _text.setValue(clean);
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isReadOnly();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(String value)
    {
        ajaxSetFieldValue(value, getChangeTracking());
    }

    @Override
    public void ajaxClearFieldValue()
    {
        ajaxSetFieldValue("");
    }

    @Override
    public void ajaxSetFieldValue(String value, boolean updateOldValue)
    {
        String jsonValue = json(value);
        String sel = ScJquery.formatReference(this);

        _htmlIdAjax().run("Kmu.ckEditorSetValue(%s,%s,%s);", sel, jsonValue, updateOldValue);
    }
}
