package sandbox.wlove;

import com.kodemore.phonetic.KmPhoneticEncoder;

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
        KmPhoneticEncoder e;
        e = new KmPhoneticEncoder();
        e.loadRulesFromResource("com/kodemore/phonetic/rules.txt");

        String s;
        s = e.encode("cookie", true);

        System.out.println(s);
    }
}
