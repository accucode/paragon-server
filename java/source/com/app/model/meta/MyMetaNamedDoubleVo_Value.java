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

public class MyMetaNamedDoubleVo_Value
    extends KmMetaDoubleProperty<MyNamedDoubleVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "value";
    }

    @Override
    public String getLabel()
    {
        return "Value";
    }

    @Override
    public String getHelp()
    {
        return null;
    }

    @Override
    public int getColumnWidth()
    {
        return 10;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmDoubleValidator getValidator()
    {
        return MyNamedDoubleVoValidator.instance.getValueValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Double getValueFor(MyNamedDoubleVo model)
    {
        return model.getValue();
    }

    @Override
    public void setValueFor(MyNamedDoubleVo model, Double value)
    {
        model.setValue(value);
    }

    @Override
    public boolean hasValueFor(MyNamedDoubleVo model, Double value)
    {
        return model.hasValue(value);
    }

}
