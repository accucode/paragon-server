package com.kodemore.property;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmComparator;
import com.kodemore.property.type.KmPropertyTypeIF;
import com.kodemore.time.KmTime;
import com.kodemore.utility.Kmu;

/**
 * A property represents the template, or type, of a property but
 * does not store a specific value.  The values are stored in tiered
 * instances of propertyRegistries for increased flexibility.
 */
public class KmPropertyDefinition
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The property key, or name.  This is the value used to look up the
     * properties value in a given file or database table.
     */
    private String           _key;

    /**
     * The type specifies the value's format; e.g.: integer, string, date.
     * The types are well defined but easily extensible.
     */
    private KmPropertyTypeIF _type;

    /**
     * The default value that should be used if no value for this property
     * is specified in the pertinent property registries.  Although stored
     * as a string, the default value must be compatible with the type.
     */
    private String           _defaultValue;

    /**
     * The group is used solely for organization of documentation and source
     * code.  Multiple properties that related to the same logical part of the
     * application should be given the same group.
     */
    private String           _group;

    /**
     * A freeform comment that describes the purpose and usage of the property.
     */
    private String           _comment;

    /**
     * A list of arbitrary flags.  The valid flags are defined on an application
     * specific basis.  The application specific tool that launches the code
     * generation is responsible for definining the list of valid flags that
     * may appear in the property definition xml file.
     */
    private KmList<String>   _flags;

    //##################################################
    //# constructor
    //##################################################

    public KmPropertyDefinition()
    {
        _flags = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public void setKey(String e)
    {
        _key = e;
    }

    public KmPropertyTypeIF getType()
    {
        return _type;
    }

    public void setType(KmPropertyTypeIF e)
    {
        _type = e;
    }

    public String getDefaultValue()
    {
        return _defaultValue;
    }

    public void setDefaultValue(String e)
    {
        _type.validateValue(_key, e);
        _defaultValue = e;
    }

    public String getGroup()
    {
        return _group;
    }

    public void setGroup(String e)
    {
        _group = e;
    }

    public boolean hasGroup(String s)
    {
        return Kmu.isEqual(_group, s);
    }

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String e)
    {
        _comment = e;
    }

    public KmList<String> getFlags()
    {
        return _flags;
    }

    public void setFlags(KmList<String> e)
    {
        _flags = e;
    }

    public void addFlag(String e)
    {
        _flags.add(e);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public Object getObjectFor(KmPropertyRegistry pr)
    {
        String s = getRawValueFor(pr);
        return getType().convertValue(getKey(), s);
    }

    public String getStringFor(KmPropertyRegistry pr)
    {
        return (String)getObjectFor(pr);
    }

    @SuppressWarnings("unchecked")
    public KmList<String> getStringListFor(KmPropertyRegistry pr)
    {
        return (KmList<String>)getObjectFor(pr);
    }

    public Boolean getBooleanFor(KmPropertyRegistry pr)
    {
        return (Boolean)getObjectFor(pr);
    }

    public Double getDoubleFor(KmPropertyRegistry pr)
    {
        return (Double)getObjectFor(pr);
    }

    public Integer getIntegerFor(KmPropertyRegistry pr)
    {
        return (Integer)getObjectFor(pr);
    }

    public KmTime getTimeFor(KmPropertyRegistry pr)
    {
        return (KmTime)getObjectFor(pr);
    }

    public String getRawValueFor(KmPropertyRegistry pr)
    {
        String s = pr._getRawValue(getKey());
        if ( s == null )
            s = getDefaultValue();
        return s;
    }

    //##################################################
    //# install
    //##################################################

    public void postInstall()
    {
        // subclass override, this gives the application specific class
        // a convenience hook to do additional work after the base property
        // has been installed.
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasFlag(String e)
    {
        return _flags.contains(e);
    }

    //##################################################
    //# static sort
    //##################################################

    public static void sortOnKey(KmList<? extends KmPropertyDefinition> v)
    {
        v.sortOn(new KmComparator<KmPropertyDefinition>()
        {
            @Override
            public int compare(KmPropertyDefinition a, KmPropertyDefinition b)
            {
                return a.getKey().compareTo(b.getKey());
            }
        });
    }

}
