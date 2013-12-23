package com.app.utility;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

import com.app.model.MySystemLog;
import com.app.model.MySystemLogTrace;

public class MyLog4jDaoAppender
    extends AppenderSkeleton
{
    //##################################################
    //# override
    //##################################################

    @Override
    protected void append(final LoggingEvent ev)
    {
        try
        {
            newCommand(ev).run();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
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

    private KmDaoCommand newCommand(final LoggingEvent ev)
    {
        return new KmDaoCommand()
        {
            @Override
            public void handle()
            {
                KmLog.disableThread();
                try
                {
                    save(ev);
                }
                finally
                {
                    KmLog.enableThread();
                }
            }
        };
    }

    private void save(final LoggingEvent ev)
    {
        String loggerName = ev.getLoggerName();
        String context = ev.getNDC();
        String levelName = ev.getLevel().toString();
        int levelCode = ev.getLevel().getSyslogEquivalent();
        String threadName = ev.getThreadName();
        String message = ev.getRenderedMessage();

        MySystemLog e;
        e = new MySystemLog();

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
                KmList<String> lines = Kmu.getLines(s);
                for ( String line : lines )
                {
                    MySystemLogTrace trace;
                    trace = new MySystemLogTrace();
                    trace.setValue(line);
                    trace.truncateValue();
                    e.addTrace(trace);
                }
            }
        }

        e.saveDao();
    }
}
