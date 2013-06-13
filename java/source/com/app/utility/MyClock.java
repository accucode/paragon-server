package com.app.utility;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmClock;

/**
 * I override the default clock, sacrificing a little bit
 * of precision in order to reduce overhead.  I rely on
 * MyClockJob to periodically update the time.
 */
public class MyClock
    extends KmClock
{
    //##################################################
    //# static
    //##################################################

    public static void install()
    {
        install(new MyClock());
    }

    public static void update()
    {
        ((MyClock)_instance)._update();
    }

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp _nowUtc;

    //##################################################
    //# constructor
    //##################################################

    protected MyClock()
    {
        _update();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected KmTimestamp _getNowUtc()
    {
        return _nowUtc;
    }

    //##################################################
    //# support
    //##################################################

    public void _update()
    {
        _nowUtc = _now();
    }

    private KmTimestamp _now()
    {
        return KmTimestamp.createNowUtc();
    }

}
