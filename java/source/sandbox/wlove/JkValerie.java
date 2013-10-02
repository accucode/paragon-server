package sandbox.wlove;

import com.kodemore.http.KmHttpGet;
import com.kodemore.http.KmHttpRequest;

public class JkValerie
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkValerie().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmHttpRequest e;
        e = new KmHttpGet();
        e.setHost("graph.facebook.com");
        e.setPort(80);
        e.setPath("1608414795");
        e.setContentType("text/html");
        e.submit();
        System.out.println("------------------------------------------------------------");
        if ( e.hasException() )
        {
            System.out.println("url:   " + e.getUrl());
            System.out.println("error: " + e.getException());
            return;
        }
        System.out.println("url:              " + e.getUrl());
        System.out.println("response code:    " + e.getResponseCode());
        System.out.println("response message: " + e.getResponseMessage());
        System.out.println(e.getResponseString());
    }
}
