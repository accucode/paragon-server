package com.app.utility;

import com.kodemore.utility.Kmu;

/**
 * I provide a standard way to return a simple status along
 * with a message.
 */
public class MyResult
{
    //##################################################
    //# type enum
    //##################################################

    public static enum Status
    {
        ok,
        error,
        ignored;
    }

    //##################################################
    //# constants
    //##################################################

    public static final MyResult OK      = createOk();
    public static final MyResult IGNORED = createIgnored();

    //##################################################
    //# instance creation
    //##################################################

    public static MyResult createOk()
    {
        MyResult e;
        e = new MyResult();
        e._status = Status.ok;
        return e;
    }

    public static MyResult createOk(String msg, Object... args)
    {
        MyResult e;
        e = new MyResult();
        e._status = Status.ok;
        e._message = Kmu.format(msg, args);
        return e;
    }

    public static MyResult createError(String msg, Object... args)
    {
        MyResult e;
        e = new MyResult();
        e._status = Status.error;
        e._message = Kmu.format(msg, args);
        return e;
    }

    public static MyResult createIgnored()
    {
        MyResult e;
        e = new MyResult();
        e._status = Status.ignored;
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * true  => ok
     * false => error
     * null  => ignored / unknown
     */
    private Status _status;

    /**
     * Optional message.
     */
    private String _message;

    //##################################################
    //# constructor
    //##################################################

    private MyResult()
    {
        // private
    }

    //##################################################
    //# type
    //##################################################

    public Status getStatus()
    {
        return _status;
    }

    public boolean isOk()
    {
        return getStatus() == Status.ok;
    }

    public boolean isError()
    {
        return getStatus() == Status.error;
    }

    public boolean isIgnored()
    {
        return getStatus() == Status.ignored;
    }

    //##################################################
    //# message
    //##################################################

    public String getMessage()
    {
        return _message;
    }

    public boolean hasMessage()
    {
        return Kmu.hasValue(getMessage());
    }

    public String formatStatusMessage()
    {
        return hasMessage()
            ? _status.name() + " - " + getMessage()
            : _status.name();
    }

    //##################################################
    //# testing
    //##################################################

    /**
     * Check if the result is ok.
     * If ok, do nothing.
     * If not ok, throw an application exception.
     */
    public void check()
    {
        if ( !isOk() )
            throw Kmu.newError(getMessage());
    }

}
