package com.app.email;

import com.kodemore.email.method.KmEmailSmtpMethod;

import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

/**
 * I extend the generic framework method to provide
 * default settings based on application specific properties.
 */
public class MyEmailGmailMethod
    extends KmEmailSmtpMethod
{
    public MyEmailGmailMethod()
    {
        MyPropertyRegistry p = MyGlobals.getProperties();

        setSmtpScheme(p.getGmailScheme());
        setSmtpHost(p.getGmailHost());
        setSmtpPort(p.getGmailPort());
        setSmtpUser(p.getGmailUser());
        setSmtpPassword(p.getGmailPassword());
    }
}
