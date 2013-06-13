package com.app.ui.monitor;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyMonitorServletData
    implements MyMonitorServletConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private HttpServletRequest  _request;
    private HttpServletResponse _response;
    private long                _startNanos;

    //##################################################
    //# constructor
    //##################################################

    public MyMonitorServletData(HttpServletRequest request, HttpServletResponse response)
    {
        _request = request;
        _response = response;
        _startNanos = getNanoTime();
    }

    //##################################################
    //# parameters
    //##################################################

    public String getParameter(String s)
    {
        return _request.getParameter(s);
    }

    public String getCommand()
    {
        return getParameter(PARAMETER_COMMAND);
    }

    public boolean hasCommand()
    {
        String s = getCommand();
        return s != null && s.length() > 0;
    }

    public boolean hasCommand(String a)
    {
        String b = getCommand();
        if ( a == null )
            return b == null;
        return a.equals(b);
    }

    public String getPassword()
    {
        return getParameter(PARAMETER_PASSWORD);
    }

    public boolean hasPassword(String a)
    {
        String b = getPassword();
        if ( a == null )
            return b == null;
        return a.equals(b);
    }

    //##################################################
    //# response
    //##################################################

    public void writeOk()
    {
        writeOk((String)null);
    }

    public void writeOk(String msg)
    {
        String s = "OK";
        if ( msg != null )
            s += ": " + msg;
        write(s);
    }

    public void writeOkSeconds()
    {
        long start = _startNanos;
        long end = getNanoTime();
        double seconds = (end - start) / 1000000000.0;
        writeOk(seconds);
    }

    public void writeOk(long i)
    {
        String s = i + "";
        writeOk(s);
    }

    public void writeOk(double d)
    {
        String s = new DecimalFormat("#.####################").format(d);
        writeOk(s);
    }

    public void writeError(String message)
    {
        write("ERROR: " + message);
    }

    public boolean isOpen()
    {
        return !_response.isCommitted();
    }

    private void write(String value)
    {
        try
        {
            _response.setContentType(CONTENT_TYPE);
            _response.getWriter().print(value);
            _response.flushBuffer();
        }
        catch ( IOException ex )
        {
            logError("Cannot write monitor response.", ex);
        }
    }

    private void logError(String message, Exception ex)
    {
        MyMonitorServletLog.logError(message, ex);
    }

    private long getNanoTime()
    {
        return System.nanoTime();
    }
}
