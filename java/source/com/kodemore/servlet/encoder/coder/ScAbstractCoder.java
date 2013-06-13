package com.kodemore.servlet.encoder.coder;

import com.kodemore.utility.Kmu;

public abstract class ScAbstractCoder
    implements ScCoderIF
{
    @Override
    public boolean hasKey(String e)
    {
        return Kmu.isEqual(getKey(), e);
    }

}
