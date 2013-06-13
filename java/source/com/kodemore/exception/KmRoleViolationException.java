package com.kodemore.exception;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;

public class KmRoleViolationException
    extends KmApplicationException
{
    public KmRoleViolationException()
    {
        super();
    }

    public KmRoleViolationException(KmErrorIF error)
    {
        super(error);
    }

    public KmRoleViolationException(KmList<KmErrorIF> errors)
    {
        super(errors);
    }

    public KmRoleViolationException(String msg, Object... args)
    {
        super(msg, args);
    }
}
