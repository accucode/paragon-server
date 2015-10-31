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

public class MyMetaTimeZoneVo_DstOffsetMinutes
    extends KmMetaIntegerProperty<MyTimeZoneVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "dstOffsetMinutes";
    }

    @Override
    public String getLabel()
    {
        return "Dst Offset Minutes";
    }

    @Override
    public String getHelp()
    {
        return "dstOffsetMinutes";
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
    public Integer getValueFor(MyTimeZoneVo model)
    {
        return model.getDstOffsetMinutes();
    }
    
    @Override
    public boolean hasValueFor(MyTimeZoneVo model, Integer value)
    {
        return model.hasDstOffsetMinutes(value);
    }
    
}
