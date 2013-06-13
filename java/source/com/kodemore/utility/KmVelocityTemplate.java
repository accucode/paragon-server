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

package com.kodemore.utility;

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.log.NullLogChute;

/**
 * I am a simple wrapper for the Apache Velocity template.
 */
public class KmVelocityTemplate
{
    //##################################################
    //# static
    //##################################################

    private static VelocityEngine _engine = newEngine();

    private static VelocityEngine newEngine()
    {
        try
        {
            VelocityEngine e;
            e = new VelocityEngine();
            e.setProperty("runtime.log.logsystem.class", NullLogChute.class.getName());
            e.setProperty("directive.foreach.counter.name", "foreachIndex");
            e.setProperty("directive.foreach.counter.initial.value", 0);
            e.init();
            return e;
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# variables
    //##################################################

    private String          _template;
    private VelocityContext _context;

    //##################################################
    //# constructor
    //##################################################

    public KmVelocityTemplate()
    {
        _context = new VelocityContext();
    }

    //##################################################
    //# accessing
    //##################################################

    public void setTemplate(String s)
    {
        _template = s;
    }

    public void setContext(String key, Object value)
    {
        _context.put(key, value);
    }

    //##################################################
    //# format
    //##################################################

    public String format(String template)
    {
        setTemplate(template);
        return format();
    }

    public String format()
    {
        StringWriter out = null;
        try
        {
            out = new StringWriter();
            boolean ok = _engine.evaluate(_context, out, "dynamic", _template);
            if ( !ok )
                throw new RuntimeException("Template failed: " + _template);
            return out.toString();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            Kmu.closeSafely(out);
        }
    }
}
