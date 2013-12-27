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

    public static MyHibernateCacheTestValidator getValidator()
    {
        return MyHibernateCacheTestValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaHibernateCacheTest_Uid Uid = new MyMetaHibernateCacheTest_Uid();
    public static final MyMetaHibernateCacheTest_Data Data = new MyMetaHibernateCacheTest_Data();
    public static final MyMetaHibernateCacheTest_LockVersion LockVersion = new MyMetaHibernateCacheTest_LockVersion();

    //##################################################
    //# associations
    //##################################################

}
