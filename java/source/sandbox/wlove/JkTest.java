package sandbox.wlove;

import com.kodemore.json.KmJsonObject;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    public void run()
    {
        KmJsonObject e;
        e = new KmJsonObject();
        e.setString("name", "bob/smith");
        System.out.println(e);
    }

}
