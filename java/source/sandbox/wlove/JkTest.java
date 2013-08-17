package sandbox.wlove;

import com.kodemore.servlet.field.ScFakeHtmlId;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.utility.Kmu;

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
        int n;

        ScRootScript root;
        root = new ScRootScript();

        // remove_wyatt: print
        n = root.getStack().size();

        System.out.println("init: " + n);

        ScFakeHtmlId a = new ScFakeHtmlId("a", root);
        //        ScFakeHtmlId b = new ScFakeHtmlId("b", root);

        root.run(Kmu.dashes());

        System.out.println("b: " + n);

        a.ajax().toggle().slide().defer();

        System.out.println("c: " + n);

        //        root.run("after a");
        //
        //        // fails
        //        b.ajax().toggle().slide().defer();
        //
        //        // ok
        //        //        root.toggle(b).slide().defer();
        //        root.run("after b");

        System.out.println(root.formatMultilineScript());
    }
}
