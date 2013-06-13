package com.kodemore.property.type;

import com.kodemore.utility.Kmu;

public abstract class KmPropertyAbstractType
    implements KmPropertyTypeIF
{
    protected void error(String msg, Object... args)
    {
        Kmu.fatal(msg, args);
    }

}
