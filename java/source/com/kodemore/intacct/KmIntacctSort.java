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
 * The list of fields to sort on.
 *
 * @see KmIntacctNode
 */
public class KmIntacctSort
    extends KmIntacctNode
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmIntacctSortField> _fields;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctSort()
    {
        _fields = new KmList<>();
    }

    //##################################################
    //# fields
    //##################################################

    public void add(KmIntacctSortField e)
    {
        _fields.add(e);
    }

    public KmIntacctSortField addAscending(String field)
    {
        KmIntacctSortField e;
        e = new KmIntacctSortField();
        e.setField(field);
        e.ascending();
        add(e);
        return e;
    }

    public KmIntacctSortField addDescending(String field)
    {
        KmIntacctSortField e;
        e = new KmIntacctSortField();
        e.setField(field);
        e.descending();
        add(e);
        return e;
    }

    public boolean isEmpty()
    {
        return _fields.isEmpty();
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void composeOn(KmXmlBuilder out)
    {
        if ( isEmpty() )
            return;

        out.begin("sorts");

        for ( KmIntacctSortField e : _fields )
            e.composeOn(out);

        out.end();
    }
}
