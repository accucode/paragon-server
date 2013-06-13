package sandbox.wlove;

import com.app.utility.MyGlobals;

public class JkPropertyTest
{
    public static void main(String[] args)
    {
        new JkPropertyTest().run();
    }

    private void run()
    {
        System.out.println("Loading System Properties...");
        MyGlobals.getProperties();
        System.out.println("ok");
    }

}
