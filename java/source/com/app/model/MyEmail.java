package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyEmailBase;
import com.app.model.base.MyEmailPartType;
import com.app.model.core.MySystemDomainIF;

public class MyEmail
    extends MyEmailBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmail()
    {
        super();
    }

    //##################################################
    //# recipients
    //##################################################

    public void addToRecipients(KmList<String> v)
    {
        for ( String e : v )
            addToRecipient(e);
    }

    public void addToRecipient(String addr)
    {
        MyEmailRecipient e;
        e = new MyEmailRecipient();
        e.setTypeTo();
        e.setAddress(addr);
        addRecipient(e);
    }

    public KmCollection<String> getToAddresses()
    {
        KmCollection<MyEmailRecipient> tos = getRecipients().select(e -> e.isTypeTo());
        return tos.collect(e -> e.getAddress());
    }

    public void addCcRecipients(KmList<String> v)
    {
        for ( String e : v )
            addCcRecipient(e);
    }

    public void addCcRecipient(String addr)
    {
        MyEmailRecipient e;
        e = new MyEmailRecipient();
        e.setTypeCc();
        e.setAddress(addr);
        addRecipient(e);
    }

    public KmCollection<String> getCcAddresses()
    {
        return getRecipients().select(e -> e.isTypeCc()).collect(e -> e.getAddress());
    }

    @Override
    public String getRecipientSummary()
    {
        KmCollection<String> v = getToAddresses();
        String s = v.join();
        return Kmu.truncate(s, 30, true);
    }

    @Override
    public String getToAddressesLabel()
    {
        return getToAddresses().join();
    }

    @Override
    public String getCcAddressesLabel()
    {
        return getCcAddresses().join();
    }

    //##################################################
    //# parts
    //##################################################

    public void addTextPart(String text)
    {
        MyEmailPart e;
        e = addPart();
        e.setTypeText();
        e.setData(text);
    }

    public void addHtmlPart(String html)
    {
        boolean replaceParagraphs = false;
        addHtmlPart(html, replaceParagraphs);
    }

    public void addHtmlPart(String html, boolean replaceParagraphs)
    {
        if ( replaceParagraphs )
            html = replaceParagraphs(html);

        MyEmailPart e;
        e = addPart();
        e.setTypeHtml();
        e.setData(html);
    }

    private String replaceParagraphs(String html)
    {
        html = Kmu.replaceAll(html, "<p>", "");
        html = Kmu.replaceAll(html, "</p>", "<br>");
        return html;
    }

    public void addAttachmentPart(String data, String name)
    {
        addAttachmentPart(data.getBytes(), name);
    }

    public void addAttachmentPart(byte[] data, String name)
    {
        MyEmailPart e;
        e = addPart();
        e.setTypeAttachment();
        e.setAttachmentName(name);
        e.setData(data);
    }

    //##################################################
    //# convenience
    //##################################################

    /**
     * Configure the email for sending.  It may not be sent immediately.
     */
    public void markReady()
    {
        setStatusReady();
        clearSentUtcTs();
        clearErrorNotes();
    }

    public void markPending()
    {
        setStatusPending();
        setSentUtcTs(nowUtc());
    }

    public void markSent()
    {
        setStatusSent();
    }

    public void markError(String msg)
    {
        setStatusError();
        setErrorNotes(msg);
        truncateErrorNotes();
    }

    public void markError(Exception ex)
    {
        markError(ex.getMessage());
    }

    public void markIgnored()
    {
        setStatusIgnored();
    }

    @Override
    public String getPartsAsHtml()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        KmList<MyEmailPart> parts = getSortedParts();
        for ( MyEmailPart e : parts )
        {
            out.printBold("Part " + e.getSequence());
            out.printfln(" (%s)", e.getTypeName());
            out.println(e.getUid());

            MyEmailPartType type = e.getType();
            switch ( type )
            {
                case Attachment:
                    out.println(e.getAttachmentName());
                    break;

                case Html:
                    out.printLiteral(e.getData().getStringValue());
                    break;

                case Text:
                    out.println(e.getData().getStringValue());
                    break;
            }
        }

        return out.toString();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getSubject();
    }
}
