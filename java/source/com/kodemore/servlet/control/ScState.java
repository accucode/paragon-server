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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.action.ScAction;

public abstract class ScState
{
    //##################################################
    //# variables
    //##################################################

    private ScState              _parent;
    private KmMap<String,Object> _values;

    //##################################################
    //# constructor
    //##################################################

    public ScState()
    {
        _parent = null;
        _values = new KmMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScState getParent()
    {
        return _parent;
    }

    public void setParent(ScState e)
    {
        _parent = e;
    }

    //##################################################
    //# base
    //##################################################

    public void _set(String key, Object value)
    {
        _values.put(key, value);
    }

    public Object _get(String key)
    {
        if ( _values.containsKey(key) )
            return _values.get(key);

        if ( _parent != null )
            return _parent._get(key);

        return null;
    }

    public void _clear(String key)
    {
        _values.remove(key);
    }

    public boolean _has(String key)
    {
        if ( _values.containsKey(key) )
            return true;
        if ( _parent != null )
            return _parent._has(key);
        return false;
    }

    @SuppressWarnings("unchecked")
    public KmList<String> _getStringList(String key)
    {
        return (KmList<String>)_get(key);
    }

    public Integer _getInteger(String key)
    {
        return _getInteger(key, null);
    }

    public Integer _getInteger(String key, Integer def)
    {
        if ( !_has(key) )
            return def;
        return (Integer)_get(key);
    }

    public Boolean _getBoolean(String key)
    {
        return (Boolean)_get(key);
    }

    public Boolean _getBoolean(String key, Boolean def)
    {
        if ( _has(key) )
            return _getBoolean(key);
        return def;
    }

    public String _getString(String key)
    {
        return _getString(key, null);
    }

    public String _getString(String key, String def)
    {
        if ( !_has(key) )
            return def;
        return (String)_get(key);
    }

    public ScAction _getCommand(String key)
    {
        return (ScAction)_get(key);
    }

    public ScControl _getControl(String key)
    {
        return (ScControl)_get(key);
    }

}
