package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

/**
 * I abstract the optional information about a field's
 * enum mapping.
 */
public class KmgModelEnumValue
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The short code used to identify the specific enum value
     * in the database.  Changing codes will usually require
     * a database migration.
     */
    private String _code;

    /**
     * The name of the enum as used in the java code.  The name
     * can be changed without touching the database, but it will
     * usually require refactoring of the java code.
     */
    private String _name;

    /**
     * The label is used for a display value and should be suitable
     * for use on screens displayed to end users.  By default, the
     * label is simply the name with spaces injected between the
     * words.  The intent is that the label can be changed without
     * any impact on java code or the database.
     */
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelEnumValue(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getCode()
    {
        return _code;
    }

    public String getName()
    {
        return _name;
    }

    public String getLabel()
    {
        return _label;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkChildrenNames(x);
        checkAttributeKeys(x, "code", "name", "label");

        _code = parseStringAttribute(x, "code", null);
        _name = parseStringAttribute(x, "name", null);
        _label = parseStringAttribute(x, "label", null);

        if ( Kmu.isEmpty(_code) )
            throw newError(x, "Enum code is required.");

        if ( Kmu.isEmpty(_name) )
            _name = _code;

        if ( Kmu.isEmpty(_label) )
            _label = Kmu.formatAsCapitalizedNames(_name);
    }

    @Override
    public void validate()
    {
        // none
    }

    @Override
    public void postValidate()
    {
        // none
    }

    //##################################################
    //# reflection
    //##################################################

    public String getf_CODE()
    {
        return capitalize(getCode());
    }

    public String getf_Name()
    {
        return capitalize(getName());
    }
}
