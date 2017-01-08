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

import java.awt.event.ActionListener;
import java.util.Iterator;

import com.kodemore.collection.KmList;

/**
 * I provide a convenient mechanism for maintaining
 * a list of actions.
 */
public class KmaActionList
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ActionListener> _actions;
    private boolean                _enabled;

    //##################################################
    //# constructors
    //##################################################

    public KmaActionList()
    {
        _actions = new KmList<>();
        _enabled = true;
    }

    //##################################################
    //# adding / removing
    //##################################################

    public void add(ActionListener e)
    {
        _actions.add(e);
    }

    public ActionListener add(Object receiver, String message)
    {
        KmaBlockAction e = new KmaBlockAction(receiver, message);
        add(e);
        return e;
    }

    public void remove(ActionListener e)
    {
        _actions.remove(e);
    }

    public void enable()
    {
        enable(true);
    }

    public void disable()
    {
        enable(false);
    }

    public void enable(boolean b)
    {
        _enabled = b;
    }

    public boolean enabled()
    {
        return _enabled;
    }

    public void fire()
    {
        if ( !_enabled )
            return;

        Iterator<ActionListener> i = _actions.iterator();
        while ( i.hasNext() )
            i.next().actionPerformed(null);
    }

}
