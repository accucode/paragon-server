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

public class MyMetaInvitation_ClosedLocalDate
    extends KmMetaDateProperty<MyInvitation>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "closedLocalDate";
    }

    @Override
    public String getLabel()
    {
        return "Closed";
    }

    @Override
    public String getHelp()
    {
        return "The date and time when this invitation was closed (e.g.: accepted).";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 10;
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
    public KmDate getValueFor(MyInvitation model)
    {
        return model.getClosedLocalDate();
    }
    
    @Override
    public boolean hasValueFor(MyInvitation model, KmDate value)
    {
        return model.hasClosedLocalDate(value);
    }
    
    @Override
    public int compareValues(MyInvitation o1, MyInvitation o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
