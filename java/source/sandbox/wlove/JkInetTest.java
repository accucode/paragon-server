package sandbox.wlove;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.kodemore.utility.Kmu;

public class JkInetTest
{
    public static void main(String[] args)
    {
        new JkInetTest().run();
    }

    private void run()
    {
        try
        {
            InetAddress a;

            a = InetAddress.getLocalHost();
            print("getLocalHost", a);

            a = InetAddress.getByAddress(new byte[]
            {
                127,
                0,
                0,
                1
            });
            print("getByAddress(127.0.0.1)", a);

            a = InetAddress.getByName("localhost");
            print("getByName(localhost)", a);

            InetAddress[] all = InetAddress.getAllByName("localhost");
            for ( InetAddress e : all )
                print("getAllByName(localhost)", e);
        }
        catch ( UnknownHostException ex )
        {
            throw Kmu.toRuntime(ex);
        }

    }

    private void print(String msg, InetAddress e)
    {
        System.out.println();
        System.out.println(msg);
        System.out.println("    " + e.getHostAddress());
        System.out.println("    " + e.getHostName());
        System.out.println("    " + e.getCanonicalHostName());
    }
}
