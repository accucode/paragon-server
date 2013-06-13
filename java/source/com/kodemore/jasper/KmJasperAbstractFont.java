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

public abstract class KmJasperAbstractFont
    extends KmJasperElement
{
    //##################################################
    //# enum
    //##################################################

    private KmJasperFontFamily _family;
    private Integer            _size;

    private Boolean            _bold;
    private Boolean            _italic;
    private Boolean            _underline;
    private Boolean            _strikeThrough;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperAbstractFont(KmJasperReportBuilder e)
    {
        super(e);
    }

    //##################################################
    //# font type
    //##################################################

    public KmJasperFontFamily getFamily()
    {
        return _family;
    }

    public void setFamily(KmJasperFontFamily e)
    {
        _family = e;
    }

    public void setFamilyCourier()
    {
        _family = KmJasperFontFamily.COURIER;
    }

    public void setFamilyHelvetica()
    {
        _family = KmJasperFontFamily.HELVETICA;
    }

    public void setFamilyTimes()
    {
        _family = KmJasperFontFamily.TIMES;
    }

    //##################################################
    //# font name
    //##################################################

    public String getFontName()
    {
        if ( !requiresFontName() )
            return null;

        KmJasperFontFamily type = getEffectiveFontType();
        switch ( type )
        {
            case COURIER:
                return "Monospaced";

            case HELVETICA:
                return "SansSerif";

            case TIMES:
                return "Serif";
        }
        return null;
    }

    private String getPdfFontName()
    {
        if ( !requiresFontName() )
            return null;

        KmJasperFontFamily type = getEffectiveFontType();
        switch ( type )
        {
            case COURIER:
                return getEffectivePdfFontName("Courier", "Courier", "Bold", "Oblique");

            case HELVETICA:
                return getEffectivePdfFontName("Helvetica", "Helvetica", "Bold", "Oblique");

            case TIMES:
                return getEffectivePdfFontName("Times-Roman", "Times", "Bold", "Italic");
        }
        return null;
    }

    protected abstract boolean requiresFontName();

    private String getEffectivePdfFontName(
        String full,
        String prefix,
        String boldSuffix,
        String italicSuffix)
    {
        boolean isBold = getEffectiveBold();
        boolean isItalic = getEffectiveItalic();

        if ( !isBold && !isItalic )
            return full;

        String s = prefix + "-";
        if ( isBold )
            s += boldSuffix;

        if ( isItalic )
            s += italicSuffix;

        return s;

    }

    protected KmJasperFontFamily getEffectiveFontType()
    {
        if ( _family != null )
            return _family;

        return KmJasperFontFamily.HELVETICA;
    }

    protected boolean getEffectiveBold()
    {
        if ( _bold != null )
            return _bold;

        return false;
    }

    protected boolean getEffectiveItalic()
    {
        if ( _italic != null )
            return _italic;

        return false;
    }

    protected int getEffectiveSize()
    {
        if ( _size != null )
            return _size;

        return 10;
    }

    //##################################################
    //# size
    //##################################################

    public Integer getSize()
    {
        return _size;
    }

    public void setSize(Integer e)
    {
        _size = e;
    }

    //##################################################
    //# bold
    //##################################################

    public Boolean getBold()
    {
        return _bold;
    }

    public void setBold(Boolean e)
    {
        _bold = e;
    }

    public void setBold()
    {
        _bold = true;
    }

    public void setBold(int size)
    {
        setBold();
        setSize(size);
    }

    //##################################################
    //# italic
    //##################################################

    public Boolean getItalic()
    {
        return _italic;
    }

    public void setItalic(Boolean e)
    {
        _italic = e;
    }

    public void setItalic()
    {
        _italic = true;
    }

    //##################################################
    //# underline
    //##################################################

    public Boolean getUnderline()
    {
        return _underline;
    }

    public void setUnderline(Boolean e)
    {
        _underline = e;
    }

    public void setUnderline()
    {
        _underline = true;
    }

    //##################################################
    //# strike
    //##################################################

    public Boolean getStikeThrough()
    {
        return _strikeThrough;
    }

    public void setStrikeThrough(Boolean e)
    {
        _strikeThrough = e;
    }

    public void setStrikeThrough()
    {
        _strikeThrough = true;
    }

    //##################################################
    //# compose
    //##################################################

    protected void addStandardAttributesTo(KmJasperXmlElement font)
    {
        font.addAttribute("fontName", getFontName());
        font.addAttribute("size", _size);
        font.addAttribute("isBold", getBold());
        font.addAttribute("isItalic", getItalic());
        font.addAttribute("isUnderline", getUnderline());
        font.addAttribute("isStrikeThrough", getStikeThrough());
        font.addAttribute("pdfFontName", getPdfFontName());
    }

}
