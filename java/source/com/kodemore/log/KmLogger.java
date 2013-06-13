package com.kodemore.log;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * I wrap log4j, to provide convenience methods and insulation from
 * if/when we swap out the logging library.
 *
 * The levels we use and their intended usage.  Levels are listed in
 * order of increasing severity.
 *
 * DEBUG: Find-grained information used to debug an application.
 *        Debug is usually NOT enabled during development, and
 *        especially not in production.  Debug messages can be
 *        both prolific and expensive to generate.
 *        Example: the sql for every database statement executed.
 *
 * INFO:  Coarse-grained informational messages of the application's progress.
 *        This is the typical level that is enabled for normal development but
 *        is usually NOT enabled in production.  However, info can generally
 *        be left enabled in production on a case-by-case basis.
 *        Example: the time spent on each servlet request.
 *
 * WARN:  Potentially harmful situations.
 *        An early warning indicator that should be reviewed by development
 *        staff periodically. Warnings should be reviewed periodically.
 *        Chronic warnings should either be fixed, or downgraded to info logs.
 *        Warnings should be enabled in both development and production.
 *        Example: Servlet request took longer than 5 seconds to process.
 *
 * ERROR: Error events that allow the application to continue running.
 *        Errors should be reviewed daily during normal business hours.
 *        Example: Automated FTP failure.
 *
 * FATAL: Very severe error events that lead the application to abort.
 *        Fatals are primarily used to log all unhandled exceptions.
 *        Aside from unhandled exceptions, we generally cannot add fatal
 *        logging to the application unless we know where to put it, and if
 *        we know where to put it for a problem this severe, then we should
 *        take real effort to avoid the need for the fatal log in the first
 *        place. Fatals should be very rare and generally warrant immediate
 *        review (and possible response) during non-business hours.
 */
public class KmLogger
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmLogger getRootLogger()
    {
        return new KmLogger(Logger.getRootLogger());
    }

    public static KmLogger getLogger(Class<?> c)
    {
        return new KmLogger(Logger.getLogger(c));
    }

    public static KmLogger getLogger(Class<?> c, String suffix)
    {
        String prefix = c.getName();
        String name = prefix + "." + suffix;
        return getLogger(name);
    }

    public static KmLogger getLogger(String name)
    {
        return new KmLogger(Logger.getLogger(name));
    }

    //##################################################
    //# variables
    //##################################################

    private Logger _logger;

    //##################################################
    //# constructor
    //##################################################

    private KmLogger(Logger e)
    {
        _logger = e;
    }

    //##################################################
    //# debug
    //##################################################

    public void debug()
    {
        if ( isThreadEnabled() )
            _logger.debug("");
    }

    public void debug(String msg)
    {
        if ( isThreadEnabled() )
            _logger.debug(msg);
    }

    public void debug(String msg, Object... args)
    {
        if ( isDebugEnabled() )
            debug(format(msg, args));
    }

    public void debug(Throwable ex, String msg)
    {
        if ( isThreadEnabled() )
            _logger.debug(msg, ex);
    }

    public void debug(Throwable ex, String msg, Object... args)
    {
        if ( isDebugEnabled() )
            debug(ex, format(msg, args));
    }

    public void debugTrace(String msg)
    {
        if ( isDebugEnabled() )
            debug(newException(), msg);
    }

    public void debugTrace(String msg, Object... args)
    {
        if ( isDebugEnabled() )
            debug(newException(), format(msg, args));
    }

    public boolean isDebugEnabled()
    {
        return isEnabled(Level.DEBUG);
    }

    //##################################################
    //# info
    //##################################################

    public void info()
    {
        if ( isThreadEnabled() )
            _logger.info("");
    }

    public void info(String msg)
    {
        if ( isThreadEnabled() )
            _logger.info(msg);
    }

    public void info(String msg, Object... args)
    {
        if ( isInfoEnabled() )
            info(format(msg, args));
    }

    public void info(Throwable ex, String msg)
    {
        if ( isThreadEnabled() )
            _logger.info(msg, ex);
    }

    public void info(Throwable ex, String msg, Object... args)
    {
        if ( isInfoEnabled() )
            info(ex, format(msg, args));
    }

    public void infoTrace(String msg)
    {
        if ( isInfoEnabled() )
            info(newException(), msg);
    }

    public void infoTrace(String msg, Object... args)
    {
        if ( isInfoEnabled() )
            info(newException(), format(msg, args));
    }

    public boolean isInfoEnabled()
    {
        return isEnabled(Level.INFO);
    }

    //##################################################
    //# warn
    //##################################################

    public void warn()
    {
        if ( isThreadEnabled() )
            _logger.warn("");
    }

    public void warn(String msg)
    {
        if ( isThreadEnabled() )
            _logger.warn(msg);
    }

    public void warn(String msg, Object... args)
    {
        if ( isWarnEnabled() )
            warn(format(msg, args));
    }

    public void warn(Throwable ex, String msg)
    {
        if ( isThreadEnabled() )
            _logger.warn(msg, ex);
    }

    public void warn(Throwable ex, String msg, Object... args)
    {
        if ( isWarnEnabled() )
            warn(ex, format(msg, args));
    }

    public void warnTrace(String msg)
    {
        if ( isWarnEnabled() )
            warn(newException(), msg);
    }

    public void warnTrace(String msg, Object... args)
    {
        if ( isWarnEnabled() )
            warn(newException(), format(msg, args));
    }

    public boolean isWarnEnabled()
    {
        return isEnabled(Level.WARN);
    }

    //##################################################
    //# error
    //##################################################

    public void error()
    {
        if ( isThreadEnabled() )
            _logger.error("");
    }

    public void error(String msg)
    {
        if ( isThreadEnabled() )
            _logger.error(msg);
    }

    public void error(String msg, Object... args)
    {
        if ( isErrorEnabled() )
            error(format(msg, args));
    }

    public void error(Throwable ex, String msg)
    {
        if ( isThreadEnabled() )
            _logger.error(msg, ex);
    }

    public void error(Throwable ex, String msg, Object... args)
    {
        if ( isErrorEnabled() )
            error(ex, format(msg, args));
    }

    public void errorTrace(String msg)
    {
        if ( isErrorEnabled() )
            error(newException(), msg);
    }

    public void errorTrace(String msg, Object... args)
    {
        if ( isErrorEnabled() )
            error(newException(), format(msg, args));
    }

    public boolean isErrorEnabled()
    {
        return isEnabled(Level.ERROR);
    }

    //##################################################
    //# fatal
    //##################################################

    public void fatal()
    {
        if ( isThreadEnabled() )
            _logger.fatal("");
    }

    public void fatal(String msg)
    {
        if ( isThreadEnabled() )
            _logger.fatal(msg);
    }

    public void fatal(String msg, Object... args)
    {
        if ( isFatalEnabled() )
            fatal(format(msg, args));
    }

    public void fatal(Throwable ex)
    {
        fatal(ex, "");
    }

    public void fatal(Throwable ex, String msg)
    {
        if ( isThreadEnabled() )
            _logger.fatal(msg, ex);
    }

    public void fatal(Throwable ex, String msg, Object... args)
    {
        if ( isFatalEnabled() )
            fatal(ex, format(msg, args));
    }

    public void fatalTrace(String msg)
    {
        if ( isFatalEnabled() )
            fatal(newException(), msg);
    }

    public void fatalTrace(String msg, Object... args)
    {
        if ( isFatalEnabled() )
            fatal(newException(), format(msg, args));
    }

    public boolean isFatalEnabled()
    {
        return isEnabled(Level.ERROR);
    }

    //##################################################
    //# support
    //##################################################

    private boolean isEnabled(Level e)
    {
        return _logger != null && _logger.isEnabledFor(e);
    }

    private String format(String msg, Object... args)
    {
        if ( msg == null || args.length == 0 )
            return msg;

        return String.format(msg, args);
    }

    private Throwable newException()
    {
        try
        {
            throw new RuntimeException();
        }
        catch ( Exception ex )
        {
            return ex;
        }
    }

    //##################################################
    //# thread enablement
    //##################################################

    /**
     * Care must be taken to utilize the disable function correctly.
     * It should be carefully wrapped in a try/finally block.
     * disable(); try { ... } finally { enable...};  Generally
     * this should only be used by rare framework code that needs
     * to avoid unintended recursion.
     */
    private static final Set<Thread> _disabledThreads = Collections.synchronizedSet(new HashSet<Thread>());

    public static void disableThread()
    {
        _disabledThreads.add(Thread.currentThread());
    }

    public static void enableThread()
    {
        _disabledThreads.remove(Thread.currentThread());
    }

    public static boolean isThreadEnabled()
    {
        if ( _disabledThreads.isEmpty() )
            return true;

        return !_disabledThreads.contains(Thread.currentThread());
    }

}
