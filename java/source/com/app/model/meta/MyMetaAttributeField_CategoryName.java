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

public class MyMetaAttributeField_CategoryName
    extends KmMetaStringProperty<MyAttributeField>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "categoryName";
    }

    @Override
    public String getLabel()
    {
        return "Category";
    }

    @Override
    public String getHelp()
    {
        return "The type of model this attribute applies to.  E.g.: product, site.";
    }
    
    @Override
    public int getColumnWidth()
    {
        return 15;
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
    public String getValueFor(MyAttributeField model)
    {
        return model.getCategoryName();
    }
    
    @Override
    public boolean hasValueFor(MyAttributeField model, String value)
    {
        return model.hasCategoryName(value);
    }
    
}
