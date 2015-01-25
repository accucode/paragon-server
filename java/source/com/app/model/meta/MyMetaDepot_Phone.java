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
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
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

public class MyMetaDepot_Phone
    extends KmMetaStringProperty<MyDepot>
    implements KmMetaDaoPropertyIF<MyDepot,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "phone";
    }

    @Override
    public String getLabel()
    {
        return "Phone";
    }

    @Override
    public String getHelp()
    {
        return "The primary phone number for the depot related to this project.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 12;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyDepotValidator.instance.getPhoneValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "phone";
    }

    @Override
    public MyDepotDao getDao()
    {
        return getAccess().getDepotDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyDepot model)
    {
        return model.getPhone();
    }
    
    @Override
    public void setValueFor(MyDepot model, String value)
    {
        model.setPhone(value);
    }
    
    @Override
    public boolean hasValueFor(MyDepot model, String value)
    {
        return model.hasPhone(value);
    }
    
    @Override
    public int compareValues(MyDepot o1, MyDepot o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
