package sandbox.wlove;

import com.kodemore.email.KmEmail;
import com.kodemore.email.method.KmEmailSmtpMethod;
import com.kodemore.utility.KmClock;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        String now = KmClock.getNowLocal().format_m_d_yyyy_hh_mm_ss();

        KmEmail e;
        e = new KmEmail();
        e.setFrom("noreply@test.com");
        e.setSubject("test " + now);
        e.addTo("wlove@accucode.com");
        e.addHtmlPart("hello");

        KmEmailSmtpMethod m;
        m = new KmEmailSmtpMethod();
        m.setSmtpSsl(false);
        m.setSmtpScheme("http");
        m.setSmtpHost("smtp.sendgrid.net");
        m.setSmtpPort(587);
        m.setSmtpUser("aoBarApp");
        m.setSmtpPassword("q8ndPsKMxpAkp3yv");
        m.send(e);

        System.out.println("ok.");
    }
}
