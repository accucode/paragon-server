package com.kodemore.hibernate.lock;

public abstract class KmDaoLockException
    extends RuntimeException
{
    //##################################################
    //# constructor
    //##################################################

    public KmDaoLockException()
    {
        super();
    }

    public KmDaoLockException(String message)
    {
        super(message);
    }

    public KmDaoLockException(Throwable cause)
    {
        super(cause);
    }

    public KmDaoLockException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
