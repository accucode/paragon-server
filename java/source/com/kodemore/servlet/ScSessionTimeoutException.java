package com.kodemore.servlet;

public class ScSessionTimeoutException
    extends RuntimeException
{
    public ScSessionTimeoutException()
    {
        super();
    }

    public ScSessionTimeoutException(String msg)
    {
        super(msg);
    }
}
