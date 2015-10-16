package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;

import com.app.dao.base.MyDaoRegistry;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkDaoTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkDaoTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        MyInstaller.installDatabase();

        System.out.println("installed. --------------------");

        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(this::handle);
        cmd.disableWarningThresholdMs();
        cmd.run();

        System.out.println("done. -------------------------");
    }

    //##################################################
    //# test
    //##################################################

    private void handle()
    {
        KmDate date = KmClock.getTodayUtc();

        KmList<String> names;
        names = getAccess().getPerformanceLogDetailDao().findNamesOn(date);
        names.sort();

        System.out.println(names.joinLines());
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
