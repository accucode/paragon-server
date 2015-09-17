package com.app.ui.page.test;

import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDropzoneTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDropzoneTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDropzoneTestPage();
    }

    public static MyDropzoneTestPage getInstance()
    {
        return _instance;
    }

    private MyDropzoneTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    /**
     * The uploaded files are written to this folder for testing.
     * In a real app, these could be written to a database, or processed directly.
     */
    private static final String UPLOAD_FOLDER = "/temp/uploads";

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScDropzone dz;
        dz = new ScDropzone();
        dz.setUploadHandler(this::handleUpload);

        ScGroup group;
        group = root.addGroup("Drop Zone Test");
        group.getBody().add(dz);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleUpload(String fileName, byte[] data)
    {
        KmFile folder;
        folder = new KmFile(UPLOAD_FOLDER);
        folder.createFolder();

        KmFile file;
        file = folder.getChild(fileName);
        file.write(data);

        KmLog.info("Dropzone uploaded to: " + file.getRealPath());
    }
}
