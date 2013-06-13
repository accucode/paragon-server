package com.kodemore.patch;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;

/**
 * I define the bridge between the generic framework, and the
 * application specific hooks. To integrate this tool with
 * your application you must create a non-abstract subclass
 * and explicitly install it, using KmPatchBridge.install().
 */
public abstract class KmPatchBridge
{
    //##################################################
    //# install
    //##################################################

    private static KmPatchBridge _instance;

    public static void install(KmPatchBridge e)
    {
        if ( _instance != null )
            throw new RuntimeException("Already installed.");

        _instance = e;
    }

    public static boolean isInstalled()
    {
        return _instance != null;
    }

    public static KmPatchBridge getInstance()
    {
        return _instance;
    }

    //##################################################
    //# local patches
    //##################################################

    public abstract KmFile getLocalPatchFolder();

    /**
     * Get all files in the patch directory on the local file system.
     */
    public KmList<KmPatch> getLocalPatches()
    {
        KmFile folder = getLocalPatchFolder();
        if ( !folder.exists() )
            return new KmList<KmPatch>();

        KmList<KmFile> files;
        files = folder.getFiles();
        files.sort();

        KmList<KmPatch> v = new KmList<KmPatch>();
        for ( KmFile file : files )
        {
            KmPatch e;
            e = new KmPatch();
            e.setName(file.getName());
            e.setSource(file.readString());
            v.add(e);
        }
        return v;
    }

    //##################################################
    //# installed patches
    //##################################################

    public abstract KmList<KmPatch> getInstalledPatches();

    public abstract void saveInstalledPatch(KmPatch patch);

    public abstract void deleteInstalledPatch(KmPatch patch);
}
