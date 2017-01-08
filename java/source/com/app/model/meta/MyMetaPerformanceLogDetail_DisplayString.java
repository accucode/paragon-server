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
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaPerformanceLogDetail_DisplayString
    extends KmMetaStringProperty<MyPerformanceLogDetail>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "displayString";
    }

    @Override
    public String getLabel()
    {
        return "Display String";
    }

    @Override
    public String getHelp()
    {
        return "A human readable semi-unique value used to identify each model. This typically uses something like the model's name or code which is expected to be unique enough to distinish between the different values within a particular project.";
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
    public String getValueFor(MyPerformanceLogDetail model)
    {
        return model.getDisplayString();
    }

    @Override
    public boolean hasValueFor(MyPerformanceLogDetail model, String value)
    {
        return model.hasDisplayString(value);
    }

}
