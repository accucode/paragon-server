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

public class MyMetaFile_UpdatedLocalTs
    extends KmMetaTimestampProperty<MyFile>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "updatedLocalTs";
    }

    @Override
    public String getLabel()
    {
        return "Updated";
    }

    @Override
    public String getHelp()
    {
        return "The updated timestamp converted to the user's local timezone.";
    }

    @Override
    public int getColumnWidth()
    {
        return 16;
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
    public KmTimestamp getValueFor(MyFile model)
    {
        return model.getUpdatedLocalTs();
    }

    @Override
    public boolean hasValueFor(MyFile model, KmTimestamp value)
    {
        return model.hasUpdatedLocalTs(value);
    }

}
