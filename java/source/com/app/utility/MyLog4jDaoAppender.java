package com.app.utility;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

import com.app.chore.application.MyApplicationLogFlusherChore;
import com.app.model.MyApplicationLog;
import com.app.model.MyApplicationLogBuffer;

/**
 * For convenience, we echo Log4J messages to the database via
 * the applicationLog table.  Each time log4j logs a message
 * it forwards that message to our customer adapter MyLog4jDaoAppender.
 *
 * Messages are reported to the appender on a separate thread from
 * the main application.  This means that any persistence to the
 * database will run in a separate transaction from the application.
 * For casual logging this is considered acceptable, and we do NOT
 * require strict transactional consistency.
 *
 * Also messages are reported one at a time.  This means that inserting
 * them into the database can be relatively inefficient, since each insert
 * requires a separate transaction.  To reduce the performance penalty,
 * the applicationLogs are buffered in a queue, and periodically written
 * to the database from a background job.
 *
 * @see MyApplicationLogBuffer
 * @see MyApplicationLogFlusherChore
 */
public class MyLog4jDaoAppender
    extends AppenderSkeleton
{
    //##################################################
    //# override
    //##################################################

    @Override
    protected void append(LoggingEvent ev)
    {
        boolean enabled = MyGlobals.getProperties().getApplicationLogFlusherChoreEnabled();
        if ( !enabled )
            return;

        try
        {
            KmLog.disableThread();
            MyApplicationLog log = composeLog(ev);
            MyApplicationLogBuffer.push(log);
        }
        catch ( Exception ex )
        {
            // do NOT use log4j here.
            ex.printStackTrace();
        }
        finally
        {
            KmLog.enableThread();
        }
    }

    @Override
    public void close()
    {
        // none
    }

    @Override
    public boolean requiresLayout()
    {
        return false;
    }

    //##################################################
    //# support
    //##################################################

    private MyApplicationLog composeLog(LoggingEvent ev)
    {
        String loggerName = ev.getLoggerName();
        String context = ev.getNDC();
        String levelName = ev.getLevel().toString();
        int levelCode = ev.getLevel().getSyslogEquivalent();
        String threadName = ev.getThreadName();
        String message = ev.getRenderedMessage();

        MyApplicationLog e;
        e = new MyApplicationLog();

        e.setLoggerName(loggerName);
        e.truncateLoggerName();

        e.setContext(context);
        e.truncateContext();

        e.setLevelName(levelName);
        e.setLevelCode(levelCode);

        e.setThreadName(threadName);
        e.truncateThreadName();

        e.setMessage(message);
        e.truncateMessage();

        e.setTrace(formatTrace(ev));
        e.truncateTrace();
        return e;
    }

    private String formatTrace(LoggingEvent ev)
    {
        ThrowableInformation ti = ev.getThrowableInformation();
        return ti == null
            ? null
            : Kmu.joinLines(ti.getThrowableStrRep());
    }
}
