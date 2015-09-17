package com.app.finder.core;

import com.kodemore.command.KmDao;

public abstract class MyAbstractFinder<T>
{
    //##################################################
    //# public
    //##################################################

    public T find()
    {
        return KmDao.fetch(this::_find);
    }

    //##################################################
    //# support
    //##################################################

    public abstract T _find();
}
