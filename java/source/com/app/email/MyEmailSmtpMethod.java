package com.app.email;

import com.kodemore.email.method.KmEmailSmtpMethod;

import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

/**
 * I extend the generic framework method to provide
 * default settings based on application specific properties.
 */
public class MyEmailSmtpMethod
    extends KmEmailSmtpMethod
{
    public MyEmailSmtpMethod()
    {
        MyPropertyRegistry p = MyGlobals.getProperties();

        setSmtpScheme(p.getSmtpScheme());
        setSmtpHost(p.getSmtpHost());
        setSmtpPort(p.getSmtpPort());
        setSmtpUser(p.getSmtpUser());
        setSmtpPassword(p.getSmtpPassword());
        setSmtpSsl(p.getSmtpUseSsl());
    }
}
