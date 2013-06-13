package sandbox.wlove.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPSSLTransport;

public class JkSendTest
{
    /*
     * gmail settings
     *
     * incoming
     *      pop.gmail.com
     *      ssl: yes
     *      port: 995
     *
     * outgoing
     *      smtp.gmail.com
     *      authentication: yes
     *      ssl: yes
     *      port: 465
     *      account: velocityservice@gmail.com
     *      email:   velocityservice@gmail.com
     *      password: velocity123
     */
    public static void main(String[] args)
    {
        new JkSendTest().run();
    }

    private void run()
    {
        try
        {
            boolean debug = true;

            String scheme = "https";
            String host = "smtp.gmail.com";
            String user = "velocityservice@gmail.com";
            String password = "velocity123";
            String file = null; // not used
            int port = 465;

            String toAddress = "wyattlove@gmail.com";
            String toName = "Wyatt Love";

            String fromAddress = "velocityService@gmail.com";
            String fromName = "Velocity Service";

            String subject = "hello";
            String content = "world";

            Properties p;
            p = new Properties();

            Session session;
            session = Session.getInstance(p);
            session.setDebug(debug);

            Address to = new InternetAddress(toAddress, toName);
            Address from = new InternetAddress(fromAddress, fromName);

            MimeMessage message;
            message = new MimeMessage(session);
            message.setSubject(subject);
            message.setContent(content, "text/plain");
            message.addRecipient(Message.RecipientType.TO, to);
            message.setFrom(from);
            message.saveChanges();

            URLName urlName = new URLName(scheme, host, port, file, user, password);

            Transport transport;
            transport = new SMTPSSLTransport(session, urlName);
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
