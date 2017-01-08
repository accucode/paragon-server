package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.utility.Kmu;

public abstract class KmgModelAttribute
    extends KmgElement
{
    //##################################################
    //# constructor
    //##################################################

    public KmgModelAttribute(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# methods
    //##################################################

    /**
     * If true, this attribute requires an instance variable.
     * E.g.: overridden by delegates.
     */
    public boolean requiresVariable()
    {
        return true;
    }

    public boolean isString()
    {
        return false;
    }

    public boolean isInteger()
    {
        return false;
    }

    public boolean isBoolean()
    {
        return false;
    }

    //##################################################
    //# accessing
    //##################################################

    public abstract String getName();

    public boolean hasName(String e)
    {
        return Kmu.isEqual(getName(), e);
    }

    //##################################################
    //# formatting
    //##################################################

    /**
     * Return the common name of this attribute.
     */
    public abstract String getf_name();

    public String getf_Name()
    {
        return Kmu.capitalizeFirstLetter(getf_name());
    }

    public String getf_NAME()
    {
        return Kmu.formatAsConstant(getf_name());
    }

    public String getf_getMethod()
    {
        return "get" + getf_Name();
    }

    public String getf_setMethod()
    {
        return "set" + getf_Name();
    }

    public String getf_hasMethod()
    {
        return "has" + getf_Name();
    }

    public String getf_variable()
    {
        return getf_name();
    }

    public String getf_Variable()
    {
        return Kmu.capitalizeFirstLetter(getf_variable());
    }

    public abstract String getf_Type();

    public String getf_ImplType()
    {
        return getf_Type();
    }

    public String getf_sqlColumn()
    {
        String msg = Kmu.format(
            "Sql column not available for attribute %s.%s.",
            getModel().getName(),
            getName());

        throw new UnsupportedOperationException(msg);
    }
}
