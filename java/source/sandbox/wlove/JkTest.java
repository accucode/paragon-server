package sandbox.wlove;

public class JkTest
{
    public static void main(String[] args)
    {
        new JkTest().run();
        System.out.println("ok.");
    }

    private void run()
    {
        Thing r = this::test;
        r.one();
    }

    private void test()
    {
        System.out.println("test");
    }

    //##################################################
    //# class
    //##################################################

    public interface Thing
    {
        default void one()
        {
            System.out.println("one");
            two();
        }

        public abstract void two();
    }
}
