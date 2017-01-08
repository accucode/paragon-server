package sandbox.wlove.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;

import com.sun.mail.pop3.POP3SSLStore;

import com.kodemore.utility.Kmu;

public class JkRetrieveTest
{
    public static void main(String[] args)
    {
        new JkRetrieveTest().run();
    }

    private static final boolean DEBUG    = false;
    private static final boolean UPDATE   = false;

    private static final String  SCHEME   = "https";
    private static final String  HOST     = "smtp.gmail.com";
    private static final String  USER     = "velocityservice@gmail.com";
    private static final String  PASSWORD = "velocity123";
    private static final String  FILE     = null;                       // not used
    private static final int     PORT     = 995;

    private void run()
    {
        try
        {
            process();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    private void process() throws Exception
    {
        System.out.println("Searching for messages...");

        Properties p = new Properties();

        Session session;
        session = Session.getInstance(p);
        session.setDebug(DEBUG);

        URLName urlName = new URLName(SCHEME, HOST, PORT, FILE, USER, PASSWORD);

        Store store;
        store = new POP3SSLStore(session, urlName);
        store.connect();

        Folder folder;
        folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        Message messages[] = folder.getMessages();

        System.out.printf("Found %s messages.\n", messages.length);

        for ( Message message : messages )
            handleMessage(message);

        folder.close(UPDATE);
        store.close();
    }

    private void handleMessage(Message message) throws Exception
    {
        System.out.println();
        System.out.println("=====================================================================");

        System.out.println();
        System.out.println("Subject...");
        System.out.println("    " + message.getSubject());

        System.out.println();
        System.out.println("Sent...");
        System.out.println("    " + message.getSentDate());

        System.out.println();
        System.out.println("From...");
        Address[] froms = message.getFrom();
        for ( Address from : froms )
        {
            System.out.println("    " + from);
            System.out.println("    class:    " + from.getClass().getName());
            System.out.println("    type:     " + from.getType());
            if ( from instanceof InternetAddress )
            {
                InternetAddress iFrom = (InternetAddress)from;
                System.out.println("    address:  " + iFrom.getAddress());
                System.out.println("    personal: " + iFrom.getPersonal());
                System.out.println("    group:    " + iFrom.isGroup());
            }
        }

        System.out.println();
        System.out.println("Content Type...:");
        System.out.println("    " + message.getContentType());

        Object content = message.getContent();
        if ( content instanceof Multipart )
        {
            Multipart mm = (Multipart)content;

            System.out.println();
            System.out.println("Multipart...");

            int n = mm.getCount();
            for ( int i = 0; i < n; i++ )
            {
                System.out.println();
                System.out.println("Part(" + i + ")");
                Part part = mm.getBodyPart(i);
                handlePart(part);
            }
        }
        else
        {
            System.out.println();
            System.out.println("Non-multipart...");
            handlePart(message);
        }
    }

    private void handlePart(Part part) throws Exception
    {
        String disposition = part.getDisposition();

        System.out.println("Content Type:  " + part.getContentType());
        System.out.println("Content Class: " + part.getContent().getClass().getName());
        System.out.println("Disposition:   " + disposition);

        if ( handleAttachment(part) )
            return;

        if ( handleSimpleContent(part) )
            return;

        System.out.println("Unhandled part");
    }

    private boolean handleSimpleContent(Part part) throws Exception
    {
        if ( !isSimpleContent(part) )
            return false;

        System.out.println("Simple Content");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println((String)part.getContent());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        return true;
    }

    private boolean isSimpleContent(Part part) throws Exception
    {
        if ( Part.ATTACHMENT.equals(part.getDisposition()) )
            return false;

        if ( !(part.getContent() instanceof String) )
            return false;

        if ( part.isMimeType("text/plain") )
            return true;

        if ( part.isMimeType("text/html") )
            return true;

        return false;
    }

    private boolean handleAttachment(Part part) throws Exception
    {
        if ( !part.ATTACHMENT.equals(part.getDisposition()) )
            return false;

        System.out.println("Attachment");
        System.out.println("Filename: " + part.getFileName());

        byte[] arr = Kmu.readBytes(part);

        System.out.println("Bytes...");
        System.out.println(Kmu.formatHexString(arr, " "));

        return true;
    }
}
