package sandbox.aledbetter;

import com.kodemore.command.KmDao;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public class AlDaoTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        new AlDaoTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmDao.run(this::test);
    }

    private void test()
    {
        int n = getAccess().getUserDao().getCount();
        System.out.println("Users = " + n);
        System.out.println("ok.");
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
