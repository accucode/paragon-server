package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class JkDuplicateFinderTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkDuplicateFinderTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmList<String> v = Kmu.readFileLines("C:/Temp/Code.txt");
        KmList<String> dups = v.getDuplicates();
        if ( dups.isEmpty() )
            System.out.println("no duplicates");
        else
            System.out.println(dups.join());
    }
}
