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

public class MyMetaShipAccount_Description
    extends KmMetaStringProperty<MyShipAccount>
    implements KmMetaDaoPropertyIF<MyShipAccount,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "description";
    }

    @Override
    public String getLabel()
    {
        return "Description";
    }

    @Override
    public String getHelp()
    {
        return "A free-form multiline description.";
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
        return MyShipAccountValidator.instance.getDescriptionValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "description";
    }

    @Override
    public MyShipAccountDao getDao()
    {
        return getAccess().getShipAccountDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyShipAccount model)
    {
        return model.getDescription();
    }
    
    @Override
    public void setValueFor(MyShipAccount model, String value)
    {
        model.setDescription(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipAccount model, String value)
    {
        return model.hasDescription(value);
    }
    
}
