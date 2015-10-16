package sandbox.wlove;

import com.kodemore.command.KmDaoRunnableCommand;

import com.app.install.MyResetDatabaseTool;
import com.app.tools.MySampleDataTool;
import com.app.utility.MyInstaller;

public class JkResetDataTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkResetDataTest().run();
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
        MyResetDatabaseTool.run();
        MySampleDataTool.run();
    }
}
