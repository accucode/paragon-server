package sandbox.wlove;

import com.kodemore.servlet.field.ScFakeHtmlId;
import com.kodemore.servlet.script.ScRootScript;

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
        ScRootScript root;
        root = new ScRootScript();

        ScFakeHtmlId a = new ScFakeHtmlId("a", root);
        ScFakeHtmlId b = new ScFakeHtmlId("b", root);
        ScFakeHtmlId c = new ScFakeHtmlId("c", root);

        a.ajax().toggle().slide().defer();
        b.ajax().toggle().slide().defer();
        c.ajax().toggle().slide().defer();

        System.out.println(root.formatMultilineScript());
    }
}
