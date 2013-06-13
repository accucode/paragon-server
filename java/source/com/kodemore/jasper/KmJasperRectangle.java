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

public class KmJasperRectangle
    extends KmJasperAbstractGraphicElement
    implements KmJasperBandElementIF
{
    //##################################################
    //# variables
    //##################################################

    private Integer _radius;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperRectangle(KmJasperReportBuilder e)
    {
        super(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public Integer getRadius()
    {
        return _radius;
    }

    public void setRadius(Integer e)
    {
        _radius = e;
    }

    public void setRadiusInches(double e)
    {
        setRadius(KmJasperUtility.inches(e));
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement rect;
        rect = root.addElement("rectangle");
        rect.addAttribute("radius", _radius);

        addReportElementTo(rect);
        addGraphicElementTo(rect);
    }

}
