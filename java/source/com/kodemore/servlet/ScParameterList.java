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

package com.kodemore.servlet;

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmValueHolderIF;
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
    //# main
    //##################################################

    /**
     * A simple example of usage.
     */
    public static void main(String[] args)
    {
        ScParameterList e;
        e = new ScParameterList();
        e.setString("hello", "world");
        e.setInteger("value", 1);
        System.out.println(e);
    }

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

    private KmOrderedMap<String,KmList<String>> _map;

    //##################################################
    //# constructor
    //##################################################

    public ScParameterList()
    {
        _map = new KmOrderedMap<>();
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
    //# string
    //##################################################

    public String getString(String key)
    {
        return getString(key, null);
    }

    public String getString(String key, String def)
    {
        if ( !_map.containsKey(key) )
            return def;

        KmList<String> v = _map.get(key);
        if ( v.isEmpty() )
            return def;

        return v.getFirst();
    }

    public void setString(String key, KmValueHolderIF<String> value)
    {
        if ( value == null )
            setString(key, (String)null);
        else
            setString(key, value.getValue());
    }

    public void setString(String key, String value)
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
    //# boolean
    //##################################################

    public Boolean getBoolean(String key)
    {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(String key, Boolean def)
    {
        String value = getString(key);
        return Kmu.parseBoolean(value, def);
    }

    public void setBoolean(String key, Boolean e)
    {
        String value = Kmu.formatBoolean(e, "Y", "N", null);
        setString(key, value);
    }

    public void setBoolean(String key, KmValueHolderIF<Boolean> holder)
    {
        setBoolean(key, holder.getValue());
    }

    //##################################################
    //# integer
    //##################################################

    public Integer getInteger(String key)
    {
        return getInteger(key, null);
    }

    public Integer getInteger(String key, Integer def)
    {
        String value = getString(key);
        return Kmu.parseInteger(value, def);
    }

    public void setInteger(String key, Integer e)
    {
        String value = e == null
            ? null
            : e.toString();

        setString(key, value);
    }

    public void setInteger(String key, KmValueHolderIF<Integer> holder)
    {
        setInteger(key, holder.getValue());
    }

    //##################################################
    //# multi values
    //##################################################

    public KmList<String> getValues(String key)
    {
        if ( !hasKey(key) )
            return new KmList<>();

        KmList<String> v;
        v = new KmList<>();
        v.addAll(_map.get(key));
        return v;
    }

    public void addValue(String key, String value)
    {
        KmList<String> v = _map.get(key);
        if ( v == null )
        {
            v = new KmList<>();
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

    /**
     * Format a url query string.
     * The keys and values are encoded.
     * The result is in the form: ?key1=value1&key2=value2...
     */
    public String formatQueryString()
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

    //##################################################
    //# convenience
    //##################################################

    public void print()
    {
        KmList<String> keys = getKeys();
        for ( String key : keys )
            System.out.printf("    %s => %s%n", key, getString(key));
    }

    //##################################################
    //# display
    //##################################################

    /**
     * Return the formatted query string, compatible with URIs.
     */
    @Override
    public String toString()
    {
        return formatQueryString();
    }
}
