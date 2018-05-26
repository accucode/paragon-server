package com.app.utility;

import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.types.KmDayFrequency;

public interface MyDefaults
{
    //##################################################
    //# time zone
    //##################################################

    KmTimeZone TIME_ZONE = KmTimeZone.Mountain;

    //##################################################
    //# business hours
    //##################################################

    KmDayFrequency BUSINESS_DAYS       = KmDayFrequency.MONDAY_THROUGH_FRIDAY;
    KmTime         BUSINESS_START_TIME = KmTime.fromHour(9);
    KmTime         BUSINESS_END_TIME   = KmTime.fromHour(17);

}
