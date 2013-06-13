/*
  Copyright (c) 2005-2011 www.kodemore.com

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

public class KmProfileCpu
{
    //##################################################
    //# variables
    //##################################################

    private int    _rank;
    private double _self;
    private double _accumulation;
    private int    _count;
    private int    _traceId;

    //##################################################
    //# accessing
    //##################################################

    public int getRank()
    {
        return _rank;
    }

    public void setRank(int e)
    {
        _rank = e;
    }

    public double getSelf()
    {
        return _self;
    }

    public void setSelf(double e)
    {
        _self = e;
    }

    public double getAccumulation()
    {
        return _accumulation;
    }

    public void setAccumulation(double e)
    {
        _accumulation = e;
    }

    public int getCount()
    {
        return _count;
    }

    public void setCount(int e)
    {
        _count = e;
    }

    public int getTraceId()
    {
        return _traceId;
    }

    public void setTraceId(int e)
    {
        _traceId = e;
    }

    public boolean hasTraceId(int e)
    {
        return _traceId == e;
    }

}
