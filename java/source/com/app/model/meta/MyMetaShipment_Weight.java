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

public class MyMetaShipment_Weight
    extends KmMetaDoubleProperty<MyShipment>
    implements KmMetaDaoPropertyIF<MyShipment,Double>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "weight";
    }

    @Override
    public String getLabel()
    {
        return "Weight";
    }

    @Override
    public String getHelp()
    {
        return "The weight of this shipment in U.S. pounds.";
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
    public KmDoubleValidator getValidator()
    {
        return MyShipmentValidator.instance.getWeightValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "weight";
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
    public Double getValueFor(MyShipment model)
    {
        return model.getWeight();
    }
    
    @Override
    public void setValueFor(MyShipment model, Double value)
    {
        model.setWeight(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipment model, Double value)
    {
        return model.hasWeight(value);
    }
    
}
