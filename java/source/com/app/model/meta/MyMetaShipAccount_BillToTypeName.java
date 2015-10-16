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

public class MyMetaShipAccount_BillToTypeName
    extends KmMetaStringProperty<MyShipAccount>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "billToTypeName";
    }

    @Override
    public String getLabel()
    {
        return "Bill To Type";
    }

    @Override
    public String getHelp()
    {
        return "This indicates who the carrier should bill, and is used when configuring the third party carrier.\n Sender: Bill to the sender, that is, ourselves.  This is the normal option for non-customer specific accounts.\n Receiving: Bill the party receiving the shipment.  This options is almost never used.  It introduces a number of potential issues, and may imply C.O.D. terms and the potential that the shipment will be refused at the receiving end.\n ThirdParty: This is the option we typically use when configuring accounts that are associated with a customer.  Some additional set up and verification is generally required to coordinate permission with the customer and the carrier.  But once set up, this allows us to ship directly against the customer's account.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
    }

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyShipAccount model)
    {
        return model.getBillToTypeName();
    }
    
    @Override
    public boolean hasValueFor(MyShipAccount model, String value)
    {
        return model.hasBillToTypeName(value);
    }
    
}
