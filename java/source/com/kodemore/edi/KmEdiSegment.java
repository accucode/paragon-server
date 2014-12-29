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

package com.kodemore.edi;

import static com.kodemore.edi.KmEdiConstantsIF.EMPTY_ELEMENT_ARRAY;
import static com.kodemore.edi.KmEdiConstantsIF.EMPTY_VALUE;

import java.io.IOException;
import java.io.StringWriter;

import com.kodemore.collection.KmList;

/**
 * I am used to parse an edi interchange.
 */
public class KmEdiSegment
{
    //##################################################
    //# variables
    //##################################################

    private String         _tag;
    private KmEdiElement[] _elements;

    //##################################################
    //# constructor
    //##################################################

    public KmEdiSegment(String tag)
    {
        _tag = tag;
        _elements = EMPTY_ELEMENT_ARRAY;
    }

    public KmEdiSegment(String tag, KmList<KmEdiElement> v)
    {
        this(tag);
        setElements(v);
    }

    //##################################################
    //# tag
    //##################################################

    public String getTag()
    {
        return _tag;
    }

    public boolean hasTag(String s)
    {
        return _tag.equals(s);
    }

    //##################################################
    //# elements
    //##################################################

    public KmEdiElement[] getElements()
    {
        return _elements;
    }

    public KmEdiElement getElement(int i)
    {
        return i < _elements.length
            ? _elements[i]
            : null;
    }

    public void setElements(KmList<KmEdiElement> v)
    {
        int n = v.size();

        if ( _elements.length != n )
            _elements = new KmEdiElement[n];

        for ( int i = 0; i < n; i++ )
            _elements[i] = v.get(i);
    }

    //##################################################
    //# values
    //##################################################

    public String getValue(int elementIndex)
    {
        return getValue(elementIndex, 0);
    }

    public String getValue(int elementIndex, int valueIndex)
    {
        KmEdiElement e = getElement(elementIndex);
        return e == null
            ? EMPTY_VALUE
            : e.getValue(valueIndex);
    }

    public void setValue(int elementIndex, String s)
    {
        int valueIndex = 0;
        setValue(elementIndex, valueIndex, s);
    }

    public void setValue(int elementIndex, int valueIndex, String s)
    {
        ensureIndex(elementIndex);
        getElement(elementIndex).setValue(valueIndex, s);
    }

    //##################################################
    //# private
    //##################################################

    public void ensureIndex(int index)
    {
        if ( _elements.length > index )
            return;

        KmEdiElement[] arr = new KmEdiElement[index + 1];

        for ( int i = 0; i < _elements.length; i++ )
            arr[i] = _elements[i];

        for ( int i = _elements.length; i < index + 1; i++ )
            arr[i] = new KmEdiElement();

        _elements = arr;
    }

    //##################################################
    //# text representation
    //##################################################

    public String format()
    {
        try
        {
            StringWriter sw = new StringWriter();

            KmEdiWriter ew;
            ew = new KmEdiWriter(sw);
            ew.writeSegment(this);
            ew.flush();

            return sw.toString();
        }
        catch ( IOException ex )
        {
            throw new RuntimeException(ex);
        }
    }
}
