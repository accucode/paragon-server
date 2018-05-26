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

package com.kodemore.servlet.variable;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

public class ScLocalMap<K, V>
    extends ScAbstractLocal<KmMap<K,V>>
{
    //##################################################
    //# constructor
    //##################################################

    public ScLocalMap()
    {
        super(new KmMap<K,V>());
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmMap<K,V> getValue()
    {
        return _getValue().getShallowCopy();
    }

    @Override
    public void setValue(KmMap<K,V> v)
    {
        _setValue(v.getShallowCopy());
    }

    //##################################################
    //# accessing (mutate)
    //##################################################

    public void put(K key, V value)
    {
        KmMap<K,V> copy;
        copy = getValue();
        copy.put(key, value);

        _setValue(copy);
    }

    public void clear()
    {
        KmMap<K,V> copy;
        copy = getValue();
        copy.clear();

        _setValue(copy);
    }

    //##################################################
    //# accessing (read-only)
    //##################################################

    public V get(K key)
    {
        return _getValue().get(key);
    }

    public KmList<K> getKeys()
    {
        return _getValue().getKeys();
    }

    //##################################################
    //# support
    //##################################################

    public KmMap<K,V> _getValue()
    {
        return super.getValue();
    }

    public void _setValue(KmMap<K,V> v)
    {
        super.setValue(v);
    }

}
