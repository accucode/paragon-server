//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
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

public class MyMetaFieldTest_UserTest
    extends KmMetaDaoAssociation<MyFieldTest,MyUser>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userTest";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public MyUser getValueFor(MyFieldTest model)
    {
        return model.getUserTest();
    }
    
    @Override
    public void setValueFor(MyFieldTest model, MyUser value)
    {
        model.setUserTest(value);
    }
    
    @Override
    public boolean hasValueFor(MyFieldTest model, MyUser value)
    {
        return model.hasUserTest(value);
    }
}
