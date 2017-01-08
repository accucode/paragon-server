package com.app.model;

import com.kodemore.collection.KmBlob;
import com.kodemore.file.KmFile;

import com.app.file.MySharedFiles;
import com.app.model.base.MyDownloadBase;
import com.app.model.core.MySystemDomainIF;
import com.app.utility.MyUrls;

public class MyDownload
    extends MyDownloadBase
    implements MySystemDomainIF
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
        return hasName()
            ? getName()
            : "Attachment";
    }

    public KmFile getFile()
    {
        return MySharedFiles.getInstance().getDownload(this);
    }

    public String getUrl()
    {
        return MyUrls.getDownloadUrl(this);
    }

    //##################################################
    //# blob
    //##################################################

    public void setByteArray(byte[] bytes)
    {
        setBytes(new KmBlob(bytes));
    }

    public byte[] getByteArray()
    {
        return hasBytes()
            ? getBytes().getValue()
            : null;
    }
}
