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

public class MyMetaAccount
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAccount instance = new MyMetaAccount();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAccount()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "account";
    }

    public static MyAccountValidator getValidator()
    {
        return MyAccountValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaAccount_Uid Uid = new MyMetaAccount_Uid();
    public static final MyMetaAccount_Name Name = new MyMetaAccount_Name();
    public static final MyMetaAccount_LockVersion LockVersion = new MyMetaAccount_LockVersion();

    //##################################################
    //# associations
    //##################################################

}
