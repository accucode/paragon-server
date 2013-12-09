package com.app.email;

import com.app.property.*;
import com.app.utility.*;
import com.kodemore.email.method.*;

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
