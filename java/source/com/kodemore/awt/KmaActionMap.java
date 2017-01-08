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

package com.kodemore.awt;

import com.kodemore.collection.KmMap;

/**
 * I provide a convenient mechanism for maintaining
 * multiple sets of Actions where each set needs to be
 * invoked indepently of the other sets.  For example,
 * a list widget that uses Actions for its listener paridgm
 * could use one ActionGroup and then maintain separtate
 * sets in the group for the selection, double click, and
 * veto listeners.
 */
public class KmaActionMap
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,KmaActionList> _map;

    //##################################################
    //# constructors
    //##################################################

    public KmaActionMap()
    {
        _map = new KmMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaActionList get(String key)
    {
        KmaActionList e = _map.get(key);
        if ( e == null )
        {
            e = new KmaActionList();
            _map.put(key, e);
        }
        return e;
    }

}
