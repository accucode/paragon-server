package sandbox.wlove;

import com.kodemore.command.KmDaoCommand;
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

        newResetCommand().run();

        newTest1Command().run();
        newTest2Command().run();
        newTest3Command().run();
        newTest4Command().run();
        newTest5Command().run();

        printHeader("end");
    }

    //##################################################
    //# commands
    //##################################################

    private KmDaoCommand newResetCommand()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleReset();
            }
        };
    }

    private KmDaoCommand newTest1Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest1();
            }
        };
    }

    private KmDaoCommand newTest2Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest2();
            }
        };
    }

    private KmDaoCommand newTest3Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest3();
            }
        };
    }

    private KmDaoCommand newTest4Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest4();
            }
        };
    }

    private KmDaoCommand newTest5Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest5();
            }
        };
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
