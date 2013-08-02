package com.app.ui.activity.test;

import com.kodemore.file.KmFile;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.control.ScDropzoneUploadHandlerIF;
import com.kodemore.servlet.control.ScGroup;

public class MyDropzoneTestPage
    extends MyAbstractTestPage
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
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        ScDropzone dz;
        dz = new ScDropzone();
        dz.setUploadHandler(newUploadHandler());
        dz.showRemoveLinks();
        dz.setRemoveAction(newRemoveAction());

        ScGroup group;
        group = root.addGroup("Dropzone");
        group.add(dz);

        return root;
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
        return new ScAction()
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
