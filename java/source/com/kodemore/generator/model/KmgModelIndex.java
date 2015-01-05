package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelIndex
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String         _name;
    private boolean        _unique;
    private KmList<String> _attributeNames;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelIndex(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        _name = parseRequiredString(x, "name");
        _unique = parseBoolean(x, "unique");

        _attributeNames = new KmList<>();

        KmList<String> ons = parseStrings(x, "on");
        for ( String on : ons )
        {
            KmList<String> tokens = Kmu.tokenize(on);
            Kmu.trimValues(tokens);

            _attributeNames.addAll(tokens);
        }
    }

    @Override
    public void validate()
    {
        for ( String name : getAttributeNames() )
        {
            KmgModelAttribute a = getModel().getAttributeNamed(name);
            if ( a == null )
                throw newFatal("Unknown index attribute (%s).", name);
        }
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
        return "model database";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public boolean getUnique()
    {
        return _unique;
    }

    public KmList<String> getAttributeNames()
    {
        return _attributeNames;
    }

    public KmList<KmgModelAttribute> getAttributes()
    {
        KmList<KmgModelAttribute> v = new KmList<>();
        for ( String e : getAttributeNames() )
            v.add(getModel().getAttributeNamed(e));
        return v;
    }

    public KmList<String> getColumnNames()
    {
        KmList<String> v = new KmList<>();
        for ( KmgModelAttribute e : getAttributes() )
            v.add(e.getf_sqlColumn());
        return v;
    }

    public String getf_columnNames()
    {
        return getColumnNames().format(", ");
    }

    public String getf_unique()
    {
        if ( getUnique() )
            return "unique ";
        return "";
    }
}
