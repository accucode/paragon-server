package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.proto.KmProtoType;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelDelegate
    extends KmgModelAttribute
    implements KmgModelFieldIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The name of the field.
     */
    private String _fieldName;

    /**
     * If not specified, the name normally defaults to the
     * parent's name, plus the fieldName.
     */
    private String _nameOverride;

    /**
     * Used for display labels.  Optional, if not specified, use name.
     */
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelDelegate(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# abstract
    //##################################################

    @Override
    public boolean requiresVariable()
    {
        return false;
    }

    @Override
    public boolean isString()
    {
        return getField().isString();
    }

    @Override
    public boolean isBoolean()
    {
        return getField().isBoolean();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getFieldName()
    {
        return _fieldName;
    }

    public void setFieldName(String s)
    {
        _fieldName = s;
    }

    public KmgModelFieldIF getField()
    {
        KmgModel model = getAttribute().getModelReference();

        KmgModelField f = model.getField(_fieldName);
        if ( f != null )
            return f;

        return model.getDelegate(_fieldName);
    }

    public String getNameOverride()
    {
        return _nameOverride;
    }

    public void setNameOverride(String e)
    {
        _nameOverride = e;
    }

    public boolean hasNameOverride()
    {
        return Kmu.hasValue(_nameOverride);
    }

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String e)
    {
        _label = e;
    }

    public boolean hasLabel()
    {
        // empty string is a valid value.
        return _label != null;
    }

    @Override
    public String getName()
    {
        if ( hasNameOverride() )
            return getNameOverride();
        return getAttribute().getName() + Kmu.capitalizeFirstLetter(getFieldName());
    }

    @Override
    public boolean hasName(String s)
    {
        return getName().equals(s);
    }

    @Override
    public boolean isRequired()
    {
        return getField().isRequired();
    }

    @Override
    public String getHelp()
    {
        return getField().getHelp();
    }

    public boolean hasHelp()
    {
        return getHelp() != null;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmgModelAssociation getAttribute()
    {
        return (KmgModelAssociation)getParent();
    }

    @Override
    public KmgModel getModel()
    {
        return getParent().getModel();
    }

    @Override
    public KmgModelType getType()
    {
        return getField().getType();
    }

    @Override
    public boolean isAbstract()
    {
        return getField().isAbstract();
    }

    //##################################################
    //# ui control
    //##################################################

    public boolean isEditable()
    {
        return !isAbstract();
    }

    public boolean hasEditControl()
    {
        return getProtoType().hasEditControlClass();
    }

    public boolean hasEditControlValidation()
    {
        return getProtoType().hasValidatorClass();
    }

    //##################################################
    //# base type
    //##################################################

    @Override
    public KmProtoType getProtoType()
    {
        return getType().getProtoType();
    }

    public boolean hasProtoType(String s)
    {
        return getType().hasProtoType(s);
    }

    public boolean hasProtoType()
    {
        return getType().hasProtoType();
    }

    //##################################################
    //# meta
    //##################################################

    @Override
    public boolean isMeta()
    {
        return true;
    }

    public String getf_MetaClass()
    {
        return getModel().getf_MetaClass() + "_" + getf_Name();
    }

    public String getf_MetaSuperClass()
    {
        String metaSuper = getProtoType().format_MetaSuperClass();
        String modelClass = getModel().getf_Class();

        return Kmu.format("%s<%s>", metaSuper, modelClass);
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkAttributeKeys(x, "fieldName", "name", "label");

        _fieldName = parseRequiredName(x, "fieldName");
        _nameOverride = parseName(x, "name");
        _label = parseString(x, "label", null);
    }

    @Override
    public void validate()
    {
        if ( getField() == null )
            throw newFatal(
                "Cannot resolve attribute(%s) field(%s).",
                getAttribute().getName(),
                _fieldName);
    }

    @Override
    public void postValidate()
    {
        // none
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String getf_name()
    {
        return Kmu.toKneelingCamelCase(getName());
    }

    public String getf_help()
    {
        return Kmu.encodeJavaString(getHelp());
    }

    @Override
    public String getf_Type()
    {
        return getField().getf_Type();
    }

    @Override
    public String getf_ADAPTOR()
    {
        return getf_Name() + "Adaptor";
    }

    @Override
    public String getf_COMPARATOR()
    {
        return getf_Name() + "Comparator";
    }

    public String getf_label()
    {
        if ( hasLabel() )
            return getLabel();

        return Kmu.formatCamelCaseAsWords(getf_Name());
    }

    public String getf_ValidatorClass()
    {
        return getProtoType().format_ValidatorClass();
    }

    public String getf_columnWidth()
    {
        return getField().getType().getf_columnWidth();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("delegate(%s)", getName());
    }

}
