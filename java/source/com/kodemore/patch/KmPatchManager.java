package com.kodemore.patch;

import com.kodemore.collection.*;
import com.kodemore.database.*;
import com.kodemore.file.*;
import com.kodemore.log.*;
import com.kodemore.string.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;

/**
 * I provide programatic access to the patch functions.
 * Normally, the list of local and installed patches is
 * only checked once, when I am created.  However, external
 * processes may be modifying these resources, you can
 * call refresh at any time.  Typical usage:
 *
 * MyPatchManager e;
 * e = new MyPatchManager();
 * e.sync();
 *
 * or...
 *
 * MyPatchManager e;
 * e = new MyPatchManager();
 * e.downgradeAll();
 * e.upgrade('20090131_235900.txt");
 */
public class KmPatchManager
{
    //##################################################
    //# variables
    //##################################################

    private static final String   DATABASE_PATCH_MANAGER_LOCK = "DATABASE.PATCH_MANAGER";

    /**
     * The patches available on the local file system.
     */
    private KmMap<String,KmPatch> _localPatches;

    /**
     * The names installed in the database.
     */
    private KmMap<String,KmPatch> _installedPatches;

    /*
     * Allows logging  to be specified, default is to console
     */
    private KmLogPrinter          _log;

    private KmDatabaseTool        _dbTools;

    //##################################################
    //# constructor
    //##################################################

    public KmPatchManager()
    {
        _log = new KmConsolePrinter();

        refresh();
    }

    //##################################################
    //# accessing
    //##################################################//

    public KmLogPrinter getLog()
    {
        return _log;
    }

    public void setLog(KmLogPrinter log)
    {
        _log = log;
    }

    //##################################################
    //# actions
    //##################################################

    public void refresh()
    {
        _localPatches = getLocalPatches();
        _installedPatches = getInstalledPatches();
    }

    //##################################################
    //# public
    //##################################################//

    public boolean sync()
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _sync();
            }
        }.run();
    }

    public boolean test()
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _test();
            }
        }.run();

    }

    public boolean upgradeAll()
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _upgradeAll();
            }
        }.run();
    }

    public boolean upgrade(final String name)
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _upgrade(name);
            }
        }.run();
    }

    public boolean upgrade(final KmPatch patch)
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _upgrade(patch);
            }
        }.run();
    }

    public boolean downgradeAll()
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _downgradeAll();
            }
        }.run();
    }

    public boolean downgrade(final String name)
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _downgrade(name);
            }
        }.run();
    }

    public boolean downgrade(final KmPatch patch)
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _downgrade(patch);
            }
        }.run();

    }

    public boolean repeat(final String name)
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _repeat(name);
            }
        }.run();

    }

    public boolean repeatLast()
    {
        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _repeatLast();
            }
        }.run();
    }

    public boolean rerepeatLast()
    {

        return new doLockDb()
        {
            @Override
            public boolean runLocked()
            {
                return _rerepeatLast();
            }
        }.run();

    }

    public void create()
    {
        try
        {
            lockDatabase();
            _create();
        }
        finally
        {
            unlockDatabase();
        }
    }

    //##################################################
    //# private
    //##################################################//

    private boolean _sync()
    {

        printLog("Sync");
        if ( !_downgradeAll() )
            return false;

        if ( _upgradeAll() )
            return false;

        return true;
    }

    private boolean _test()
    {
        printLog("Test");

        printLog("Downgrade Candidates...");
        for ( KmPatch e : getDowngradeCandidates() )
            printLog("    " + e.getName());

        printLog("Upgrade Candidates...");
        for ( KmPatch e : getUpgradeCandidates() )
            printLog("    " + e.getName());

        return true;
    }

    private boolean _upgradeAll()
    {
        printLog("Upgrade All");

        KmList<KmPatch> v = getUpgradeCandidates();
        for ( KmPatch e : v )
            if ( !_upgrade(e) )
                return false;

        return true;
    }

    private KmList<KmPatch> getUpgradeCandidates()
    {
        KmList<KmPatch> v;
        v = _localPatches.getValues();
        v.removeAll(_installedPatches.getValues());
        v.sort();
        return v;
    }

    private boolean _upgrade(String name)
    {
        KmPatch e = _localPatches.get(name);
        if ( e == null )
        {
            printLog(name + " : Unknown patch");
            return false;
        }
        return _upgrade(e);
    }

    private boolean _upgrade(KmPatch patch)
    {
        String name = patch.getName();
        printLog(name + " : Upgrade");

        if ( hasInstalledPatch(patch) )
        {
            printLog(name + " : Already installed");
            return false;
        }

        KmPatchProcessor.upgrade(patch);
        saveInstalledPatch(patch);

        _installedPatches.put(name, patch);
        return true;
    }

    private boolean _downgradeAll()
    {
        printLog("Downgrade All");

        KmList<KmPatch> v = getDowngradeCandidates();
        for ( KmPatch e : v )
            if ( !_downgrade(e) )
                return false;

        return true;
    }

    private KmList<KmPatch> getDowngradeCandidates()
    {
        KmList<KmPatch> v;
        v = _installedPatches.getValues();
        v.removeAll(_localPatches.getValues());
        v.sort();
        v.reverse();
        return v;
    }

    private boolean _downgrade(final String name)
    {
        KmPatch e = _installedPatches.get(name);
        if ( e == null )
        {
            printLog(name + " : Not Installed");
            return false;
        }
        return _downgrade(e);
    }

    private boolean _downgrade(final KmPatch patch)
    {
        String name = patch.getName();
        printLog(name + " : Downgrade");

        KmPatchProcessor.downgrade(patch);

        deleteInstalledPatch(patch);
        _installedPatches.remove(name);
        return true;
    }

    private boolean _repeat(String name)
    {
        printLog(name + " : Repeat");
        if ( !_downgrade(name) )
            return false;

        return _upgrade(name);
    }

    private boolean _repeatLast()
    {
        printLog("Repeat Last");
        if ( _localPatches.isEmpty() )
        {
            printLog("No patches available");
            return false;
        }
        return _repeat(getLastLocalPatchName());
    }

    private boolean _rerepeatLast()
    {
        return _repeatLast() && _repeatLast();
    }

    private void _create()
    {
        printLog("Create");
        generateDefaultPatch();
        _upgrade(getLastLocalPatchName());
    }

    //##################################################
    //# support
    //##################################################

    private KmPatchBridge getBridge()
    {
        return KmPatchBridge.getInstance();
    }

    private KmFile getLocalPatchDirectory()
    {
        return getBridge().getLocalPatchFolder();
    }

    private KmMap<String,KmPatch> getLocalPatches()
    {
        return toMap(getBridge().getLocalPatches());
    }

    public boolean hasLocalPatch(String name)
    {
        return _localPatches.containsKey(name);
    }

    public boolean hasLocalPatch(KmPatch patch)
    {
        return hasLocalPatch(patch.getName());
    }

    public boolean hasInstalledPatch(String name)
    {
        return _installedPatches.containsKey(name);
    }

    public boolean hasInstalledPatch(KmPatch patch)
    {
        return hasInstalledPatch(patch.getName());
    }

    private String getLastLocalPatchName()
    {
        return _localPatches.getKeys().getMaximum();
    }

    //##################################################
    //# support
    //##################################################

    private KmMap<String,KmPatch> getInstalledPatches()
    {
        return toMap(getBridge().getInstalledPatches());
    }

    private void saveInstalledPatch(KmPatch patch)
    {
        getBridge().saveInstalledPatch(patch);
    }

    private void deleteInstalledPatch(KmPatch patch)
    {
        getBridge().deleteInstalledPatch(patch);
    }

    private void generateDefaultPatch()
    {
        KmFile dir = getLocalPatchDirectory();
        KmTimestamp now = KmClock.getNowUtc();
        String name = "patch_" + now.format_yyyymmdd_hhmmss() + ".txt";
        KmFile child = dir.getChild(name);

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("########################################");
        out.printfln("#! UPGRADE");
        out.printfln("########################################");
        out.println();
        out.println();
        out.println();
        out.printfln("########################################");
        out.printfln("#! DOWNGRADE");
        out.printfln("########################################");
        String source = out.toString();

        dir.createFolder();
        child.write(source);

        KmPatch e;
        e = new KmPatch();
        e.setName(name);
        e.setSource(source);
        _localPatches.put(name, e);

        printLog(name + " : Created");
    }

    private KmMap<String,KmPatch> toMap(KmList<KmPatch> v)
    {
        KmMap<String,KmPatch> m = new KmMap<String,KmPatch>();
        for ( KmPatch e : v )
            m.put(e.getName(), e);
        return m;
    }

    //##################################################
    //# logging
    //##################################################//

    private void printLog(String s)
    {
        _log.println(s);
    }

    //##################################################
    //# locking
    //##################################################//
    private void lockDatabase()
    {
        printLog("Trying to obtain lock on database before managing patches.");
        while ( true )
        {
            //try for db lock every 5 seconds for up to 60 seconds
            if ( getDbTools().lock(DATABASE_PATCH_MANAGER_LOCK, 5, 12, 0) )
                return;

            printLog("Another Patch Manager process is already running, waiting...");
        }
    }

    private void unlockDatabase()
    {
        getDbTools().unlock(DATABASE_PATCH_MANAGER_LOCK);
        getDbTools().closeSafely();
    }

    private KmDatabaseTool getDbTools()
    {
        if ( _dbTools == null )
        {
            _dbTools = new KmDatabaseTool();
            _dbTools.open();
        }
        return _dbTools;
    }

    private abstract class doLockDb
    {
        public boolean run()
        {
            try
            {
                lockDatabase();
                printLog("Database lock obtained.");
                return runLocked();
            }
            finally
            {
                unlockDatabase();
                printLog("Lock released.");
            }
        }

        public abstract boolean runLocked();
    }

}
