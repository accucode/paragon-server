/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

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

    private ScLocalString       _text;
    private ScLocalBoolean      _readOnly;
    private ScLocalBoolean      _disabled;
    private KmValidator<String> _validator;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _text = new ScLocalString();
        _readOnly = new ScLocalBoolean(false);
        _disabled = new ScLocalBoolean(false);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        String s = _text.getValue();

        if ( Kmu.isEmpty(s) )
            return null;

        return s;
    }

    @Override
    public void setValue(String e)
    {
        if ( Kmu.isEmpty(e) )
            e = null;

        _text.setValue(e);
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    public void clearValue()
    {
        setValue(null);
    }

    public boolean isEmpty()
    {
        return _text.isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
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
    //# disabled
    //##################################################

    public void enable()
    {
        _disabled.setFalse();
    }

    public void disable()
    {
        _disabled.setTrue();
    }

    public boolean isDisabled()
    {
        return _disabled.isTrue();
    }

    //##################################################
    //# page session
    //##################################################

    @Override
    public void saveFieldValues()
    {
        super.saveFieldValues();
        _text.saveValue();
    }

    @Override
    public void resetFieldValues()
    {
        super.resetFieldValues();
        resetValue();
    }

    //##################################################
    //# validator
    //##################################################

    public KmValidator<String> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<String> e)
    {
        _validator = e;
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    @Override
    public void setRequired()
    {
        if ( hasValidator() )
        {
            if ( getValidator().isRequired() )
                return;

            KmValidator<String> e;
            e = getValidator().getCopy();
            e.setRequired();
            setValidator(e);
        }
        else
            setValidator(new KmRequiredValidator<String>());
    }

    public void setOptional()
    {
        if ( !hasValidator() )
            return;

        if ( getValidator().isOptional() )
            return;

        KmValidator<String> e;
        e = getValidator().getCopy();
        e.setOptional();
        setValidator(e);
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

    private String getRenderScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.printf("$('%s').ckeditor(function() {", getJquerySelector());
        out.print("this.on( 'change', function ( ev ) {");
        out.print("this.updateElement();");
        out.print("});");
        out.print("});");

        return out.toString();
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

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        if ( isReadOnly() )
            out.printAttribute("readonly", "readonly");

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        printOldValueAttributeOn(out, getValue());
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        String name = getHtmlName();
        if ( data.hasParameter(name) )
            _text.setValue(data.getParameter(name));
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( hasErrors() )
            return false;

        if ( _validator == null )
            return true;

        KmList<KmErrorIF> errors = new KmList<>();

        _validator.validateOnly(getValue(), errors);
        if ( errors.isEmpty() )
            return true;

        setErrors(errors);
        return false;
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isReadOnly() && !isDisabled();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        String value = getValue();
        ajax().setValue(value);
        ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }
}
