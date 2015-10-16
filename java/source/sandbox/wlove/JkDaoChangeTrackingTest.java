package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoRunnableCommand;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyFieldTest;
import com.app.model.MyProject;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkDaoChangeTrackingTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkDaoChangeTrackingTest().run();
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
        KmList<MyProject> projects;
        projects = getAccess().getProjectDao().findAll();
        projects.sortOn(e -> e.getName());

        //        MyProject p1 = projects.get(0);
        //        MyProject p2 = projects.get(1);

        //        MyUser root;
        //        root = getAccess().getUserDao().findEmail("root");

        MyFieldTest test;
        test = new MyFieldTest();
        test.setNameValue("bob");
        test.setIntegerValue(1);
        test.attachDao();

        //        test = getAccess().findFieldTestUid("6MU2D31-KGSXH5-J01HPX-9OL887");
        //        test.setMoneyTest(KmMoney.ZERO.add(5.25));
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
