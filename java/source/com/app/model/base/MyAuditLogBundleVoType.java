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

public enum MyAuditLogBundleVoType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Add("Add", "Add"),
    Update("Update", "Update"),
    Delete("Delete", "Delete"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyAuditLogBundleVoType> _values;
    private static final KmMap<String,MyAuditLogBundleVoType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyAuditLogBundleVoType e : EnumSet.allOf(MyAuditLogBundleVoType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyAuditLogBundleVoType> getValues()
    {
        return _values;
    }

    public static MyAuditLogBundleVoType findCode(String code)
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

    private MyAuditLogBundleVoType(String code, String label)
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

    public boolean isAdd()
    {
        return this == Add;
    }

    public boolean isUpdate()
    {
        return this == Update;
    }

    public boolean isDelete()
    {
        return this == Delete;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyAuditLogBundleVoType getAt(int index)
    {
        return values()[index];
    }

    public static MyAuditLogBundleVoType getFirst()
    {
        return values()[0];
    }

    public static MyAuditLogBundleVoType getLast()
    {
        return values()[values().length - 1];
    }

    public MyAuditLogBundleVoType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyAuditLogBundleVoType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
