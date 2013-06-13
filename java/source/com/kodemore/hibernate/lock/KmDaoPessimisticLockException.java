package com.kodemore.hibernate.lock;

public class KmDaoPessimisticLockException
    extends KmDaoLockException
{
    //##################################################
    //# variables
    //##################################################

    private String _key;

    //##################################################
    //# constructors
    //##################################################

    public KmDaoPessimisticLockException(String key)
    {
        super("Cannot acquire pessimistic lock on " + key);
        _key = key;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getKey()
    {
        return _key;
    }

}
