package sandbox.wlove;

import com.app.dao.base.MyDaoRegistry;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;

public class JkHqlTest
{
    public static void main(String[] args)
    {
        new JkHqlTest().run();
    }

    private void run()
    {
        MyInstaller.installDatabase();
        new HqlCommand().run();
    }

    private class HqlCommand
        extends KmDaoCommand
    {
        @Override
        public void handle()
        {
            String s = "select count(*) from MyUser";

            System.out.println("Hql Test");
            System.out.println("    hql: " + s);

            KmList<Object> v = getAccess().getUserDao().runHql(s);
            System.out.println("    v.size(): " + v.size());
            for ( Object e : v )
                System.out.println("e: " + e);
        }
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
