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
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaFieldTest_BooleanTest
    extends KmMetaBooleanProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "booleanTest";
    }

    @Override
    public String getLabel()
    {
        return "Boolean Test";
    }

    @Override
    public String getHelp()
    {
        return null;
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmBooleanValidator getValidator()
    {
        return MyFieldTestValidator.instance.getBooleanTestValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "booleanTest";
    }

    @Override
    public MyFieldTestDao getDao()
    {
        return getAccess().getFieldTestDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyFieldTest model)
    {
        return model.getBooleanTest();
    }

    @Override
    public void setValueFor(MyFieldTest model, Boolean value)
    {
        model.setBooleanTest(value);
    }

    @Override
    public boolean hasValueFor(MyFieldTest model, Boolean value)
    {
        return model.hasBooleanTest(value);
    }

}
