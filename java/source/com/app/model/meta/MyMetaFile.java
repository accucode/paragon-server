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

public class MyMetaFile
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaFile instance = new MyMetaFile();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaFile()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "file";
    }

    public MyFileValidator getValidator()
    {
        return MyFileValidator.instance;
    }

    public String getComment()
    {
        return "A file. A record of files managed on the file system.";
    }

    @Override
    public String getHelp()
    {
        return "I represent a file stored on the file system.  I only store a reference to the file, NOT the contents of the file itself.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaFile_Uid Uid = new MyMetaFile_Uid();
    public static final MyMetaFile_CreatedUtcTs CreatedUtcTs = new MyMetaFile_CreatedUtcTs();
    public static final MyMetaFile_UpdatedUtcTs UpdatedUtcTs = new MyMetaFile_UpdatedUtcTs();
    public static final MyMetaFile_Name Name = new MyMetaFile_Name();
    public static final MyMetaFile_Path Path = new MyMetaFile_Path();
    public static final MyMetaFile_StatusCode StatusCode = new MyMetaFile_StatusCode();
    public static final MyMetaFile_Size Size = new MyMetaFile_Size();
    public static final MyMetaFile_PartialSize PartialSize = new MyMetaFile_PartialSize();
    public static final MyMetaFile_LockVersion LockVersion = new MyMetaFile_LockVersion();
    public static final MyMetaFile_DisplayString DisplayString = new MyMetaFile_DisplayString();
    public static final MyMetaFile_StatusName StatusName = new MyMetaFile_StatusName();
    public static final MyMetaFile_CreatedLocalTs CreatedLocalTs = new MyMetaFile_CreatedLocalTs();
    public static final MyMetaFile_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFile_CreatedLocalTsMessage();
    public static final MyMetaFile_CreatedLocalDate CreatedLocalDate = new MyMetaFile_CreatedLocalDate();
    public static final MyMetaFile_CreatedLocalTime CreatedLocalTime = new MyMetaFile_CreatedLocalTime();
    public static final MyMetaFile_UpdatedLocalTs UpdatedLocalTs = new MyMetaFile_UpdatedLocalTs();
    public static final MyMetaFile_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaFile_UpdatedLocalTsMessage();
    public static final MyMetaFile_UpdatedLocalDate UpdatedLocalDate = new MyMetaFile_UpdatedLocalDate();
    public static final MyMetaFile_UpdatedLocalTime UpdatedLocalTime = new MyMetaFile_UpdatedLocalTime();
    public static final MyMetaFile_CreatedByFullName CreatedByFullName = new MyMetaFile_CreatedByFullName();
    public static final MyMetaFile_UpdatedByFullName UpdatedByFullName = new MyMetaFile_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaFile_CreatedBy CreatedBy = new MyMetaFile_CreatedBy();
    public static final MyMetaFile_UpdatedBy UpdatedBy = new MyMetaFile_UpdatedBy();
}
