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

public class MyMetaFieldTest_DateTest
    extends KmMetaDateProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,KmDate>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dateTest";
    }

    @Override
    public String getLabel()
    {
        return "Date Test";
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
    public KmDateValidator getValidator()
    {
        return MyFieldTestValidator.instance.getDateTestValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "dateTest";
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
    public KmDate getValueFor(MyFieldTest model)
    {
        return model.getDateTest();
    }

    @Override
    public void setValueFor(MyFieldTest model, KmDate value)
    {
        model.setDateTest(value);
    }

    @Override
    public boolean hasValueFor(MyFieldTest model, KmDate value)
    {
        return model.hasDateTest(value);
    }

}
