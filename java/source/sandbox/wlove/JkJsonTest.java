package sandbox.wlove;

import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonUtility;

public class JkJsonTest
{
    public static void main(String[] args)
    {
        new JkJsonTest().run();
    }

    public void run()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("name", "foo");
        e.setInteger("num", 100);
        e.setDouble("balance", 1000.21);
        e.setBoolean("isVip", true);
        e.setNull("nickname");

        KmJsonArray v;
        v = e.setArray("list");
        v.addBoolean(true);
        v.addInteger(1);
        v.addDouble(2.3);

        System.out.print(e);

        System.out.println();
        System.out.println();

        System.out.println(KmJsonUtility.format(1.23));
    }

}
