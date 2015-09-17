package com.kodemore.hibernate.lock;

public class KmhDaoOptimisticLockException
    extends KmhDaoLockException
{
    //##################################################
    //# constructors
    //##################################################

    public KmhDaoOptimisticLockException(Throwable cause)
    {
        super(cause);
    }
}
