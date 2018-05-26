package sandbox.wlove;

import com.kodemore.utility.Kmu;

public final class JkUidTest
    extends JkAbstractTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkUidTest().run();
    }

    //##################################################
    //# init
    //##################################################

    @Override
    protected void init()
    {
        setAutoInstall(false);
        setAutoTransaction(false);

        setShortErrors(false);
        setShowTimes(false);
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    protected void handle()
    {
        System.out.println(Kmu.newUid());
    }
}
