package sandbox.wlove;

import com.kodemore.command.KmDaoRunnableCommand;

import com.app.dao.base.MyDaoAccess;
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
        System.exit(0);
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        install();
        runCommand();
        print("ok.");
    }

    private void install()
    {
        MyInstaller.installDatabase();
        print("installed.");
        printDivider();
    }

    private void runCommand()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.disableWarningThresholdMs();
        cmd.setRunnable(this::handle);
        cmd.run();

        print("done.");
        printDivider();
    }

    //##################################################
    //# test
    //##################################################

    private void handle()
    {
        getAccess().getUserDao().findAll();
    }

    //##################################################
    //# print
    //##################################################

    private void printDivider()
    {
        print("----------------------------------------");
    }

    private void print(String s)
    {
        System.out.println(s);
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
