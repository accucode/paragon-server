package com.app.email;

import com.kodemore.email.method.KmEmailSmtpMethod;
import com.kodemore.log.KmLog;

import com.app.property.MyProperties;
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
        MyProperties p = MyGlobals.getProperties();

        setSmtpScheme(p.getSmtpScheme());
        setSmtpHost(p.getSmtpHost());
        setSmtpPort(p.getSmtpPort());
        setSmtpUser(p.getSmtpUser());
        setSmtpPassword(p.getSmtpPassword());
        setSmtpSsl(p.getSmtpUseSsl());

        KmLog.info("Create Smtp Method...");
        KmLog.info("scheme(%s)", p.getSmtpScheme());
        KmLog.info("host(%s)", p.getSmtpHost());
        KmLog.info("port(%s)", p.getSmtpPort());
        KmLog.info("user(%s)", p.getSmtpUser());
        KmLog.info("password(%s)", p.getSmtpPassword());
        KmLog.info("ssl(%s)", p.getSmtpUseSsl());
    }
}
