package com.kodemore.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.kodemore.comparator.KmComparator;
import com.kodemore.comparator.KmUncheckedComparator;
import com.kodemore.utility.KmIntegerIdIF;
import com.kodemore.utility.KmUnchecked;
import com.kodemore.utility.Kmu;

public class KmCollection<T>
    extends KmCollectionWrapper<T>
{
    //##################################################
    //# constructor
    //##################################################

    public KmCollection()
    {
        super();
    }

    public KmCollection(int i)
    {
        super(i);
    }

    public KmCollection(Collection<T> e)
    {
        super(e);
    }

    //##################################################
    //# add
    //##################################################

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

    public void replaceAll(Collection<T> e)
    {
        clear();
        addAll(e);
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
    //# accessing
    //##################################################

    /**
     * Return the first element as returned by iterator().
     * Since I am inherently UN-ordered, the first element
     * generally does not have a deterministic behavior.
     * Mostly this is used when the client has already
     * determined that the collection contains a single element.
     */
    public T getFirst()
    {
        return iterator().next();
    }

    public T getFirstSafe()
    {
        return isEmpty()
            ? null
            : getFirst();
    }

    /**
     * Return the first element.
     * If the list is empty, or has more than one element, then return null.
     */
    public T getOnlySafe()
    {
        return isSingleton()
            ? getFirst()
            : null;
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
        T min = null;

        Iterator<T> i = iterator();
        while ( i.hasNext() )
        {
            T e = i.next();

            if ( min == null )
                min = e;
            else
                if ( c.compare(e, min) < 0 )
                    min = e;
        }
        return min;
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
        T max = null;

        Iterator<T> i = iterator();
        while ( i.hasNext() )
        {
            T e = i.next();

            if ( max == null )
                max = e;
            else
                if ( c.compare(e, max) > 0 )
                    max = e;
        }
        return max;
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

    public KmCollection<Integer> collectIds()
    {
        KmCollection<Integer> v = new KmCollection<>();

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
    //# conversion
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

    //##################################################
    //# copying
    //##################################################

    public KmCollection<T> getShallowCopy()
    {
        KmCollection<T> v;
        v = new KmCollection<>();
        v.addAll(this);
        return v;
    }

    public KmCollection<T> getDeepCopy()
    {
        KmCollection<T> v = new KmCollection<>();

        for ( T e : this )
            v.add(KmUnchecked.getCopy(e));

        return v;
    }

    public KmCollection<T> getSerializedCopy()
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
    //# collection conversion
    //##################################################

    public KmSet<T> toSet()
    {
        KmSetImpl<T> v = new KmSetImpl<>();

        for ( T e : this )
            v.add(e);

        return v;
    }

    public <K> KmSet<K> toSet(Function<T,K> fn)
    {
        KmSet<K> v = new KmSetImpl<>();

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

    public <K> KmMap<K,KmCollection<T>> toMapList(Function<T,K> keyFn)
    {
        KmMap<K,KmCollection<T>> m = new KmMap<>();

        for ( T e : this )
        {
            K key = keyFn.apply(e);
            KmCollection<T> v = m.get(key);

            if ( v == null )
            {
                v = new KmCollection<>();
                m.put(key, v);
            }

            v.add(e);
        }

        return m;
    }

    public <K, V> KmMap<K,KmCollection<V>> toMapList(Function<T,K> keyFn, Function<T,V> valueFn)
    {
        KmMap<K,KmCollection<V>> map = new KmMap<>();
        for ( T e : this )
        {
            K key = keyFn.apply(e);
            V value = valueFn.apply(e);

            KmCollection<V> list = map.get(key);
            if ( list == null )
            {
                list = new KmCollection<>();
                map.put(key, list);
            }

            list.add(value);
        }
        return map;
    }

    public KmList<T> toList()
    {
        return new KmList<>(this);
    }

    public KmList<T> toList(Comparator<T> c)
    {
        KmList<T> v;
        v = toList();
        v.sortOn(c);
        return v;
    }

    public KmList<T> toList(Function<T,Comparable<?>> f)
    {
        KmList<T> v;
        v = toList();
        v.sortOn(f);
        return v;
    }

    //##################################################
    //# sequence
    //##################################################

    public Integer getNextSequence()
    {
        return KmListUtility.getNextSequence(this);
    }

    //##################################################
    //# lambda
    //##################################################

    /**
     * Return a NEW list containing only the elements that match the predicate.
     */
    public KmCollection<T> select(Predicate<? super T> p)
    {
        KmCollection<T> v = new KmCollection<>();

        for ( T e : this )
            if ( p.test(e) )
                v.add(e);

        return v;
    }

    /**
     * Return a NEW list containing only the elements that do NOT match the predicate.
     */
    public KmCollection<T> reject(Predicate<? super T> p)
    {
        return select(p.negate());
    }

    /**
     * Return a NEW list containing exactly one converted value for each element in the original.
     */
    public <R> KmCollection<R> collect(Function<? super T,R> f)
    {
        KmCollection<R> v = new KmCollection<>();

        for ( T e : this )
            v.add(f.apply(e));

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
     * and return the value of either ifFound or ifNotFound accordingly.
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

}
