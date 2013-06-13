package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmgCssSelector
{
    //##################################################
    //# variables
    //##################################################

    private String _name;

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    //##################################################
    //# composite
    //##################################################

    public boolean isComposite()
    {
        return getCompositeElements() != null;
    }

    public String getCompositePrefix()
    {
        return getCompositeElements().get(0);
    }

    public String getCompositePart()
    {
        return getCompositeElements().get(1);
    }

    public String getCompositeFlavor()
    {
        return getCompositeElements().get(2);
    }

    /**
     * Composites are identified by the use of one or two
     * dashes in the name.  The format is:
     *      prefix-part-flavor
     *      
     * The flavor is optional.
     */
    private KmList<String> getCompositeElements()
    {
        String name = getName();
        if ( Kmu.isEmpty(name) )
            return null;

        String regex = "([^-]+)-([^-]+)-([^-]+)";
        return Kmu.getRegexGroups(name, regex);
    }

    //##################################################
    //# format
    //##################################################

    public String getf_name()
    {
        return getName();
    }

    public String getf_method()
    {
        String s;
        s = getName();
        s = Kmu.replaceAll(s, "-", "_");
        return s;
    }

    public String getf_constant()
    {
        return getf_method();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("cssSelector(%s)", getName());
    }
}
