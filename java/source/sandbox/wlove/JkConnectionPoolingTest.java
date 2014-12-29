package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.Kmu;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.utility.MyInstaller;

public class JkConnectionPoolingTest
{
    public static void main(String[] args)
    {
        MyInstaller.installDatabase();

        startThread(100);
        startThread(100);
        startThread(1000);
        startThread(10000);
        startThread(100000);
    }

    public static void test()
    {
        System.out.println("test.1");
        findUsers();
        sleepRandom(20000);
        System.out.println("test.2");
        findUsers();
        System.out.println("test.ok");
    }

    public static void startThread(final int ms)
    {
        newThread(ms).start();
    }

    public static Thread newThread(final int ms)
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                while ( true )
                {
                    System.out.println(ms);
                    findUsers();
                    sleepRandom(ms);
                }
            }
        };
    }

    //##################################################
    //# support
    //##################################################

    private static KmList<MyUser> findUsers()
    {
        return new MyUserFilter().toDaoFilter().findAll();
    }

    private static void sleepRandom(int ms)
    {
        Kmu.sleepMs(KmRandom.getInstance().getInteger(ms));
    }
}
