package com.kodemore.time;

import com.kodemore.utility.KmCodedEnumIF;

public interface KmTimeZoneIF
    extends KmCodedEnumIF
{
    //##################################################
    //# constants
    //##################################################

    // fixme_wyatt: timezone
    KmTimeZoneIF UTC    = null;
    KmTimeZoneIF DENVER = null;

    //##################################################
    //# conversion
    //##################################################

    KmTimestamp toLocal(KmTimestamp utc);

    KmTimestamp toUtc(KmTimestamp local);
}
