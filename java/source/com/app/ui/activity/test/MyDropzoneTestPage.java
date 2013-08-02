package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDropzone;
import com.kodemore.servlet.control.ScDropzoneUploadHandlerIF;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.utility.Kmu;

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

    private static final String UPLOAD_FOLDER = "C:/uploadImageTest";

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        ScDropzone dz = new ScDropzone();
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

    private void handleRemove()
    {
        ajax().toast("Removed File");
    }

    //##################################################
    //# upload handler
    //##################################################

    private ScDropzoneUploadHandlerIF newUploadHandler()
    {
        return new ScDropzoneUploadHandlerIF()
        {
            @Override
            public void handleUpload(String fileName, byte[] data)
            {
                Kmu.createFolder(UPLOAD_FOLDER);

                String filePath = Kmu.joinFilePath(UPLOAD_FOLDER, fileName);
                Kmu.writeFile(filePath, data);
            }
        };
    }
}
