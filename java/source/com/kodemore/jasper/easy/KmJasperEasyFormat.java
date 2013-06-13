/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper.easy;

import com.kodemore.jasper.KmJasperAbstractReportElement;
import com.kodemore.jasper.KmJasperAbstractText;
import com.kodemore.jasper.KmJasperFont;
import com.kodemore.jasper.KmJasperLocalFont;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.KmJasperStyle;

public class KmJasperEasyFormat
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperReportBuilder _builder;
    private KmJasperStyle         _style;
    private KmJasperLocalFont     _font;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperEasyFormat(KmJasperReportBuilder e)
    {
        _builder = e;
    }

    //##################################################
    //# style
    //##################################################

    public KmJasperStyle getStyle()
    {
        if ( _style == null )
            _style = _builder.addStyle();
        return _style;
    }

    public void setStyle(KmJasperStyle e)
    {
        _style = e;
    }

    public boolean hasStyle()
    {
        return _style != null;
    }

    //##################################################
    //# font
    //##################################################

    public KmJasperLocalFont getFont()
    {
        if ( _font == null )
            _font = new KmJasperLocalFont(_builder);
        return _font;
    }

    public void setFont(KmJasperLocalFont e)
    {
        _font = e;
    }

    public void setFont(KmJasperFont e)
    {
        getFont().setFont(e);
    }

    public boolean hasFont()
    {
        return _font != null;
    }

    //##################################################
    //# convenience
    //##################################################

    public void applyTo(KmJasperAbstractReportElement e)
    {
        if ( hasStyle() )
            e.setStyle(getStyle());

        if ( hasFont() )
            if ( e instanceof KmJasperAbstractText )
                ((KmJasperAbstractText)e).setFont(getFont());
    }
}
