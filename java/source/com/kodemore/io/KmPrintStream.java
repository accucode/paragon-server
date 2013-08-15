/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * I am the a version of PrintStream. I provide the
 * the ability to echo streams to the screen while writing
 * the data to a file.
 */
public class KmPrintStream
    extends PrintStream
{
    //##################################################
    //# variables
    //##################################################

    private boolean     _echo;
    private PrintStream _echoStream;

    //##################################################
    //# constructor
    //##################################################

    public KmPrintStream(OutputStream os)
    {
        this(os, false);
    }

    public KmPrintStream(OutputStream os, boolean autoFlush)
    {
        this(os, autoFlush, false);
    }

    public KmPrintStream(OutputStream os, boolean autoFlush, boolean echoBoolean)
    {
        super(os, autoFlush);
        setEcho(echoBoolean);
        FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
        _echoStream = new PrintStream(new BufferedOutputStream(fdOut, 128), true);
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getEcho()
    {
        return _echo;
    }

    public void setEcho(boolean b)
    {
        _echo = b;
    }

    //##################################################
    //# echo
    //##################################################

    public void echoWrite(String s)
    {
        if ( _echo )
            _echoStream.print(s);
    }

    public void echoWrite(char s[])
    {
        if ( _echo )
            _echoStream.print(s);
    }

    public void echoNewLine()
    {
        if ( _echo )
            _echoStream.println();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void print(boolean b)
    {
        super.print(b);
        echoWrite(b
            ? "true"
            : "false");
    }

    @Override
    public void print(char c)
    {
        super.print(c);
        echoWrite(String.valueOf(c));
    }

    @Override
    public void print(int i)
    {
        super.print(i);
        echoWrite(String.valueOf(i));
    }

    @Override
    public void print(long l)
    {
        super.print(l);
        echoWrite(String.valueOf(l));
    }

    @Override
    public void print(float f)
    {
        super.print(f);
        echoWrite(String.valueOf(f));
    }

    @Override
    public void print(double d)
    {
        super.print(d);
        echoWrite(String.valueOf(d));
    }

    @Override
    public void print(char s[])
    {
        super.print(s);
        echoWrite(s);
    }

    @Override
    public void print(String s)
    {
        super.print(s);
        if ( s == null )
            s = "null";
        echoWrite(s);
    }

    @Override
    public void print(Object obj)
    {
        super.print(obj);
        echoWrite(String.valueOf(obj));
    }

    @Override
    public void println()
    {
        super.println();
        echoNewLine();
    }

    @Override
    public void println(boolean x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(char x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(int x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(long x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(float x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(double x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(char x[])
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(String x)
    {
        super.println(x);
        echoNewLine();
    }

    @Override
    public void println(Object x)
    {
        super.println(x);
        echoNewLine();
    }
}
