package com.app.ui.page.test;

import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.control.ScDropzoneUploadHandlerIF;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyDropzoneTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDropzoneTestPage instance = new MyDropzoneTestPage();

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
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
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
        dz.setUploadHandler(newUploadHandler());

        ScGroup group;
        group = root.addGroup("Drop Zone Test");
        group.getBody().add(dz);
    }

    //##################################################
    //# action
    //##################################################

    private ScDropzoneUploadHandlerIF newUploadHandler()
    {
        return new ScDropzoneUploadHandlerIF()
        {
            @Override
            public void upload(String fileName, byte[] data)
            {
                handleUpload(fileName, data);
            }
        };
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
