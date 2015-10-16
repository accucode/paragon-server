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

public class MyMetaMasterProduct_PartNumber
    extends KmMetaStringProperty<MyMasterProduct>
    implements KmMetaDaoPropertyIF<MyMasterProduct,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "partNumber";
    }

    @Override
    public String getLabel()
    {
        return "Part Number";
    }

    @Override
    public String getHelp()
    {
        return "The unique part number shared by all versions of the product.";
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
        return MyMasterProductValidator.instance.getPartNumberValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "partNumber";
    }

    @Override
    public MyMasterProductDao getDao()
    {
        return getAccess().getMasterProductDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyMasterProduct model)
    {
        return model.getPartNumber();
    }
    
    @Override
    public void setValueFor(MyMasterProduct model, String value)
    {
        model.setPartNumber(value);
    }
    
    @Override
    public boolean hasValueFor(MyMasterProduct model, String value)
    {
        return model.hasPartNumber(value);
    }
    
}
