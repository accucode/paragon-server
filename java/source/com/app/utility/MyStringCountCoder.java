package com.app.utility;

import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.encoder.coder.ScAbstractCoder;

public class MyStringCountCoder
    extends ScAbstractCoder
{
    @Override
    public String getKey()
    {
        return "SC";
    }

    @Override
    public boolean matches(Object e)
    {
        return e instanceof MyStringCount;
    }

    @Override
    public void encode(ScEncoder encoder, Object o)
    {
        MyStringCount e = (MyStringCount)o;
        encoder._print(e.getString());
        encoder.encode(e.getCount());
    }

    @Override
    public Object decode(ScDecoder decoder, String s)
    {
        Integer n = (Integer)decoder.nextValue();

        MyStringCount e;
        e = new MyStringCount();
        e.setString(s);
        e.setCount(n);
        return e;
    }

}
