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

public class MyMetaProduct_VendorPartNumber
    extends KmMetaIntegerProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Integer>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "vendorPartNumber";
    }

    @Override
    public String getLabel()
    {
        return "Vendor Part Number";
    }

    @Override
    public String getHelp()
    {
        return "The vendor's part number, which may be different from the part number.";
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
    public KmIntegerValidator getValidator()
    {
        return MyProductValidator.instance.getVendorPartNumberValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "vendorPartNumber";
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
    public Integer getValueFor(MyProduct model)
    {
        return model.getVendorPartNumber();
    }
    
    @Override
    public void setValueFor(MyProduct model, Integer value)
    {
        model.setVendorPartNumber(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Integer value)
    {
        return model.hasVendorPartNumber(value);
    }
    
}
