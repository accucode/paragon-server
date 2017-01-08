/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.kodemore.collection.KmList;

/**
 * I provide a convenient way to combine existing comparator into
 * a composite.  For example: there may already be two comparators,
 * one for first name, and another for last name.  Using this composite
 * comparator, the logic from the existing comparators can be combined
 * to easily create a firstLast, or lastFirst comparator without having
 * to resort to the copy/paste approach.
 */
public class KmCompositeComparator<T>
    extends KmComparator<T>
{
    //##################################################
    //# instance creation (comparators)
    //##################################################

    @SafeVarargs
    public static <T> KmCompositeComparator<T> createWith(Comparator<T>... arr)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.addAll(arr);
        return cc;
    }

    //==================================================
    //= instance creations (functions)
    //==================================================

    public static <T> KmCompositeComparator<T> createWith(Function<T,Comparable<?>> a)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.add(a);
        return cc;
    }

    public static <T> KmCompositeComparator<T> createWith(
        Function<T,Comparable<?>> a,
        Function<T,Comparable<?>> b)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.add(a);
        cc.add(b);
        return cc;
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<Comparator<T>> _comparators;

    //##################################################
    //# constructor
    //##################################################

    public KmCompositeComparator()
    {
        _comparators = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<Comparator<T>> getComparators()
    {
        return _comparators;
    }

    public void setComparators(KmList<Comparator<T>> e)
    {
        if ( e == null )
            e = new KmList<>();

        _comparators = e;
    }

    //==================================================
    //= add
    //==================================================

    public void add(Comparator<T> c)
    {
        _comparators.add(c);
    }

    public void add(Function<T,Comparable<?>> f)
    {
        add(KmComparator.createWith(f));
    }

    //==================================================
    //= add all
    //==================================================

    @SuppressWarnings("unchecked")
    public void addAll(Comparator<T>... arr)
    {
        for ( Comparator<T> e : arr )
            add(e);
    }

    @SuppressWarnings("unchecked")
    public void addAll(Function<T,Comparable<?>>... arr)
    {
        for ( Function<T,Comparable<?>> e : arr )
            add(e);
    }

    public void addAll(List<Comparator<T>> v)
    {
        for ( Comparator<T> e : v )
            add(e);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public int compare(T a, T b)
    {
        int i;
        for ( Comparator<T> e : _comparators )
        {
            i = e.compare(a, b);
            if ( i != 0 )
                return i;
        }
        return 0;
    }

}
