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

package com.kodemore.match;

import java.util.ArrayList;
import java.util.List;

/**
 * I provide a convenient way to combine existing comparator into
 * a composite.  For example: there may already be two comparators,
 * one for first name, and another for last name.  Using this composite
 * comparator, the logic from the existing comparators can be combined
 * to easily create a firstLast, or lastFirst comparator without having
 * to resort to the copy/paste approach.
 */
public class KmCompositeMatch<T>
    extends KmAbstractMatch<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static <T> KmCompositeMatch<T> createWith(KmMatchIF<T> a)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(KmMatchIF<T> a, KmMatchIF<T> b)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(KmMatchIF<T> a, KmMatchIF<T> b, KmMatchIF<T> c)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        x.add(c);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(
        KmMatchIF<T> a,
        KmMatchIF<T> b,
        KmMatchIF<T> c,
        KmMatchIF<T> d)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(
        KmMatchIF<T> a,
        KmMatchIF<T> b,
        KmMatchIF<T> c,
        KmMatchIF<T> d,
        KmMatchIF<T> e)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(
        KmMatchIF<T> a,
        KmMatchIF<T> b,
        KmMatchIF<T> c,
        KmMatchIF<T> d,
        KmMatchIF<T> e,
        KmMatchIF<T> f)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(
        KmMatchIF<T> a,
        KmMatchIF<T> b,
        KmMatchIF<T> c,
        KmMatchIF<T> d,
        KmMatchIF<T> e,
        KmMatchIF<T> f,
        KmMatchIF<T> g)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        x.add(g);
        return x;
    }

    public static <T> KmCompositeMatch<T> createWith(
        KmMatchIF<T> a,
        KmMatchIF<T> b,
        KmMatchIF<T> c,
        KmMatchIF<T> d,
        KmMatchIF<T> e,
        KmMatchIF<T> f,
        KmMatchIF<T> g,
        KmMatchIF<T> h)
    {
        KmCompositeMatch<T> x;
        x = new KmCompositeMatch<T>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        x.add(g);
        x.add(h);
        return x;
    }

    //##################################################
    //# variables
    //##################################################

    private List<KmMatchIF<T>> _matches;

    //##################################################
    //# constructor
    //##################################################

    public KmCompositeMatch()
    {
        _matches = new ArrayList<KmMatchIF<T>>();
    }

    //##################################################
    //# accessing
    //##################################################

    public List<KmMatchIF<T>> getComparators()
    {
        return _matches;
    }

    public void setComparators(List<KmMatchIF<T>> e)
    {
        _matches = e;
    }

    public void add(KmMatchIF<T> c)
    {
        _matches.add(c);
    }

    public void addAll(KmMatchIF<T>... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            add(arr[i]);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean matches(T e)
    {
        for ( KmMatchIF<T> m : _matches )
            if ( !m.matches(e) )
                return false;

        return true;
    }

}
