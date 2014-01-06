/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.exception.error;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringAssociation;

public class KmBadReferenceError
    extends KmError
{
    //##################################################
    //# variables
    //##################################################

    private String                      _model;
    private KmList<KmStringAssociation> _keys;

    //##################################################
    //# constructor
    //##################################################

    public KmBadReferenceError()
    {
        super();
        _keys = new KmList<KmStringAssociation>();
    }

    public KmBadReferenceError(String model, String field, String value)
    {
        _model = model;
        _keys = new KmList<KmStringAssociation>();
        addKey(field, value);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getModel()
    {
        return _model;
    }

    public void setModel(String e)
    {
        _model = e;
    }

    public KmList<KmStringAssociation> getKeys()
    {
        return _keys;
    }

    public void setKeys(KmList<KmStringAssociation> e)
    {
        _keys = e;
    }

    //##################################################
    //# collection manipulation
    //##################################################

    public void addKey(String field, String value)
    {
        KmStringAssociation a = new KmStringAssociation(field, value);
        _keys.add(a);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public void formatProblem(StringBuilder sb)
    {
        sb.append(_model);
        sb.append(" does not exist for ");
        Iterator<KmStringAssociation> e = _keys.iterator();
        while ( e.hasNext() )
        {
            KmStringAssociation a = e.next();
            sb.append(a.getKey());
            sb.append(" = ");
            sb.append(a.getValue());
            if ( e.hasNext() )
                sb.append(", ");
        }
    }

}
