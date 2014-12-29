package com.kodemore.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.comparator.KmComparator;
import com.kodemore.comparator.KmUncheckedComparator;
import com.kodemore.match.KmCompositeMatch;
import com.kodemore.match.KmMatchIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
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

    public T getMinimum(KmMetaProperty<T,?> x)
    {
        return getMinimum(x.getComparator());
    }

    public <V> V getMinimumValue(KmMetaProperty<T,V> x)
    {
        return collect(x).getMinimum();
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

    public T getMaximum(KmMetaProperty<T,?> x)
    {
        return getMaximum(x.getComparator());
    }

    public <V> V getMaximumValue(KmMetaProperty<T,V> x)
    {
        return collect(x).getMaximum();
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
    //# match
    //##################################################

    public <K> KmCollection<K> collect(KmAdaptorIF<T,K> a)
    {
        KmCollection<K> v = new KmCollection<>();

        for ( T e : this )
            v.add(a.getValue(e));

        return v;
    }

    public <K> KmCollection<K> collect(KmMetaAttribute<T,K> a)
    {
        return collect(a.getAdaptor());
    }

    public KmCollection<T> select(KmMatchIF<T> m)
    {
        KmCollection<T> v = new KmCollection<>();

        for ( T e : this )
            if ( m.matches(e) )
                v.add(e);

        return v;
    }

    public <V> KmCollection<T> select(KmMetaAttribute<T,V> attr, V value)
    {
        return select(attr.getMatch(value));
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

    public KmCollection<T> reject(KmMatchIF<T> m)
    {
        KmCollection<T> v = new KmCollection<>();

        for ( T e : this )
            if ( !m.matches(e) )
                v.add(e);

        return v;
    }

    public <V> KmCollection<T> reject(KmMetaProperty<T,V> attr, V value)
    {
        return reject(attr.getMatch(value));
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

    @SuppressWarnings("unchecked")
    public T selectInSequence(KmMatchIF<T> first, KmMatchIF<T>... arr)
    {
        return selectInSequence(first, KmList.createWith(arr));
    }

    public T selectInSequence(KmMatchIF<T> first, List<KmMatchIF<T>> arr)
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

    /**
     * Determine if any of the element match all of the criteria specified.
     */
    public boolean containsMatch(KmMatchIF<T> a, KmMatchIF<T> b)
    {
        KmCompositeMatch<T> m;
        m = new KmCompositeMatch<>();
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
    //# collection conversion
    //##################################################

    public KmSet<T> toSet()
    {
        KmSetImpl<T> v = new KmSetImpl<>();

        for ( T e : this )
            v.add(e);

        return v;
    }

    public <K> KmSet<K> toSet(KmAdaptorIF<T,K> a)
    {
        KmSet<K> v = new KmSetImpl<>();

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
        KmMap<K,V> m = new KmMap<>();

        for ( T e : this )
            m.put(keyAdaptor.getValue(e), valueAdaptor.getValue(e));

        return m;
    }

    public <K> KmMap<K,T> toMap(KmAdaptorIF<T,K> keyAdaptor)
    {
        KmMap<K,T> m = new KmMap<>();

        for ( T e : this )
            m.put(keyAdaptor.getValue(e), e);

        return m;
    }

    public <K> KmMap<K,T> toMap(KmMetaProperty<T,K> property)
    {
        return toMap(property.getAdaptor());
    }

    public <K, V> KmMap<K,KmCollection<V>> toMapList(
        KmAdaptorIF<T,K> keyAdaptor,
        KmAdaptorIF<T,V> valueAdaptor)
    {
        KmMap<K,KmCollection<V>> map = new KmMap<>();
        for ( T e : this )
        {
            K key = keyAdaptor.getValue(e);
            V value = valueAdaptor.getValue(e);

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

    public <K> KmMap<K,KmCollection<T>> toMapList(KmAdaptorIF<T,K> keyAdaptor)
    {
        KmMap<K,KmCollection<T>> m = new KmMap<>();

        for ( T e : this )
        {
            K key = keyAdaptor.getValue(e);
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

    public KmList<T> toList(KmMetaProperty<T,?> p)
    {
        return toList(p.getComparator());
    }

    //##################################################
    //# sequence
    //##################################################

    public Integer getNextSequence()
    {
        return KmListUtility.getNextSequence(this);
    }

}
