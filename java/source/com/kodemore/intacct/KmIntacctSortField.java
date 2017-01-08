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

package com.kodemore.intacct;

import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * A single field for sorting.
 *
 * @see KmIntacctNode
 */
public class KmIntacctSortField
    extends KmIntacctNode
{
    //##################################################
    //# constants
    //##################################################

    private static final String ASCENDING  = "asc";
    private static final String DESCENDING = "desc";

    //##################################################
    //# variables
    //##################################################

    private String              _field;
    private String              _order;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctSortField()
    {
        ascending();
    }

    //##################################################
    //# field
    //##################################################

    public String getField()
    {
        return _field;
    }

    public void setField(String e)
    {
        _field = e;
    }

    //##################################################
    //# order
    //##################################################

    public String getOrder()
    {
        return _order;
    }

    public void setOrder(String e)
    {
        _order = e;
    }

    public void ascending()
    {
        setOrder(ASCENDING);
    }

    public void descending()
    {
        setOrder(DESCENDING);
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void composeOn(KmXmlBuilder out)
    {
        out.setAutoFormat(false);

        out.indent();
        out.open("sortfield");
        out.printAttribute("order", getOrder());
        out.close();
        out.text(getField());
        out.end();
        out.printLine();

        out.setAutoFormat(true);
    }
}
