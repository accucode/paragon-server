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

public class MyMetaAttributeField_Active
    extends KmMetaBooleanProperty<MyAttributeField>
    implements KmMetaDaoPropertyIF<MyAttributeField,Boolean>
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
        return "Inactive fields will no longer be displayed to users, but are still stored.";
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
        return MyAttributeFieldValidator.instance.getActiveValidator();
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
    public MyAttributeFieldDao getDao()
    {
        return getAccess().getAttributeFieldDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValueFor(MyAttributeField model)
    {
        return model.getActive();
    }
    
    @Override
    public void setValueFor(MyAttributeField model, Boolean value)
    {
        model.setActive(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeField model, Boolean value)
    {
        return model.hasActive(value);
    }
    
}
