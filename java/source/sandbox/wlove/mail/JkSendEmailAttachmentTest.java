package sandbox.wlove.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPSSLTransport;

import com.kodemore.time.KmTime;

public class JkSendEmailAttachmentTest
{
    private static final String TEXT         = "text/plain";

    private static final String OCTET_STREAM = "application/octet-stream";

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
        new JkSendEmailAttachmentTest().run();
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

            // kludge_wyatt: SUBJECT
            String name = KmTime.createNowLocal().format_hh24mmss() + ".csv";
            String subject = "Attachment: " + name;

            Properties p;
            p = new Properties();
            p.put("mail.mime.encodeeol.strict", "true");

            // kludge_wyatt:
            System.setProperty("mail.mime.encodeeol.strict", "true");

            Session session;
            session = Session.getInstance(p);
            session.setDebug(debug);

            Address to = new InternetAddress(toAddress, toName);
            Address from = new InternetAddress(fromAddress, fromName);

            MimeMultipart multipart;
            multipart = new MimeMultipart();

            MimeBodyPart textPart;
            textPart = new MimeBodyPart();
            textPart.setText("message text");
            multipart.addBodyPart(textPart);

            MimeBodyPart attachmentPart;
            attachmentPart = new MimeBodyPart();
            attachmentPart.setContent("a,b,c\r\nx,y,z\r\n", OCTET_STREAM);
            attachmentPart.setFileName(name);
            attachmentPart.setDisposition(Part.ATTACHMENT);
            attachmentPart.setHeader("Content-Transfer-Encoding", "base64");
            multipart.addBodyPart(attachmentPart);

            MimeMessage message;
            message = new MimeMessage(session);
            message.setSubject(subject);
            message.setContent(multipart, TEXT);
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
        catch ( IOException ex )
        {
            ex.printStackTrace();
        }
        catch ( MessagingException ex )
        {
            ex.printStackTrace();
        }
    }
}
