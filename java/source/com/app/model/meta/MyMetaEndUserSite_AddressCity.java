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

public class MyMetaEndUserSite_AddressCity
    extends KmMetaStringProperty<MyEndUserSite>
    implements KmMetaDaoPropertyIF<MyEndUserSite,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "addressCity";
    }

    @Override
    public String getLabel()
    {
        return "Address City";
    }

    @Override
    public String getHelp()
    {
        return "The name of the city.";
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
        return MyEndUserSiteValidator.instance.getAddressCityValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "addressCity";
    }

    @Override
    public MyEndUserSiteDao getDao()
    {
        return getAccess().getEndUserSiteDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyEndUserSite model)
    {
        return model.getAddressCity();
    }
    
    @Override
    public void setValueFor(MyEndUserSite model, String value)
    {
        model.setAddressCity(value);
    }
    
    @Override
    public boolean hasValueFor(MyEndUserSite model, String value)
    {
        return model.hasAddressCity(value);
    }
    
}
