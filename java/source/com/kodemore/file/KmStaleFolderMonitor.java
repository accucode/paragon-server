/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import java.io.File;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmClock;
import com.kodemore.utility.Kmu;

/**
 * I am used to a folder to make sure that it is active.
 * That is, that it has files being added and removed from it.
 * 
 * I may be used to monitor a folder used to coordinate
 * files that are shared via ftp, and to make sure that files
 * are moving back and forth, and that no files are getting
 * stuck.
 */
public class KmStaleFolderMonitor
{
    //##################################################
    //# variables
    //##################################################

    private String                    _folderPath;
    private Integer                   _staleMinutes;
    private Integer                   _inactiveMinutes;
    private boolean                   _logResults;

    private File                      _folder;
    private KmMap<String,KmTimestamp> _lastFilenames;
    private KmTimestamp               _lastNewFileUtcTs;

    //##################################################
    //# constructor
    //##################################################

    public KmStaleFolderMonitor()
    {
        _lastFilenames = new KmMap<String,KmTimestamp>();
        _lastNewFileUtcTs = KmClock.getNowUtc();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getFolderPath()
    {
        return _folderPath;
    }

    public void setFolderPath(String e)
    {
        _folderPath = e;
        _folder = null;
    }

    public Integer getStaleMinutes()
    {
        return _staleMinutes;
    }

    public void setStaleMinutes(Integer e)
    {
        _staleMinutes = e;
    }

    public Integer getInactiveMinutes()
    {
        return _inactiveMinutes;
    }

    public void setInactiveMinutes(Integer e)
    {
        _inactiveMinutes = e;
    }

    public boolean getLogResults()
    {
        return _logResults;
    }

    public void setLogResults(boolean e)
    {
        _logResults = e;
    }

    //##################################################
    //# actions
    //##################################################

    public void run()
    {
        KmTimestamp now = KmClock.getNowUtc();

        if ( _folder == null )
            _folder = new File(_folderPath);

        if ( _folder == null )
            return;

        if ( !_folder.exists() )
            return;

        updateState(now);
        checkInput(now);
        checkOutput(now);
    }

    private void updateState(KmTimestamp now)
    {
        KmList<String> current = KmList.createStrings(_folder.list());
        KmList<String> last = _lastFilenames.getKeys();
        KmList<String> added = getNotInListFirstNotLast(current, last);
        KmList<String> removed = getNotInListFirstNotLast(last, current);

        if ( added.isNotEmpty() )
            _lastNewFileUtcTs = now;

        addFiles(added, now);
        removeFiles(removed);
    }

    private KmList<String> getNotInListFirstNotLast(KmList<String> first, KmList<String> last)
    {
        KmList<String> v = new KmList<String>();

        for ( String e : first )
            if ( !last.contains(e) )
                v.add(e);

        return v;
    }

    private void addFiles(KmList<String> filenames, KmTimestamp now)
    {
        for ( String e : filenames )
            _lastFilenames.put(e, now);
    }

    private void removeFiles(KmList<String> filenames)
    {
        for ( String e : filenames )
            _lastFilenames.remove(e);
    }

    private void checkInput(KmTimestamp now)
    {
        double diff = _lastNewFileUtcTs.getMinutesDoubleDifference(now);
        if ( diff > _inactiveMinutes )
            reportNoInput();
    }

    private void checkOutput(KmTimestamp now)
    {
        KmMap<String,KmTimestamp> map = new KmMap<String,KmTimestamp>();

        for ( String e : _lastFilenames.getKeys() )
        {
            KmTimestamp ts = _lastFilenames.get(e);
            double diff = now.getMinutesDoubleDifference(ts);

            if ( diff > _staleMinutes )
                map.put(e, ts);
        }

        if ( map.isNotEmpty() )
            reportFilesStuck(map);
    }

    //##################################################
    //# reporting
    //##################################################

    private void reportNoInput()
    {
        String subject = Kmu.format("Folder Input Error: %s", _folderPath);

        String msg = Kmu.format(
            "No new files have been received in the folder %s for more than %s minutes.",
            _folderPath,
            _inactiveMinutes);

        warn(subject, msg);
    }

    private void reportFilesStuck(KmMap<String,KmTimestamp> map)
    {
        String subject = Kmu.format("Folder Output Error: %s", _folderPath);

        String msg = Kmu.format(
            "The following files have been in the folder %s for more than %s minutes: %s.",
            _folderPath,
            _staleMinutes,
            getSortedFilenameString(map));

        warn(subject, msg);
    }

    private void warn(String subject, String msg)
    {
        if ( _logResults )
            KmLog.warn("%s. %s", subject, msg);
    }

    private String getSortedFilenameString(KmMap<String,KmTimestamp> map)
    {
        KmList<String> keys;
        keys = map.getKeys();
        keys.sort();

        return keys.format(", ");
    }

}
