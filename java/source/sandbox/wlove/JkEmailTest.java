package sandbox.wlove;

import com.app.utility.MyInstaller;

import com.kodemore.email.KmEmail;
import com.kodemore.email.method.KmEmailMethod;
import com.kodemore.email.method.KmEmailNoopMethod;
import com.kodemore.email.method.KmEmailPrintMethod;
import com.kodemore.email.method.KmEmailSmtpMethod;
import com.kodemore.utility.KmTimer;

public class JkEmailTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        MyInstaller.installCore();

        new JkEmailTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmTimer t = KmTimer.run();
        System.out.println("Sending...");

        KmEmail e = getEmail();
        //        getNoopMethod().send(e);
        getPrintMethod().send(e);
        //        getGmailMethod().send(e);
        //        getSmtpMethod().send(e);

        System.out.println("Done.");
        t.print();
    }

    private KmEmail getEmail()
    {
        KmEmail e;
        e = new KmEmail();
        e.setKey("12345");
        e.addTo("wlove@accucode.com");
        e.setFrom("velocityservice@gmail.com");
        e.setSubject("gmail test");
        e.addPart().setText("gmail test message.");
        return e;
    }

    //##################################################
    //# methods
    //##################################################

    @SuppressWarnings("unused")
    private KmEmailMethod getNoopMethod()
    {
        return new KmEmailNoopMethod();
    }

    private KmEmailMethod getPrintMethod()
    {
        return new KmEmailPrintMethod();
    }

    @SuppressWarnings("unused")
    private KmEmailMethod getGmailMethod()
    {
        KmEmailSmtpMethod m;
        m = new KmEmailSmtpMethod();
        m.setSmtpScheme("https");
        m.setSmtpHost("smtp.gmail.com");
        m.setSmtpPort(465);
        m.setSmtpUser("velocityservice@gmail.com");
        m.setSmtpPassword("velocity123");
        return m;
    }

    @SuppressWarnings("unused")
    private KmEmailMethod getSmtpMethod()
    {
        KmEmailSmtpMethod m;
        m = new KmEmailSmtpMethod();
        m.setSmtpScheme("smtp");
        m.setSmtpHost("smtp");
        m.setSmtpPort(25);
        m.setSmtpUser(null);
        m.setSmtpPassword(null);
        return m;
    }

}
