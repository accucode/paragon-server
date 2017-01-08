package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

/**
 * I abstract the optional information about a field's
 * enum mapping.
 */
public class KmgModelEnum
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The class that defines the Enum.  E.g.: MyStatusEnum.
     * Normally this is set automatically based on the name
     * of the model, combined with the name of the field.
     * For example: If the model.field = Order.statusCode,
     * then the type is assumed to be OrderStatus.
     */
    private String                    _type;

    /**
     * The name of the enum.  Normally, this is set automatically
     * based on the name of the field.  E.g.: if the field's name
     * is statusCode, then it is assumed that the enum's name
     * is status.
     */
    private String                    _name;

    /**
     * The individual values of the enum.
     */
    private KmList<KmgModelEnumValue> _values;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelEnum(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getType()
    {
        return _type;
    }

    public String getName()
    {
        return _name;
    }

    public KmList<KmgModelEnumValue> getValues()
    {
        return _values;
    }

    public KmgModelField getField()
    {
        return (KmgModelField)getParent();
    }

    //##################################################
    //# format
    //##################################################

    public String getf_name()
    {
        return getName();
    }

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

    public String getf_Class()
    {
        return _type;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkAttributeKeys(x, "type", "name");
        checkChildrenNames(x, "value");

        parseType(x);
        parseName(x);
        parseValues(x);
    }

    private void parseType(KmStfElement x)
    {
        _type = parseString(x, "type", null);

        if ( _type == null )
        {
            String prefix = getf_Prefix();
            String modelName = getModel().getf_Name();
            String fieldName = Kmu.removeSuffix(getField().getf_Name(), "Code");
            _type = prefix + modelName + fieldName;
        }
    }

    private void parseName(KmStfElement x)
    {
        _name = parseString(x, "name", null);

        if ( _name == null )
        {
            String suffix = "Code";
            String s = getField().getName();
            if ( s.endsWith(suffix) )
                _name = Kmu.removeSuffix(s, suffix);
        }

        if ( _name == null )
            throw newError(x, "Cannot determine enum name.");
    }

    private void parseValues(KmStfElement x)
    {
        _values = new KmList<>();

        KmList<KmStfElement> v = x.getChildren("value");
        for ( KmStfElement e : v )
        {
            KmgModelEnumValue value;
            value = new KmgModelEnumValue(this);
            value.parse(e);
            _values.add(value);
        }
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
        return Kmu.format("enum(%s)", _name);
    }

}
