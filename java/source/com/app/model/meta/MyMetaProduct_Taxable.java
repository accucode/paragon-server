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

public class MyMetaProduct_Taxable
    extends KmMetaBooleanProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "taxable";
    }

    @Override
    public String getLabel()
    {
        return "Taxable";
    }

    @Override
    public String getHelp()
    {
        return "Indicate if this product is subject to sales tax.  This is generally set to false for labor and servcies, and true for everything else.  If a product is some type of package that includes multiple items, then it must be set to taxable if even a single sub-component is taxable.\n Additional rules related to sales tax are checked for each order.  If a particular order is flagged as tax exempt, then we will not apply sales tax even if the items are taxable.";
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
        return MyProductValidator.instance.getTaxableValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "taxable";
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
        return model.getTaxable();
    }
    
    @Override
    public void setValueFor(MyProduct model, Boolean value)
    {
        model.setTaxable(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, Boolean value)
    {
        return model.hasTaxable(value);
    }
    
}
