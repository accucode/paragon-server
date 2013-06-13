package com.kodemore.patch;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmClock;

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

    /**
     * The patches available on the local file system.
     */
    private KmMap<String,KmPatch> _localPatches;

    /**
     * The names installed in the database.
     */
    private KmMap<String,KmPatch> _installedPatches;

    //##################################################
    //# constructor
    //##################################################

    public KmPatchManager()
    {
        refresh();
    }

    //##################################################
    //# actions
    //##################################################

    public void refresh()
    {
        _localPatches = getLocalPatches();
        _installedPatches = getInstalledPatches();
    }

    public boolean sync()
    {
        System.out.println("Sync");
        if ( !downgradeAll() )
            return false;

        if ( upgradeAll() )
            return false;

        return true;
    }

    public boolean test()
    {
        System.out.println("Test");

        System.out.println("Downgrade Candidates...");
        for ( KmPatch e : getDowngradeCandidates() )
            System.out.println("    " + e.getName());

        System.out.println("Upgrade Candidates...");
        for ( KmPatch e : getUpgradeCandidates() )
            System.out.println("    " + e.getName());

        return true;
    }

    public boolean upgradeAll()
    {
        System.out.println("Upgrade All");

        KmList<KmPatch> v = getUpgradeCandidates();
        for ( KmPatch e : v )
            if ( !upgrade(e) )
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

    public boolean upgrade(String name)
    {
        KmPatch e = _localPatches.get(name);
        if ( e == null )
        {
            System.out.println(name + " : Unknown patch");
            return false;
        }
        return upgrade(e);
    }

    public boolean upgrade(KmPatch patch)
    {
        String name = patch.getName();
        System.out.println(name + " : Upgrade");

        if ( hasInstalledPatch(patch) )
        {
            System.out.println(name + " : Already installed");
            return false;
        }

        KmPatchProcessor.upgrade(patch);
        saveInstalledPatch(patch);

        _installedPatches.put(name, patch);
        return true;
    }

    public boolean downgradeAll()
    {
        System.out.println("Downgrade All");

        KmList<KmPatch> v = getDowngradeCandidates();
        for ( KmPatch e : v )
            if ( !downgrade(e) )
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

    public boolean downgrade(final String name)
    {
        KmPatch e = _installedPatches.get(name);
        if ( e == null )
        {
            System.out.println(name + " : Not Installed");
            return false;
        }
        return downgrade(e);
    }

    public boolean downgrade(final KmPatch patch)
    {
        String name = patch.getName();
        System.out.println(name + " : Downgrade");

        KmPatchProcessor.downgrade(patch);

        deleteInstalledPatch(patch);
        _installedPatches.remove(name);
        return true;
    }

    public boolean repeat(String name)
    {
        System.out.println(name + " : Repeat");
        if ( !downgrade(name) )
            return false;

        return upgrade(name);
    }

    public boolean repeatLast()
    {
        System.out.println("Repeat Last");
        if ( _localPatches.isEmpty() )
        {
            System.out.println("No patches available");
            return false;
        }
        return repeat(getLastLocalPatchName());
    }

    public boolean rerepeatLast()
    {
        return repeatLast() && repeatLast();
    }

    public void create()
    {
        System.out.println("Create");
        generateDefaultPatch();
        upgrade(getLastLocalPatchName());
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

        System.out.println(name + " : Created");
    }

    private KmMap<String,KmPatch> toMap(KmList<KmPatch> v)
    {
        KmMap<String,KmPatch> m = new KmMap<String,KmPatch>();
        for ( KmPatch e : v )
            m.put(e.getName(), e);
        return m;
    }

}
