package sandbox.wlove;

import com.kodemore.http.KmHttpGet;
import com.kodemore.http.KmHttpRequest;

// review_valerie: simple page to receive public information
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
        e.setPath("oauth/access_token");
        // fixme_valerie: insert client id from dashboard
        e.setParameter("client_id", "");
        e.setParameter("redirect_uri", "http://www.accucode.com/");
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
