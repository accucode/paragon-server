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

public class MyMetaEndUserSite_AddressCountry
    extends KmMetaStringProperty<MyEndUserSite>
    implements KmMetaDaoPropertyIF<MyEndUserSite,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "addressCountry";
    }

    @Override
    public String getLabel()
    {
        return "Address Country";
    }

    @Override
    public String getHelp()
    {
        return "The name or abbreviation of the country.";
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
        return MyEndUserSiteValidator.instance.getAddressCountryValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "addressCountry";
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
        return model.getAddressCountry();
    }
    
    @Override
    public void setValueFor(MyEndUserSite model, String value)
    {
        model.setAddressCountry(value);
    }
    
    @Override
    public boolean hasValueFor(MyEndUserSite model, String value)
    {
        return model.hasAddressCountry(value);
    }
    
}
