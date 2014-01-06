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

package com.kodemore.servlet;

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I provide a wrapper for working with url parameters.
 * 
 * A given key will typically only have a single value, but 
 * urls do allow for multiple values and this is occasionally 
 * useful.  For example, with multi-selection lists.
 * 
 * I support multiple values per key, but also provide conenience
 * methods for the far more common situation where each key is
 * expected to have only a single value.
 * 
 * Convenience methods are also provided to convert to and from
 * url query strings.
 */
public class ScParameterList
{
    //##################################################
    //# instance creation
    //##################################################

    public static ScParameterList createFromUrl(String url)
    {
        ScParameterList e;
        e = new ScParameterList();
        e.parseUrl(url);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private KmMap<String,KmList<String>> _map;

    //##################################################
    //# constructor
    //##################################################

    public ScParameterList()
    {
        _map = new KmMap<String,KmList<String>>();
    }

    //##################################################
    //# keys
    //##################################################

    public boolean hasKey(String key)
    {
        return _map.containsKey(key);
    }

    public void removeKey(String key)
    {
        _map.remove(key);
    }

    public void clear()
    {
        _map.clear();
    }

    //##################################################
    //# single values
    //##################################################

    public String getValue(String key)
    {
        return getValue(key, null);
    }

    public String getValue(String key, String def)
    {
        if ( !_map.containsKey(key) )
            return def;

        KmList<String> v = _map.get(key);
        if ( v.isEmpty() )
            return def;

        return v.getFirst();
    }

    public void setValue(String key, String value)
    {
        if ( value == null )
        {
            removeKey(key);
            return;
        }

        KmList<String> v = KmList.createWith(value);
        _map.put(key, v);
    }

    //##################################################
    //# multi values
    //##################################################

    public KmList<String> getValues(String key)
    {
        if ( !hasKey(key) )
            return new KmList<String>();

        KmList<String> v;
        v = new KmList<String>();
        v.addAll(_map.get(key));
        return v;
    }

    public void addValue(String key, String value)
    {
        KmList<String> v = _map.get(value);
        if ( v == null )
        {
            v = new KmList<String>();
            _map.put(key, v);
        }
        v.add(value);
    }

    public void addValues(String key, List<String> values)
    {
        for ( String value : values )
            addValue(key, value);
    }

    public void setValues(String key, List<String> values)
    {
        removeKey(key);
        addValues(key, values);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMap<String,KmList<String>> getFullMap()
    {
        return _map;
    }

    public KmMap<String,String> getMap()
    {
        KmMap<String,String> m = new KmMap<String,String>();

        KmList<String> keys = getKeys();
        for ( String key : keys )
            m.put(key, getValue(key));

        return m;
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

    //##################################################
    //# url
    //##################################################

    public void parseUrl(String url)
    {
        String[] urlParts = url.split("\\?");
        if ( urlParts.length <= 1 )
            return;

        String query = urlParts[1];
        String[] params = query.split("&");

        for ( String param : params )
        {
            String[] pair = param.split("=");
            String key = Kmu.decodeUtf8(pair[0]);
            String value = pair.length > 1
                ? Kmu.decodeUtf8(pair[1])
                : "";

            addValue(key, value);
        }
    }

    public String formatUrl()
    {
        if ( isEmpty() )
            return "";

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print("?");

        KmList<String> keys = getKeys();
        for ( String key : keys )
        {
            KmList<String> values = getValues(key);
            for ( String value : values )
            {
                out.print(Kmu.encodeUtf8(key));
                out.print("=");
                out.print(Kmu.encodeUtf8(value));
                out.print("&");
            }
        }

        out.removeSuffix("&");
        return out.toString();
    }
}
