package com.kodemore.hibernate.lock;

import com.kodemore.exception.KmSignalingException;

public abstract class KmhDaoLockException
    extends KmSignalingException
{
    //##################################################
    //# constructor
    //##################################################

    public KmhDaoLockException()
    {
        super();
    }

    public KmhDaoLockException(String message)
    {
        super(message);
    }

    public KmhDaoLockException(Throwable cause)
    {
        super(cause);
    }

    public KmhDaoLockException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
