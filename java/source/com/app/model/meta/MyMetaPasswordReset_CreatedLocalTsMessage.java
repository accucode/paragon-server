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

public class MyMetaPasswordReset_CreatedLocalTsMessage
    extends KmMetaStringProperty<MyPasswordReset>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "createdLocalTsMessage";
    }

    @Override
    public String getLabel()
    {
        return "Created";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyPasswordReset model)
    {
        return model.getCreatedLocalTsMessage();
    }
    
    @Override
    public boolean hasValueFor(MyPasswordReset model, String value)
    {
        return model.hasCreatedLocalTsMessage(value);
    }
    
    @Override
    public int compareValues(MyPasswordReset o1, MyPasswordReset o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
