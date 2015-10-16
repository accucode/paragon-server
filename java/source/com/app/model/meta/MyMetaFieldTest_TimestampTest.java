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

public class MyMetaFieldTest_TimestampTest
    extends KmMetaTimestampProperty<MyFieldTest>
    implements KmMetaDaoPropertyIF<MyFieldTest,KmTimestamp>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "timestampTest";
    }

    @Override
    public String getLabel()
    {
        return "Timestamp Test";
    }

    @Override
    public String getHelp()
    {
        return null;
    }
    
    @Override
    public int getColumnWidth()
    {
        return 16;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmTimestampValidator getValidator()
    {
        return MyFieldTestValidator.instance.getTimestampTestValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "timestampTest";
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
    public KmTimestamp getValueFor(MyFieldTest model)
    {
        return model.getTimestampTest();
    }
    
    @Override
    public void setValueFor(MyFieldTest model, KmTimestamp value)
    {
        model.setTimestampTest(value);
    }
    
    @Override
    public boolean hasValueFor(MyFieldTest model, KmTimestamp value)
    {
        return model.hasTimestampTest(value);
    }
    
}
