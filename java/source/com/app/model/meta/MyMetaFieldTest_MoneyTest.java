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
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaFieldTest_MoneyTest
    extends KmMetaMoneyProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "moneyTest";
    }

    @Override
    public String getLabel()
    {
        return "Money Test";
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
    public KmMoneyValidator getValidator()
    {
        return MyFieldTestValidator.instance.getMoneyTestValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "moneyTest";
    }

    @Override
    public MyFieldTestDao getDao()
    {
        return getAccess().getFieldTestDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmMoney getValueFor(MyFieldTest model)
    {
        return model.getMoneyTest();
    }
    
    @Override
    public void setValueFor(MyFieldTest model, KmMoney value)
    {
        model.setMoneyTest(value);
    }
    
    @Override
    public boolean hasValueFor(MyFieldTest model, KmMoney value)
    {
        return model.hasMoneyTest(value);
    }
    
}
