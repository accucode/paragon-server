package sandbox.wlove;

import com.kodemore.command.KmDao;
import com.kodemore.utility.Kmu;

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

        KmDao.run(this::handleReset);

        KmDao.run(this::handleTest1);
        KmDao.run(this::handleTest2);
        KmDao.run(this::handleTest3);
        KmDao.run(this::handleTest4);
        KmDao.run(this::handleTest5);

        printHeader("end");
    }

    //##################################################
    //# reset
    //##################################################

    private void handleReset()
    {
        printHeader("Reset");
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTest1()
    {
        printHeader("test 1");
    }

    private void handleTest2()
    {
        printHeader("test 2");
    }

    private void handleTest3()
    {
        printHeader("test 3");
    }

    private void handleTest4()
    {
        printHeader("test 4");
    }

    private void handleTest5()
    {
        printHeader("test 5");
    }

    //##################################################
    //# print
    //##################################################

    private void printHeader(String s)
    {
        String prefix = "-- " + s.toUpperCase() + " ";

        System.out.println();
        System.out.print(prefix);
        System.out.println(Kmu.dashes(80 - prefix.length()));
        System.out.println();
    }

    //##################################################
    //# support
    //##################################################

    @SuppressWarnings("unused")
    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
