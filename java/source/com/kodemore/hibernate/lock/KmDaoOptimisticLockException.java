package com.kodemore.hibernate.lock;

public class KmDaoOptimisticLockException
    extends KmDaoLockException
{
    //##################################################
    //# constructors
    //##################################################

    public KmDaoOptimisticLockException(Throwable cause)
    {
        super(cause);
    }
}
