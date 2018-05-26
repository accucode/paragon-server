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

package com.kodemore.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.kodemore.comparator.KmComparator;
import com.kodemore.comparator.KmCompositeComparator;
import com.kodemore.comparator.KmUncheckedComparator;
import com.kodemore.filter.KmFilter;
import com.kodemore.types.KmMoney;
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
    extends KmListWrapper<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmList<String> createStrings(String... arr)
    {
        KmList<String> v;
        v = new KmList<>(arr.length);
        v.addAll(arr);
        return v;
    }

    public static <E> KmList<E> createSynchronized()
    {
        List<E> v;
        v = new ArrayList<>();
        v = Collections.synchronizedList(v);
        return wrap(v);
    }

    /**
     * The returned list actually wraps the provided parameter.
     * Thus all modifications to the new list will affect the original.
     * This allows the client to effectively add my convenience methods
     * to someone else's list.
     */
    public static <T> KmList<T> wrap(List<T> v)
    {
        return new KmList<>(v);
    }

    @SafeVarargs
    public static <T> KmList<T> createWith(T... arr)
    {
        KmList<T> v;
        v = new KmList<>();
        v.addAll(arr);
        return v;
    }

    public static <E> KmList<E> createEmpty()
    {
        return new KmList<>();
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

    public KmList(T[] arr)
    {
        addAll(arr);
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
    //# index :: first
    //##################################################

    public T getFirst()
    {
        return get(0);
    }

    public KmList<T> getFirst(int n)
    {
        KmList<T> v = new KmList<>();

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

    public boolean isFirst(T e)
    {
        if ( isEmpty() )
            return false;

        return getFirst().equals(e);
    }

    //==================================================
    //= index :: last
    //==================================================

    public T getLast()
    {
        return get(size() - 1);
    }

    public KmList<T> getLast(int n)
    {
        int nn = size();
        KmList<T> v = new KmList<>();

        for ( int i = nn - n; i < nn; i++ )
            v.add(get(i));

        return v;
    }

    public boolean isLast(T e)
    {
        return isEmpty()
            ? false
            : getLast().equals(e);
    }

    //==================================================
    //= index :: prev/next
    //==================================================

    /**
     * Get the element immediately before e.
     * May throw an out of bounds exception.
     */
    public T getPrevious(T e) throws NoSuchElementException, IndexOutOfBoundsException
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
    public T getNext(T e) throws NoSuchElementException, IndexOutOfBoundsException
    {
        int i = indexOf(e);
        if ( i < 0 )
            throw new NoSuchElementException();

        return get(i + 1);
    }

    //==================================================
    //= index :: predicate
    //==================================================

    public int indexIf(Predicate<T> p)
    {
        int i = 0;
        for ( T e : this )
        {
            if ( p.test(e) )
                return i;
            i++;
        }
        return -1;
    }

    //##################################################
    //# before/after
    //##################################################

    /**
     * Return all of the element BEFORE the requested value.
     * If I do not contain the specified value, return an empty list.
     */
    public KmList<T> getAllBefore(T e)
    {
        int i = indexOf(e);
        if ( i < 0 )
            return createEmpty();

        KmList<T> v;
        v = createEmpty();
        v.addAll(subList(0, i));
        return v;
    }

    /**
     * Return all of the element AFTER the requested value.
     * If I do not contain the specified value, return an empty list.
     */
    public KmList<T> getAllAfter(T e)
    {
        int i = indexOf(e);
        if ( i < 0 )
            return createEmpty();

        KmList<T> v;
        v = createEmpty();
        v.addAll(subList(i + 1, size()));
        return v;
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
        return KmRandom.getInstance().getElement(this);
    }

    public KmList<T> getRandom(int n)
    {
        KmList<T> v = new KmList<>();

        for ( int i = 0; i < n; i++ )
            v.add(getRandom());

        return v;
    }

    public KmList<T> getRandomDistinct(int n)
    {
        KmList<T> v = new KmList<>();

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
        KmRandom r = new KmRandom();

        int i = size();
        while ( i > 1 )
        {
            int j = r.getInteger(i);
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

    public void swap(T a, T b)
    {
        int i = indexOf(a);
        int j = indexOf(b);
        swap(i, j);
    }

    //##################################################
    //# move
    //##################################################

    public void move(T e, boolean up)
    {
        if ( up )
            moveUp(e);
        else
            moveDown(e);
    }

    public void moveSafe(T e, boolean up)
    {
        if ( up )
            moveUpSafe(e);
        else
            moveDownSafe(e);
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

    public T getPreviousSafe(T e)
    {
        return getAtSafe(indexOf(e) - 1);
    }

    public T getNextSafe(T e)
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

    @SuppressWarnings("unchecked")
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

    /**
     * Return a batch of elements.
     * Throw an error if the full batch cannot be returned.
     *
     * @param index The index of the first element to be returned.
     * @param count The number of elements to return.
     */
    public KmList<T> getBatch(int index, int count)
    {
        return getRange(index, index + count);
    }

    /**
     * Return a batch of elements.
     * Automatically restricted the index and count to a valid range.
     *
     * @param index The index of the first element to be returned.
     * @param count The number of elements to return.
     */
    public KmList<T> getBatchSafe(Integer index, Integer count)
    {
        if ( index == null )
            index = 0;

        if ( count == null )
            count = size();

        return getRangeSafe(index, index + count);
    }

    public KmList<T> getRange(int startInclusive, int endExclusive)
    {
        return new KmList<>(subList(startInclusive, endExclusive));
    }

    public KmList<T> getRangeSafe(int startInclusive, int endExclusive)
    {
        if ( startInclusive < 0 )
            startInclusive = 0;

        if ( endExclusive < startInclusive )
            endExclusive = startInclusive;

        if ( endExclusive > size() )
            endExclusive = size();

        return new KmList<>(subList(startInclusive, endExclusive));
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
        return contains(e)
            ? false
            : add(e);
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

    /**
     * Remove any element that equals the parameter.
     */
    public void removeAny(T e)
    {
        Iterator<T> i = iterator();
        while ( i.hasNext() )
            if ( Kmu.isEqual(i.next(), e) )
                i.remove();
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
    //# sort
    //##################################################

    public void sort()
    {
        KmUnchecked.sort(this);
    }

    /**
     * Return a NEW list, sorted using a default comparator.
     */
    public KmList<T> toSorted()
    {
        KmList<T> v;
        v = new KmList<>();
        v.addAll(this);
        v.sort();
        return v;
    }

    /**
     * Return a NEW list, sorted using the specified comparator.
     */
    public KmList<T> toSorted(Function<T,Comparable<?>> fn)
    {
        KmList<T> v;
        v = new KmList<>();
        v.addAll(this);
        v.sortOn(fn);
        return v;
    }

    /**
     * Return a NEW list, containing the elements identified by the provided keys.
     * The result will be same size as the list of keys.
     * If a key cannot be found, the list will contain null.
     * If multiple elements share the same key, the result is undetermined.
     */
    public <K> KmList<T> toOrderedList(KmList<K> keys, Function<T,K> keyFn)
    {
        KmMap<K,T> map = toMap(keyFn);
        return keys.collect(e -> map.get(e));
    }

    //==================================================
    //= sort (comparators)
    //==================================================

    public void sortOn(Comparator<? super T> c)
    {
        if ( c != null )
            Collections.sort(this, c);
    }

    public void sortOn(Comparator<T> a, Comparator<T> b)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.add(a);
        cc.add(b);
        Collections.sort(this, cc);
    }

    public void sortOn(Comparator<T> a, Comparator<T> b, Comparator<T> c)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.add(a);
        cc.add(b);
        cc.add(c);
        Collections.sort(this, cc);
    }

    //==================================================
    //= sort (functions)
    //==================================================

    public void sortOn(Function<T,Comparable<?>> a)
    {
        KmComparator<T> cc = KmComparator.createWith(a);
        sortOn(cc);
    }

    public void sortOn(Function<T,Comparable<?>> a, Function<T,Comparable<?>> b)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.add(a);
        cc.add(b);
        sortOn(cc);
    }

    public void sortOn(
        Function<T,Comparable<?>> a,
        Function<T,Comparable<?>> b,
        Function<T,Comparable<?>> c)
    {
        KmCompositeComparator<T> cc;
        cc = new KmCompositeComparator<>();
        cc.add(a);
        cc.add(b);
        cc.add(c);
        sortOn(cc);
    }

    //##################################################
    //# minimum
    //##################################################

    public T getMinimum()
    {
        return getMinimum(new KmUncheckedComparator<T>());
    }

    public T getMinimum(Comparator<T> c)
    {
        if ( isEmpty() )
            return null;

        if ( isSingleton() )
            return getFirst();

        T min = getFirst();
        for ( T e : this )
            if ( c.compare(e, min) < 0 )
                min = e;

        return min;
    }

    public <E extends Comparable<E>> T getMinimum(Function<T,E> fn)
    {
        return getMinimum(Kmu.toNullLastComparator(fn));
    }

    public <E extends Comparable<E>> E getMinimumValue(Function<T,E> fn)
    {
        T e = getMinimum(fn);
        return e == null
            ? null
            : fn.apply(e);
    }

    //##################################################
    //# maximum
    //##################################################

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

        T max = getFirst();
        for ( T e : this )
            if ( c.compare(e, max) > 0 )
                max = e;

        return max;
    }

    public <E extends Comparable<E>> T getMaximum(Function<T,E> fn)
    {
        return getMaximum(Kmu.toNullFirstComparator(fn));
    }

    public <E extends Comparable<E>> E getMaximumValue(Function<T,E> fn)
    {
        T e = getMaximum(fn);
        return e == null
            ? null
            : fn.apply(e);
    }

    //##################################################
    //# reverse
    //##################################################

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

    //##################################################
    //# iterators
    //##################################################

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

    public KmPushbackIterator<T> pushbackIterator()
    {
        return new KmPushbackIterator<>(iterator());
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
        KmList<Integer> v = new KmList<>();
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

    //==================================================
    //= testing :: contains
    //==================================================

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

    public boolean containsIf(Predicate<T> pred)
    {
        for ( T e : this )
            if ( pred.test(e) )
                return true;

        return false;
    }

    /**
     * Returns true only if ALL elements of the list match the predicate.
     */
    public boolean containsOnlyIf(Predicate<T> pred)
    {
        return !containsIf(pred.negate());
    }

    //==================================================
    //= testing :: index
    //==================================================

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
        KmSetImpl<T> s = new KmSetImpl<>();

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
        replaceAll(toDistinctList());
    }

    public KmList<T> getDuplicates()
    {
        KmSetImpl<T> set = new KmSetImpl<>();
        KmList<T> v = new KmList<>();

        for ( T e : this )
            if ( !set.add(e) )
                v.addDistinct(e);

        return v;
    }

    /**
     * If a list contains: a, b, c, b; remove the second b.
     * Duplicate tests are based on IDENTITY (==).
     * The original sequence is preserved.
     */
    public void removeDuplicateIdentities()
    {
        KmIdentitySet<T> set = new KmIdentitySet<>();
        KmList<T> list = new KmList<>();

        for ( T e : this )
            if ( set.add(e) )
                list.add(e);

        replaceAll(list);
    }

    public void replaceDuplicatesWithNull()
    {
        HashSet<T> values = new HashSet<>();

        int n = size();
        for ( int i = 0; i < n; i++ )
        {
            T e = get(i);
            if ( !values.add(e) )
                set(i, null);
        }
    }

    /**
     * Remove duplicates, based on the values returned by the function.
     * Does NOT preserve the original sequence.
     */
    public void removeDuplicates(Function<T,?> fn)
    {
        replaceAll(toMap(fn).getValues());
    }

    //##################################################
    //# not in
    //##################################################

    /**
     * Return the list of my elements that are NOT contained in v.
     */
    public KmList<T> getNotIn(KmList<T> v)
    {
        return select(e -> !v.contains(e));
    }

    //##################################################
    //# join
    //##################################################

    public String join()
    {
        return Kmu.join(this);
    }

    public String join(Function<T,?> fn)
    {
        return Kmu.join(this, fn);
    }

    public String join(String delim)
    {
        return Kmu.join(this, delim);
    }

    public String joinLines()
    {
        return Kmu.joinLines(this);
    }

    public String joinLines(Function<T,?> fn)
    {
        return Kmu.joinLines(this, fn);
    }

    public String concatentate()
    {
        return join("");
    }

    //##################################################
    //# system.out
    //##################################################

    public void print()
    {
        System.out.println(join());
    }

    public void print(Function<T,?> fn)
    {
        System.out.println(join(fn));
    }

    public void printLines()
    {
        System.out.println(joinLines());
    }

    public void printLines(Function<T,?> fn)
    {
        System.out.println(joinLines(fn));
    }

    //##################################################
    //# copying
    //##################################################

    public KmList<T> getShallowCopy()
    {
        KmList<T> v;
        v = new KmList<>();
        v.addAll(this);
        return v;
    }

    public KmList<T> getDeepCopy()
    {
        KmList<T> v = new KmList<>();

        for ( T e : this )
            v.add(KmUnchecked.getCopy(e));

        return v;
    }

    public KmList<T> getSerializedCopy()
    {
        return KmUnchecked.getSerializedCopy(this);
    }

    public KmList<T> withoutNulls()
    {
        KmList<T> v;
        v = getShallowCopy();
        v.removeNulls();
        return v;
    }

    /**
     * Return a NEW list, without any of the excluded values.
     * The order of the original list is preserved.
     */
    public KmList<T> without(Collection<T> exclude)
    {
        KmList<T> v = createEmpty();

        for ( T e : this )
            if ( !exclude.contains(e) )
                v.add(e);

        return v;
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
        KmList<KmList<T>> groups = new KmList<>();

        int n = groupCount;
        for ( int i = 0; i < n; i++ )
        {
            int a = i * groupSize;
            int b = Math.min(size(), a + groupSize);

            KmList<T> v;
            v = new KmList<>();
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
    //# sequence
    //##################################################

    public void updateSequences()
    {
        updateSequences(1);
    }

    public void updateSequences(int startingAt)
    {
        int i = startingAt;
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

    public KmSet<T> toSet()
    {
        KmSetImpl<T> v = new KmSetImpl<>();

        for ( T e : this )
            v.add(e);

        return v;
    }

    public <E> KmSet<E> toSet(Function<T,E> fn)
    {
        KmSetImpl<E> v = new KmSetImpl<>();

        for ( T e : this )
            v.add(fn.apply(e));

        return v;
    }

    public <K> KmMap<K,T> toMap(Function<T,K> keyFn)
    {
        KmMap<K,T> m = new KmMap<>();

        for ( T e : this )
            m.put(keyFn.apply(e), e);

        return m;
    }

    public <K, V> KmMap<K,V> toMap(Function<T,K> keyFn, Function<T,V> valueFn)
    {
        KmMap<K,V> m = new KmMap<>();

        for ( T e : this )
            m.put(keyFn.apply(e), valueFn.apply(e));

        return m;
    }

    public <K> KmMap<K,KmList<T>> toMapList(Function<T,K> keyFn)
    {
        KmMap<K,KmList<T>> m = new KmMap<>();
        for ( T e : this )
        {
            K key = keyFn.apply(e);
            KmList<T> v = m.get(key);

            if ( v == null )
            {
                v = new KmList<>();
                m.put(key, v);
            }

            v.add(e);
        }
        return m;
    }

    public <K, V> KmMap<K,KmList<V>> toMapList(Function<T,K> keyFn, Function<T,V> valueFn)
    {
        KmMap<K,KmList<V>> map = new KmMap<>();

        for ( T e : this )
        {
            K key = keyFn.apply(e);
            V value = valueFn.apply(e);

            KmList<V> list = map.get(key);
            if ( list == null )
            {
                list = new KmList<>();
                map.put(key, list);
            }

            list.add(value);
        }

        return map;
    }

    public KmVirtualList<T> toVirtualList()
    {
        return new KmVirtualListWrapper<>(this);
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

    public <K> KmBag<K> toBag(Function<T,K> fn)
    {
        KmBag<K> b = new KmBag<>();

        for ( T e : this )
            b.add(fn.apply(e));

        return b;
    }

    public KmList<T> toDistinctList()
    {
        KmList<T> v = new KmList<>(size());
        KmSetImpl<T> set = new KmSetImpl<>();

        for ( T e : this )
            if ( set.add(e) )
                v.add(e);

        return v;
    }

    //##################################################
    //# other
    //##################################################

    public KmList<T> repeat(int n)
    {
        KmList<T> v = new KmList<>();

        for ( int i = 0; i < n; i++ )
            v.addAll(this);

        return v;
    }

    //##################################################
    //# lambda
    //##################################################

    /**
     * Return a NEW list containing only the elements that match the predicate.
     */
    public KmList<T> select(Predicate<? super T> p)
    {
        KmList<T> v = new KmList<>();

        for ( T e : this )
            if ( p.test(e) )
                v.add(e);

        return v;
    }

    public T selectFirst(Predicate<? super T> p)
    {
        for ( T e : this )
            if ( p.test(e) )
                return e;

        return null;
    }

    public T selectLast(Predicate<? super T> p)
    {
        return getReverse().selectFirst(p);
    }

    /**
     * Return a NEW list containing only the elements that do NOT match the predicate.
     */
    public KmList<T> reject(Predicate<? super T> p)
    {
        return select(p.negate());
    }

    /**
     * Return a NEW list containing exactly one converted value for each element in the original.
     */
    public <R> KmList<R> collect(Function<? super T,R> f)
    {
        KmList<R> v = new KmList<>();

        for ( T e : this )
            v.add(f.apply(e));

        return v;
    }

    /**
     * Return a NEW list containing exactly one converted value for each element in the original.
     */
    public <R> KmList<R> collectAll(Function<? super T,List<R>> f)
    {
        KmList<R> v = new KmList<>();

        for ( T e : this )
            v.addAll(f.apply(e));

        return v;
    }

    /**
     * Return the first element that matches the predicate.
     * Return null if no matches are found.
     */
    public T detect(Predicate<? super T> p)
    {
        return detect(p, (T)null);
    }

    /**
     * Return the first element that matches the predicate.
     * Return the default if no matches are found.
     */
    public T detect(Predicate<? super T> p, T def)
    {
        for ( T e : this )
            if ( p.test(e) )
                return e;

        return def;
    }

    /**
     * Find the first element that matches the predicate,
     * and return the value of either ifFound, or null if not found.
     */
    public <R> R detect(Predicate<? super T> p, Function<T,R> ifFound)
    {
        for ( T e : this )
            if ( p.test(e) )
                return ifFound.apply(e);

        return null;
    }

    /**
     * Find the first element that matches the predicate,
     * and return the value of either ifFound or ifNotFound accordingly.
     */
    public <R> R detect(Predicate<? super T> p, Function<T,R> ifFound, Supplier<R> ifNotFound)
    {
        for ( T e : this )
            if ( p.test(e) )
                return ifFound.apply(e);

        return ifNotFound.get();
    }

    /**
     * REMOVE matching elements from THIS list.
     */
    @Override
    public boolean removeIf(Predicate<? super T> p)
    {
        return super.removeIf(p);
    }

    /**
     * KEEP  matching elements from THIS list.
     */
    public void retainIf(Predicate<? super T> p)
    {
        removeIf(p.negate());
    }

    @Override
    public void forEach(Consumer<? super T> c)
    {
        super.forEach(c);
    }

    /**
     * Sort THIS collection, any NULL values must be handled by the function.
     */
    public <E extends Comparable<E>> void sort(Function<? super T,E> f)
    {
        KmComparator<T> c = new KmComparator<T>()
        {
            @Override
            public int compare(T a, T b)
            {
                E aa = f.apply(a);
                E bb = f.apply(b);
                return c(aa, bb);
            }
        };
        sort(c);
    }

    /**
     * Sort THIS collection, but safely handle NULL values.
     * The comparator checks for null values and handles them directly without
     * passing them into the function.
     */
    public <E extends Comparable<E>> void sortSafe(Function<? super T,E> f)
    {
        KmComparator<T> c = new KmComparator<T>()
        {
            @Override
            public int compare(T a, T b)
            {
                E aa = a == null
                    ? null
                    : f.apply(a);

                E bb = b == null
                    ? null
                    : f.apply(b);

                return c(aa, bb);
            }
        };
        sort(c);
    }

    public boolean containsNull()
    {
        return containsIf(e -> e == null);
    }

    public int countIf(Predicate<? super T> p)
    {
        int n = 0;

        for ( T e : this )
            if ( p.test(e) )
                n++;

        return n;
    }

    //##################################################
    //# reduce
    //##################################################

    public <R> R reduce(R init, BiFunction<R,T,R> fn)
    {
        R result = init;

        for ( T e : this )
            result = fn.apply(result, e);

        return result;
    }

    public int reduceInt(BiFunction<Integer,T,Integer> fn)
    {
        return reduce(0, fn);
    }

    public <E> KmList<E> reduceList(Function<T,KmList<E>> fn)
    {
        KmList<E> v = new KmList<>();

        for ( T t : this )
            v.addAll(fn.apply(t));

        return v;
    }

    //##################################################
    //# sum
    //##################################################

    public int sumInt(Function<T,Integer> fn)
    {
        int total = 0;

        for ( T e : this )
            total += fn.apply(e);

        return total;
    }

    public double sumDouble(Function<T,Double> fn)
    {
        double total = 0;

        for ( T e : this )
            total += fn.apply(e);

        return total;
    }

    public KmMoney sumMoney(Function<T,KmMoney> fn)
    {
        KmMoney total = KmMoney.ZERO;

        for ( T e : this )
            total = total.add(fn.apply(e));

        return total;
    }

}
