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

public class MyMetaProject_Name
    extends KmMetaStringProperty<MyProject>
    implements KmMetaDaoPropertyIF<MyProject,String>
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
        return "The display name.";
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
        return MyProjectValidator.instance.getNameValidator();
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
    public MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyProject model)
    {
        return model.getName();
    }
    
    @Override
    public void setValueFor(MyProject model, String value)
    {
        model.setName(value);
    }
    
    @Override
    public boolean hasValueFor(MyProject model, String value)
    {
        return model.hasName(value);
    }
    
    @Override
    public int compareValues(MyProject o1, MyProject o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
