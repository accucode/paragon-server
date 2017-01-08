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

public class MyMetaHibernateCacheTest
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaHibernateCacheTest instance = new MyMetaHibernateCacheTest();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaHibernateCacheTest()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "hibernateCacheTest";
    }

    public MyHibernateCacheTestValidator getValidator()
    {
        return MyHibernateCacheTestValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I am used to test the hibernate second level cache.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaHibernateCacheTest_Uid Uid = new MyMetaHibernateCacheTest_Uid();
    public static final MyMetaHibernateCacheTest_Data Data = new MyMetaHibernateCacheTest_Data();
    public static final MyMetaHibernateCacheTest_LockVersion LockVersion = new MyMetaHibernateCacheTest_LockVersion();
    public static final MyMetaHibernateCacheTest_DisplayString DisplayString = new MyMetaHibernateCacheTest_DisplayString();

    //##################################################
    //# associations
    //##################################################

}
