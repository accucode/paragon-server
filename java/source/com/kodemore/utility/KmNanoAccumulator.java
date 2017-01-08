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

package com.kodemore.utility;

public class KmNanoAccumulator
{
    //##################################################
    //# variables
    //##################################################

    private long _count;
    private long _nanos;

    //##################################################
    //# accessing
    //##################################################

    public synchronized long[] resetCountAndNanos()
    {
        long[] arr = getCountAndNanos();
        _count = 0;
        _nanos = 0;
        return arr;
    }

    public synchronized double resetAverageSeconds()
    {
        long[] arr = resetCountAndNanos();
        long count = arr[0];
        long nanos = arr[1];

        if ( count == 0 )
            return 0;

        return 1.0 * nanos / count / 1000000000;
    }

    public synchronized long[] getCountAndNanos()
    {
        return new long[]
        {
            _count,
            _nanos
        };
    }

    public synchronized void addNanos(long nanos)
    {
        if ( nanos > 0 )
        {
            _count++;
            _nanos += nanos;
        }
    }

    public synchronized long addSince(long start)
    {
        long diff = getNow() - start;
        addNanos(diff);
        return diff;
    }

    public long getNow()
    {
        return System.nanoTime();
    }

}
