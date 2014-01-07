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
 * I am used to inspect a simple value without an
 * a known declared type.
 */
public class KmInspectorSubjectNode
    extends KmInspectorNode
{
    //##################################################
    //# variables
    //##################################################

    private Object _subject;

    //##################################################
    //# constructors
    //##################################################

    public KmInspectorSubjectNode(Object s)
    {
        _subject = s;
    }

    //##################################################
    //# accessing
    //##################################################

    public Object getSubject()
    {
        return _subject;
    }

    public void setSubject(Object o)
    {
        _subject = o;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public Object getValue()
    {
        return _subject;
    }

}
