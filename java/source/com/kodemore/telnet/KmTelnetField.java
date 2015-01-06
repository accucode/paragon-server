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

package com.kodemore.telnet;

import java.util.BitSet;

import com.kodemore.utility.Kmu;

public class KmTelnetField
    implements KmTelnetConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmTelnetForm  _form;

    private int           _x;
    private int           _y;
    private int           _width;
    private BitSet        _allowableCharacters;
    private boolean       _forceLowerCase;
    private boolean       _forceUpperCase;
    private char          _mask;
    private StringBuilder _value;
    private boolean       _allowsCursorPastEnd;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetField()
    {
        _form = null;
        _x = 0;
        _y = 0;
        _allowableCharacters = new BitSet();
        _forceLowerCase = false;
        _forceUpperCase = false;
        _mask = 0;
        setWidth(1);
        _allowsCursorPastEnd = false;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTelnetForm getForm()
    {
        return _form;
    }

    public void setForm(KmTelnetForm e)
    {
        _form = e;
    }

    public int getX()
    {
        return _x;
    }

    public void setX(int e)
    {
        _x = e;
    }

    public int getY()
    {
        return _y;
    }

    public void setY(int e)
    {
        _y = e;
    }

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int i)
    {
        _width = i;
        String s = Kmu.repeat(SPACE, i);
        _value = new StringBuilder(s);
    }

    public boolean isForceLowerCase()
    {
        return _forceLowerCase;
    }

    public void forceLowerCase()
    {
        setForceLowerCase(true);
    }

    public void setForceLowerCase(boolean e)
    {
        _forceLowerCase = e;
    }

    public boolean isForceUpperCase()
    {
        return _forceUpperCase;
    }

    public void forceUpperCase()
    {
        setForceUpperCase(true);
    }

    public void setForceUpperCase(boolean e)
    {
        _forceUpperCase = e;
    }

    public char getMask()
    {
        return _mask;
    }

    public void mask()
    {
        setMask('*');
    }

    public void setMask(char e)
    {
        _mask = e;
    }

    public boolean hasMask()
    {
        return _mask != 0;
    }

    public String getValue()
    {
        return Kmu.trimTrailing(_value.toString());
    }

    public void setValue(String s)
    {
        s = Kmu.rightPad(s, _width);
        _value = new StringBuilder(s);
    }

    public boolean allowsCursorPastEnd()
    {
        return _allowsCursorPastEnd;
    }

    public void allowCursorPastEnd()
    {
        _allowsCursorPastEnd = true;
    }

    public void allowsCursorPastEnd(boolean e)
    {
        _allowsCursorPastEnd = e;
    }

    //##################################################
    //# session
    //##################################################

    public KmTelnetSession getSession()
    {
        return getForm().getSession();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean contains(int x, int y)
    {
        if ( x < _x )
            return false;
        if ( x >= _x + _width )
            return false;
        if ( y != _y )
            return false;
        return true;
    }

    //##################################################
    //# characters
    //##################################################

    public void allowLetters()
    {
        allowLowerCase();
        allowUpperCase();
    }

    public void allowLowerCase()
    {
        allowRange('a', 'z');
    }

    public void allowUpperCase()
    {
        allowRange('A', 'Z');
    }

    public void allowDigits()
    {
        allowRange('0', '9');
    }

    public void allowPrintableCharacters()
    {
        allowRange(32, 126);
    }

    public void allowRange(int min, int max)
    {
        for ( int i = min; i <= max; i++ )
            _allowableCharacters.set(i);
    }

    public void allowSpace()
    {
        allow(' ');
    }

    public void allow(int c)
    {
        _allowableCharacters.set(c);
    }

    public void allow(String s)
    {
        int n = s.length();
        for ( int i = 0; i < n; i++ )
            allow(s.charAt(i));
    }

    public void clearAllowableCharacters()
    {
        _allowableCharacters = new BitSet();
    }

    public boolean allows(int c)
    {
        return _allowableCharacters.get(c);
    }

    //##################################################
    //# handle
    //##################################################

    public boolean handleKey(char c)
    {
        if ( !allows(c) )
            return false;

        if ( _forceLowerCase )
            c = Character.toLowerCase(c);

        if ( _forceUpperCase )
            c = Character.toUpperCase(c);

        _value.setCharAt(getSession().getX() - _x, c);
        if ( hasMask() )
            c = _mask;

        getSession().print(c);

        if ( getSession().getX() > getLastX() )
            getSession().moveTo(getLastX(), getY());

        return true;
    }

    public void handleVirtualKey(int key)
    {
        switch ( key )
        {
            case VK_LEFT:
                handleLeft();
                break;

            case VK_RIGHT:
                handleRight();
                break;

            case VK_HOME:
                handleHome();
                break;

            case VK_END:
                handleEnd();
                break;

            case VK_BACKSPACE:
                handleBackspace();
                break;

            case VK_DELETE:
                handleDelete();
                break;

            case VK_F10:
                handleF10();
                break;

            default:
                break;
        }
    }

    public void handleLeft()
    {
        int i = getCursorX();
        if ( i > 0 )
            setCursorX(i - 1);
    }

    public void handleRight()
    {
        int limit = getWidth() - 1;
        if ( !allowsCursorPastEnd() )
            limit = Math.min(limit, getValue().length());
        int i = getCursorX() + 1;
        if ( i <= limit )
            setCursorX(i);
    }

    public void handleHome()
    {
        setCursorX(0);
    }

    public void handleEnd()
    {
        int i = getWidth() - 1;
        if ( !allowsCursorPastEnd() )
            i = Math.min(i, getValue().length());
        setCursorX(i);
    }

    public void handleBackspace()
    {
        if ( getCursorX() == 0 )
            return;
        getSession().left();
        handleDelete();
    }

    public void handleDelete()
    {
        int x = getCursorX();
        _value = _value.deleteCharAt(x);
        _value.append(SPACE);
        refresh();
    }

    public void handleF10()
    {
        System.out.println(getValue());
    }

    //##################################################
    //# utility
    //##################################################

    public void setFocus()
    {
        getSession().moveTo(_x, _y);
    }

    public int getLastX()
    {
        return getX() + getWidth() - 1;
    }

    public void refresh()
    {
        int x = getSession().getX();
        int y = getSession().getY();
        print();
        getSession().moveTo(x, y);
    }

    public void print()
    {
        getSession().normal();
        getSession().underscore();
        getSession().print(_x, _y, mask(_value.toString()));
    }

    public String mask(String s)
    {
        s = Kmu.trimTrailing(s);
        if ( hasMask() )
            s = Kmu.repeat(getMask(), s.length());
        s = Kmu.rightPad(s, getWidth(), ' ');
        return s;
    }

    public int getCursorX()
    {
        return getSession().getX() - getX();
    }

    public void setCursorX(int i)
    {
        int x = getX() + i;
        int y = getSession().getY();
        getSession().moveTo(x, y);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Field");
        sb.append("(");
        sb.append(_x);
        sb.append(",");
        sb.append(_y);
        sb.append(",");
        sb.append(_width);
        sb.append(",");
        sb.append(_value);
        sb.append(")");
        return sb.toString();
    }

}
