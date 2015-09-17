package com.kodemore.command;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.kodemore.utility.Kmu;

public class KmDaoRunnableCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private Runnable _runnable;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoRunnableCommand()
    {
        // none
    }

    public KmDaoRunnableCommand(Runnable e)
    {
        _runnable = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public Runnable getRunnable()
    {
        return _runnable;
    }

    public void setRunnable(Runnable e)
    {
        _runnable = e;
    }

    public <A> void setRunnable(Consumer<A> con, A a)
    {
        setRunnable(Kmu.toRunnable(con, a));
    }

    public <A, B> void setRunnable(BiConsumer<A,B> con, A a, B b)
    {
        setRunnable(Kmu.toRunnable(con, a, b));
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    protected void handle()
    {
        if ( _runnable != null )
            _runnable.run();
    }
}
