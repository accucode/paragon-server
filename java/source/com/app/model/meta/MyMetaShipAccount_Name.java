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

public class MyMetaShipAccount_Name
    extends KmMetaStringProperty<MyShipAccount>
    implements KmMetaDaoPropertyIF<MyShipAccount,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "name";
    }

    @Override
    public String getLabel()
    {
        return "Name";
    }

    @Override
    public String getHelp()
    {
        return "The common display name.";
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
        return MyShipAccountValidator.instance.getNameValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "name";
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
        return model.getName();
    }
    
    @Override
    public void setValueFor(MyShipAccount model, String value)
    {
        model.setName(value);
    }
    
    @Override
    public boolean hasValueFor(MyShipAccount model, String value)
    {
        return model.hasName(value);
    }
    
}
