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

package com.kodemore.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.comparator.KmComparator;
import com.kodemore.comparator.KmCompositeComparator;
import com.kodemore.comparator.KmUncheckedComparator;
import com.kodemore.filter.KmFilter;
import com.kodemore.match.KmCompositeMatch;
import com.kodemore.match.KmMatchIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.utility.KmIntegerIdIF;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.KmSequenceIF;
import com.kodemore.utility.KmUnchecked;
import com.kodemore.utility.Kmu;

/**
 * I provide a hook for miscellaneous extension points
 * and convenience methods.
 */
public class KmList<T>
    extends KmReadOnlyList<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmList<String> createStrings(String... arr)
    {
        KmList<String> v;
        v = new KmList<String>(arr.length);
        v.addAll(arr);
        return v;
    }

    /**
     * The returned list actually wraps the provided parameter.
     * Thus all modifications to the new list will affect the original.
     * This allows the client to effectively add my convenience methods
     * to someone else's list.
     */
    public static <T> KmList<T> wrap(List<T> v)
    {
        return new KmList<T>(v);
    }

    public static <T> KmList<T> createWith(T... a)
    {
        KmList<T> v;
        v = new KmList<T>();
        v.addAll(a);
        return v;
    }

    //##################################################
    //# constructor
    //##################################################

    public KmList()
    {
        super();
    }

    public KmList(Collection<? extends T> v)
    {
        super(v.size());
        addAll(v);
    }

    public KmList(Iterator<? extends T> v)
    {
        addAll(v);
    }

    public KmList(Enumeration<? extends T> v)
    {
        addAll(v);
    }

    public KmList(T... v)
    {
        addAll(v);
    }

    public KmList(int initialSize)
    {
        super(initialSize);
    }

    protected KmList(List<T> e)
    {
        super(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public T getFirst()
    {
        return get(0);
    }

    public KmList<T> getFirst(int n)
    {
        KmList<T> v = new KmList<T>();
        for ( int i = 0; i < n; i++ )
            v.add(get(i));
        return v;
    }

    public KmList<T> getFirstSafe(int n)
    {
        if ( n > size() )
            n = size();

        return getFirst(n);
    }

    public T getLast()
    {
        return get(size() - 1);
    }

    /**
     * Get the element immediately before e.
     * May throw an out of bounds exception.
     */
    public T getBefore(T e) throws NoSuchElementException, IndexOutOfBoundsException
    {
        int i = indexOf(e);
        if ( i <= 0 )
            throw new NoSuchElementException();
        return get(i - 1);
    }

    /**
     * Get the element immediately after e.
     * May throw an out of bounds exception.
     */
    public T getAfter(T e) throws NoSuchElementException, IndexOutOfBoundsException
    {
        int i = indexOf(e);
        if ( i < 0 )
            throw new NoSuchElementException();
        return get(i + 1);
    }

    public boolean isFirst(T e)
    {
        if ( isEmpty() )
            return false;

        return getFirst().equals(e);
    }

    public boolean isLast(T e)
    {
        return isEmpty()
            ? false
            : getLast().equals(e);
    }

    //##################################################
    //# size
    //##################################################

    public boolean isSingleton()
    {
        return size() == 1;
    }

    public boolean isNotSingleton()
    {
        return !isSingleton();
    }

    public boolean isMultiple()
    {
        return size() > 1;
    }

    public boolean isNotMultiple()
    {
        return !isMultiple();
    }

    //##################################################
    //# random
    //##################################################

    public T getRandom()
    {
        return get(KmRandom.getInteger(size()));
    }

    public KmList<T> getRandom(int n)
    {
        KmList<T> v = new KmList<T>();
        for ( int i = 0; i < n; i++ )
            v.add(getRandom());
        return v;
    }

    public KmList<T> getRandomDistinct(int n)
    {
        KmList<T> v = new KmList<T>();
        while ( v.size() < n )
            v.addDistinct(getRandom());
        return v;
    }

    /**
     * Shuffle the contents in place.
     * Uses the Fisher-Yates Shuffle.
     * http://en.wikipedia.org/wiki/Fisher-Yates
     * http://bost.ocks.org/mike/shuffle/
     * http://bost.ocks.org/mike/shuffle/compare.html
     */
    public void shuffle()
    {
        int i = size();
        while ( i > 1 )
        {
            int j = KmRandom.getInteger(i);
            i--;
            swap(i, j);
        }
    }

    public void swap(int i, int j)
    {
        T e = get(i);
        set(i, get(j));
        set(j, e);
    }

    public void moveUp(T e)
    {
        int i = indexOf(e);
        swap(i, i - 1);
    }

    public void moveDown(T e)
    {
        int i = indexOf(e);
        swap(i, i + 1);
    }

    public void moveUpSafe(T e)
    {
        int i = indexOf(e);
        if ( i <= 0 )
            return;

        swap(i, i - 1);
    }

    public void moveDownSafe(T e)
    {
        int i = indexOf(e);
        if ( i < 0 )
            return;

        if ( i == size() - 1 )
            return;

        swap(i, i + 1);
    }

    //##################################################
    //# accessing (safe)
    //##################################################

    public T getAt(int i)
    {
        return get(i);
    }

    public T getAtSafe(int i)
    {
        if ( i < 0 )
            return null;
        if ( i >= size() )
            return null;

        return getAt(i);
    }

    public T getFirstSafe()
    {
        return getAtSafe(0);
    }

    public T getLastSafe()
    {
        return getAtSafe(size() - 1);
    }

    public T getBeforeSafe(T e)
    {
        return getAtSafe(indexOf(e) - 1);
    }

    public T getAfterSafe(T e)
    {
        return getAtSafe(indexOf(e) + 1);
    }

    //##################################################
    //# add
    //##################################################

    public void addFirst(T e)
    {
        add(0, e);
    }

    public void addAll(Iterator<? extends T> i)
    {
        while ( i.hasNext() )
            add(i.next());
    }

    public void addAll(Enumeration<? extends T> e)
    {
        while ( e.hasMoreElements() )
            add(e.nextElement());
    }

    public void addAll(T... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            add(arr[i]);
    }

    public void addAll(KmBag<T> v)
    {
        addAll(v.getKeys());
    }

    public void replaceAll(Collection<T> e)
    {
        clear();
        addAll(e);
    }

    /**
     * Add the element, but return myself instead of a boolean.
     */
    public KmList<T> with(T e)
    {
        add(e);
        return this;
    }

    //##################################################
    //# sub list
    //##################################################

    public KmList<T> getIndexCount(int index, int count)
    {
        return getRange(index, index + count);
    }

    public KmList<T> getIndexCountSafe(int index, int count)
    {
        return getRangeSafe(index, index + count);
    }

    public KmList<T> getRange(int startInclusive, int endExclusive)
    {
        return new KmList<T>(subList(startInclusive, endExclusive));
    }

    public KmList<T> getRangeSafe(int startInclusive, int endExclusive)
    {
        if ( startInclusive < 0 )
            startInclusive = 0;

        if ( endExclusive < startInclusive )
            endExclusive = startInclusive;

        if ( endExclusive > size() )
            endExclusive = size();

        return new KmList<T>(subList(startInclusive, endExclusive));
    }

    //##################################################
    //# add distinct
    //##################################################

    public boolean addNonNull(T e)
    {
        if ( e == null )
            return false;

        return add(e);
    }

    public boolean addNonNullDistinct(T e)
    {
        if ( e == null )
            return false;

        return addDistinct(e);
    }

    public boolean addDistinct(T e)
    {
        if ( contains(e) )
            return false;

        return add(e);
    }

    public boolean addAllDistinct(Collection<? extends T> v)
    {
        boolean b = false;

        for ( T e : v )
            if ( addDistinct(e) )
                b = true;

        return b;
    }

    //##################################################
    //# supressed warnings
    //##################################################

    public void addAllUnchecked(Collection<?> e)
    {
        KmUnchecked.addAll(this, e);
    }

    public void addAllUnchecked(Iterator<?> e)
    {
        KmUnchecked.addAll(this, e);
    }

    public void addAllUnchecked(Enumeration<?> e)
    {
        KmUnchecked.addAll(this, e);
    }

    public void addAllUnchecked(Object[] arr)
    {
        KmUnchecked.addAll(this, arr);
    }

    //##################################################
    //# remove
    //##################################################

    public T removeFirst()
    {
        return remove(0);
    }

    public T removeFirstSafe()
    {
        if ( isEmpty() )
            return null;
        return removeFirst();
    }

    public T removeLast()
    {
        return remove(size() - 1);
    }

    public T removeLastSafe()
    {
        if ( isEmpty() )
            return null;

        return removeLast();
    }

    public void removeNulls()
    {
        Iterator<T> i = iterator();
        while ( i.hasNext() )
            if ( i.next() == null )
                i.remove();
    }

    public void removeRange(int inclusiveStart, int exclusiveEnd)
    {
        int n = exclusiveEnd - inclusiveStart;
        for ( int i = 0; i < n; i++ )
            remove(inclusiveStart);
    }

    public void removeAll(KmMatchIF<T> m)
    {
        Iterator<T> i = iterator();
        while ( i.hasNext() )
            if ( m.matches(i.next()) )
                i.remove();
    }

    public <V> void removeAll(KmMetaProperty<T,V> a, V value)
    {
        removeAll(a.getMatch(value));
    }

    public <V> void removeAll(KmMetaProperty<T,Boolean> a)
    {
        removeAll(a.getMatch(true));
    }

    /**
     * Set all elements to null, then clear the list.
     */
    public void purge()
    {
        int n = size();
        for ( int i = 0; i < n; i++ )
            set(i, null);

        clear();
    }

    //##################################################
    //# retain
    //##################################################

    public void retainAll(KmMatchIF<T> m)
    {
        Iterator<T> i = iterator();
        while ( i.hasNext() )
            if ( !m.matches(i.next()) )
                i.remove();
    }

    public <V> void retainAll(KmMetaAttribute<T,V> a, V value)
    {
        retainAll(a.getMatch(value));
    }

    public <V> void retainAll(KmMetaAttribute<T,Boolean> a)
    {
        retainAll(a.getMatch(true));
    }

    //##################################################
    //# sort
    //##################################################

    public void sort()
    {
        KmUnchecked.sort(this);
    }

    public void sortOn(Comparator<? super T> c)
    {
        if ( c != null )
            Collections.sort(this, c);
    }

    public void sortOn(Comparator<T> a, Comparator<T> b)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<T>();
        cc.add(a);
        cc.add(b);
        Collections.sort(this, cc);
    }

    public void sortOn(Comparator<T> a, Comparator<T> b, Comparator<T> c)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<T>();
        cc.add(a);
        cc.add(b);
        cc.add(c);
        Collections.sort(this, cc);
    }

    public void sortOn(KmMetaProperty<T,?> e)
    {
        sortOn(e.getComparator());
    }

    public void sortOn(KmMetaProperty<T,?> a, KmMetaProperty<T,?> b)
    {
        sortOn(a.getComparator(), b.getComparator());
    }

    public void sortOn(KmMetaProperty<T,?> a, KmMetaProperty<T,?> b, KmMetaProperty<T,?> c)
    {
        sortOn(a.getComparator(), b.getComparator(), c.getComparator());
    }

    public void sortReverseOn(KmMetaProperty<T,?> e)
    {
        sortOn(e.getComparator().reverse());
    }

    public void sortReverseOn(KmMetaProperty<T,?> a, KmMetaProperty<T,?> b)
    {
        sortOn(a.getComparator().reverse(), b.getComparator().reverse());
    }

    public void sortWithNullsOn(KmMetaProperty<T,?> e)
    {
        sortOn(e.getComparator().toNullComparator());
    }

    //##################################################
    //# min / max
    //##################################################

    public T getMinimum()
    {
        return getMinimum(new KmUncheckedComparator<T>());
    }

    public T getMinimum(Comparator<T> c)
    {
        if ( isEmpty() )
            return null;

        if ( size() == 1 )
            return getFirst();

        T smallest = getFirst();
        for ( T e : this )
            if ( c.compare(e, smallest) < 0 )
                smallest = e;

        return smallest;
    }

    public T getMaximum()
    {
        return getMaximum(new KmUncheckedComparator<T>());
    }

    public T getMaximum(Comparator<T> c)
    {
        if ( isEmpty() )
            return null;

        if ( size() == 1 )
            return getFirst();

        T largest = getFirst();
        for ( T e : this )
            if ( c.compare(e, largest) > 0 )
                largest = e;

        return largest;
    }

    public KmList<T> getReverse()
    {
        KmList<T> v;
        v = getShallowCopy();
        v.reverse();
        return v;
    }

    public void reverse()
    {
        Collections.reverse(this);
    }

    public Iterator<T> reverseIterator()
    {
        return new Iterator<T>()
        {
            int _index = size();

            @Override
            public boolean hasNext()
            {
                return _index > 0;
            }

            @Override
            public T next()
            {
                if ( _index == 0 )
                    throw new NoSuchElementException();

                _index--;
                return get(_index);
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    //##################################################
    //# move elements
    //##################################################

    public void moveToStart(T e)
    {
        int i = indexOf(e);
        moveToStartAt(i);
    }

    public void moveToStartAt(int i)
    {
        T e = remove(i);
        addFirst(e);
    }

    public void moveToEnd(T e)
    {
        int i = indexOf(e);
        moveToEndAt(i);
    }

    public void moveToEndAt(int i)
    {
        T e = remove(i);
        add(e);
    }

    /**
     * Find e, and swap it with the element immediately before it.
     * Return true if the collection is modified.
     */
    public boolean moveToPrevious(T e)
    {
        int i = indexOf(e);
        if ( i <= 0 )
            return false;

        swap(i, i - 1);
        return true;
    }

    /**
     * Find e, and swap it with the element immediately after it.
     * Return true if the collection is modified.
     */
    public boolean moveToNext(T e)
    {
        int i = indexOf(e);
        if ( i < 0 )
            return false;

        if ( i == size() - 1 )
            return false;

        swap(i, i + 1);
        return true;
    }

    //##################################################
    //# id access
    //##################################################

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    public T findId(Integer id)
    {
        if ( id == null )
            return null;
        Iterator i = iterator();
        while ( i.hasNext() )
        {
            KmIntegerIdIF e = (KmIntegerIdIF)i.next();
            if ( id.equals(e.getId()) )
                return (T)e;
        }
        return null;
    }

    public boolean hasId(Integer id)
    {
        return findId(id) != null;
    }

    public KmList<Integer> collectIds()
    {
        KmList<Integer> v = new KmList<Integer>();
        Iterator<?> i = iterator();
        while ( i.hasNext() )
        {
            KmIntegerIdIF e = (KmIntegerIdIF)i.next();
            v.add(e.getId());
        }
        return v;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    public boolean containsAny(Collection<? extends T> v)
    {
        for ( T e : v )
            if ( contains(e) )
                return true;
        return false;
    }

    public boolean containsNone(Collection<? extends T> v)
    {
        return !containsAny(v);
    }

    public boolean containsSame(Collection<? extends T> v)
    {
        return containsAll(v) && v.containsAll(this);
    }

    public boolean containsOnly(Collection<? extends T> v)
    {
        for ( T e : this )
            if ( !v.contains(e) )
                return false;
        return true;
    }

    public boolean isIndexOk(int index)
    {
        if ( index < 0 )
            return false;

        if ( index >= size() )
            return false;

        return true;
    }

    public boolean isOutOfBounds(int index)
    {
        return !isIndexOk(index);
    }

    //##################################################
    //# accessing array
    //##################################################

    public String[] toStringArray()
    {
        int n = size();
        String[] arr = new String[n];
        int j = 0;
        Iterator<T> i = iterator();
        while ( i.hasNext() )
        {
            String e = (String)i.next();
            arr[j] = e;
            j++;
        }
        return arr;
    }

    public Integer[] toIntegerArray()
    {
        int n = size();
        Integer[] arr = new Integer[n];
        int j = 0;
        Iterator<?> i = iterator();
        while ( i.hasNext() )
        {
            Integer e = (Integer)i.next();
            arr[j] = e;
            j++;
        }
        return arr;
    }

    //##################################################
    //# duplicates
    //##################################################

    public boolean containsDuplicate()
    {
        return hasDuplicates();
    }

    public boolean hasDuplicates()
    {
        KmSetImpl<T> s = new KmSetImpl<T>();

        for ( T e : this )
            if ( !s.add(e) )
                return true;

        return false;
    }

    /**
     * If a list contains: a, b, c, b; remove the second b.
     * Duplicate tests are based on equals().
     * The original sequence is preserved.
     */
    public void removeDuplicates()
    {
        KmSetImpl<T> set = new KmSetImpl<T>();
        KmList<T> v = new KmList<T>(size());

        for ( T e : this )
            if ( set.add(e) )
                v.add(e);

        replaceAll(v);
    }

    public KmList<T> getDuplicates()
    {
        KmSetImpl<T> set = new KmSetImpl<T>();
        KmList<T> v = new KmList<T>();

        for ( T e : this )
            if ( !set.add(e) )
                v.add(e);

        return v;
    }

    /**
     * If a list contains: a, b, c, b; remove the second b.
     * Duplicate tests are based on IDENTITY (==).
     * The original sequence is preserved.
     */
    public void removeDuplicateIdentities()
    {
        KmIdentitySet<T> set = new KmIdentitySet<T>();
        KmList<T> list = new KmList<T>();

        for ( T e : this )
            if ( set.add(e) )
                list.add(e);

        replaceAll(list);
    }

    //##################################################
    //# display
    //##################################################

    public String format()
    {
        return Kmu.formatList(this);
    }

    public String format(KmAdaptorIF<T,?> a)
    {
        return Kmu.formatList(this, a);
    }

    public String format(KmMetaAttribute<T,?> a)
    {
        return Kmu.formatList(this, a);
    }

    public String format(Object separator)
    {
        return Kmu.formatList(this, separator);
    }

    public String formatLines()
    {
        return Kmu.formatLines(this);
    }

    //##################################################
    //# copying
    //##################################################

    public KmList<T> getShallowCopy()
    {
        KmList<T> v;
        v = new KmList<T>();
        v.addAll(this);
        return v;
    }

    public KmList<T> getDeepCopy()
    {
        KmList<T> v = new KmList<T>();
        for ( T e : this )
            v.add(KmUnchecked.getCopy(e));
        return v;
    }

    public KmList<T> getSerializedCopy()
    {
        return KmUnchecked.getSerializedCopy(this);
    }

    //##################################################
    //# comparators
    //##################################################

    public static KmComparator<?> getSizeComparator()
    {
        return new KmComparator<Object>()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                int size1 = ((List<?>)o1).size();
                int size2 = ((List<?>)o2).size();
                return Kmu.compare(size1, size2);
            }
        };
    }

    //##################################################
    //# splitting
    //##################################################

    public KmList<KmList<T>> splitByGroupCount(int groupCount)
    {
        int groupSize = size() / groupCount;
        if ( size() % groupCount != 0 )
            groupSize++;
        return _split(groupCount, groupSize);
    }

    public KmList<KmList<T>> splitByGroupSize(int groupSize)
    {
        int groupCount = size() / groupSize;
        if ( size() % groupSize != 0 )
            groupCount++;
        return _split(groupCount, groupSize);
    }

    private KmList<KmList<T>> _split(int groupCount, int groupSize)
    {
        KmList<KmList<T>> groups = new KmList<KmList<T>>();
        int n = groupCount;
        for ( int i = 0; i < n; i++ )
        {
            int a = i * groupSize;
            int b = Math.min(size(), a + groupSize);
            KmList<T> v = new KmList<T>();
            v.addAll(subList(a, b));
            groups.add(v);
        }
        return groups;
    }

    //##################################################
    //# strings
    //##################################################

    public boolean containsIgnoreCase(String s)
    {
        for ( T e : this )
        {
            String s1 = (String)e;
            if ( s1.equalsIgnoreCase(s) )
                return true;
        }
        return false;
    }

    //##################################################
    //# collect
    //##################################################

    public <K> KmList<K> collect(KmAdaptorIF<T,K> a)
    {
        KmList<K> v = new KmList<K>();
        for ( T e : this )
            v.add(a.getValue(e));
        return v;
    }

    public <K> KmList<K> collect(KmMetaAttribute<T,K> a)
    {
        return collect(a.getAdaptor());
    }

    public <K> KmList<K> collectDistinct(KmAdaptorIF<T,K> a)
    {
        KmList<K> v = new KmList<K>();
        for ( T e : this )
            v.addDistinct(a.getValue(e));
        return v;
    }

    public <K> KmList<K> collectDistinct(KmMetaAttribute<T,K> a)
    {
        return collectDistinct(a.getAdaptor());
    }

    //##################################################
    //# select
    //##################################################

    public KmList<T> select(KmMatchIF<T> m)
    {
        KmList<T> v = new KmList<T>();
        for ( T e : this )
            if ( m.matches(e) )
                v.add(e);
        return v;
    }

    public <V> KmList<T> select(KmMetaAttribute<T,V> attr, V value)
    {
        return select(attr.getMatch(value));
    }

    public <V> KmList<T> select(KmMetaAttribute<T,Boolean> attr)
    {
        return select(attr.getMatch(true));
    }

    public T selectFirst(KmMatchIF<T> m)
    {
        for ( T e : this )
            if ( m.matches(e) )
                return e;
        return null;
    }

    public <V> T selectFirst(KmMetaAttribute<T,V> attr, V value)
    {
        return selectFirst(attr.getMatch(value));
    }

    public T selectInSequence(KmMatchIF<T> first, KmMatchIF<T>... arr)
    {
        T e = selectFirst(first);
        if ( e != null )
            return e;

        for ( KmMatchIF<T> m : arr )
        {
            e = selectFirst(m);
            if ( e != null )
                return e;
        }
        return null;
    }

    //##################################################
    //# reject
    //##################################################

    public KmList<T> reject(KmMatchIF<T> m)
    {
        KmList<T> v = new KmList<T>();
        for ( T e : this )
            if ( !m.matches(e) )
                v.add(e);
        return v;
    }

    public <V> KmList<T> reject(KmMetaProperty<T,V> attr, V value)
    {
        return reject(attr.getMatch(value));
    }

    //##################################################
    //# contains
    //##################################################

    /**
     * Determine if any of the element match all of the criteria specified.
     */
    public boolean containsMatch(KmMatchIF<T> a, KmMatchIF<T> b)
    {
        KmCompositeMatch<T> m;
        m = new KmCompositeMatch<T>();
        m.add(a);
        m.add(b);
        return containsMatch(m);
    }

    /**
     * Determine if any element matches.
     */
    public boolean containsMatch(KmMatchIF<T> m)
    {
        for ( T e : this )
            if ( m.matches(e) )
                return true;
        return false;
    }

    //##################################################
    //# sequence
    //##################################################

    public void updateSequence()
    {
        int i = 1;
        for ( T e : this )
            ((KmSequenceIF)e).setSequence(i++);
    }

    public int getNextSequence()
    {
        return KmListUtility.getNextSequence(this);
    }

    //##################################################
    //# collection conversion
    //##################################################

    public KmList<T> toDistinctList()
    {
        KmList<T> v = new KmList<T>();

        for ( T e : this )
            v.addDistinct(e);

        return v;
    }

    public KmSet<T> toSet()
    {
        KmSetImpl<T> v = new KmSetImpl<T>();
        for ( T e : this )
            v.add(e);
        return v;
    }

    public <K> KmSet<K> toSet(KmAdaptorIF<T,K> a)
    {
        KmSet<K> v = new KmSetImpl<K>();
        for ( T e : this )
            v.add(a.getValue(e));
        return v;
    }

    public <K> KmSet<K> toSet(KmMetaProperty<T,K> p)
    {
        return toSet(p.getAdaptor());
    }

    public <K, V> KmMap<K,V> toMap(KmAdaptorIF<T,K> keyAdaptor, KmAdaptorIF<T,V> valueAdaptor)
    {
        KmMap<K,V> m = new KmMap<K,V>();
        for ( T e : this )
            m.put(keyAdaptor.getValue(e), valueAdaptor.getValue(e));
        return m;
    }

    public <K> KmMap<K,T> toMap(KmAdaptorIF<T,K> keyAdaptor)
    {
        KmMap<K,T> m = new KmMap<K,T>();
        for ( T e : this )
            m.put(keyAdaptor.getValue(e), e);
        return m;
    }

    public <K> KmMap<K,T> toMap(KmMetaProperty<T,K> property)
    {
        return toMap(property.getAdaptor());
    }

    public <K, V> KmMap<K,KmList<V>> toMapList(
        KmAdaptorIF<T,K> keyAdaptor,
        KmAdaptorIF<T,V> valueAdaptor)
    {
        KmMap<K,KmList<V>> map = new KmMap<K,KmList<V>>();
        for ( T e : this )
        {
            K key = keyAdaptor.getValue(e);
            V value = valueAdaptor.getValue(e);
            KmList<V> list = map.get(key);
            if ( list == null )
            {
                list = new KmList<V>();
                map.put(key, list);
            }
            list.add(value);
        }
        return map;
    }

    public <K> KmMap<K,KmList<T>> toMapList(KmMetaProperty<T,K> attr)
    {
        return toMapList(attr.getAdaptor());
    }

    public <K> KmMap<K,KmList<T>> toMapList(KmAdaptorIF<T,K> keyAdaptor)
    {
        KmMap<K,KmList<T>> m = new KmMap<K,KmList<T>>();
        for ( T e : this )
        {
            K key = keyAdaptor.getValue(e);
            KmList<T> v = m.get(key);
            if ( v == null )
            {
                v = new KmList<T>();
                m.put(key, v);
            }
            v.add(e);
        }
        return m;
    }

    public KmVirtualList<T> toVirtualList()
    {
        return new KmVirtualListWrapper<T>(this);
    }

    public KmFilter<T> toFilter()
    {
        return new KmFilter<T>()
        {
            @Override
            public KmList<T> findAll()
            {
                return KmList.this;
            }
        };
    }

    public <K> KmBag<K> toBag(KmMetaProperty<T,K> attr)
    {
        return toBag(attr.getAdaptor());
    }

    public <K> KmBag<K> toBag(KmAdaptorIF<T,K> adaptor)
    {
        KmBag<K> b = new KmBag<K>();

        for ( T e : this )
            b.add(adaptor.getValue(e));

        return b;
    }

    //##################################################
    //# other
    //##################################################

    public KmList<T> repeat(int n)
    {
        KmList<T> v = new KmList<T>();
        for ( int i = 0; i < n; i++ )
            v.addAll(this);
        return v;
    }
}
