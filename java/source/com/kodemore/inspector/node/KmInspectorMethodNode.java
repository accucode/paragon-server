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

package com.kodemore.inspector.node;

import java.lang.reflect.Method;

/**
 * I inspect the value of a some method invoke on some subject object. You
 * cannot use a method that takes any input parameters. WARNING ! You should
 * only specify methods that do not have any side affects. This method will be
 * called multiple times each time the user selects this node in the inspector
 * list box.
 */
public class KmInspectorMethodNode
    extends KmInspectorSubjectNode
{
    //##################################################
    //# variables
    //##################################################

    public Method _method;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorMethodNode(Object e, Method m)
    {
        super(e);
        _method = m;
    }

    public KmInspectorMethodNode(Object e, String s)
    {
        super(e);
        try
        {
            _method = e.getClass().getMethod(s);
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public Method getMethod()
    {
        return _method;
    }

    public void setMethod(Method o)
    {
        _method = o;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public Object getValue()
    {
        try
        {
            Object e = getSubject();
            if ( e == null )
                return null;

            return _method.invoke(e);
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getName()
    {
        return _method.getName();
    }

    @Override
    public Class<?> getDeclaredClass()
    {
        return _method.getReturnType();
    }
}
