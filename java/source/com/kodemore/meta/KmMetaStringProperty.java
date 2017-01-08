package com.kodemore.meta;

import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.time.KmTimeZone;
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
        return newField(getLabel());
    }

    @Override
    public ScTextField newField(String label)
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValueAdaptor(this);
        e.setValidator(getValidator());
        return e;
    }

    public ScTextArea newMultilineField()
    {
        return newMultilineField(getLabel());
    }

    public ScTextArea newMultilineField(String label)
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel(label);
        e.setHelp(getHelp());
        e.setValueAdaptor(this);
        e.setValidator(getValidator());
        e.layoutBlock(65);
        return e;
    }

    public ScDropdownField<String> newTimeZoneDropdown()
    {
        ScDropdownField<String> dd;
        dd = new ScDropdownField<>();
        dd.setLabel(getLabel());
        dd.setHelp(getHelp());
        dd.setValueAdaptor(this);
        dd.setValidator(getValidator());

        if ( getValidator().isRequired() )
            dd.setNullSelectPrefix();
        else
            dd.setNullNonePrefix();

        for ( KmTimeZone e : KmTimeZone.getCommonZones() )
            dd.addOption(e.getCode(), e.getName());

        dd.addOption(null, "--------------------");

        for ( KmTimeZone e : KmTimeZone.getAllZones() )
            dd.addOption(e.getCode(), e.getName());

        return dd;
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
