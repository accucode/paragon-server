package com.kodemore.exception;

import com.kodemore.utility.Kmu;

public class KmSecurityException
    extends RuntimeException
{
    //##################################################
    //# constructor
    //##################################################

    public KmSecurityException()
    {
        super();
    }

    public KmSecurityException(String msg, Object... args)
    {
        super(Kmu.format(msg, args));
    }

    //##################################################
    //# format
    //##################################################

    public String formatDisplayMessage()
    {
        String s = "Security Violation.";

        if ( hasMessage() )
            return s + "\n" + getMessage();

        return s;
    }

    //##################################################
    //# utility
    //##################################################

    public boolean hasMessage()
    {
        return Kmu.hasValue(getMessage());
    }
}
