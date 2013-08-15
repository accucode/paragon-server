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

package com.kodemore.lock;

import java.util.HashMap;
import java.util.Map;

import com.kodemore.log.KmLog;

/**
 * I hold onto various objects that clients will resolve by key,
 * then synchronize upon.  These clients require a large number
 * of keys that are infrequently used, such that the lock
 * should be disposed of no one else is using it.
 */
public class KmManagedLockCache
{
    //##################################################
    //# variables
    //##################################################

    private Map<Object,KmManagedLock> _map;

    //##################################################
    //# constructor
    //##################################################

    public KmManagedLockCache()
    {
        _map = new HashMap<Object,KmManagedLock>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmManagedLock getLock(Object key)
    {
        KmManagedLock e = _map.get(key);

        if ( e == null )
        {
            e = new KmManagedLock();
            _map.put(key, e);
        }

        e.increment();
        return e;
    }

    public synchronized void release(Object key)
    {
        try
        {
            KmManagedLock e;
            e = _map.get(key);
            e.decrement();

            if ( e.getCount() == 0 )
                _map.remove(key);
        }
        catch ( Exception x )
        {
            KmLog.error("Trouble releasing a lock resource.");
        }
    }
}
