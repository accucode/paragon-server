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

public class KmJasperBorder
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    private Integer     _padding;
    private Integer     _topPadding;
    private Integer     _leftPadding;
    private Integer     _bottomPadding;
    private Integer     _rightPadding;

    private KmJasperPen _pen;
    private KmJasperPen _topPen;
    private KmJasperPen _leftPen;
    private KmJasperPen _bottomPen;
    private KmJasperPen _rightPen;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperBorder()
    {
        // none
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

    public KmJasperPen getTopPen()
    {
        if ( _topPen == null )
            _topPen = new KmJasperPen("topPen");
        return _topPen;
    }

    public KmJasperPen getLeftPen()
    {
        if ( _leftPen == null )
            _leftPen = new KmJasperPen("leftPen");
        return _leftPen;
    }

    public KmJasperPen getBottomPen()
    {
        if ( _bottomPen == null )
            _bottomPen = new KmJasperPen("bottomPen");
        return _bottomPen;
    }

    public KmJasperPen getRightPen()
    {
        if ( _rightPen == null )
            _rightPen = new KmJasperPen("rightPen");
        return _rightPen;
    }

    //##################################################
    //# padding
    //##################################################

    public Integer getPadding()
    {
        return _padding;
    }

    public void setPadding(Integer e)
    {
        _padding = e;
    }

    public Integer getTopPadding()
    {
        return _topPadding;
    }

    public void setTopPadding(Integer e)
    {
        _topPadding = e;
    }

    public Integer getLeftPadding()
    {
        return _leftPadding;
    }

    public void setLeftPadding(Integer e)
    {
        _leftPadding = e;
    }

    public Integer getBottomPadding()
    {
        return _bottomPadding;
    }

    public void setBottomPadding(Integer e)
    {
        _bottomPadding = e;
    }

    public Integer getRightPadding()
    {
        return _rightPadding;
    }

    public void setRightPadding(Integer e)
    {
        _rightPadding = e;
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement border;
        border = root.addElement("box");
        border.addAttribute("padding", _padding);
        border.addAttribute("topPadding", _topPadding);
        border.addAttribute("leftPadding", _leftPadding);
        border.addAttribute("bottomPadding", _bottomPadding);
        border.addAttribute("rightPadding", _rightPadding);
        border.add(_pen);
        border.add(_topPen);
        border.add(_leftPen);
        border.add(_bottomPen);
        border.add(_rightPen);
    }

}
