package com.app.utility;

import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;

/**
 * A simple base class to facilitate tests.
 */
public abstract class MyAbstractTest
{
    //##################################################
    //# variables
    //##################################################

    private KmTimer _timer;

    //##################################################
    //# run
    //##################################################

    protected void run()
    {
        try
        {
            _run();
        }
        catch ( RuntimeException ex )
        {
            Kmu.printStackTrace(ex);
        }
    }

    private void _run()
    {
        printHeader(getClass().getSimpleName());

        if ( autoTransaction() )
        {
            installDatabase();
            handleDao();
        }
        else
            handle();

        printHeader("done");
    }

    private void handleDao()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(this::handle);
        cmd.disableWarningThresholdMs();
        cmd.run();
    }

    protected abstract void handle();

    protected abstract boolean autoTransaction();

    //##################################################
    //# install
    //##################################################

    protected final void installCore()
    {
        printHeader("install core");
        MyInstaller.installCore();
    }

    protected final void installDatabase()
    {
        printHeader("install database");
        MyInstaller.installDatabase();
    }

    //##################################################
    //# print
    //##################################################

    protected final void print()
    {
        print("");
    }

    protected final void print(Object e)
    {
        System.out.println(e);
    }

    protected final void print(String msg, Object... args)
    {
        System.out.printf(msg, args);
        System.out.println();
    }

    protected final void printHeader(String msg, Object... args)
    {
        int n = 60;
        char c = '=';
        String title = Kmu.format(msg, args);

        String s;
        s = Kmu.format("%s %s ", Kmu.repeat(c, 2), title);
        s = s + Kmu.repeat(c, n - s.length());

        if ( _timer != null )
            print(_timer);

        print();
        print(s);
        print();

        _timer = KmTimer.run();
    }

    //##################################################
    //# support
    //##################################################

    protected final MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected final KmTimestamp getNowUtc()
    {
        return KmClock.getUtcTimestamp();
    }

    protected final KmTimestamp getNowLocal()
    {
        return KmClock.getLocalTimestamp();
    }
}
