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

public class MyMetaNamedIntegerVo_Value
    extends KmMetaIntegerProperty<MyNamedIntegerVo>
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
    public KmIntegerValidator getValidator()
    {
        return MyNamedIntegerVoValidator.instance.getValueValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyNamedIntegerVo model)
    {
        return model.getValue();
    }

    @Override
    public void setValueFor(MyNamedIntegerVo model, Integer value)
    {
        model.setValue(value);
    }

    @Override
    public boolean hasValueFor(MyNamedIntegerVo model, Integer value)
    {
        return model.hasValue(value);
    }

}
