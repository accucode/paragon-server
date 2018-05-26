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

package com.kodemore.utility;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.kodemore.collection.KmList;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.ParseException;
import bsh.TargetError;

/**
 * I am a wrapper for BeanShell.
 */
public class KmBeanShell
{
    //##################################################
    //# variables
    //##################################################

    private Interpreter           _interpreter;
    private String                _source;
    private ByteArrayOutputStream _out;
    private Object                _result;
    private Exception             _exception;

    //##################################################
    //# constructor
    //##################################################

    public KmBeanShell()
    {
        reset();
    }

    //##################################################
    //# setup
    //##################################################

    public void reset()
    {
        _interpreter = null;
        _source = null;
        _out = null;
        _result = null;
        _exception = null;
    }

    public Interpreter getInterpreter()
    {
        if ( _interpreter == null )
        {
            _interpreter = new Interpreter();
            _out = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(_out);
            _interpreter.setOut(ps);
        }
        return _interpreter;

    }

    public void setScriptFolder(String folder)
    {
        if ( Kmu.isEmpty(folder) )
            return;

        String s = Kmu.format("cd(\"%s\")", folder);
        eval(s);
    }

    public void runScriptFile(String script)
    {
        if ( Kmu.isEmpty(script) )
            return;

        String s = Kmu.format("source(\"%s\")", script);
        eval(s);
    }

    //##################################################
    //# accessing
    //##################################################

    public void eval(String s)
    {
        try
        {
            _result = null;
            _exception = null;
            _source = s;

            if ( _source != null )
                _result = getInterpreter().eval(_source);
        }
        catch ( Exception ex )
        {
            _result = null;
            _exception = ex;
        }
    }

    public void setValue(String key, Object value)
    {
        try
        {
            getInterpreter().set(key, value);
        }
        catch ( EvalError ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public String getSource()
    {
        return _source;
    }

    public Object getResult()
    {
        return _result;
    }

    public boolean hasResult()
    {
        return _result != null;
    }

    public void clearResult()
    {
        _result = null;
    }

    public Exception getException()
    {
        return _exception;
    }

    public boolean isOk()
    {
        return _exception == null;
    }

    public boolean hasException()
    {
        return !isOk();
    }

    public void clearException()
    {
        _exception = null;
    }

    public String getOutput()
    {
        if ( _out == null )
            return null;

        return new String(_out.toByteArray());
    }

    public boolean hasOutput()
    {
        return Kmu.hasValue(getOutput());
    }

    //##################################################
    //# format
    //##################################################

    public String formatException()
    {
        if ( _exception == null )
            return "";

        if ( _exception instanceof ParseException )
        {
            ParseException x = (ParseException)_exception;
            return x.getMessage();
        }

        if ( _exception instanceof TargetError )
        {
            TargetError x = (TargetError)_exception;
            return x.getTarget().toString() + "..." + x.getMessage();
        }

        return _exception.toString();
    }

    public KmList<String> getSourceLines()
    {
        return Kmu.parseLines(_source);
    }

    public int getErrorLine()
    {
        if ( isOk() )
            return 0;

        if ( _exception instanceof ParseException )
        {
            String s = _exception.toString();
            int i = s.indexOf("line");
            if ( i < 0 )
                return 0;
            s = s.substring(i + 4).trim();
            i = s.indexOf(",");
            if ( i < 0 )
                return 0;
            s = s.substring(0, i).trim();
            return Kmu.parseInteger(s, 0);
        }

        if ( _exception instanceof TargetError )
        {
            String s = _exception.toString();
            int i = s.indexOf("Line:");
            if ( i < 0 )
                return 0;
            s = s.substring(i + 5).trim();
            i = s.indexOf(":");
            if ( i < 0 )
                return 0;
            s = s.substring(0, i).trim();
            return Kmu.parseInteger(s, 0);
        }
        return 0;
    }

    public String getErrorMessage()
    {
        if ( _exception instanceof EvalError )
            return ((EvalError)_exception).getMessage();
        return "";
    }

    public String getStackTrace()
    {
        if ( isOk() )
            return "";

        if ( _exception instanceof ParseException )
            return "";

        if ( _exception instanceof TargetError )
        {
            TargetError x = (TargetError)_exception;
            return Kmu.formatStackTrace(x.getTarget());
        }

        return Kmu.formatStackTrace(_exception);
    }

}
