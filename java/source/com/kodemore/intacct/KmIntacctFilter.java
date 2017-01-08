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
 * A filter for requests.
 *
 * @see KmIntacctNode
 */
public class KmIntacctFilter
    extends KmIntacctNode
{
    //##################################################
    //# variables
    //##################################################

    private KmIntacctJunction _junction;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctFilter()
    {
        _junction = new KmIntacctJunction();
        beAnd();
    }

    //##################################################
    //# type
    //##################################################

    public void beAnd()
    {
        _junction.beAnd();
    }

    public void beOr()
    {
        _junction.beOr();
    }

    //##################################################
    //# elements
    //##################################################

    public KmIntacctJunction addAnd()
    {
        return _junction.addAnd();
    }

    public KmIntacctJunction addOr()
    {
        return _junction.addOr();
    }

    public KmIntacctExpression addExpression(String field)
    {
        return _junction.addExpression(field);
    }

    public boolean isEmpty()
    {
        return _junction.isEmpty();
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void composeOn(KmXmlBuilder out)
    {
        if ( isEmpty() )
            return;

        out.begin("filter");
        _junction.composeOn(out);
        out.end();
    }
}
