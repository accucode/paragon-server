package com.kodemore.meta;

public interface KmMetaPropertyIF<T, V>
{
    String getName();

    V getValueFor(T model);

    void setValueFor(T model, V value);

    boolean hasValueFor(T model, V value);
}
