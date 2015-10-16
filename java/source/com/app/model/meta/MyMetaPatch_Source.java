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

public class MyMetaPatch_Source
    extends KmMetaStringProperty<MyPatch>
    implements KmMetaDaoPropertyIF<MyPatch,String>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "source";
    }

    @Override
    public String getLabel()
    {
        return "Source";
    }

    @Override
    public String getHelp()
    {
        return "The full raw script.  This contains both the text originally used to upgrade, as well as the text used to subsequently downgrade.  Each script has a maximum length of 50,000 characters.";
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
        return MyPatchValidator.instance.getSourceValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "source";
    }

    @Override
    public MyPatchDao getDao()
    {
        return getAccess().getPatchDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPatch model)
    {
        return model.getSource();
    }
    
    @Override
    public void setValueFor(MyPatch model, String value)
    {
        model.setSource(value);
    }
    
    @Override
    public boolean hasValueFor(MyPatch model, String value)
    {
        return model.hasSource(value);
    }
    
}
