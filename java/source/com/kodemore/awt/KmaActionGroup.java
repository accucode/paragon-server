/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kodemore.collection.KmList;
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
public class KmaActionGroup
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,KmList<ActionListener>> _actions;

    //##################################################
    //# constructors
    //##################################################

    public KmaActionGroup()
    {
        initialize();
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        _actions = new KmMap<String,KmList<ActionListener>>();
    }

    //##################################################
    //# adding / removing
    //##################################################

    public void add(String key, ActionListener a)
    {
        getActionsFor(key).add(a);
    }

    public void remove(String key, ActionListener a)
    {
        getActionsFor(key).remove(a);
    }

    public boolean has(String key, ActionListener a)
    {
        return getActionsFor(key).contains(a);
    }

    //##################################################
    //# actions
    //##################################################

    public void fireAll()
    {
        for ( KmList<ActionListener> v : _actions.getValues() )
            for ( ActionListener a : v )
                a.actionPerformed(null);
    }

    public void fire(String key)
    {
        fire(key, this);
    }

    public void fire(String key, Object source)
    {
        ActionEvent ev = new ActionEvent(source, 0, key);
        for ( ActionListener a : getActionsFor(key) )
            a.actionPerformed(ev);
    }

    //##################################################
    //# private
    //##################################################

    public KmList<ActionListener> getActionsFor(String key)
    {
        KmList<ActionListener> v = _actions.get(key);
        if ( v == null )
        {
            v = new KmList<ActionListener>();
            _actions.put(key, v);
        }
        return v;
    }

}
