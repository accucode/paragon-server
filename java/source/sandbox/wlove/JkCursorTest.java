package sandbox.wlove;

import com.kodemore.command.KmDao;
import com.kodemore.dao.KmDaoStringKeyCursor;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.utility.MyInstaller;

public class JkCursorTest
{
    public static void main(String[] args)
    {
        new JkCursorTest().run();
    }

    private void run()
    {
        MyInstaller.installDatabase();
        KmDao.run(this::runDao);
    }

    protected void runDao()
    {
        MyMetaUser x = MyUser.Meta;
        KmDaoStringKeyCursor<MyUser> c = KmDaoStringKeyCursor.createOn(x.Uid);

        for ( MyUser e : c )
            System.out.println(e.getUid());
    }
}
