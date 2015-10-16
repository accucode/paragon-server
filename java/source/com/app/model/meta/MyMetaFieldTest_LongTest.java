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

public class MyMetaFieldTest_LongTest
    extends KmMetaLongProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,Long>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "longTest";
    }

    @Override
    public String getLabel()
    {
        return "Long Test";
    }

    @Override
    public String getHelp()
    {
        return null;
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
    public KmLongValidator getValidator()
    {
        return MyFieldTestValidator.instance.getLongTestValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "longTest";
    }

    @Override
    public MyFieldTestDao getDao()
    {
        return getAccess().getFieldTestDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public Long getValueFor(MyFieldTest model)
    {
        return model.getLongTest();
    }
    
    @Override
    public void setValueFor(MyFieldTest model, Long value)
    {
        model.setLongTest(value);
    }
    
    @Override
    public boolean hasValueFor(MyFieldTest model, Long value)
    {
        return model.hasLongTest(value);
    }
    
}
