package com.kodemore.meta;

import com.kodemore.servlet.field.ScBarcodeField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.field.ScTimeZoneCodeField;
import com.kodemore.validator.KmStringValidator;

public abstract class KmMetaStringProperty<T>
    extends KmMetaProperty<T,String>
{
    //##################################################
    //# field
    //##################################################

    @Override
    public ScTextField newField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setMeta(this);
        return e;
    }

    @Override
    public ScTextField newField(String label)
    {
        ScTextField e;
        e = newField();
        e.setLabel(label);
        return e;
    }

    public ScHiddenField<String> newHiddenField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        e.setValueAdaptor(this);
        return e;
    }

    public ScTextArea newMultilineField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setMeta(this);
        e.layoutBlock();
        return e;
    }

    public ScTextArea newMultilineField(String label)
    {
        ScTextArea e;
        e = newMultilineField();
        e.setLabel(label);
        return e;
    }

    public ScTimeZoneCodeField newTimeZoneDropdown()
    {
        ScTimeZoneCodeField e;
        e = new ScTimeZoneCodeField();
        e.setMeta(this);
        return e;
    }

    public ScBarcodeField newBarcodeField()
    {
        ScBarcodeField e;
        e = new ScBarcodeField();
        e.setMeta(this);
        return e;
    }

    //##################################################
    //# retyping
    //##################################################

    @Override
    public KmStringValidator getValidator()
    {
        return null;
    }
}
