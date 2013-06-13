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

import java.util.Comparator;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmTimer;

/**
 * I provide some basic tests and examples of this package.
 */
public class KmBlockTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new KmBlockTest().run();
    }

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        testBlock();
        testBlockPath();
        testBlockComparator();
        testSpeed();
    }

    public void testBlock()
    {
        Object e = KmBlock.invokeStatic(this, "getAbc");
        System.out.println("abc = " + e);
    }

    public String getAbc()
    {
        return "abc";
    }

    public void testBlockPath()
    {
        String s = "  12345  ";
        KmBlockPath p = new KmBlockPath(s, "trim.length");
        Object e = p.invoke();
        int n = ((Integer)e).intValue();
        System.out.println("length: " + n);
    }

    public void testBlockComparator()
    {
        Comparator<String> c = new KmBlockComparator<String>("trim.length");
        KmList<String> v = new KmList<String>();
        v.add("2. abcd     ");
        v.add("4. abcdef   ");
        v.add("1. abc      ");
        v.add("3. abcde    ");
        v.sortOn(c);
        for ( String s : v )
            System.out.println(s);
    }

    public void testSpeed()
    {
        System.out.println();
        System.out.println();

        int n = 100000;
        for ( int i = 0; i < n; i++ )
            testNano();

        testSpeedDirect(n);
        testSpeedDirect(n);

        testSpeedBlock(n);
        testSpeedBlock(n);

        testSpeedDirect(n);
        testSpeedDirect(n);

        testSpeedBlock(n);
        testSpeedBlock(n);
    }

    private void testSpeedDirect(int n)
    {
        KmTimer timer = KmTimer.run("direct");
        for ( int i = 0; i < n; i++ )
            testNano();
        System.out.println(timer);
    }

    private void testSpeedBlock(int n)
    {
        KmTimer timer = KmTimer.run("block ");
        KmBlock block = new KmBlock(this, "testNano");
        for ( int i = 0; i < n; i++ )
            block.invoke();
        System.out.println(timer);
    }

    public void testNano()
    {
        System.nanoTime();
    }
}
