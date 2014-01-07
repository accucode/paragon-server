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

package com.kodemore.inspector.node;

/**
 * I inspect a value and use an explicit name for display.
 * I also allow for the declared class to be specified.
 */
public class KmInspectorNamedNode
    extends KmInspectorSubjectNode
{
    //##################################################
    //# variables
    //##################################################

    private String   _name;
    private Class<?> _declaredClass;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorNamedNode(String s, Object e)
    {
        this(s, e, null);
    }

    public KmInspectorNamedNode(String s, Object e, Class<?> c)
    {
        super(e);
        _name = s;
        _declaredClass = c;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        if ( _name == null )
            _name = super.getName();
        return _name;
    }

    public void setName(String o)
    {
        _name = o;
    }

    @Override
    public Class<?> getDeclaredClass()
    {
        return _declaredClass;
    }

    public void setDeclaredClass(Class<?> o)
    {
        _declaredClass = o;
    }

}
