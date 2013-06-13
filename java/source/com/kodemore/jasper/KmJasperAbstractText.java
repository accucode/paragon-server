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

public abstract class KmJasperAbstractText
    extends KmJasperAbstractReportElement
{
    //##################################################
    //# variables
    //##################################################

    private String            _textAlign;
    private String            _verticalAlign;
    private String            _rotation;
    private String            _lineSpacing;

    private KmJasperLocalFont _localFont;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperAbstractText(KmJasperReportBuilder e)
    {
        super(e);
    }

    //##################################################
    //# text align
    //##################################################

    public String getTextAlign()
    {
        return _textAlign;
    }

    public void setTextAlign(String e)
    {
        _textAlign = e;
    }

    public void alignLeft()
    {
        setTextAlign("Left");
    }

    public void alignRight()
    {
        setTextAlign("Right");
    }

    public void alignCenter()
    {
        setTextAlign("Center");
    }

    public void alignJustified()
    {
        setTextAlign("Justified");
    }

    //##################################################
    //# vertical align
    //##################################################

    public String getVerticalAlign()
    {
        return _verticalAlign;
    }

    public void setVerticalAlign(String e)
    {
        _verticalAlign = e;
    }

    public void alignTop()
    {
        setVerticalAlign("Top");
    }

    public void alignMiddle()
    {
        setVerticalAlign("Middle");
    }

    public void alignBottom()
    {
        setVerticalAlign("Bottom");
    }

    //##################################################
    //# rotation
    //##################################################

    public String getRotation()
    {
        return _rotation;
    }

    public void setRotation(String e)
    {
        _rotation = e;
    }

    public void setRotationNone()
    {
        setRotation("None");
    }

    public void setRotationLeft()
    {
        setRotation("Left");
    }

    public void setRotationRight()
    {
        setRotation("Right");
    }

    //##################################################
    //# line spacing
    //##################################################

    public String getLineSpacing()
    {
        return _lineSpacing;
    }

    public void setLineSpacing(String e)
    {
        _lineSpacing = e;
    }

    public void setLineSpacingSingle()
    {
        setLineSpacing("Single");
    }

    public void setLineSpacingDouble()
    {
        setLineSpacing("Double");
    }

    public void setLineSpacingMedium()
    {
        setLineSpacing("1_1_2");
    }

    //##################################################
    //# font
    //##################################################

    public KmJasperLocalFont getFont()
    {
        if ( _localFont == null )
            _localFont = new KmJasperLocalFont(getBuilder());
        return _localFont;
    }

    public void setFont(KmJasperLocalFont e)
    {
        _localFont = e;
    }

    public void setFont(KmJasperFont e)
    {
        _localFont = new KmJasperLocalFont(getBuilder());
        _localFont.setFont(e);
    }

    public boolean hasFont()
    {
        return _localFont != null;
    }

    //##################################################
    //# convenience
    //##################################################

    public void centerOn(KmJasperAbstractReportElement e)
    {
        setShape(e);
        alignMiddle();
        alignCenter();
    }

    //##################################################
    //# compose
    //##################################################

    public void addTextElementTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement e;
        e = root.addElement("textElement");
        e.addAttribute("textAlignment", getTextAlign());
        e.addAttribute("verticalAlignment", getVerticalAlign());
        e.addAttribute("rotation", getRotation());
        e.addAttribute("lineSpacing", getLineSpacing());
        e.add(_localFont);
    }

}
