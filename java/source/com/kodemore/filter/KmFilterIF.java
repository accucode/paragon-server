package com.kodemore.filter;

import com.kodemore.collection.KmList;

public interface KmFilterIF<T>
{
    //##################################################
    //# find
    //##################################################

    /**
     * Find all elements that match the filter.
     */
    KmList<T> findAll();

    /**
     * Find a batch of elements, starting at the 
     * 0-based index, and returning a maximum of 
     * count elements.  
     */
    KmList<T> findBatch(int index, int count);

    /**
     * Equivalent to findBatch(0, count);
     */
    KmList<T> findFirst(int count);

    /**
     * Equivalent to findBatch(0, 1);
     * Return null if no element is found.
     */
    T findFirst();

    //##################################################
    //# count
    //##################################################

    /**
     * Equivalent to findAll().size();
     */
    int getCount();

    /**
     * Determine if at least one element exists.
     * This is often optimized to be significantly
     * faster than getCount() > 0.
     */
    boolean exists();

    //##################################################
    //# cursor
    //##################################################

    /**
     * Return an iterable for all elements.
     */
    Iterable<T> getCursor();

    //##################################################
    //# delete
    //##################################################

    void deleteAll();

    void deleteFirst();

    void deleteFirst(int count);

}
