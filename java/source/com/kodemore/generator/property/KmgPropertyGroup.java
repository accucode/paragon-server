package com.kodemore.generator.property;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgPropertyGroup
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String              _name;
    private KmList<KmgProperty> _properties = new KmList<>();

    //##################################################
    //# constructor
    //##################################################

    public KmgPropertyGroup(KmgElement parent)
    {
        super(parent);
    }

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

    public KmList<KmgProperty> getProperties()
    {
        return _properties;
    }

    public KmgPropertyFile getFile()
    {
        return (KmgPropertyFile)getParent();
    }

    //##################################################
    //# format
    //##################################################

    public String getf_name()
    {
        return getName();
    }

    public String getf_CONSTANT()
    {
        String s = "group " + getName();
        return Kmu.formatAsConstant(s);
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        if ( !e.hasName("group") )
            throw Kmu.newFatal("Expected element: 'group'");

        _name = parseRequiredName(e, "name");

        for ( KmStfElement c : e.getChildren("property") )
        {
            KmgProperty p;
            p = new KmgProperty(this);
            p.parse(c);
            _properties.add(p);
        }

        _properties.sortOn(KmgProperty.getNameComparator());
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
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("PropertyGroup(%s)", getName());
    }

}
