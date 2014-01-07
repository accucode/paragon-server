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

package com.kodemore.inspector.sample;

import java.util.Date;

import com.kodemore.collection.KmList;

@SuppressWarnings("unused")
public class KmInspectorSample
{
    private int            i;
    private String         s;
    private int            iArr[];
    private String         sArr[];
    private Object         objectArr;
    private Object         sample;
    private KmList<Object> v1;
    private KmList<Object> v2;
    private Date           d;
    private Object         sample2;

    public KmInspectorSample()
    {
        i = 5;
        s = "John";
        iArr = new int[5];
        iArr[2] = 2;
        sArr = new String[4];
        sArr[1] = "one";
        sArr[2] = "two";
        v1 = new KmList<Object>();
        v1.add("one");
        v1.add("two");
        d = new Date();
        sample2 = new KmInspectorSample2();
    }

    public void installData()
    {
        Object a[] = new Object[5];
        a[0] = new KmInspectorSample();
        a[1] = "at 1";
        objectArr = a;
        sample = new KmInspectorSample();
        v2 = new KmList<Object>();
        v2.add("four");
        v2.add("five");
        v2.add(new KmInspectorSample());
    }

}
