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

public class MyMetaShipAccount_BilledToCustomer
    extends KmMetaBooleanProperty<MyShipAccount>
    implements KmMetaDaoPropertyIF<MyShipAccount,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "billedToCustomer";
    }

    @Override
    public String getLabel()
    {
        return "Billed To Customer";
    }

    @Override
    public String getHelp()
    {
        return "Indicates whether shipments on this account will be automatically billed to the customer by the carrier.\n This is independent from the customer.  For example, this could be set to true, even if this account is not associated with a specific customer.  Also, this could be set to false even if this account is associated with a single specific customer.";
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
        return MyShipAccountValidator.instance.getBilledToCustomerValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "billedToCustomer";
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
    public Boolean getValueFor(MyShipAccount model)
    {
        return model.getBilledToCustomer();
    }
    
    @Override
    public void setValueFor(MyShipAccount model, Boolean value)
    {
        model.setBilledToCustomer(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipAccount model, Boolean value)
    {
        return model.hasBilledToCustomer(value);
    }
    
}
