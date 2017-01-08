package com.app.model.support;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

public enum MyTheme
                implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Default("default", "Default"),
    Blue("blue", "Blue");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyTheme>       _values;
    private static final KmMap<String,MyTheme> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyTheme e : EnumSet.allOf(MyTheme.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyTheme> getValues()
    {
        return _values;
    }

    public static MyTheme findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The code serves as both the PATH to the web resources,
     * and also the database identifier.
     */
    private String _code;

    /**
     * The label is displayed to end users.
     */
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyTheme(String code, String label)
    {
        _code = code;
        _label = label;
    }

    //##################################################
    //# instructions
    //##################################################

    /**
     * The process of adding a new theme is as follows:
     *
     * 1) Add the new enum value.
     *      The enum's code is used in subsequent steps.
     *
     * 2) Copy the 'default' folder.
     *      The new folder should match the enum's code.
     *      /4Work/web/static/version/app/theme/default/**
     *
     * 3) Update the Eclipse Builder.
     *      Menu > project > properties...
     *      Builders > stylus ant > edit...
     *      build options > specific resources...
     *      Add ONLY the new theme.styl & variables.styl
     *
     * 4) Edit the new variables.styl
     *      The corresponding css should be automatically updated.
     *
     * 5) Restart the application.
     *      The new theme should be available on the Tenant Edit page.
     */
    @SuppressWarnings("unused")
    private void _README()
    {
        switch ( this )
        {
            case Blue:
            case Default:
                // see method comment
                break;
        }
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

    public String getWebFolder()
    {
        return getCode();
    }

}
