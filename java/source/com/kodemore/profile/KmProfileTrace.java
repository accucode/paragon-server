/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.profile;

import java.util.Iterator;

import com.kodemore.collection.KmList;

public class KmProfileTrace
{
    //##################################################
    //# variables
    //##################################################

    private int                        _traceId;
    private int                        _threadId;
    private KmList<KmProfileTraceLine> _lines;

    //##################################################
    //# constructor
    //##################################################

    public KmProfileTrace()
    {
        _traceId = -1;
        _threadId = -1;
        _lines = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getTraceId()
    {
        return _traceId;
    }

    public void setTraceId(int e)
    {
        _traceId = e;
    }

    public int getThreadId()
    {
        return _threadId;
    }

    public void setThreadId(int e)
    {
        _threadId = e;
    }

    public KmList<KmProfileTraceLine> getLines()
    {
        return _lines;
    }

    public void setLines(KmList<KmProfileTraceLine> e)
    {
        _lines = e;
    }

    public void addLine(String name, int lineNumber)
    {
        KmProfileTraceLine e;
        e = new KmProfileTraceLine();
        e.setName(name);
        e.setLineNumber(lineNumber);
        _lines.add(e);
    }

    public KmProfileTraceLine getRoot()
    {
        int n = _lines.size();
        if ( n == 0 )
            return null;
        return _lines.get(n - 1);
    }

    public Iterator<KmProfileTraceLine> getTraceLinesFromRoot()
    {
        KmList<KmProfileTraceLine> v;
        v = new KmList<>();
        v.addAll(_lines);
        v.reverse();
        return v.iterator();
    }
}
