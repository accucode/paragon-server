package com.kodemore.log;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * An example of how to create custom log4j filters.
 */
public class KmLogFilter
    extends Filter
{
    /**
     * Return one of:
     * NEUTRAL : defer
     * DENY    : do not log
     * ACCEPT  : log
     */
    @Override
    public int decide(LoggingEvent e)
    {
        return NEUTRAL;
    }
}
