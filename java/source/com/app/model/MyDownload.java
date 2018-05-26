package com.app.model;

import com.kodemore.collection.KmBlob;
import com.kodemore.file.KmFile;
import com.kodemore.utility.Kmu;

import com.app.file.MySharedFiles;
import com.app.model.base.MyDownloadBase;
import com.app.model.base.MyDownloadType;
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

    public KmFile getFile()
    {
        return MySharedFiles.getInstance().getDownload(this);
    }

    public String getUrl()
    {
        return MyUrls.getDownloadUrl(this);
    }

    public String getDisplayName()
    {
        return hasName()
            ? getName()
            : "Attachment";
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

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getDisplayName();
    }

    @Override
    public String getDomainTitle()
    {
        return getDisplayName();
    }

    @Override
    public String getDomainSubtitle()
    {
        MyDownloadType type = getType();
        switch ( type )
        {
            case Attachment:
                return "attachment";

            case Bytes:
                return "bytes";

            case File:
                return "file " + getFileName();
        }
        throw Kmu.newEnumError(type);
    }
}
