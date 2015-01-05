package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;

/**
 * I abstract the optional information about the attributes
 * that a fields depends on.
 */
public class KmgModelFieldDependsOn
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The list of values that it depends on.
     */
    private KmList<String> _values;

    /**
     * The method to call when any of the attributes change.
     */
    private String         _onChange;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelFieldDependsOn(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<String> getValues()
    {
        return _values;
    }

    public String getOnChange()
    {
        return _onChange;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmgModelField getField()
    {
        return (KmgModelField)getParent();
    }

    //##################################################
    //# format
    //##################################################

    public KmList<KmgModelAttribute> getAttributes()
    {
        KmList<KmgModelAttribute> v = new KmList<>();
        KmgModel m = getModel();
        for ( String s : _values )
        {
            KmgModelField f = m.getField(s);
            if ( f != null )
            {
                v.add(f);
                continue;
            }

            KmgModelAssociation a = m.getAssociation(s);
            if ( a != null )
            {
                v.add(a);
                continue;
            }

            throw newFatal("Unknown depend value (%s).", s);
        }
        return v;
    }

    public KmList<KmgModelField> getFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelAttribute e : getAttributes() )
            if ( e instanceof KmgModelField )
                v.add((KmgModelField)e);
        return v;
    }

    public KmList<KmgModelAssociation> getAssociations()
    {
        KmList<KmgModelAssociation> v = new KmList<>();
        for ( KmgModelAttribute e : getAttributes() )
            if ( e instanceof KmgModelAssociation )
                v.add((KmgModelAssociation)e);
        return v;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        _values = parseStrings(e, "value");

        if ( _values.isEmpty() )
            throw newFatal(e, "depend values is empty.");

        String def = "update" + getField().getf_Name();

        _onChange = parseString(e, "onChange", def);
    }

    @Override
    public void validate()
    {
        getAttributes();
    }

    @Override
    public void postValidate()
    {
        for ( KmgModelField e : getFields() )
            e.addOnChangeMethod(getOnChange());

        for ( KmgModelAssociation e : getAssociations() )
            e.addOnChangeMethod(getOnChange());
    }
}
