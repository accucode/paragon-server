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

package com.kodemore.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * I hold onto various objects that clients will resolve by key,
 * then synchronize upon.  Clients of this set should require a
 * small number of keys that will not eventually overrun memory.
 * If the key set will grow, see the KmManagedLockCache.
 */
public class KmLockCache
{
    //##################################################
    //# variables
    //##################################################

    private Map<Object,Object> _map;

    //##################################################
    //# constructor
    //##################################################

    public KmLockCache()
    {
        _map = new HashMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public Object getLock(Object key)
    {
        Object e = _map.get(key);

        if ( e == null )
            e = initLock(key);

        return e;
    }

    //##################################################
    //# private
    //##################################################

    public synchronized Object initLock(Object key)
    {
        Object e = _map.get(key);

        if ( e != null )
            return e;

        e = newLockObject();
        _map.put(key, e);

        return e;
    }

    public Object newLockObject()
    {
        return new Object();
    }

}
