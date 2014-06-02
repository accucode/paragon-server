package com.kodemore.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.log.KmLog;
import com.kodemore.monitor.KmDefaultMonitor;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.utility.KmNanoAccumulator;

public abstract class ScAbstractServlet<T extends ScServletData>
    extends HttpServlet
{
    //##################################################
    //# constants
    //##################################################

    private static final boolean           MONITOR_GET  = false;
    private static final boolean           MONITOR_POST = false;

    //##################################################
    //# accumulator (static)
    //##################################################

    private static final KmNanoAccumulator _accumulator = new KmNanoAccumulator();

    public static double resetAverageSeconds()
    {
        return _accumulator.resetAverageSeconds();
    }

    //##################################################
    //# get
    //##################################################

    @Override
    public final void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        long start = _accumulator.getNow();
        if ( MONITOR_GET )
            doGetMonitored(request, response);
        else
            _doGet(request, response);
        _accumulator.addSince(start);
    }

    private void doGetMonitored(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            System.out.println("\n");
            KmDefaultMonitor.enable();
            KmDefaultMonitor.reset();
            KmDefaultMonitor.enter("ScAbstractServlet.doGet");
            _doGet(request, response);
        }
        finally
        {
            KmDefaultMonitor.exit();
            KmDefaultMonitor.print();
        }
    }

    private void _doGet(HttpServletRequest request, HttpServletResponse response)
    {
        T data = newServletData(request, response);
        try
        {
            doGet();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unhandled Exception");
        }
        finally
        {
            cleanUp(data);
        }
    }

    protected abstract void doGet();

    //##################################################
    //# post
    //##################################################

    @Override
    public final void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        long start = _accumulator.getNow();
        if ( MONITOR_POST )
            doPostMonitored(request, response);
        else
            _doPost(request, response);
        _accumulator.addSince(start);
    }

    private void doPostMonitored(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            System.out.println("\n");
            KmDefaultMonitor.enable();
            KmDefaultMonitor.reset();
            KmDefaultMonitor.enter("ScAbstractServlet.doPost");
            _doPost(request, response);
        }
        finally
        {
            KmDefaultMonitor.exit();
            KmDefaultMonitor.print();
        }
    }

    private void _doPost(HttpServletRequest request, HttpServletResponse response)
    {
        T data = newServletData(request, response);
        try
        {
            doPost();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Unhandled Exception");
        }
        finally
        {
            cleanUp(data);
        }
    }

    protected abstract void doPost();

    //##################################################
    //# clean up
    //##################################################

    private void cleanUp(T data)
    {
        data.flushResult();
        data.releaseResources();

        if ( logsPerformance() )
            data.logServletPerformance();

        KmThreadLocalManager.clearDirtyLocals();
    }

    //##################################################
    //# data
    //##################################################

    protected abstract T newServletData(HttpServletRequest request, HttpServletResponse response);

    protected abstract T getData();

    //##################################################
    //# logging
    //##################################################

    protected boolean logsPerformance()
    {
        return true;
    }

    //##################################################
    //# ajax
    //##################################################

    protected ScBlockScript ajax()
    {
        return getData().ajax();
    }

}
