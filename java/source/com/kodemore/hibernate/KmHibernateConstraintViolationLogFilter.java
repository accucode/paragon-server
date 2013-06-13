package com.kodemore.hibernate;

import org.apache.log4j.Level;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * There are certain situations where database inserts can result in 
 * collisions on well known primary keys.  Although these are errors
 * and need to be thrown up the stack and exceptions; the problem is
 * that hibernate generates verbose stack traces.
 * 
 * While the application will almost certainly need to handle the
 * exception, it doesn't necessary warrant a verbose stack trace.
 * 
 * The event is only filtered if all of the following are true:
 *      level = ERROR
 *      logger = org.hibernate.event.def.AbstractFlushingEventListener
 *      message = Could not synchronize database state with session
 *      throwable prefix = org.hibernate.ConstraintViolationException
 */
public class KmHibernateConstraintViolationLogFilter
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

        if ( !line.startsWith("org.hibernate.ConstraintViolationException:") )
            return NEUTRAL;

        return DENY;
    }
}
