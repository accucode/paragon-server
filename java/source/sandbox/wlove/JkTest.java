package sandbox.wlove;

import com.kodemore.servlet.field.ScFakeHtmlId;

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
        ScFakeHtmlId fake;
        fake = new ScFakeHtmlId();
        fake.setId("sel");
        fake.ajax().show();
        fake.ajax().whenDone().focus();

        System.out.println(fake.ajax().formatMultilineScript());
    }
}
