package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEnumIF;

public enum MyContactType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Main,

    Install,
    Requester,
    Sales,
    Scheduling,
    Technical,

    EffectiveInstall,
    EffectiveRequester,
    EffectiveSales,
    EffectiveScheduling,
    EffectiveTechnical;

    //##################################################
    //# static
    //##################################################

    public static KmList<MyContactType> getValues()
    {
        KmList<MyContactType> v;
        v = new KmList<>();
        v.addAll(values());
        return v;
    }
}
