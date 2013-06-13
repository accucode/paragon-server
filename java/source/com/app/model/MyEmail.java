package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyEmailBase;
import com.app.model.meta.MyMetaEmailRecipient;

public class MyEmail
    extends MyEmailBase
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
        MyMetaEmailRecipient x = MyEmailRecipient.Meta;
        String code = MyEmailRecipientType.To.getCode();

        return getRecipients().select(x.TypeCode, code).collect(x.Address);
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
        MyMetaEmailRecipient x = MyEmailRecipient.Meta;
        String code = MyEmailRecipientType.Cc.getCode();

        return getRecipients().select(x.TypeCode, code).collect(x.Address);
    }

    @Override
    public String getRecipientSummary()
    {
        KmCollection<String> v = getToAddresses();
        String s = v.format(", ");
        return Kmu.truncate(s, 30, true);
    }

    @Override
    public String getToAddressesLabel()
    {
        return getToAddresses().format(", ");
    }

    @Override
    public String getCcAddressesLabel()
    {
        return getCcAddresses().format(", ");
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
        MyEmailPart e;
        e = addPart();
        e.setTypeHtml();
        e.setData(html);
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
        setSentUtcTs(getNowUtc());
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
}
