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

public enum MyDownloadType
    implements MyDownloadTypeIF
{
    //##################################################
    //# values
    //##################################################

    File("File", "File"),
    Attachment("Attachment", "Attachment"),
    Bytes("Bytes", "Bytes"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyDownloadType> _values;
    private static final KmMap<String,MyDownloadType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyDownloadType e : EnumSet.allOf(MyDownloadType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyDownloadType> getValues()
    {
        return _values;
    }

    public static MyDownloadType findCode(String code)
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

    private MyDownloadType(String code, String label)
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

    public boolean isFile()
    {
        return this == File;
    }

    public boolean isAttachment()
    {
        return this == Attachment;
    }

    public boolean isBytes()
    {
        return this == Bytes;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyDownloadType getAt(int index)
    {
        return values()[index];
    }

    public static MyDownloadType getFirst()
    {
        return values()[0];
    }

    public static MyDownloadType getLast()
    {
        return values()[values().length - 1];
    }

    public MyDownloadType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyDownloadType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
