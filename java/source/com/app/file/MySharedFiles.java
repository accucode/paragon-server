package com.app.file;

import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileRoot;
import com.kodemore.utility.Kmu;

import com.app.model.MyDownload;

public class MySharedFiles
{
    //##################################################
    //# instance
    //##################################################

    private static MySharedFiles _instance;

    public static void install()
    {
        if ( _instance != null )
            Kmu.fatal("Already Installed.");

        _instance = new MySharedFiles();
    }

    public static MySharedFiles getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not Installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private KmFileRoot _persistentRoot;
    private KmFileRoot _transientRoot;

    //##################################################
    //# constructor
    //##################################################

    public MySharedFiles()
    {
        _persistentRoot = new KmFileRoot(MyFilePaths.getSharedPersistentPath());
        _transientRoot = new KmFileRoot(MyFilePaths.getSharedTransientPath());

        getPersistentRootFolder().createFolder();
        getUploadFolder().createFolder();

        getTransientRootFolder().createFolder();
    }

    //##################################################
    //# accessing (persistent)
    //##################################################

    public KmFile getPersistentRootFolder()
    {
        return _persistentRoot.getFolder();
    }

    public KmFile getUploadFolder()
    {
        return getPersistentRootFolder().getChild("upload");
    }

    //##################################################
    //# accessing (transient)
    //##################################################

    public KmFile getTransientRootFolder()
    {
        return _transientRoot.getFolder();
    }

    public KmFile getDownload(MyDownload e)
    {
        String uid = e.getUid();
        return getTransientRootFolder().getChild(uid);
    }

}
