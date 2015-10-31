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

public class MyMetaAttributeValue_TextValue
    extends KmMetaStringProperty<MyAttributeValue>
    implements KmMetaDaoPropertyIF<MyAttributeValue,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "textValue";
    }

    @Override
    public String getLabel()
    {
        return "Text Value";
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
        return MyAttributeValueValidator.instance.getTextValueValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "textValue";
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
        return model.getTextValue();
    }
    
    @Override
    public void setValueFor(MyAttributeValue model, String value)
    {
        model.setTextValue(value);
    }
    
    @Override
    public boolean hasValueFor(MyAttributeValue model, String value)
    {
        return model.hasTextValue(value);
    }
    
}
