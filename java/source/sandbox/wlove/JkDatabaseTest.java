package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.utility.KmTimer;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkDatabaseTest
    extends KmDaoCommand
{
    public static void main(String[] args)
    {
        KmTimer timer = KmTimer.run();
        MyInstaller.installDatabase();
        System.out.println("----------------------------------------");
        new JkDatabaseTest().run();
        System.out.println("----------------------------------------");
        timer.print();
        System.exit(0);
    }

    @Override
    protected void handle()
    {
        MyUser u = getAccess().findUserUid("root");
        System.out.println(u);

        KmList<String> v;
        v = u.getPets().toList();
        v.sort();
        System.out.printf("Pets: %s.\n", v.format());
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
