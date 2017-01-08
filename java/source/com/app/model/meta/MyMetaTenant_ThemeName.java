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

public class MyMetaTenant_ThemeName
    extends KmMetaStringProperty<MyTenant>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "themeName";
    }

    @Override
    public String getLabel()
    {
        return "Theme";
    }

    @Override
    public String getHelp()
    {
        return "The display name of the current theme.";
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
    public String getValueFor(MyTenant model)
    {
        return model.getThemeName();
    }

    @Override
    public boolean hasValueFor(MyTenant model, String value)
    {
        return model.hasThemeName(value);
    }

}
