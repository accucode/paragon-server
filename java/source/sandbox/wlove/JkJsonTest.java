package sandbox.wlove;

import com.kodemore.json.KmJsonList;
import com.kodemore.json.KmJsonObject;
import com.kodemore.json.KmJsonUtility;

public class JkJsonTest
{
    public static void main(String[] args)
    {
        new JkJsonTest().run();
    }

    public void run()
    {
        KmJsonObject e;
        e = new KmJsonObject();
        e.setString("name", "foo");
        e.setInteger("num", 100);
        e.setDouble("balance", 1000.21);
        e.setBoolean("isVip", true);
        e.setNull("nickname");

        KmJsonList v;
        v = e.setList("list");
        v.addBoolean(true);
        v.addInteger(1);
        v.addDouble(2.3);

        System.out.print(e);

        System.out.println();
        System.out.println();

        System.out.println(KmJsonUtility.format(1.23));
    }

}
