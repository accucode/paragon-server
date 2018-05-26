package com.kodemore.meta;

import com.kodemore.utility.Kmu;

public abstract class KmMetaModel
{
    //##################################################
    //# accessing
    //##################################################

    public abstract String getName();

    public abstract String getHelp();

    public String getLabel()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(getName());
    }
}
