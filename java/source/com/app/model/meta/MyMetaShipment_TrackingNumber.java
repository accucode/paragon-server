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

public class MyMetaShipment_TrackingNumber
    extends KmMetaStringProperty<MyShipment>
    implements KmMetaDaoPropertyIF<MyShipment,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "trackingNumber";
    }

    @Override
    public String getLabel()
    {
        return "Tracking Number";
    }

    @Override
    public String getHelp()
    {
        return "The tracking number used by the third party carrier to identify this shipment.";
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
        return MyShipmentValidator.instance.getTrackingNumberValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "trackingNumber";
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
    public String getValueFor(MyShipment model)
    {
        return model.getTrackingNumber();
    }
    
    @Override
    public void setValueFor(MyShipment model, String value)
    {
        model.setTrackingNumber(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, String value)
    {
        return model.hasTrackingNumber(value);
    }
    
}
