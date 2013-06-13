package com.kodemore.hibernate;

import org.apache.log4j.Level;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Hibernate supports optimistic locking, allowing the application to cleanly
 * manage multiple retries.  However, as of hibernate 3.3.2, the Stale Object
 * exception is logged as an ERROR level problem.  To avoid this causing
 * false alarms, this filter can be added to log4j.  The log event is only
 * filtered if all of the following conditions are true:
 *      level = ERROR
 *      logger = org.hibernate.event.def.AbstractFlushingEventListener
 *      message = Could not synchronize database state with session
 *      throwable prefix = org.hibernate.StaleObjectStateException:
 */
public class KmHibernateStaleObjectLogFilter
    extends Filter
{
    @Override
    public int decide(LoggingEvent e)
    {
        Level level = e.getLevel();
        if ( level != Level.ERROR )
            return NEUTRAL;

        String loggerName = e.getLoggerName();
        if ( !loggerName.equals("org.hibernate.event.def.AbstractFlushingEventListener") )
            return NEUTRAL;

        String message = e.getRenderedMessage();
        if ( !message.equals("Could not synchronize database state with session") )
            return NEUTRAL;

        String[] lines = e.getThrowableStrRep();
        if ( lines == null )
            return NEUTRAL;

        if ( lines.length == 0 )
            return NEUTRAL;

        String line = lines[0];
        if ( line == null )
            return NEUTRAL;

        if ( !line.startsWith("org.hibernate.StaleObjectStateException:") )
            return NEUTRAL;

        return DENY;
    }
}
