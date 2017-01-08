/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.email.method;

import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPSSLTransport;
import com.sun.mail.smtp.SMTPTransport;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.email.KmEmailIF;
import com.kodemore.email.KmEmailPartIF;
import com.kodemore.email.KmEmailPartType;
import com.kodemore.email.KmEmailResult;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * I send an email via an smtp server.
 */
public class KmEmailSmtpMethod
    extends KmEmailMethod
{
    //##################################################
    //# constants
    //##################################################

    private static final String            MIME_TYPE_TEXT         = "text/plain";
    private static final String            MIME_TYPE_OCTET_STREAM = "application/octet-stream";

    //##################################################
    //# variables
    //##################################################

    private String                         _smtpScheme;
    private boolean                        _smtpSsl;
    private String                         _smtpHost;
    private int                            _smtpPort;
    private String                         _smtpUser;
    private String                         _smtpPassword;
    private String                         _smtpAutoBcc;

    private KmList<KmEmailIF>              _emails;
    private KmMap<KmEmailIF,KmEmailResult> _results;

    private KmMap<KmEmailIF,MimeMessage>   _messages;

    private Properties                     _properties;
    private Session                        _session;
    private Transport                      _transport;

    //##################################################
    //# setup
    //##################################################

    public String getSmtpScheme()
    {
        return _smtpScheme;
    }

    public void setSmtpScheme(String e)
    {
        _smtpScheme = e;
    }

    public boolean getSmtpSsl()
    {
        return _smtpSsl;
    }

    public void setSmtpSsl(boolean e)
    {
        _smtpSsl = e;
    }

    public String getSmtpHost()
    {
        return _smtpHost;
    }

    public void setSmtpHost(String e)
    {
        _smtpHost = e;
    }

    public int getSmtpPort()
    {
        return _smtpPort;
    }

    public void setSmtpPort(int e)
    {
        _smtpPort = e;
    }

    public String getSmtpUser()
    {
        return _smtpUser;
    }

    public void setSmtpUser(String e)
    {
        _smtpUser = e;
    }

    public String getSmtpPassword()
    {
        return _smtpPassword;
    }

    public void setSmtpPassword(String e)
    {
        _smtpPassword = e;
    }

    public String getSmtpAutoBcc()
    {
        return _smtpAutoBcc;
    }

    public void setSmtpAutoBcc(String e)
    {
        _smtpAutoBcc = e;
    }

    //##################################################
    //# send
    //##################################################

    @Override
    public KmList<KmEmailResult> send(List<KmEmailIF> v)
    {
        _emails = new KmList<>();
        _emails.addAll(v);

        run();

        return _results.getValues();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        installResults();
        if ( _results.isEmpty() )
            return;

        if ( !installSession() )
            return;

        if ( !installMessages() )
            return;

        transport();
    }

    private void installResults()
    {
        _results = new KmMap<>();
        for ( KmEmailIF email : _emails )
            _results.put(email, okResult(email));
    }

    private boolean installSession()
    {
        try
        {
            _properties = new Properties();
            _session = Session.getInstance(_properties);
            return true;
        }
        catch ( Exception ex )
        {
            setAllErrors(ex);
            return false;
        }
    }

    //##################################################
    //# install messages
    //##################################################

    private boolean installMessages()
    {
        _messages = new KmMap<>();

        for ( KmEmailIF e : _emails )
            if ( _results.get(e).isOk() )
                installMessage(e);

        return _messages.isNotEmpty();
    }

    private void installMessage(KmEmailIF email)
    {
        try
        {
            MimeMessage msg = composeMessage(email);
            _messages.put(email, msg);
        }
        catch ( Exception ex )
        {
            setError(email, ex);
        }
    }

    private MimeMessage composeMessage(KmEmailIF email) throws Exception
    {
        List<KmEmailPartIF> parts = email.getParts();

        if ( parts.isEmpty() )
            throw Kmu.newFatal("No parts to send.");

        if ( parts.size() == 1 )
            return composeSinglePart(email);

        return composeMultiPart(email);
    }

    //##################################################
    //# single-part
    //##################################################

    private MimeMessage composeSinglePart(KmEmailIF email) throws Exception
    {
        KmEmailPartIF part = email.getParts().get(0);

        KmEmailPartType type = part.getType();
        switch ( type )
        {
            case Text:
                String text = new String(part.getData());
                return createTextMessage(email, text);

            case Html:
                String html = new String(part.getData());
                return createHtmlMessage(email, html);

            case Attachment:
                MimeMultipart multipart = new MimeMultipart();
                addTextTo(multipart, "See attachment.");
                addAttachmentTo(multipart, part);
                return createMessage(email, multipart);
        }

        return null;
    }

    //##################################################
    //# multi-part
    //##################################################

    private MimeMessage composeMultiPart(KmEmailIF email) throws Exception
    {
        MimeMultipart multipart = new MimeMultipart();

        List<KmEmailPartIF> parts = email.getParts();
        for ( KmEmailPartIF part : parts )
            composeMultiPart(multipart, part);

        return createMessage(email, multipart);
    }

    private void composeMultiPart(MimeMultipart multipart, KmEmailPartIF part) throws Exception
    {
        KmEmailPartType type = part.getType();
        switch ( type )
        {
            case Text:
                addTextTo(multipart, part);
                break;

            case Html:
                addHtmlTo(multipart, part);
                break;

            case Attachment:
                addAttachmentTo(multipart, part);
                break;
        }
    }

    private void addTextTo(MimeMultipart multipart, KmEmailPartIF part) throws Exception
    {
        byte[] arr = part.getData();
        String text = new String(arr);
        addTextTo(multipart, text);
    }

    private void addTextTo(MimeMultipart multipart, String text) throws Exception
    {
        MimeBodyPart e;
        e = new MimeBodyPart();
        e.setText(text);
        multipart.addBodyPart(e);
    }

    private void addHtmlTo(MimeMultipart multipart, KmEmailPartIF part) throws Exception
    {
        byte[] arr = part.getData();
        String text = new String(arr);
        addHtmlTo(multipart, text);
    }

    private void addHtmlTo(MimeMultipart multipart, String text) throws Exception
    {
        MimeBodyPart e;
        e = new MimeBodyPart();
        e.setContent(text, "text/html");
        multipart.addBodyPart(e);
    }

    private void addAttachmentTo(MimeMultipart multipart, KmEmailPartIF part) throws Exception
    {
        byte[] attachment = part.getData();
        String attachmentName = part.getAttachmentName();
        addAttachmentTo(multipart, attachment, attachmentName);
    }

    private void addAttachmentTo(MimeMultipart multipart, byte[] attachment, String attachmentName)
        throws Exception
    {
        MimeBodyPart e;
        e = new MimeBodyPart();
        e.setContent(attachment, MIME_TYPE_OCTET_STREAM);
        e.setFileName(attachmentName);
        e.setDisposition(Part.ATTACHMENT);
        e.setHeader("Content-Transfer-Encoding", "base64");
        multipart.addBodyPart(e);
    }

    //##################################################
    //# create message
    //##################################################

    private MimeMessage createTextMessage(KmEmailIF email, String text) throws Exception
    {
        MimeMessage msg;
        msg = newMessage(email);
        msg.setText(text);
        msg.saveChanges();
        return msg;
    }

    private MimeMessage createHtmlMessage(KmEmailIF email, String text) throws Exception
    {
        MimeMessage msg;
        msg = newMessage(email);
        msg.setContent(text, "text/html");
        msg.saveChanges();
        return msg;
    }

    private MimeMessage createMessage(KmEmailIF email, MimeMultipart multipart) throws Exception
    {
        MimeMessage msg;
        msg = newMessage(email);
        msg.setContent(multipart, MIME_TYPE_TEXT);
        msg.saveChanges();
        return msg;
    }

    private MimeMessage newMessage(KmEmailIF email) throws Exception
    {
        MimeMessage msg;
        msg = new MimeMessage(_session);
        msg.setSubject(email.getSubject());

        InternetAddress from = new InternetAddress(email.getFrom());
        msg.setFrom(from);

        for ( String e : email.getToList() )
            msg.addRecipient(Message.RecipientType.TO, newAddress(e));

        for ( String e : email.getCcList() )
            msg.addRecipient(Message.RecipientType.CC, newAddress(e));

        String bcc = getSmtpAutoBcc();
        if ( Kmu.hasValue(bcc) )
            msg.addRecipient(Message.RecipientType.BCC, newAddress(bcc));

        return msg;
    }

    private InternetAddress newAddress(String e) throws Exception
    {
        return new InternetAddress(e);
    }

    //##################################################
    //# transport
    //##################################################

    private void transport()
    {
        if ( !transportOpen() )
            return;

        transportSend();
        transportClose();
    }

    private boolean transportOpen()
    {
        try
        {
            String file = null; // not used

            URLName urlName = new URLName(
                getSmtpScheme(),
                getSmtpHost(),
                getSmtpPort(),
                file,
                getSmtpUser(),
                getSmtpPassword());

            _transport = createTransport(urlName);
            _transport.connect();
            return true;
        }
        catch ( Exception ex )
        {
            setAllErrors(ex);
            return false;
        }
    }

    private Transport createTransport(URLName urlName)
    {
        if ( getSmtpSsl() )
            return new SMTPSSLTransport(_session, urlName);

        return new SMTPTransport(_session, urlName);
    }

    private void transportSend()
    {
        Set<Entry<KmEmailIF,MimeMessage>> set = _messages.entrySet();
        for ( Entry<KmEmailIF,MimeMessage> e : set )
        {
            KmEmailIF email = e.getKey();
            MimeMessage msg = e.getValue();
            transportSend(email, msg);
        }
    }

    private void transportSend(KmEmailIF email, MimeMessage msg)
    {
        try
        {
            transportSend(msg);
        }
        catch ( Exception ex )
        {
            setError(email, ex);
        }
    }

    private void transportSend(MimeMessage msg) throws Exception
    {
        _transport.sendMessage(msg, msg.getAllRecipients());
    }

    private void transportClose()
    {
        try
        {
            if ( _transport != null )
                _transport.close();
        }
        catch ( Exception ex )
        {
            KmLog.warn(ex, "Unable to close email transport");
        }
    }

    //##################################################
    //# support
    //##################################################

    private void setError(KmEmailIF email, Exception ex)
    {
        _results.get(email).setError(ex);
    }

    private void setAllErrors(Exception ex)
    {
        for ( KmEmailResult r : _results.values() )
            r.setError(ex);
    }
}
