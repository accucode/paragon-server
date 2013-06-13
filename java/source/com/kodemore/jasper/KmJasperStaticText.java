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

/**
 * I am rarely used.  Because I cannot automatically stretch,
 * it is usually preferable to use dynamic text, even for
 * static content.
 */
public class KmJasperStaticText
    extends KmJasperAbstractText
    implements KmJasperBandElementIF
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# constructor 
    //##################################################

    public KmJasperStaticText(KmJasperReportBuilder e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement staticText;
        staticText = root.addElement("staticText");

        addReportElementTo(staticText);
        addTextElementTo(staticText);

        KmJasperXmlElement text;
        text = staticText.addElement("text");
        text.setIndentChildren(false);
        text.addCdata(getValue());
    }

}
