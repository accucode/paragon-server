package com.kodemore.collection;

import java.util.Collection;
import java.util.Set;

public interface KmSet<T>
    extends Set<T>
{
    public KmList<T> toList();

    public boolean addNonNull(T e);

    public boolean isNotEmpty();

    public boolean containsAny(Collection<T> v);

    public boolean containsNone(Collection<T> v);

    public String format();

}
