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

public class MyMetaFieldTest_PinNumber2
    extends KmMetaStringProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "pinNumber2";
    }

    @Override
    public String getLabel()
    {
        return "Pin Number2";
    }

    @Override
    public String getHelp()
    {
        return "Excluded from the auditLog.";
    }

    @Override
    public int getColumnWidth()
    {
        return 5;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyFieldTestValidator.instance.getPinNumber2Validator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "pinNumber2";
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
    public String getValueFor(MyFieldTest model)
    {
        return model.getPinNumber2();
    }

    @Override
    public void setValueFor(MyFieldTest model, String value)
    {
        model.setPinNumber2(value);
    }

    @Override
    public boolean hasValueFor(MyFieldTest model, String value)
    {
        return model.hasPinNumber2(value);
    }

}
