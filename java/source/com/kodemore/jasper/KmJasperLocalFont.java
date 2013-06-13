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

package com.kodemore.jasper;

import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperLocalFont
    extends KmJasperAbstractFont
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperFont _font;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperLocalFont(KmJasperReportBuilder e)
    {
        super(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmJasperFont getFont()
    {
        return _font;
    }

    public void setFont(KmJasperFont e)
    {
        _font = e;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected boolean requiresFontName()
    {
        return getFamily() != null || getBold() != null || getItalic() != null;
    }

    @Override
    protected KmJasperFontFamily getEffectiveFontType()
    {
        if ( getFamily() != null )
            return getFamily();

        if ( _font == null )
            return KmJasperFontFamily.HELVETICA;

        return _font.getFamily();
    }

    @Override
    protected boolean getEffectiveBold()
    {
        if ( getBold() != null )
            return getBold();

        if ( _font == null )
            return false;

        return _font.getEffectiveBold();
    }

    @Override
    protected boolean getEffectiveItalic()
    {
        if ( getItalic() != null )
            return getItalic();

        if ( _font == null )
            return false;

        return _font.getEffectiveItalic();
    }

    @Override
    protected int getEffectiveSize()
    {
        if ( getSize() != null )
            return getSize();

        if ( _font == null )
            return getBuilder().getDefaultFont().getSize();

        return _font.getEffectiveSize();
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement font;
        font = root.addElement("font");
        addAttributesTo(font);
    }

    public void addAttributesTo(KmJasperXmlElement root)
    {
        root.addAttribute("reportFont", getFont());
        addStandardAttributesTo(root);
    }
}
