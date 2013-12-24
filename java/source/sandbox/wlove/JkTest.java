package sandbox.wlove;

import com.kodemore.json.KmJsonMap;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("html", "aaa &copy; bbb");
        System.out.println(e);
    }
}
