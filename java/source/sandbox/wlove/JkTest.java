package sandbox.wlove;

public final class JkTest
    extends JkAbstractTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
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
        print("hello");
    }
}
