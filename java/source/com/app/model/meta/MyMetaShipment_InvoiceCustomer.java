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

public class MyMetaShipment_InvoiceCustomer
    extends KmMetaBooleanProperty<MyShipment>
    implements KmMetaDaoPropertyIF<MyShipment,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "invoiceCustomer";
    }

    @Override
    public String getLabel()
    {
        return "Invoice Customer";
    }

    @Override
    public String getHelp()
    {
        return "Indicates whether we should invoice the customer for this shipment.";
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
        return MyShipmentValidator.instance.getInvoiceCustomerValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "invoiceCustomer";
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
    public Boolean getValueFor(MyShipment model)
    {
        return model.getInvoiceCustomer();
    }
    
    @Override
    public void setValueFor(MyShipment model, Boolean value)
    {
        model.setInvoiceCustomer(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, Boolean value)
    {
        return model.hasInvoiceCustomer(value);
    }
    
}
