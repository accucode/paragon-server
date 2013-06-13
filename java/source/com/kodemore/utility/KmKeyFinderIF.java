package com.kodemore.utility;

/**
 * Find a model (T) by its unique key (K).
 */
public interface KmKeyFinderIF<T, K>
{
    T find(K key);
}
