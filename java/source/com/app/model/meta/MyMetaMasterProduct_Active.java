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

public class MyMetaMasterProduct_Active
    extends KmMetaBooleanProperty<MyMasterProduct>
    implements KmMetaDaoPropertyIF<MyMasterProduct,Boolean>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "active";
    }

    @Override
    public String getLabel()
    {
        return "Active";
    }

    @Override
    public String getHelp()
    {
        return "Products cannot be deleted from the system, but they can be deactivated. Once set to inactive, the product will no longer be available for sale. Also, the product will be hidden from most configuration screens. Inactive products are still included in historical reports.";
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
        return MyMasterProductValidator.instance.getActiveValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "active";
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
    public Boolean getValueFor(MyMasterProduct model)
    {
        return model.getActive();
    }
    
    @Override
    public void setValueFor(MyMasterProduct model, Boolean value)
    {
        model.setActive(value);
    }
    
    @Override
    public boolean hasValueFor(MyMasterProduct model, Boolean value)
    {
        return model.hasActive(value);
    }
    
}
