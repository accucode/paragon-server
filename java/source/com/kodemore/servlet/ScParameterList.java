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

package com.kodemore.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

public class ScParameterList
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,String> _map;

    //##################################################
    //# constructor
    //##################################################

    public ScParameterList()
    {
        _map = new KmMap<String,String>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String get(String key)
    {
        return get(key, null);
    }

    public String get(String key, String def)
    {
        if ( _map.containsKey(key) )
            return _map.get(key);
        return def;
    }

    public void set(String key, String value)
    {
        if ( value == null )
            remove(key);
        else
            _map.put(key, value);
    }

    public boolean has(String key)
    {
        return _map.containsKey(key);
    }

    public void remove(String key)
    {
        _map.remove(key);
    }

    public void removeAll()
    {
        _map.clear();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmMap<String,String> getMap()
    {
        return _map;
    }

    public KmList<String> getKeys()
    {
        return _map.getKeys();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isEmpty()
    {
        return _map.isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

}
