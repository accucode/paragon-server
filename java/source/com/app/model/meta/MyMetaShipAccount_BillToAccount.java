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

public class MyMetaShipAccount_BillToAccount
    extends KmMetaStringProperty<MyShipAccount>
    implements KmMetaDaoPropertyIF<MyShipAccount,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "billToAccount";
    }

    @Override
    public String getLabel()
    {
        return "Bill To Account";
    }

    @Override
    public String getHelp()
    {
        return "The account name/number that the carrier should bill. This is only applicable when the billToType is third party.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyShipAccountValidator.instance.getBillToAccountValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "billToAccount";
    }

    @Override
    public MyShipAccountDao getDao()
    {
        return getAccess().getShipAccountDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyShipAccount model)
    {
        return model.getBillToAccount();
    }
    
    @Override
    public void setValueFor(MyShipAccount model, String value)
    {
        model.setBillToAccount(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipAccount model, String value)
    {
        return model.hasBillToAccount(value);
    }
    
}
