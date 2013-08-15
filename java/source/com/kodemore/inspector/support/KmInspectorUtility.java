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

package com.kodemore.inspector.support;

import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.kodemore.collection.KmList;
import com.kodemore.inspector.node.KmInspectorFieldNode;
import com.kodemore.inspector.node.KmInspectorNodeList;

public class KmInspectorUtility
{
    //##################################################
    //# reflection
    //##################################################

    public static KmList<Field> getLocalFieldsFor(Object o)
    {
        if ( o == null )
            return null;
        Class<?> c = o.getClass();
        Field fields[] = c.getFields();
        return new KmList<Field>(fields);
    }

    //##################################################
    //# testing
    //##################################################

    public static KmList<Field> getLocalVariablesFor(Object o)
    {
        KmList<Field> v = new KmList<Field>();
        for ( Field f : getLocalFieldsFor(o) )
        {
            int n = f.getModifiers();
            if ( Modifier.isStatic(n) )
                continue;
            if ( Modifier.isFinal(n) )
                continue;
            v.add(f);
        }
        return v;
    }

    //##################################################
    //# stuff
    //##################################################

    public static KmInspectorNodeList getLocalFieldNodesFor(Object o)
    {
        KmInspectorNodeList v = new KmInspectorNodeList();
        for ( Field f : getLocalFieldsFor(o) )
            v.add(new KmInspectorFieldNode(o, f));
        return v;
    }

    public static KmInspectorNodeList getLocalVariableNodesFor(Object o)
    {
        KmInspectorNodeList v = new KmInspectorNodeList();
        for ( Field f : getLocalVariablesFor(o) )
            v.add(new KmInspectorFieldNode(o, f));
        return v;
    }

    public static void beep()
    {
        Toolkit.getDefaultToolkit().beep();
    }

}
