package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmConstantsIF;

public class JkTest
    implements KmConstantsIF
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        printLine();
        new JkTest().run();
        printLine();
        System.out.println("ok.");
    }

    private static void printLine()
    {
        System.out.println("--------------------");
    }

    private void run() throws Exception
    {
        KmList<Integer> a = KmList.createWith(1, 2, 3);
        KmList<Integer> b = KmList.createWith(3, 5, 5);
        System.out.println(a.getNotIn(b).join());
    }

}
