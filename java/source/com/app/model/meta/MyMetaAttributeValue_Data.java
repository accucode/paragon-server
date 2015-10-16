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

public class MyMetaAttributeValue_Data
    extends KmMetaStringProperty<MyAttributeValue>
    implements KmMetaDaoPropertyIF<MyAttributeValue,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "data";
    }

    @Override
    public String getLabel()
    {
        return "Data";
    }

    @Override
    public String getHelp()
    {
        return "The value of the custom attribute.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyAttributeValueValidator.instance.getDataValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "data";
    }

    @Override
    public MyAttributeValueDao getDao()
    {
        return getAccess().getAttributeValueDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyAttributeValue model)
    {
        return model.getData();
    }
    
    @Override
    public void setValueFor(MyAttributeValue model, String value)
    {
        model.setData(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeValue model, String value)
    {
        return model.hasData(value);
    }
    
}
