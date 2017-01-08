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

public class MyMetaNamedIntegerVo_Name
    extends KmMetaStringProperty<MyNamedIntegerVo>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "name";
    }

    @Override
    public String getLabel()
    {
        return "Name";
    }

    @Override
    public String getHelp()
    {
        return "The display name.";
    }

    @Override
    public int getColumnWidth()
    {
        return 20;
    }

    @Override
    public boolean isEditable()
    {
        return true;
    }

    @Override
    public KmStringValidator getValidator()
    {
        return MyNamedIntegerVoValidator.instance.getNameValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValueFor(MyNamedIntegerVo model)
    {
        return model.getName();
    }

    @Override
    public void setValueFor(MyNamedIntegerVo model, String value)
    {
        model.setName(value);
    }

    @Override
    public boolean hasValueFor(MyNamedIntegerVo model, String value)
    {
        return model.hasName(value);
    }

}
