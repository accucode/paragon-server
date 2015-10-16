package com.app.model;

import com.kodemore.file.KmFile;

import com.app.file.MySharedFiles;
import com.app.model.base.MyDownloadBase;
import com.app.utility.MyUrls;

public class MyDownload
    extends MyDownloadBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyDownload()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

    public KmFile getFile()
    {
        return MySharedFiles.getInstance().getDownload(this);
    }

    public String getUrl()
    {
        return MyUrls.getDownloadUrl(this);
    }
}
