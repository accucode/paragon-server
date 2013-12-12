//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MyDownloadValidator;

public class MyMetaDownload
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaDownload instance = new MyMetaDownload();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaDownload()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "download";
    }

    public static MyDownloadValidator getValidator()
    {
        return MyDownloadValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaDownload_Uid Uid = new MyMetaDownload_Uid();
    public static final MyMetaDownload_Name Name = new MyMetaDownload_Name();
    public static final MyMetaDownload_CreatedUtcTs CreatedUtcTs = new MyMetaDownload_CreatedUtcTs();
    public static final MyMetaDownload_LockVersion LockVersion = new MyMetaDownload_LockVersion();
    public static final MyMetaDownload_CreatedLocalTs CreatedLocalTs = new MyMetaDownload_CreatedLocalTs();
    public static final MyMetaDownload_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaDownload_CreatedLocalTsMessage();
    public static final MyMetaDownload_CreatedLocalDate CreatedLocalDate = new MyMetaDownload_CreatedLocalDate();
    public static final MyMetaDownload_CreatedLocalTime CreatedLocalTime = new MyMetaDownload_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaDownload_User User = new MyMetaDownload_User();
}
