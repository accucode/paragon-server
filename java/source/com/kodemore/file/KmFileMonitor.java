/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.file;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.thread.KmThread;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

/**
 * I am used to monitor changes to files in a folder and
 * its sub-folders.
 */
public class KmFileMonitor
{
    //##################################################
    //# main
    //##################################################

    /**
     * This "main" method serves as an example of common usage.
     * Clients will typically implement a more interesting handler.
     */
    public static void main(String[] args)
    {
        KmFileMonitorHandler h = new KmFileMonitorHandler()
        {
            @Override
            public void handleChange(KmFile f)
            {
                KmLog.info(f.getPath());
            }
        };

        KmFileMonitor f;
        f = new KmFileMonitor();
        f.addRoot("someFilePath", "css");
        f.setHandler(h);
        f.setLogScan(true);
        f.start();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The roots to scan.  You need to specify at least one.
     */
    private KmList<KmFileMonitorRoot> _roots;

    /**
     * The list of known files, along with their last modified
     * timestamp (as an ordinal value).
     */
    private KmMap<KmFile,Long> _files;

    /**
     * The handler responsible for performing a custom action
     * any time a file is added or changed.
     */
    private KmFileMonitorHandler _handler;

    /**
     * The background thread that is responsible for scanning
     * for file changes.
     */
    private KmThread _thread;

    /**
     * The frequency at which we scan for modified files.
     */
    private int _modifiedScanFrequencySeconds;

    /**
     * The frequency at which we scan for new files.
     */
    private int _newScanFrequencySeconds;

    /**
     * If true, print a brief log message each time the scan
     * process completes.
     */
    private boolean _logScan;

    private KmTimestamp _lastNewScanTs;
    private KmTimestamp _lastModifiedScanTs;

    //##################################################
    //# constructor
    //##################################################

    public KmFileMonitor()
    {
        _roots = new KmList<>();
        _newScanFrequencySeconds = 5;
        _modifiedScanFrequencySeconds = 1;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<KmFileMonitorRoot> getRoots()
    {
        return _roots;
    }

    public KmFileMonitorRoot addRoot()
    {
        KmFileMonitorRoot e;
        e = new KmFileMonitorRoot();

        addRoot(e);

        return e;
    }

    public void addRoot(KmFileMonitorRoot e)
    {
        _roots.add(e);
    }

    public KmFileMonitorRoot addRoot(String path, String ext)
    {
        KmFileMonitorRoot e;
        e = addRoot();
        e.setFile(path);
        e.setExtension(ext);
        return e;
    }

    public KmFileMonitorHandler getHandler()
    {
        return _handler;
    }

    public void setHandler(KmFileMonitorHandler e)
    {
        _handler = e;
    }

    public int getNewScanFrequencySeconds()
    {
        return _newScanFrequencySeconds;
    }

    public void setNewScanFrequencySeconds(int e)
    {
        _newScanFrequencySeconds = e;
    }

    public int getModifiedScanFrequencySeconds()
    {
        return _modifiedScanFrequencySeconds;
    }

    public void setModifiedScanFrequencySeconds(int e)
    {
        _modifiedScanFrequencySeconds = e;
    }

    public boolean getLogScan()
    {
        return _logScan;
    }

    public void setLogScan(boolean e)
    {
        _logScan = e;
    }

    //##################################################
    //# run
    //##################################################

    public void start()
    {
        initializeFiles();

        KmTimestamp now = getNowUtc();

        _lastNewScanTs = now;
        _lastModifiedScanTs = now;

        _thread = newThread();
        _thread.start();
    }

    public void stop()
    {
        _thread.requestStopAndWait();
        _thread = null;
    }

    //##################################################
    //# support
    //##################################################

    private KmTimestamp getNowUtc()
    {
        return KmTimestamp.nowUtc();
    }

    private KmThread newThread()
    {
        return new KmThread()
        {
            @Override
            public void run()
            {
                while ( !hasStopRequest() )
                    loop();
            }
        };
    }

    private void loop()
    {
        checkScanNew();
        checkScanModified();
        sleep();
    }

    //##################################################
    //# scan init
    //##################################################

    private void initializeFiles()
    {
        _files = new KmMap<>();

        for ( KmFileMonitorRoot e : getRoots() )
            initializeFiles(e);
    }

    private void initializeFiles(final KmFileMonitorRoot e)
    {
        new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                if ( e.matches(f) )
                    initializeFile(f);
            }
        }.processAll(e.getFile());
    }

    private void initializeFile(KmFile f)
    {
        long ord = f.getLastModifiedOrdinal();
        _files.put(f, ord);
    }

    //##################################################
    //# scan new
    //##################################################

    private void checkScanNew()
    {
        if ( isReady(_lastNewScanTs, _newScanFrequencySeconds) )
            scanNewFiles();
    }

    private void scanNewFiles()
    {
        KmTimer t = KmTimer.run();

        _lastNewScanTs = getNowUtc();

        for ( KmFileMonitorRoot e : getRoots() )
            scanNewFiles(e);

        if ( _logScan )
        {
            double ms = t.getMilliseconds();
            KmLog.info("Scanned for new files, %.1f ms.", ms);
        }
    }

    private void scanNewFiles(final KmFileMonitorRoot e)
    {
        new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                if ( e.matches(f) )
                    checkFile(f);
            }
        }.processAll(e.getFile());
    }

    //##################################################
    //# scan modified
    //##################################################

    private void checkScanModified()
    {
        if ( isReady(_lastModifiedScanTs, _modifiedScanFrequencySeconds) )
            scanModifiedFiles();
    }

    private void scanModifiedFiles()
    {
        KmTimer t = KmTimer.run();

        _lastModifiedScanTs = getNowUtc();

        KmList<KmFile> v = _files.getKeys();
        for ( KmFile e : v )
            checkFile(e);

        if ( _logScan )
        {
            double ms = t.getMilliseconds();
            KmLog.info("Scanned for modified files, %.1f ms.", ms);
        }
    }

    //##################################################
    //# support
    //##################################################

    private void checkFile(KmFile f)
    {
        Long oldOrd = _files.get(f);
        Long newOrd = f.getLastModifiedOrdinal();

        if ( !Kmu.isEqual(oldOrd, newOrd) )
        {
            _files.put(f, newOrd);
            handleChange(f);
        }
    }

    private void handleChange(KmFile f)
    {
        getHandler().handleChange(f);
    }

    private boolean isReady(KmTimestamp lastTs, int freqSecs)
    {
        return lastTs.addSeconds(freqSecs).isBeforeNowUtc();
    }

    private void sleep()
    {
        Kmu.sleepSeconds(1);
    }

}
