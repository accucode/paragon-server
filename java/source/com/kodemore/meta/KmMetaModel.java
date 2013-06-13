package com.kodemore.meta;

import com.kodemore.utility.Kmu;

public abstract class KmMetaModel
{
    //##################################################
    //# accessing
    //##################################################

    public abstract String getName();

    public String getLabel()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(getName());
    }

}
