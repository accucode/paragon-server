package com.kodemore.log;

public interface KmLogPrinter
{
    public void println(String s);

    public void printfln(String s, Object... args);
}
