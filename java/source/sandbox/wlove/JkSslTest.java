package sandbox.wlove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import com.kodemore.utility.KmConstantsIF;

/**
 * https://goo.gl/eQfxx
 * https://goo.gl/4GEHb5
 */
public class JkSslTest
    implements KmConstantsIF
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        printLine();
        new JkSslTest().run();
        printLine();
        System.out.println("ok.");
    }

    private static void printLine()
    {
        System.out.println("--------------------");
    }

    //##################################################
    //# run
    //##################################################

    private void run() throws Exception
    {
        SSLSocketFactory factory;
        factory = (SSLSocketFactory)SSLSocketFactory.getDefault();

        URL url;
        url = new URL("https://www.microsoft.com/");
        url = new URL("https://www.example.com/");
        url = new URL("https://api.intacct.com/");

        HttpsURLConnection conn;
        conn = (HttpsURLConnection)url.openConnection();
        conn.setSSLSocketFactory(factory);

        try (BufferedReader r = toReader(conn))
        {
            while ( true )
            {
                String s = r.readLine();
                if ( s == null )
                    break;

                System.out.println(s);
            }
        }
    }

    private BufferedReader toReader(HttpsURLConnection conn) throws IOException
    {
        InputStream is = conn.getInputStream();
        InputStreamReader isReader = new InputStreamReader(is);
        return new BufferedReader(isReader);
    }

}
