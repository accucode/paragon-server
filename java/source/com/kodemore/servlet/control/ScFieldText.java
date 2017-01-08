/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.meta.KmMetaAttribute;

/**
 * I represent read only text for views that display 'field' oriented
 * information.  Similar to a text SPAN, I am always rendered with
 * an enclosing element which allows me to be dynamically updated,
 * or hidden.  I render an an inline (vs block) element, and automatically
 * display the standard help icon for any attached help message.
 */
public class ScFieldText
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScImage _helpImage;
    private ScText  _text;

    //##################################################
    //# constructor
    //##################################################

    public ScFieldText()
    {
        css().fieldText();

        _helpImage = getInner().addImage();
        _helpImage.css().helpTriangle().helpTooltip();
        _helpImage.setSource(getUrls().getHelpIndicatorUrl());
        _helpImage.hide();

        _text = getInner().addText();
    }

    //##################################################
    //# value
    //##################################################

    public void setValue(String e)
    {
        _text.setValue(e);
    }

    public void setFormattedValue(Object e)
    {
        _text.setFormattedValue(e);
    }

    public void setValue(KmAdaptorIF<?,?> e)
    {
        _text.setValue(e);
    }

    public void setValue(KmMetaAttribute<?,?> e)
    {
        _text.setValue(e);
    }

    public void clearValue()
    {
        _text.clearValue();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        if ( hasHelp() )
        {
            _helpImage.setHoverText(getHelp());
            _helpImage.show();
        }
    }

}
