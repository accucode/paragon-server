package com.kodemore.generator.property;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmComparator;
import com.kodemore.generator.KmgElement;
import com.kodemore.log.KmLog;
import com.kodemore.property.type.KmPropertyTypeIF;
import com.kodemore.property.type.KmPropertyTypes;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgProperty
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String           _name;
    private KmPropertyTypeIF _type;
    private String           _defaultValue;
    private String           _comment;

    //##################################################
    //# constructor
    //##################################################

    public KmgProperty(KmgElement parent)
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

    public KmPropertyTypeIF getType()
    {
        return _type;
    }

    public void setType(KmPropertyTypeIF e)
    {
        _type = e;
    }

    public boolean hasType(String s)
    {
        return Kmu.isEqual(_type, s);
    }

    public String getDefaultValue()
    {
        return _defaultValue;
    }

    public void setDefaultValue(String e)
    {
        _defaultValue = e;
    }

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String e)
    {
        _comment = e;
    }

    public KmgPropertyGroup getGroup()
    {
        return (KmgPropertyGroup)getParent();
    }

    public KmgPropertyFile getFile()
    {
        return getGroup().getFile();
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
        String s = "property " + capitalize(getName());
        return toConstant(s);
    }

    public String getf_MethodName()
    {
        return capitalize(getName());
    }

    public String getf_comment()
    {
        return getComment();
    }

    public String getf_commentEscaped()
    {
        String s;
        s = getComment();
        s = Kmu.replaceAll(s, "  ", " ", true);
        s = Kmu.replaceAll(s, "\n", "\\n");
        return s;
    }

    public String getf_TYPE_CONSTANT()
    {
        String s;
        s = "type " + getType().getName();
        s = Kmu.replaceAll(s, "..", " ");
        s = Kmu.replaceAll(s, ":", " ");
        s = s.toLowerCase();
        s = Kmu.formatAsConstant(s);
        return s;
    }

    public String getf_default()
    {
        return getDefaultValue();
    }

    public String getf_getTypeFor()
    {
        return getType().formatGetValueFor();
    }

    public String getf_javaType()
    {
        return getType().formatJavaType();
    }

    public String getf_type()
    {
        return getType().getName();
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        if ( !e.hasName("property") )
            Kmu.fatal("Invalid properties file.  Expected root: 'properties'.");

        _name = parseRequiredName(e, "name");

        String typeName = e.getValue("type");

        _type = KmPropertyTypes.getType(typeName);
        if ( _type == null )
            Kmu.fatal("Unknown type (%s) in property (%s).", typeName, _name);

        _defaultValue = e.getValue("default");
        _comment = e.getValue("comment");

        KmList<String> validTags = KmList.createStrings("name", "type", "default", "comment");

        KmList<String> keys;
        keys = e.getKeys().toDistinctList();
        keys.removeAll(validTags);

        if ( keys.isNotEmpty() )
            KmLog.warnTrace("Unknown property attributes: %s", keys.format());
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
        return Kmu.format("Property(%s)", getName());
    }

    //##################################################
    //# static comparators
    //##################################################

    public static KmComparator<KmgProperty> getNameComparator()
    {
        return new KmComparator<KmgProperty>()
        {
            @Override
            public int compare(KmgProperty o1, KmgProperty o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

}
