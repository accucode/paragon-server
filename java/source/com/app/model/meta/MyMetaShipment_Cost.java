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

public class MyMetaShipment_Cost
    extends KmMetaMoneyProperty<MyShipment>
    implements KmMetaDaoPropertyIF<MyShipment,KmMoney>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "cost";
    }

    @Override
    public String getLabel()
    {
        return "Cost";
    }

    @Override
    public String getHelp()
    {
        return "The cost of this shipment.  If recorded, this should be the exact cost reported by the carrier.";
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
        return MyShipmentValidator.instance.getCostValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "cost";
    }

    @Override
    public MyShipmentDao getDao()
    {
        return getAccess().getShipmentDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmMoney getValueFor(MyShipment model)
    {
        return model.getCost();
    }
    
    @Override
    public void setValueFor(MyShipment model, KmMoney value)
    {
        model.setCost(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, KmMoney value)
    {
        return model.hasCost(value);
    }
    
}
