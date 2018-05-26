package com.kodemore.meta;

import com.kodemore.dao.KmAbstractDao;

public interface KmMetaDaoPropertyIF<T, V>
    extends KmMetaPropertyIF<T,V>
{
    public abstract String getDaoPropertyName();

    public abstract KmAbstractDao<T,?> getDao();

}
