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

import static com.kodemore.edi.KmEdiConstantsIF.TAG_INTERCHANGE_HEADER;
import static com.kodemore.edi.KmEdiConstantsIF.TAG_INTERCHANGE_TRAILER;
import static com.kodemore.edi.KmEdiConstantsIF.TAG_MESSAGE_HEADER;
import static com.kodemore.edi.KmEdiConstantsIF.TAG_MESSAGE_TRAILER;

import java.io.IOException;
import java.io.StringWriter;

import com.kodemore.collection.KmList;

/**
 * I am used to parse an edi interchange.
 */
public class KmEdiInterchange
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmEdiSegment> _segments;

    //##################################################
    //# constructor
    //##################################################

    public KmEdiInterchange()
    {
        _segments = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<KmEdiSegment> getSegments()
    {
        return _segments;
    }

    public void setSegments(KmList<KmEdiSegment> e)
    {
        _segments = e;
    }

    public void addSegment(KmEdiSegment e)
    {
        _segments.add(e);
    }

    public void addAllSegments(KmList<KmEdiSegment> l)
    {
        _segments.addAll(l);
    }

    //##################################################
    //# convenience
    //##################################################

    public KmEdiSegment getHeader()
    {
        return getFirstSegment(TAG_INTERCHANGE_HEADER);
    }

    public void setHeader(KmEdiSegment x)
    {
        _segments.add(0, x);
    }

    public KmEdiSegment getTrailer()
    {
        return getFirstSegment(TAG_INTERCHANGE_TRAILER);
    }

    public void setTrailer(KmEdiSegment x)
    {
        _segments.add(x);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmEdiSegment getFirstSegment(String tag)
    {
        for ( KmEdiSegment e : _segments )
            if ( e.hasTag(tag) )
                return e;

        return null;
    }

    public int getFirstSegmentIndex(int begin, int end, String tag)
    {
        for ( int i = begin; i <= end && i < _segments.size(); i++ )
        {
            KmEdiSegment e = _segments.get(i);
            if ( e.hasTag(tag) )
                return i;
        }

        return -1;
    }

    public KmList<KmEdiMessage> getMessages()
    {
        KmList<KmEdiMessage> messages = new KmList<>();

        int b = findMessageHeaderIndex(0);
        if ( b == -1 )
            return null;

        int e = b + 1;
        while ( e != -1 )
        {
            e = findMessageTrailerIndex(b);
            if ( e == -1 )
                continue;

            messages.add(createMessage(b, e));
            b = e + 1;
        }

        return messages;
    }

    public KmEdiMessage createMessage(int b, int e)
    {
        KmEdiMessage msg;
        msg = new KmEdiMessage();
        msg.setParent(this);
        msg.setBeginInterchangeIndex(b);
        msg.setEndInterchangeIndex(e);
        return msg;
    }

    private int findMessageTrailerIndex(int b)
    {
        return getFirstSegmentIndex(b, _segments.size() - 1, TAG_MESSAGE_TRAILER);
    }

    private int findMessageHeaderIndex(int b)
    {
        return getFirstSegmentIndex(b, _segments.size() - 1, TAG_MESSAGE_HEADER);
    }

    public KmList<KmEdiSegment> getSegments(int beginIndex, int endIndex)
    {
        KmList<KmEdiSegment> v = new KmList<>();

        for ( int i = beginIndex; i <= endIndex && i <= _segments.size(); i++ )
            v.add(_segments.get(i));

        return v;
    }

    public String format()
    {
        try
        {
            StringWriter sw = new StringWriter();

            KmEdiWriter ew;
            ew = new KmEdiWriter(sw);
            ew.writeInterchange(this);
            ew.flush();

            return sw.toString();
        }
        catch ( IOException ex )
        {
            throw new RuntimeException(ex);
        }
    }

    public KmEdiSegment getSegment(int beginInterchangeIndex, int relativeIndex)
    {
        return _segments.get(beginInterchangeIndex + relativeIndex);
    }
}
