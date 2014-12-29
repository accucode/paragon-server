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

import java.util.Map;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

public class KmProperties
{
    //##################################################
    //# variables
    //##################################################

    public KmMap<String,String> _map;

    //##################################################
    //# constructor
    //##################################################

    public KmProperties()
    {
        _map = new KmMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMap<String,String> getMap()
    {
        return _map;
    }

    public void setMap(KmMap<String,String> e)
    {
        _map = e;
    }

    public boolean hasKey(String key)
    {
        return _map.containsKey(key);
    }

    public KmList<String> getKeys()
    {
        return new KmList<>(_map.keySet());
    }

    public void clear()
    {
        _map.clear();
    }

    public void put(String key, String value)
    {
        _map.put(key, value);
    }

    public void putAll(Map<String,String> m)
    {
        _map.putAll(m);
    }

    public String get(String key)
    {
        return _map.get(key);
    }

    public KmList<String> getKeysStartingWith(String prefix)
    {
        KmList<String> v = new KmList<>();
        for ( String key : _map.getKeys() )
            if ( key.startsWith(prefix) )
                v.add(key);
        return v;
    }

    //##################################################
    //# accessing strings
    //##################################################

    public String getString(String key)
    {
        return getString(key, "");
    }

    public String getString(String key, String def)
    {
        if ( hasKey(key) )
            return _map.get(key);
        return def;
    }

    public void setString(String key, String value)
    {
        _map.put(key, value);
    }

    //##################################################
    //# accessing integers
    //##################################################

    public int getInteger(String key)
    {
        return getInteger(key, 0);
    }

    public int getInteger(String key, int def)
    {
        if ( hasKey(key) )
            return Kmu.parse_int(getString(key), def);
        return def;
    }

    public void setInteger(String key, int value)
    {
        setString(key, value + "");
    }

    //##################################################
    //# accessing doubles
    //##################################################

    public double getDouble(String key)
    {
        return getDouble(key, 0);
    }

    public double getDouble(String key, double def)
    {
        if ( hasKey(key) )
            return Kmu.parse_double(getString(key), def);
        return def;
    }

    public void setDouble(String key, double value)
    {
        setString(key, value + "");
    }

    //##################################################
    //# accessing booleans
    //##################################################

    public boolean getBoolean(String key)
    {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean def)
    {
        if ( hasKey(key) )
            return Kmu.parse_boolean(getString(key), def);
        return def;
    }

    public void setBoolean(String key, boolean value)
    {
        setString(key, value + "");
    }
}
