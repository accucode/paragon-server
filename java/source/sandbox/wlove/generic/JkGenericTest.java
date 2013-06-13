package sandbox.wlove.generic;

public class JkGenericTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkGenericTest().run();
    }

    public void run()
    {
        JkGenericContainer<MyGenericPolicy> c;
        c = new JkGenericContainer<MyGenericPolicy>();
        c.getCss().jkMethod();

        // CANNOT do this...
        // c.getCss().MyMethod();

        c.getPolicy().getCss().myMethod();
    }

}
