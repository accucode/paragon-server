package sandbox.wlove.mail;

import java.security.Security;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JkPopTest
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
        new JkPopTest().run();
    }

    private void run()
    {
        try
        {
            boolean debug = true;

            String host = "smtp.gmail.com";
            String username = "velocityservice@gmail.com";
            String password = "velocity123";
            String port = "465";

            String toAddress = "wyattlove@gmail.com";
            String toName = "Wyatt Love";

            String fromAddress = "velocityService@gmail.com";
            String fromName = "Velocity Service";

            String subject = "hello";
            String content = "world";

            String sslFactoryClass = "javax.net.ssl.SSLSocketFactory";

            Security.setProperty(
                "ssl.SocketFactory.provider",
                DummySSLSocketFactory.class.getName());

            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Properties p;
            p = new Properties();
            p.setProperty("mail.pop3.socketFactory.class", sslFactoryClass);
            p.setProperty("mail.pop3.socketFactory.fallback", "false");
            p.setProperty("mail.pop3.port", port);
            p.setProperty("mail.pop3.socketFactory.port", port);

            Session session;
            session = Session.getInstance(p);
            session.setDebug(debug);

            Address to = new InternetAddress(toAddress, toName);
            Address from = new InternetAddress(fromAddress, fromName);

            MimeMessage message;
            message = new MimeMessage(session);
            message.setSubject(subject);
            message.setContent(content, "text/plain");
            message.setRecipient(Message.RecipientType.TO, to);
            message.setFrom(from);
            message.saveChanges();

            Transport transport;
            transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
