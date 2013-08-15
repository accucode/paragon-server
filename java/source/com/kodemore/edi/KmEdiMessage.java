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

package com.kodemore.edi;

import java.io.IOException;
import java.io.StringWriter;

import com.kodemore.collection.KmList;

public class KmEdiMessage
{
    //##################################################
    //# variables
    //##################################################

    private KmEdiInterchange _parent;
    private int              _beginInterchangeIndex;
    private int              _endInterchangeIndex;

    //##################################################
    //# constructor
    //##################################################

    public KmEdiMessage()
    {
        super();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getBeginInterchangeIndex()
    {
        return _beginInterchangeIndex;
    }

    public void setBeginInterchangeIndex(int interchangeIndex)
    {
        _beginInterchangeIndex = interchangeIndex;
    }

    public int getEndInterchangeIndex()
    {
        return _endInterchangeIndex;
    }

    public void setEndInterchangeIndex(int interchangeIndex)
    {
        _endInterchangeIndex = interchangeIndex;
    }

    public KmEdiInterchange getParent()
    {
        return _parent;
    }

    public void setParent(KmEdiInterchange e)
    {
        _parent = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public KmEdiSegment getHeader()
    {
        return getSegments().get(0);
    }

    public KmEdiSegment getBeginMessageSegment()
    {
        return getSegments().get(1);
    }

    public KmEdiSegment getTrailer()
    {
        KmList<KmEdiSegment> l = getSegments();
        return l.get(l.size() - 1);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmList<KmEdiSegment> getSegments()
    {
        return _parent.getSegments(_beginInterchangeIndex, _endInterchangeIndex);
    }

    public String format()
    {
        try
        {
            StringWriter sw = new StringWriter();
            KmEdiWriter ew = new KmEdiWriter(sw);
            ew.writeMessage(this);
            ew.flush();
            return sw.toString();
        }
        catch ( IOException e )
        {
            throw new RuntimeException(e);
        }
    }

    public KmEdiSegment getSegment(int relativeIndex)
    {
        return _parent.getSegment(_beginInterchangeIndex, relativeIndex);
    }
}
