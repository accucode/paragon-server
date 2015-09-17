package com.kodemore.hibernate.lock;

public class KmhDaoPessimisticLockException
    extends KmhDaoLockException
{
    //##################################################
    //# variables
    //##################################################

    private String _key;

    //##################################################
    //# constructors
    //##################################################

    public KmhDaoPessimisticLockException(String key)
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
