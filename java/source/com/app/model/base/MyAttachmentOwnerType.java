//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.model.*;

public enum MyAttachmentOwnerType
    implements MyAttachmentOwnerTypeIF
{
    //##################################################
    //# values
    //##################################################

    Project("Project", "Project"),
    Customer("Customer", "Customer"),
    Site("Site", "Site"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyAttachmentOwnerType> _values;
    private static final KmMap<String,MyAttachmentOwnerType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyAttachmentOwnerType e : EnumSet.allOf(MyAttachmentOwnerType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyAttachmentOwnerType> getValues()
    {
        return _values;
    }

    public static MyAttachmentOwnerType findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyAttachmentOwnerType(String code, String label)
    {
        _code = code;
        _label = label;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    @Override
    public String getLabel()
    {
        return _label;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isProject()
    {
        return this == Project;
    }

    public boolean isCustomer()
    {
        return this == Customer;
    }

    public boolean isSite()
    {
        return this == Site;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyAttachmentOwnerType getAt(int index)
    {
        return values()[index];
    }

    public static MyAttachmentOwnerType getFirst()
    {
        return values()[0];
    }

    public static MyAttachmentOwnerType getLast()
    {
        return values()[values().length - 1];
    }

    public MyAttachmentOwnerType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyAttachmentOwnerType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
