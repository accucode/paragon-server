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

package com.kodemore.block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * I use reflection to execute a method.  I support the use of
 * arguments and return values.
 */
public class KmBlock
    implements KmBlockIF
{
    //##################################################
    //# static
    //##################################################

    public static Object invokeStatic(Object rec, String msg)
    {
        return new KmBlock(rec, msg).invoke();
    }

    //##################################################
    //# variables
    //##################################################

    private Object     _receiver;
    private String     _message;
    private Object[]   _arguments;
    private Class<?>[] _types;
    private Method     _method;

    //##################################################
    //# constructors
    //##################################################

    public KmBlock()
    {
        _receiver = null;
        _message = null;
        _arguments = new Object[0];
        _types = new Class[0];
        _reset();
    }

    public KmBlock(Object r, String m)
    {
        this();
        _receiver = r;
        _message = m;
    }

    public KmBlock(Object r, String m, Class<?> a0)
    {
        this(r, m);
        addArgument(a0);
    }

    public KmBlock(Object r, String m, Class<?> a0, Class<?> a1)
    {
        this(r, m);
        addArgument(a0);
        addArgument(a1);
    }

    public KmBlock(Object r, String m, Class<?> a0, Class<?> a1, Class<?> a2)
    {
        this(r, m);
        addArgument(a0);
        addArgument(a1);
        addArgument(a2);
    }

    //##################################################
    //# accessing
    //##################################################

    public Object getReceiver()
    {
        return _receiver;
    }

    @Override
    public void setReceiver(Object o)
    {
        _receiver = o;
        _reset();
    }

    public String getMessage()
    {
        return _message;
    }

    public void setMessage(String o)
    {
        _message = o;
        _reset();
    }

    //##################################################
    //# arguments
    //##################################################

    public void addArgument(Object o)
    {
        addArgument(o, o.getClass());
    }

    public void addArgument(Class<?> c)
    {
        addArgument(null, c);
    }

    public void addArgument(Object o, Class<?> c)
    {
        Object newArguments[];
        Class<?> newTypes[];
        int n = _arguments.length;
        newArguments = new Object[n + 1];
        newTypes = new Class[n + 1];
        for ( int i = 0; i < n; i++ )
        {
            newArguments[i] = _arguments[i];
            newTypes[i] = _types[i];
        }
        _arguments = newArguments;
        _types = newTypes;
        _arguments[n] = o;
        _types[n] = c;
        _reset();
    }

    public void setArgument(int i, Object value)
    {
        _arguments[i] = value;
    }

    public void addArgument(double d)
    {
        addArgument(d, double.class);
    }

    public void addArgument(int i)
    {
        addArgument(i, int.class);
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public Object invoke()
    {
        try
        {
            if ( _method == null )
            {
                Class<?> c = _receiver.getClass();
                _method = c.getMethod(_message, _types);
            }
            return _method.invoke(_receiver, _arguments);
        }
        catch ( Throwable ex )
        {
            System.out.println("--------------------");
            if ( ex instanceof InvocationTargetException )
                ex = ((InvocationTargetException)ex).getTargetException();
            ex.printStackTrace();
            System.out.println("Receiver: " + _receiver);
            System.out.println("Message: " + _message);
            System.out.println("--------------------");
            return null;
        }
    }

    public Object invoke(Object arg0)
    {
        setArgument(0, arg0);
        return invoke();
    }

    public Object invoke(Object arg0, Object arg1)
    {
        setArgument(0, arg0);
        setArgument(1, arg1);
        return invoke();
    }

    public Object invoke(Object arg0, Object arg1, Object arg2)
    {
        setArgument(0, arg0);
        setArgument(1, arg1);
        setArgument(2, arg2);
        return invoke();
    }

    //##################################################
    //# validate
    //##################################################

    public boolean validate(Class<?> returnType)
    {
        if ( _receiver == null )
            return _error("Receiver is null");
        if ( _message == null )
            return _error("Message is null");
        Class<?> c = _receiver.getClass();
        Method m;
        try
        {
            m = c.getMethod(_message, _types);
        }
        catch ( Exception ex )
        {
            return _error("Method not found");
        }
        if ( m.getReturnType() != returnType )
            return _error("Incorrect return type");
        return true;
    }

    //##################################################
    //# private
    //##################################################

    public void _reset()
    {
        _method = null;
    }

    public boolean _error(String s)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Block > validate fail");
        sb.append("\n" + s);
        sb.append("\n    receiver: " + _receiver);
        sb.append("\n    message:  " + _message);
        sb.append("\n    arguments: " + _types.length);
        int n = _types.length;
        for ( int i = 0; i < n; i++ )
            sb.append("\n        " + _types[i]);
        sb.append("\n");
        throw new RuntimeException(sb.toString());
    }

}
