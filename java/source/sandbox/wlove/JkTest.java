package sandbox.wlove;

import com.app.utility.MyInstaller;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("--------------------");
        new JkTest().run();
        System.out.println("--------------------");
        System.out.println("ok.");
    }

    private void run()
    {
        System.out.println("hello");
        MyInstaller.installCore();
    }

}
