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

import com.kodemore.collection.KmList;
import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * An "and/or" element used in filters.
 *
 * @see KmIntacctNode
 */
public class KmIntacctJunction
    extends KmIntacctFilterElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String            AND = "and";
    private static final String            OR  = "or";

    //##################################################
    //# variables
    //##################################################

    private String                         _type;
    private KmList<KmIntacctFilterElement> _elements;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctJunction()
    {
        beAnd();
        _elements = new KmList<>();
    }

    //##################################################
    //# type
    //##################################################

    public String getType()
    {
        return _type;
    }

    public void beAnd()
    {
        _type = AND;
    }

    public void beOr()
    {
        _type = OR;
    }

    //##################################################
    //# elements
    //##################################################

    public void addElement(KmIntacctFilterElement e)
    {
        _elements.add(e);
    }

    public KmIntacctJunction addAnd()
    {
        KmIntacctJunction e;
        e = new KmIntacctJunction();
        e.beAnd();
        addElement(e);
        return e;
    }

    public KmIntacctJunction addOr()
    {
        KmIntacctJunction e;
        e = new KmIntacctJunction();
        e.beOr();
        addElement(e);
        return e;
    }

    public KmIntacctExpression addExpression(String field)
    {
        KmIntacctExpression e;
        e = new KmIntacctExpression();
        e.setField(field);
        addElement(e);
        return e;
    }

    public boolean isEmpty()
    {
        return _elements.isEmpty();
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void composeOn(KmXmlBuilder out)
    {
        KmList<KmIntacctFilterElement> v = _elements;
        if ( v.isEmpty() )
            return;

        if ( v.isSingleton() )
        {
            v.getFirst().composeOn(out);
            return;
        }

        out.open("logical");
        out.printAttribute("logical_operator", getType());
        out.close();

        for ( KmIntacctFilterElement e : v )
            e.composeOn(out);

        out.end();
    }
}
