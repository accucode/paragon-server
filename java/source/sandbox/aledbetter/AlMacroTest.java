package sandbox.aledbetter;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.macro.MyMacro;
import com.app.macro.MyMacroContextType;
import com.app.macro.MyMacroFetcher;
import com.app.macro.MyMacros;

public class AlMacroTest
{
    //##################################################
    //# run
    //##################################################

    private void run()
    {
        MyMacros.install();

        MyMacroContextType context = MyMacroContextType.Site;

        System.out.println(context.getLabel() + " Macros.");

        MyMacroFetcher f;
        f = new MyMacroFetcher();
        f.setContextType(context);

        KmList<MyMacro> v;
        v = f.findAll();
        for ( MyMacro e : v )
        {
            String s = Kmu.format("%s: %s", e.getName(), e.getToken());
            System.out.println(s);
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("========== START ==========");
        new AlMacroTest().run();
        System.out.println("==========  END  ==========");
    }
}
