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

public class MyMetaProduct_RequiresShip
    extends KmMetaBooleanProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "requiresShip";
    }

    @Override
    public String getLabel()
    {
        return "Requires Ship";
    }

    @Override
    public String getHelp()
    {
        return "Physical goods generally require that we ship them to the customer.  That is, they must be picked, packed, and shipped to the customer.  On the other hand, services such as installation or warranty generally do not require shipping.";
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
        return MyProductValidator.instance.getRequiresShipValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "requiresShip";
    }

    @Override
    public MyProductDao getDao()
    {
        return getAccess().getProductDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyProduct model)
    {
        return model.getRequiresShip();
    }
    
    @Override
    public void setValueFor(MyProduct model, Boolean value)
    {
        model.setRequiresShip(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Boolean value)
    {
        return model.hasRequiresShip(value);
    }
    
}
