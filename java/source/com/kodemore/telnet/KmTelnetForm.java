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

package com.kodemore.telnet;

import java.util.Iterator;

import com.kodemore.collection.KmList;

public abstract class KmTelnetForm
    implements KmTelnetConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmTelnetFormSession   _session;
    private KmList<KmTelnetLabel> _labels;
    private KmList<KmTelnetField> _fields;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetForm()
    {
        _labels = new KmList<>();
        _fields = new KmList<>();
    }

    //##################################################
    //# session
    //##################################################

    public KmTelnetFormSession getSession()
    {
        return _session;
    }

    public void setSession(KmTelnetFormSession e)
    {
        _session = e;
    }

    public void show(KmTelnetForm e)
    {
        _session.setForm(e);
        e.updateView();
        _session.printForm();
    }

    //##################################################
    //# labels
    //##################################################

    public KmList<KmTelnetLabel> getLabels()
    {
        return _labels;
    }

    public void setLabels(KmList<KmTelnetLabel> e)
    {
        _labels = e;
    }

    public void addLabel(KmTelnetLabel e)
    {
        _labels.add(e);
    }

    public KmTelnetLabel addLabel(int x, int y, String text)
    {
        KmTelnetLabel e;
        e = new KmTelnetLabel();
        e.setX(x);
        e.setY(y);
        e.setText(text);
        addLabel(e);
        return e;
    }

    //##################################################
    //# fields
    //##################################################

    public Iterator<KmTelnetField> getFields()
    {
        return _fields.iterator();
    }

    public void addField(KmTelnetField e)
    {
        e.setForm(this);
        _fields.add(e);

    }

    public KmTelnetField addField(int x, int y, int width)
    {
        KmTelnetField e;
        e = new KmTelnetField();
        e.setX(x);
        e.setY(y);
        e.setWidth(width);
        addField(e);
        return e;
    }

    public boolean hasFields()
    {
        return !_fields.isEmpty();
    }

    public KmTelnetField getFirstField()
    {
        return getField(0);
    }

    public KmTelnetField getField(int i)
    {
        return _fields.get(i);
    }

    public KmTelnetField getCurrentField()
    {
        return getCurrentField(getSession().getX(), getSession().getY());
    }

    public KmTelnetField getCurrentField(int x, int y)
    {
        Iterator<KmTelnetField> i = _fields.iterator();
        while ( i.hasNext() )
        {
            KmTelnetField e = i.next();
            if ( e.contains(x, y) )
                return e;
        }
        return null;
    }

    public KmTelnetField getNextField()
    {
        KmTelnetField f = getCurrentField();
        if ( f == null )
        {
            if ( hasFields() )
                return getFirstField();
            return null;
        }
        int i = _fields.indexOf(f) + 1;
        if ( i >= _fields.size() )
            i = 0;
        return getField(i);
    }

    public KmTelnetField getPreviousField()
    {
        KmTelnetField f = getCurrentField();
        if ( f == null )
        {
            if ( hasFields() )
                return getFirstField();
            return null;
        }
        int i = _fields.indexOf(f) - 1;
        if ( i < 0 )
            i = _fields.size() - 1;
        return getField(i);
    }

    //##################################################
    //# utility
    //##################################################

    public KmTelnetField addLabeledField(int x, int y, String label, int width)
    {
        addLabel(x, y, label);
        return addField(x + label.length(), y, width);
    }

    //##################################################
    //# print
    //##################################################

    public void print()
    {
        getSession().clear();

        for ( KmTelnetLabel e : _labels )
            e.printOn(getSession());

        for ( KmTelnetField e : _fields )
            e.print();

        if ( _fields.isEmpty() )
            getSession().home();
        else
            getFirstField().setFocus();
    }

    //##################################################
    //# handle
    //##################################################

    public void handleKey(char c, boolean alt)
    {
        if ( alt )
            return;
        KmTelnetField f = getCurrentField();
        if ( f == null )
            return;
        f.handleKey(c);
    }

    public void handleVirtualKey(int key, boolean alt)
    {
        if ( alt )
            return;
        if ( key == VK_TAB )
        {
            getNextField().setFocus();
            return;
        }
        if ( key == VK_SHIFT_TAB )
        {
            getPreviousField().setFocus();
            return;
        }
        KmTelnetField f = getCurrentField();
        if ( f != null )
            f.handleVirtualKey(key);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract void updateView();
}
