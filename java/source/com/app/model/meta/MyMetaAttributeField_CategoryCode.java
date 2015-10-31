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

public class MyMetaAttributeField_CategoryCode
    extends KmMetaStringProperty<MyAttributeField>
    implements KmMetaDaoPropertyIF<MyAttributeField,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "categoryCode";
    }

    @Override
    public String getLabel()
    {
        return "Category";
    }

    @Override
    public String getHelp()
    {
        return "The type of model this attribute applies to.  E.g.: product, site.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 5;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyAttributeFieldValidator.instance.getCategoryCodeValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "categoryCode";
    }

    @Override
    public MyAttributeFieldDao getDao()
    {
        return getAccess().getAttributeFieldDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# enum
    //##################################################

    public ScDropdown newDropdown()
    {
        return newDropdown(getLabel());
    }

    public ScDropdown newDropdown(String label)
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValidator(getValidator());
        e.setValueAdaptor(getAdaptor());
        e.addOptions(MyAttributeFieldCategory.values());
        return e;
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAttributeField model)
    {
        return model.getCategoryCode();
    }
    
    @Override
    public void setValueFor(MyAttributeField model, String value)
    {
        model.setCategoryCode(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeField model, String value)
    {
        return model.hasCategoryCode(value);
    }
    
}
