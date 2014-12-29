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

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

/**
 * I am used to expand the values in a map by replacing their content
 * with the values from other keys.  See the main method for an example
 * of usage.
 */
public class KmMapExpander
{
    //##################################################
    //# public
    //##################################################

    public static KmMap<String,String> expand(KmMap<String,String> m)
    {
        return new KmMapExpander()._expand(m);
    }

    //##################################################
    //# variables
    //##################################################

    private KmMap<String,String> _source;
    private KmMap<String,String> _result;

    //##################################################
    //# constructor
    //##################################################

    private KmMapExpander()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMap<String,String> _expand(KmMap<String,String> m)
    {
        _source = m;
        _result = new KmMap<>();
        for ( String key : _source.getKeys() )
            _result.put(key, getResult(key));
        return _result;
    }

    public String getResult(String key)
    {
        KmList<String> path = new KmList<>();
        path.add(key);
        String value = _source.get(key);
        boolean changed = true;
        while ( changed )
        {
            changed = false;
            for ( String k : _source.getKeys() )
            {
                String v = _source.get(k);
                if ( value.contains(k) )
                {
                    if ( path.contains(k) )
                        error("A value cannot contain itself. Key=%s. Path=%s.", key, path);
                    path.add(k);
                    value = Kmu.replaceAll(value, k, v);
                    changed = true;
                }
            }
        }
        return value;
    }

    public void error(String s, Object... args)
    {
        Kmu.fatal(s, args);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmMap<String,String> m = new KmMap<>();
        m.put("#(first)", "John");
        m.put("#(last)", "Smith");
        m.put("#(name)", "#(first) #(last)");
        m.put("#(result)", "My name is: #(name).");
        m = KmMapExpander.expand(m);
        System.out.println(m.get("#(result)"));
    }
}
