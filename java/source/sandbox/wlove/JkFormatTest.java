package sandbox.wlove;

public class JkFormatTest
{
    public static void main(String[] args)
    {
        new JkFormatTest().run();
    }

    public void run()
    {
        System.out.printf("text: %,10d%n", 1);
        System.out.printf("text: %,10d%n", 12345);
        System.out.println();
        System.out.printf("text: %,10.3f%n", 1.23);
        System.out.printf("text: %,10.3f%n", 12345.2345);
    }

}
