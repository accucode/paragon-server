package com.app.property;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEmailAddress;
import com.kodemore.utility.KmEmailAddressParser;

import com.app.property.base.MyPropertiesBase;

public class MyProperties
    extends MyPropertiesBase
{
    //##################################################
    //# environment
    //##################################################

    public boolean isEnvironmentDevelopment()
    {
        return getEnvironment().equals("development");
    }

    public boolean isEnvironmentStage()
    {
        return getEnvironment().equals("stage");
    }

    public boolean isEnvironmentProduction()
    {
        return getEnvironment().equals("production");
    }

    //##################################################
    //# developers
    //##################################################

    public KmList<String> getDeveloperEmails()
    {
        KmEmailAddressParser p;
        p = new KmEmailAddressParser();
        p.parse(getDeveloperEmailCsv());

        KmList<KmEmailAddress> v;
        v = p.getAllEmails();
        v.retainIf(e -> e.isValid());
        return v.collect(e -> e.format());
    }

}
