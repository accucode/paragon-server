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

package com.kodemore.servlet.encoder;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

public class ScEncoderTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        test();
    }

    private static void test()
    {
        ScEncoder e;
        e = new ScEncoder();
        e.encode("abc");
        e.encode(12345);
        e.encode(null);

        KmList<Object> v = new KmList<>();
        v.add("x");
        v.add(null);
        v.add(3);
        v.add("z");
        e.encode(v);

        KmMap<Object,Object> m = new KmMap<>();
        m.put("a", "b");
        m.put("c", null);
        m.put("v", v);
        m.put("y", 3);
        e.encode(m);

        String s = e.toString();

        System.out.println();
        System.out.println("Buffer...");
        System.out.println(s);

        ScDecoder d;
        d = new ScDecoder();
        d.decode(s);

        System.out.println();
        System.out.println("Parse...");
        System.out.println("size:    " + d.getSize());
        System.out.println();
        System.out.println("string:  " + d.getString());
        System.out.println("integer: " + d.getInteger());
        System.out.println("null:    " + d.isNull());
        d.skip();
        System.out.println("list:    " + d.getList().join());
        System.out.println("map:     " + d.getMap());

    }
}
