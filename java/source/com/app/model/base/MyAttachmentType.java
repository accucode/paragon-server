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

public enum MyAttachmentType
    implements MyAttachmentTypeIF
{
    //##################################################
    //# values
    //##################################################

    Other("Other", "Other"),
    Text("Text", "Text"),
    Pdf("Pdf", "Pdf"),
    Image("Image", "Image"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyAttachmentType> _values;
    private static final KmMap<String,MyAttachmentType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyAttachmentType e : EnumSet.allOf(MyAttachmentType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyAttachmentType> getValues()
    {
        return _values;
    }

    public static MyAttachmentType findCode(String code)
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

    private MyAttachmentType(String code, String label)
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

    public boolean isOther()
    {
        return this == Other;
    }

    public boolean isText()
    {
        return this == Text;
    }

    public boolean isPdf()
    {
        return this == Pdf;
    }

    public boolean isImage()
    {
        return this == Image;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyAttachmentType getAt(int index)
    {
        return values()[index];
    }

    public static MyAttachmentType getFirst()
    {
        return values()[0];
    }

    public static MyAttachmentType getLast()
    {
        return values()[values().length - 1];
    }

    public MyAttachmentType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyAttachmentType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
