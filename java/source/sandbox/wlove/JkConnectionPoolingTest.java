package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmRandomUtility;
import com.kodemore.utility.Kmu;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.utility.MyInstaller;

@SuppressWarnings("unused")
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

    private static void test()
    {
        System.out.println("test.1");
        findUsers();
        sleepRandom(20000);
        System.out.println("test.2");
        findUsers();
        System.out.println("test.ok");
    }

    private static void startThread(final int ms)
    {
        newThread(ms).start();
    }

    private static Thread newThread(final int ms)
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
        Kmu.sleep(KmRandomUtility.getInteger(ms));
    }
}
