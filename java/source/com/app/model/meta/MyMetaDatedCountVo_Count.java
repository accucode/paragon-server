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

public class MyMetaDatedCountVo_Count
    extends KmMetaIntegerProperty<MyDatedCountVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "count";
    }

    @Override
    public String getLabel()
    {
        return "Count";
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
        return MyDatedCountVoValidator.instance.getCountValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Integer getValueFor(MyDatedCountVo model)
    {
        return model.getCount();
    }

    @Override
    public void setValueFor(MyDatedCountVo model, Integer value)
    {
        model.setCount(value);
    }

    @Override
    public boolean hasValueFor(MyDatedCountVo model, Integer value)
    {
        return model.hasCount(value);
    }

}
