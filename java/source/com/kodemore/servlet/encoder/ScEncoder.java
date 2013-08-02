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

package com.kodemore.servlet.encoder;

import com.kodemore.servlet.encoder.coder.ScCoderIF;
import com.kodemore.servlet.encoder.coder.ScCoderRegistry;
import com.kodemore.utility.Kmu;

public class ScEncoder
    implements ScEncoderConstantsIF
{
    //##################################################
    //# static
    //##################################################

    public static String staticEncode(Object e)
    {
        ScEncoder b;
        b = new ScEncoder();
        b.encode(e);
        return b.toString();
    }

    //##################################################
    //# variables
    //##################################################

    private StringBuilder _buffer;

    //##################################################
    //# constructor
    //##################################################

    public ScEncoder()
    {
        _buffer = new StringBuilder();
    }

    //##################################################
    //# public
    //##################################################

    public void encodeAll(Object... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            encode(arr[i]);
    }

    public void encode(Object e)
    {
        ScCoderIF c = getRegistry().getCoderFor(e);
        if ( c == null )
            Kmu.fatal("Cannot encode (%s): %s", e.getClass().getName(), e.toString());

        if ( _buffer.length() > 0 )
            _buffer.append(COMMA);

        _buffer.append(c.getKey());
        _buffer.append(COMMA);
        c.encode(this, e);
    }

    //##################################################
    //# support
    //##################################################

    public void _print(String s)
    {
        int n = s.length();
        for ( int i = 0; i < n; i++ )
            print(s.charAt(i));
    }

    public void _printInteger(int e)
    {
        _buffer.append(e);
    }

    public void _printDouble(double e)
    {
        _buffer.append(e);
    }

    public void _printLong(long e)
    {
        _buffer.append(e);
    }

    private void print(char c)
    {
        if ( requiresEscape(c) )
            printEscaped(c);
        else
            _buffer.append(c);
    }

    private void printEscaped(char c)
    {
        _buffer.append(SLASH);
        _buffer.append(Kmu.formatHexString((byte)c));
    }

    private boolean requiresEscape(char c)
    {
        if ( c < 32 )
            return true;

        if ( c == COMMA )
            return true;

        if ( c == QUOTE )
            return true;

        if ( c == TICK )
            return true;

        if ( c == SLASH )
            return true;

        if ( c == BACKSLASH )
            return true;

        if ( c == POUND )
            return true;

        return false;
    }

    private ScCoderRegistry getRegistry()
    {
        return ScCoderRegistry.instance;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _buffer.toString();
    }

}
