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

public class MyMetaProduct_PickInstruction
    extends KmMetaStringProperty<MyProduct>
    implements KmMetaDaoPropertyIF<MyProduct,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "pickInstruction";
    }

    @Override
    public String getLabel()
    {
        return "Pick Instruction";
    }

    @Override
    public String getHelp()
    {
        return "Special instructions that need to be displayed to the worker when picking this product.";
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
        return MyProductValidator.instance.getPickInstructionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "pickInstruction";
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
    public String getValueFor(MyProduct model)
    {
        return model.getPickInstruction();
    }
    
    @Override
    public void setValueFor(MyProduct model, String value)
    {
        model.setPickInstruction(value);
    }
    
    @Override
    public boolean hasValueFor(MyProduct model, String value)
    {
        return model.hasPickInstruction(value);
    }
    
}
