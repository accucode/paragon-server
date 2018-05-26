package sandbox.wlove;

import com.kodemore.command.KmDaoRollbackException;
import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public abstract class JkAbstractTest
{
    //##################################################
    //# variables
    //##################################################

    private boolean _autoInstallAll;
    private boolean _autoTransaction;
    private boolean _shortErrors;
    private boolean _showTimes;

    private KmTimer _timer;

    //##################################################
    //# constructor
    //##################################################

    public JkAbstractTest()
    {
        // none
    }

    //##################################################
    //# run
    //##################################################

    protected void run()
    {
        try
        {
            runTry();
            System.exit(0);
        }
        catch ( RuntimeException ex )
        {
            if ( _shortErrors )
            {
                System.err.println(ex.getClass().getName());
                System.err.println(ex.getMessage());
            }
            else
                throw ex;
        }
    }

    private void runTry()
    {
        init();
        printHeader(getClass().getSimpleName());

        if ( _autoInstallAll )
            installAll();

        if ( _autoTransaction )
        {
            if ( !_autoInstallAll )
                installDatabase();

            handleDao();
        }
        else
            handleIt();

        printHeader("done");
    }

    private void handleDao()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(this::handleIt);
        cmd.disableWarningThresholdMs();
        cmd.setStaleObjectRetryCount(0);
        cmd.run();
    }

    private void handleIt()
    {
        printHeader("handle");
        handle();
    }

    protected abstract void handle();

    //##################################################
    //# init
    //##################################################

    protected abstract void init();

    protected void setAutoInstall(boolean e)
    {
        _autoInstallAll = e;
    }

    protected void setAutoTransaction(boolean e)
    {
        _autoTransaction = e;
    }

    protected void setShortErrors(boolean e)
    {
        _shortErrors = e;
    }

    protected void setShowTimes(boolean e)
    {
        _showTimes = e;
    }

    //##################################################
    //# install
    //##################################################

    protected final void installAll()
    {
        printHeader("install all");
        MyInstaller.install();
    }

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

    protected final void installUserInterface()
    {
        printHeader("install ui");
        MyInstaller.installUserInterface();
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

        printTime();

        print();
        print(s);
        print();

        _timer = KmTimer.run();
    }

    private void printTime()
    {
        if ( _showTimes && _timer != null )
            print(_timer);
    }

    protected void printError(String msg, Object... args)
    {
        System.err.println(Kmu.format(msg, args));
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

    protected void throwRollback()
    {
        throw new KmDaoRollbackException();
    }

}
