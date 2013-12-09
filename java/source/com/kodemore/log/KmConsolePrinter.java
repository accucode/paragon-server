package com.kodemore.log;

public class KmConsolePrinter
    implements KmLogPrinter
{
    @Override
    public void println(String s)
    {
        System.out.println(s);
    }

    @Override
    public void printfln(String s, Object... args)
    {
        System.out.printf(s, args);

    }

}
