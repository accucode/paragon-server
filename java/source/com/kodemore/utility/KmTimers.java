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

import com.kodemore.collection.KmMap;

/**
 * I implement a convenience method for managing a list of named timers.
 * This simplifies collecting cumulative times.
 */
public class KmTimers
{
    //##################################################
    //# variables
    //##################################################

    public static final KmMap<String,KmTimer> _timers = new KmMap<String,KmTimer>();

    //##################################################
    //# accessing
    //##################################################

    public static KmTimer getTimer(String key)
    {
        KmTimer e = _timers.get(key);
        if ( e == null )
        {
            e = new KmTimer(key);
            _timers.put(key, e);
        }
        return e;
    }

    public static void start(String key)
    {
        getTimer(key).start();
    }

    public static void stop(String key)
    {
        getTimer(key).stop();
    }

    public static void print(String key)
    {
        getTimer(key).print();
    }

}
