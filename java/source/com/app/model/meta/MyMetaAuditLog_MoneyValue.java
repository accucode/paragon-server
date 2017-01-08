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

public class MyMetaAuditLog_MoneyValue
    extends KmMetaMoneyProperty<MyAuditLog>
    implements KmMetaDaoPropertyIF<MyAuditLog,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "moneyValue";
    }

    @Override
    public String getLabel()
    {
        return "Money Value";
    }

    @Override
    public String getHelp()
    {
        return "The money value, if applicable.";
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
        return MyAuditLogValidator.instance.getMoneyValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "moneyValue";
    }

    @Override
    public MyAuditLogDao getDao()
    {
        return getAccess().getAuditLogDao();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmMoney getValueFor(MyAuditLog model)
    {
        return model.getMoneyValue();
    }

    @Override
    public void setValueFor(MyAuditLog model, KmMoney value)
    {
        model.setMoneyValue(value);
    }

    @Override
    public boolean hasValueFor(MyAuditLog model, KmMoney value)
    {
        return model.hasMoneyValue(value);
    }

}
