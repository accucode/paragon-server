package com.app.utility;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

import com.app.model.MyApplicationLog;
import com.app.model.MyApplicationLogTrace;

public class MyLog4jDaoAppender
    extends AppenderSkeleton
{
    //##################################################
    //# constants
    //##################################################

    private static final boolean ENABLED = false;

    //##################################################
    //# override
    //##################################################

    @Override
    protected void append(LoggingEvent ev)
    {
        try
        {
            if ( !ENABLED )
                return;

            KmLog.disableThread();
            KmDao.run(this::saveDao, ev);
        }
        catch ( Exception ex )
        {
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
    //# command
    //##################################################

    private void saveDao(LoggingEvent ev)
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

        ThrowableInformation ti = ev.getThrowableInformation();
        if ( ti != null )
        {
            e.setExceptionText(ti.getThrowable().toString());
            e.truncateExceptionText();

            for ( String s : ti.getThrowableStrRep() )
            {
                KmList<String> lines = Kmu.parseLines(s);
                for ( String line : lines )
                {
                    MyApplicationLogTrace trace;
                    trace = e.addTrace();
                    trace.setValue(line);
                    trace.truncateValue();
                }
            }
        }

        e.attachDao();
    }
}
