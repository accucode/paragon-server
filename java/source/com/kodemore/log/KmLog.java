package com.kodemore.log;

/**
 * See KmLogger.
 */
public class KmLog
{
    //##################################################
    //# constants
    //##################################################

    private static final KmLogger root = KmLogger.getRootLogger();

    //##################################################
    //# debug
    //##################################################

    public static void debug()
    {
        root.debug();
    }

    public static void debug(String msg)
    {
        root.debug(msg);
    }

    public static void debug(String msg, Object... args)
    {
        root.debug(msg, args);
    }

    public static void debug(Throwable ex, String msg)
    {
        root.debug(ex, msg);
    }

    public static void debug(Throwable ex, String msg, Object... args)
    {
        root.debug(ex, msg, args);
    }

    public static void debugTrace(String msg)
    {
        root.debugTrace(msg);
    }

    public static void debugTrace(String msg, Object... args)
    {
        root.debugTrace(msg, args);
    }

    public static boolean isDebugEnabled()
    {
        return root.isDebugEnabled();
    }

    //##################################################
    //# info
    //##################################################

    public static void info()
    {
        root.info();
    }

    public static void info(String msg)
    {
        root.info(msg);
    }

    public static void info(String msg, Object... args)
    {
        root.info(msg, args);
    }

    public static void info(Throwable ex, String msg)
    {
        root.info(ex, msg);
    }

    public static void info(Throwable ex, String msg, Object... args)
    {
        root.info(ex, msg, args);
    }

    public static void infoTrace(String msg)
    {
        root.infoTrace(msg);
    }

    public static void infoTrace(String msg, Object... args)
    {
        root.infoTrace(msg, args);
    }

    public static boolean isInfoEnabled()
    {
        return root.isInfoEnabled();
    }

    //##################################################
    //# warn
    //##################################################

    public static void warn()
    {
        root.warn();
    }

    public static void warn(String msg)
    {
        root.warn(msg);
    }

    public static void warn(String msg, Object... args)
    {
        root.warn(msg, args);
    }

    public static void warn(Throwable ex, String msg)
    {
        root.warn(ex, msg);
    }

    public static void warn(Throwable ex, String msg, Object... args)
    {
        root.warn(ex, msg, args);
    }

    public static void warnTrace(String msg)
    {
        root.warnTrace(msg);
    }

    public static void warnTrace(String msg, Object... args)
    {
        root.warnTrace(msg, args);
    }

    public static boolean isWarnEnabled()
    {
        return root.isWarnEnabled();
    }

    //##################################################
    //# error
    //##################################################

    public static void error()
    {
        root.error();
    }

    public static void error(String msg)
    {
        root.error(msg);
    }

    public static void error(String msg, Object... args)
    {
        root.error(msg, args);
    }

    public static void error(Throwable ex, String msg)
    {
        root.error(ex, msg);
    }

    public static void error(Throwable ex, String msg, Object... args)
    {
        root.error(ex, msg, args);
    }

    public static void errorTrace(String msg)
    {
        root.errorTrace(msg);
    }

    public static void errorTrace(String msg, Object... args)
    {
        root.errorTrace(msg, args);
    }

    public static boolean isErrorEnabled()
    {
        return root.isErrorEnabled();
    }

    //##################################################
    //# fatal
    //##################################################

    public static void fatal()
    {
        root.fatal();
    }

    public static void fatal(String msg)
    {
        root.fatal(msg);
    }

    public static void fatal(String msg, Object... args)
    {
        root.fatal(msg, args);
    }

    public static void fatal(Throwable ex)
    {
        root.fatal(ex);
    }

    public static void fatal(Throwable ex, String msg)
    {
        root.fatal(ex, msg);
    }

    public static void fatal(Throwable ex, String msg, Object... args)
    {
        root.fatal(ex, msg, args);
    }

    public static void fatalTrace(String msg)
    {
        root.fatalTrace(msg);
    }

    public static void fatalTrace(String msg, Object... args)
    {
        root.fatalTrace(msg, args);
    }

    public static boolean isFatalEnabled()
    {
        return root.isFatalEnabled();
    }

    //##################################################
    //# thread
    //##################################################

    public static void enableThread()
    {
        KmLogger.enableThread();
    }

    public static void disableThread()
    {
        KmLogger.disableThread();
    }
}
