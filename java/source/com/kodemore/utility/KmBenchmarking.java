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
package com.kodemore.utility;

/**
 * Methods in this class may be flagged as dubious by style checkers.
 * These methods are not directly unsafe, but they generally shouldn't be used
 * except for benchmarking, start up info, and debugging.
 */
public class KmBenchmarking
    implements KmConstantsIF
{
    //##################################################
    //# runtime
    //##################################################

    /**
     * Just checking freeMemory before/after some action isn't enough.
     * You might see the free memory stay the same, but if the totalMemory
     * increased by 100Mg, then that means that the action actually used
     * 100Mg even though the free memory didn't change.
     */
    public static long getUsedMemory()
    {
        Runtime rt;
        rt = Runtime.getRuntime();
        rt.gc();
        rt.gc(); // the double gc seems to generate more consistent results.
        return rt.totalMemory() - rt.freeMemory();
    }
}
