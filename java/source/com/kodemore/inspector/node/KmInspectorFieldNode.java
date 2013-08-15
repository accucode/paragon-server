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

package com.kodemore.inspector.node;

import java.lang.reflect.Field;

/**
 * I am used to inspect a field (variable) of some instance. Both values of the
 */
public class KmInspectorFieldNode
    extends KmInspectorSubjectNode
{
    //##################################################
    //# variables
    //##################################################

    private Field _field;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorFieldNode(Object e, Field f)
    {
        super(e);
        _field = f;
    }

    public KmInspectorFieldNode(Object e, String s)
    {
        super(e);
        try
        {
            _field = e.getClass().getField(s);
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public Field getField()
    {
        return _field;
    }

    public void setField(Field o)
    {
        _field = o;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public Object getValue()
    {
        try
        {
            /*
             * if ( subject == null ) { System.out.println("subject == null");
             * return null; } System.out.println("subject: " + subject);
             * System.out.println("c:" + subject.getClass().getName());
             * System.out.println("field: " + field); System.out.println("c: " +
             * field.getClass().getName()); return field.get(subject);
             */
            Object e = getSubject();
            if ( e == null )
                return null;

            return _field.get(e);
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
        return _field.getName();
    }

    @Override
    public Class<?> getDeclaredClass()
    {
        return _field.getType();
    }

}
