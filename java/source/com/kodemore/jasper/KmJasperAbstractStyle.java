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

import java.util.List;

import com.kodemore.jasper.xml.KmJasperXmlElement;

public abstract class KmJasperAbstractStyle
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    // attributes
    private String         _name;
    private String         _mode;
    private KmJasperColor  _color;
    private KmJasperColor  _fillColor;
    private String         _horizontalAlign;
    private String         _verticalAlign;
    private String         _rotation;
    private String         _lineSpacing;
    private Boolean        _blankWhenNull;
    private String         _markup;

    // elements
    private KmJasperPen    _pen;
    private KmJasperBorder _border;

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# mode
    //##################################################

    public String getMode()
    {
        return _mode;
    }

    public void setModeOpaque()
    {
        _mode = "Opaque";

    }

    public void setModeTransparent()
    {
        _mode = "Transparent";
    }

    public String getEffectiveMode()
    {
        if ( _mode != null )
            return _mode;

        if ( _fillColor != null )
            return "Opaque";

        return null;
    }

    //##################################################
    //# color
    //##################################################

    public KmJasperColor getColor()
    {
        if ( _color == null )
            _color = new KmJasperColor();
        return _color;
    }

    public void setColor(KmJasperColor e)
    {
        _color = e;

    }

    //##################################################
    //# background color
    //##################################################

    public KmJasperColor getFillColor()
    {
        if ( _fillColor == null )
            _fillColor = new KmJasperColor();
        return _fillColor;
    }

    public void setFillColor(KmJasperColor e)
    {
        _fillColor = e;
    }

    //##################################################
    //# horizontal align
    //##################################################

    public String getHorizontalAlign()
    {
        return _horizontalAlign;
    }

    public void alignLeft()
    {
        _horizontalAlign = "Left";
    }

    public void alignRight()
    {
        _horizontalAlign = "Right";
    }

    public void alignCenter()
    {
        _horizontalAlign = "Center";
    }

    public void alignJustified()
    {
        _horizontalAlign = "Justified";
    }

    //##################################################
    //# vertical align
    //##################################################

    public String getVerticalAlign()
    {
        return _verticalAlign;
    }

    public void alignTop()
    {
        _verticalAlign = "Top";
    }

    public void alignMiddle()
    {
        _verticalAlign = "Middle";
    }

    public void alignBottom()
    {
        _verticalAlign = "Bottom";
    }

    //##################################################
    //# rotation
    //##################################################

    public String getRotation()
    {
        return _rotation;
    }

    public void setRotationNone()
    {
        _rotation = "None";
    }

    public void setRotationLeft()
    {
        _rotation = "Left";
    }

    public void setRotationRight()
    {
        _rotation = "Right";
    }

    public void setRotationUpsideDown()
    {
        _rotation = "UpsideDown";
    }

    //##################################################
    //# line spacing
    //##################################################

    public String getLineSpacing()
    {
        return _lineSpacing;
    }

    public void setLineSpacingSingle()
    {
        _lineSpacing = "Single";
    }

    public void setLineSpacingMiddle()
    {
        _lineSpacing = "1_1_2";
    }

    public void setLineSpacingDouble()
    {
        _lineSpacing = "Double";
    }

    //##################################################
    //# blank when null
    //##################################################

    public Boolean getBlankWhenNull()
    {
        return _blankWhenNull;
    }

    public void setBlankWhenNull(Boolean e)
    {
        _blankWhenNull = e;
    }

    public void setBlankWhenNull()
    {
        setBlankWhenNull(true);
    }

    //##################################################
    //# markup
    //##################################################

    public String getMarkup()
    {
        return _markup;
    }

    public void setMarkupNone()
    {
        _markup = "none";
    }

    public void setMarkupStyled()
    {
        _markup = "styled";
    }

    public void setMarkupRichText()
    {
        _markup = "rtf";
    }

    public void setMarkupHtml()
    {
        _markup = "html";
    }

    //##################################################
    //# pen
    //##################################################

    public KmJasperPen getPen()
    {
        if ( _pen == null )
            _pen = new KmJasperPen();
        return _pen;
    }

    public void setPen(KmJasperPen e)
    {
        _pen = e;
    }

    //##################################################
    //# border
    //##################################################

    public KmJasperBorder getBorder()
    {
        if ( _border == null )
            _border = new KmJasperBorder();
        return _border;
    }

    public KmJasperColor getBorderColor()
    {
        return getBorder().getPen().getColor();
    }

    public void setBorderPadding(Integer e)
    {
        getBorder().setPadding(e);
    }

    public void setBorder(KmJasperBorder e)
    {
        _border = e;
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract Boolean getDefault();

    public abstract List<KmJasperConditionalStyle> getConditionalStyles();

    //##################################################
    //# compose
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement style;
        style = root.addElement("style");
        style.addAttribute("name", _name);
        style.addAttribute("isDefault", getDefault());
        style.addAttribute("mode", getEffectiveMode());
        style.addAttribute("forecolor", _color);
        style.addAttribute("backcolor", _fillColor);
        style.addAttribute("hAlign", _horizontalAlign);
        style.addAttribute("vAlign", _verticalAlign);
        style.addAttribute("rotation", _rotation);
        style.addAttribute("lineSpacing", _lineSpacing);
        style.addAttribute("isBlankWhenNull", _blankWhenNull);
        style.addAttribute("markup", _markup);

        style.add(_pen);
        style.add(_border);

        style.addAll(getConditionalStyles());
    }

}
