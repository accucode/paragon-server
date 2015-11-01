package sandbox.wlove;

import java.time.ZoneId;
import java.util.Set;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("--------------------");
        new JkTest().run();
        System.out.println("--------------------");
        System.out.println("ok.");
    }

    private void run()
    {
        int n = 0;
        Set<String> ids = ZoneId.getAvailableZoneIds();
        for ( String id : ids )
            n = Math.max(n, id.length());

        System.out.println(n);
    }

}
