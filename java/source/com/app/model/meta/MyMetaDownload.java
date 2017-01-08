//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

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

    public MyDownloadValidator getValidator()
    {
        return MyDownloadValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I am used to manage file downloads to the client browser.  When a client requests a file the server returns a token (url) that redirects the user to the page where the download can actually occur.  This helps avoid the problem of download interferring with the current user interface, especially with the single page ajax ui we now use.  However, this also means that additional security is needed to ensure that users cannot access someone else's download.  Only the \"user\" identified in this record is allowed to download the specified file.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaDownload_Uid Uid = new MyMetaDownload_Uid();
    public static final MyMetaDownload_CreatedUtcTs CreatedUtcTs = new MyMetaDownload_CreatedUtcTs();
    public static final MyMetaDownload_Name Name = new MyMetaDownload_Name();
    public static final MyMetaDownload_TypeCode TypeCode = new MyMetaDownload_TypeCode();
    public static final MyMetaDownload_FileName FileName = new MyMetaDownload_FileName();
    public static final MyMetaDownload_Bytes Bytes = new MyMetaDownload_Bytes();
    public static final MyMetaDownload_LockVersion LockVersion = new MyMetaDownload_LockVersion();
    public static final MyMetaDownload_DisplayString DisplayString = new MyMetaDownload_DisplayString();
    public static final MyMetaDownload_TypeName TypeName = new MyMetaDownload_TypeName();
    public static final MyMetaDownload_CreatedLocalTs CreatedLocalTs = new MyMetaDownload_CreatedLocalTs();
    public static final MyMetaDownload_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaDownload_CreatedLocalTsMessage();
    public static final MyMetaDownload_CreatedLocalDate CreatedLocalDate = new MyMetaDownload_CreatedLocalDate();
    public static final MyMetaDownload_CreatedLocalTime CreatedLocalTime = new MyMetaDownload_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaDownload_User User = new MyMetaDownload_User();
}
