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

    public static MyFileValidator getValidator()
    {
        return MyFileValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaFile_Id Id = new MyMetaFile_Id();
    public static final MyMetaFile_Name Name = new MyMetaFile_Name();
    public static final MyMetaFile_Path Path = new MyMetaFile_Path();
    public static final MyMetaFile_CreatedUtcTs CreatedUtcTs = new MyMetaFile_CreatedUtcTs();
    public static final MyMetaFile_StatusCode StatusCode = new MyMetaFile_StatusCode();
    public static final MyMetaFile_Size Size = new MyMetaFile_Size();
    public static final MyMetaFile_PartialSize PartialSize = new MyMetaFile_PartialSize();
    public static final MyMetaFile_LockVersion LockVersion = new MyMetaFile_LockVersion();
    public static final MyMetaFile_StatusName StatusName = new MyMetaFile_StatusName();
    public static final MyMetaFile_CreatedLocalTs CreatedLocalTs = new MyMetaFile_CreatedLocalTs();
    public static final MyMetaFile_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFile_CreatedLocalTsMessage();
    public static final MyMetaFile_CreatedLocalDate CreatedLocalDate = new MyMetaFile_CreatedLocalDate();
    public static final MyMetaFile_CreatedLocalTime CreatedLocalTime = new MyMetaFile_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

}
