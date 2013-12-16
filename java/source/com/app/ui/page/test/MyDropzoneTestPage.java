package com.app.ui.page.test;

import com.kodemore.file.KmFile;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.control.ScDropzoneUploadHandlerIF;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyDropzoneTestPage
    extends MyTestPage
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

    private static final String UPLOAD_FOLDER = "/temp/uploads";

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeLocalQueryParameters()
    {
        return null;
    }

    @Override
    public void applyLocalQueryParameters(ScParameterList v)
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
        dz.showRemoveLinks();
        dz.setRemoveAction(newRemoveAction());

        ScGroup group;
        group = root.addGroup("Dropzone");
        group.add(dz);
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

    private ScActionIF newRemoveAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleRemove();
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
    }

    private void handleRemove()
    {
        ajax().toast("Removed File");
    }
}
