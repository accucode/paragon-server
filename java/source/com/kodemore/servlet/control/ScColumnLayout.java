/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;

public class ScColumnLayout
    implements ScLayoutIF
{
    //##################################################
    //# variables
    //##################################################

    private int _gap;

    //##################################################
    //# constructor
    //##################################################

    public ScColumnLayout()
    {
        _gap = 5;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public ScColumnLayout getCopy()
    {
        ScColumnLayout e;
        e = new ScColumnLayout();
        e.setGap(getGap());
        return e;
    }

    //##################################################
    //# gap
    //##################################################

    public int getGap()
    {
        return _gap;
    }

    public void setGap(int e)
    {
        _gap = e;
    }

    public ScColumnLayout gap(int e)
    {
        _gap = e;
        return this;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderOpenOn(KmHtmlBuilder out)
    {
        out.beginTable();
    }

    @Override
    public void renderChildOn(KmHtmlBuilder out, ScControl e, int i, int n)
    {
        out.beginTableRow();

        out.openTableData();
        if ( _gap > 0 && i > 0 )
        {
            KmStyleBuilder style;
            style = new KmStyleBuilder();
            style.padTop(_gap);

            out.printAttribute(style);
        }
        out.close();

        out.render(e);
        out.endTableData();
        out.endTableRow();
    }

    @Override
    public void renderCloseOn(KmHtmlBuilder out)
    {
        out.endTable();
    }
}
