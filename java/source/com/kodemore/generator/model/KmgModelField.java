package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmComparator;
import com.kodemore.generator.KmgElement;
import com.kodemore.proto.KmProtoType;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelField
    extends KmgModelAttribute
    implements KmgModelFieldIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The name of the field.  The name should be defined in kneeling camel case.
     * E.g.: color, topColor, firstTopColor.
     */
    private String _name;

    /**
     * The optional display label used for this field.
     * If not specified, the name will be used to generate an default label format.
     * The label can be explicitly set to empty string to indicate that no label
     * should be used.
     */
    private String _label;

    /**
     * The free form comment of this field.
     */
    private String _comment;

    /**
     * The help text, suitable for display to users.
     */
    private String _help;

    /**
     * The data type.  All data types are defined in the types.stf file.
     */
    private KmgModelType _type;

    /**
     * Indicates that this field is part of the primary key.  If multiple
     * fields are flagged as a primary key, then their primary key sequence
     * is determined by their relative sequence in the fields list.
     */
    private boolean _primaryKey;

    /**
     * Indicates that this field is an auto-incrementing "identity" field.
     * Only one field per model can be identified as an identity field.
     * Also, the corresponding format must be an integer (or big integer)
     * type.
     */
    private boolean _identity;

    /**
     * Indicates the field is required.  For most types this simply means
     * non-null.  String types are also limited from being empty (length=0).
     */
    private boolean _required;

    /**
     * Used to indicate that this field is a getter rather than an editable field.
     */
    private boolean _abstract;

    /**
     * A string representation of the default value for this field.  If null,
     * then no default value will be set.  There is no checking until compile time;
     * the default value is just used exactly as is in the class's constructor.
     */
    private String _defaultValue;

    /**
     * The description of the enum mapping, if any.
     */
    private KmgModelEnum _enum;

    /**
     * The list of attributes that I depend on, and what
     * to do when any of those attributes changes.
     */
    private KmgModelDependsOn _dependsOn;

    /**
     * Call these methods when I change.
     */
    private KmList<String> _onChangeMethods;

    /**
     * The java code for a custom getter.
     */
    private String _getter;

    /**
     * There are currently three options.
     *      - true (default), changes are logged normally.
     *      - false, changes are NOT logged.
     *      - mask, changes are logged but always report *** as the value.
     */
    private String _auditLogMode;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelField(KmgElement parent)
    {
        super(parent);
        _onChangeMethods = new KmList<>();
        _auditLogMode = "true";
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    @Override
    public boolean hasName(String s)
    {
        return Kmu.isEqual(_name, s);
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
        // label may be empty string
        return _label != null;
    }

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String e)
    {
        _comment = e;
    }

    public boolean hasComment()
    {
        return Kmu.hasValue(getComment());
    }

    @Override
    public String getHelp()
    {
        return _help;
    }

    public void setHelp(String e)
    {
        _help = e;
    }

    public boolean hasHelp()
    {
        return Kmu.hasValue(getHelp());
    }

    @Override
    public KmgModelType getType()
    {
        return _type;
    }

    @Override
    public KmProtoType getProtoType()
    {
        return getType().getProtoType();
    }

    public void setType(KmgModelType e)
    {
        _type = e;
    }

    public void setType(String name)
    {
        KmgModelType type = getRoot().getType(name);
        if ( type == null )
            throw newFatal("Unknown type: " + type);

        _type = type;
    }

    public boolean isPrimaryKey()
    {
        return _primaryKey;
    }

    public boolean isNotPrimaryKey()
    {
        return !isPrimaryKey();
    }

    public void setPrimaryKey(boolean e)
    {
        _primaryKey = e;
    }

    public boolean isIdentity()
    {
        return _identity;
    }

    public void setIdentity(boolean e)
    {
        _identity = e;
    }

    @Override
    public boolean isRequired()
    {
        return _required;
    }

    public void setRequired(boolean e)
    {
        _required = e;
    }

    public boolean hasValidator()
    {
        return isEditable();
    }

    public boolean isEditable()
    {
        return !isAbstract();
    }

    @Override
    public boolean isAbstract()
    {
        return _abstract;
    }

    public void setAbstract(boolean e)
    {
        _abstract = e;
    }

    public String getDefaultValue()
    {
        return _defaultValue;
    }

    public void setDefaultValue(String e)
    {
        _defaultValue = e;
    }

    public boolean hasDefaultValue()
    {
        return Kmu.hasValue(_defaultValue);
    }

    public boolean hasEditControl()
    {
        return getProtoType().hasEditControlClass();
    }

    public boolean hasEditControlValidation()
    {
        return getProtoType().hasValidatorClass();
    }

    public KmgModelEnum getEnum()
    {
        return _enum;
    }

    public boolean hasEnum()
    {
        return getEnum() != null;
    }

    public KmgModelDependsOn getDependsOn()
    {
        return _dependsOn;
    }

    public boolean hasDependsOn()
    {
        return getDependsOn() != null;
    }

    public void addOnChangeMethod(String e)
    {
        _onChangeMethods.add(e);
    }

    public KmList<String> getOnChangeMethods()
    {
        return _onChangeMethods;
    }

    public boolean isCustomGetter()
    {
        return hasGetter();
    }

    public String getGetter()
    {
        return _getter;
    }

    public void setGetter(String e)
    {
        _getter = e;
    }

    public boolean hasGetter()
    {
        return _getter != null;
    }

    //==================================================
    //= audit log mode
    //==================================================

    public String getAuditLogMode()
    {
        return _auditLogMode;
    }

    public void setAuditLogMode(String e)
    {
        _auditLogMode = e;
    }

    public boolean isAuditLogNormal()
    {
        return !(isAuditLogMasked() || isAuditLogDisabled());
    }

    public boolean isAuditLogMasked()
    {
        return _auditLogMode.equals("mask");
    }

    public boolean isAuditLogDisabled()
    {
        return _auditLogMode.equals("false");
    }

    //##################################################
    //# abstract
    //##################################################

    @Override
    public boolean requiresVariable()
    {
        return isEditable();
    }

    @Override
    public boolean isString()
    {
        return getProtoType().isString();
    }

    @Override
    public boolean isInteger()
    {
        return getProtoType().isInteger();
    }

    @Override
    public boolean isBoolean()
    {
        return getProtoType().isBoolean();
    }

    public boolean isSequence()
    {
        return isInteger() && hasName("sequence");
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

    public boolean isDaoProperty()
    {
        return getModel().hasDatabase() && isEditable();
    }

    public String getf_daoPropertyName()
    {
        return getName();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmgModel getModel()
    {
        return (KmgModel)getParent();
    }

    public boolean hasBaseType(String s)
    {
        return getProtoType().hasName(s);
    }

    public boolean hasBaseType()
    {
        return getProtoType() != null;
    }

    public boolean isLockVersion()
    {
        return isInteger() && hasName("lockVersion");
    }

    public boolean isNotLockVersion()
    {
        return !isLockVersion();
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkAttributeKeys(
            x,
            "name",
            "label",
            "help",
            "comment",
            "primaryKey",
            "identity",
            "required",
            "default",
            "getter",
            "type",
            "auditLog",
            "onChange");

        checkChildrenNames(x, "enum", "dependsOn");

        _name = parseRequiredNameAttribute(x);
        _label = parseString(x, "label", null);
        _help = parseString(x, "help", null);
        _comment = parseString(x, "comment", null);
        _primaryKey = parseBoolean(x, "primaryKey");
        _identity = parseBoolean(x, "identity");
        _required = parseBoolean(x, "required");
        _defaultValue = parseString(x, "default", null);
        _getter = parseString(x, "getter", null);

        String typeName = parseRequiredString(x, "type");
        _type = getRoot().getType(typeName);
        if ( _type == null )
            throw newFatal(x, "Unknown type: %s", typeName);

        _auditLogMode = parseString(x, "auditLog", "true");
        if ( !Kmu.matchesAny(_auditLogMode, "true", "false", "mask") )
            throw newFatal(x, "Unknown audit log: %s", _auditLogMode);

        String onChange = parseString(x, "onChange", null);
        if ( Kmu.hasValue(onChange) )
            _onChangeMethods.add(onChange);

        _enum = parseEnum(x);
        _dependsOn = parseDependsOn(x);
    }

    private KmgModelEnum parseEnum(KmStfElement x)
    {
        x = x.getChild("enum");
        if ( x == null )
            return null;

        KmgModelEnum e;
        e = new KmgModelEnum(this);
        e.parse(x);
        return e;
    }

    private KmgModelDependsOn parseDependsOn(KmStfElement x)
    {
        x = x.getChild("dependsOn");
        if ( x == null )
            return null;

        KmgModelDependsOn e;
        e = new KmgModelDependsOn(this);
        e.parse(x);
        return e;
    }

    @Override
    public void validate()
    {
        if ( !hasBaseType() )
            throw newFatal("Cannnot resolve base type.");

        if ( hasBaseType("string") )
            if ( !getType().hasMaximumLength() )
                throw newFatal("String baseType requires maximum length.");

        if ( hasEnum() )
            getEnum().validate();

        if ( hasDependsOn() )
            getDependsOn().validate();
    }

    @Override
    public void postValidate()
    {
        if ( hasEnum() )
            getEnum().postValidate();

        if ( hasDependsOn() )
            getDependsOn().postValidate();
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String getf_name()
    {
        return getName();
    }

    @Override
    public String getf_sqlColumn()
    {
        return getf_name();
    }

    public String getf_sqlForeignKeyColumn(String prefix)
    {
        return prefix + getf_Name();
    }

    public String getf_sqlColumnDefinition()
    {
        return getProtoType().formatSqlColumnDefinition(this);
    }

    public String getf_sqlColumnDefinitionBare()
    {
        return getProtoType().formatSqlColumnDefinition(this, false);
    }

    @Override
    public String getf_Type()
    {
        return getType().toJavaType();
    }

    public String getf_defaultValue()
    {
        return getDefaultValue();
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

    public String getf_hibernateGeneratorClass()
    {
        if ( isIdentity() )
            return "identity";
        return "assigned";
    }

    public String getf_hibernateType()
    {
        return getProtoType().getHibernateType();
    }

    public String getf_comment()
    {
        return getComment();
    }

    public String getf_help()
    {
        return Kmu.encodeJavaString(getHelp());
    }

    public String getf_sqlType()
    {
        return getProtoType().getDatabaseType(getType());
    }

    public String getf_sqlForeignKeyDefinition(String prefix)
    {
        return getProtoType().formatSqlForeignKeyDefininition(this, prefix);
    }

    public String getf_columnWidth()
    {
        return getType().getf_columnWidth();
    }

    public String getf_CriteriaClass()
    {
        return getProtoType().format_CriteriaClass();
    }

    public String getf_CriteriaClass_NoGeneric()
    {
        return getProtoType().format_CriteriaClass_NoGeneric();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("field(%s)", getName());
    }

    //##################################################
    //# static sort
    //##################################################

    public static KmComparator<KmgModelField> getNameComparator()
    {
        return new KmComparator<KmgModelField>()
        {
            @Override
            public int compare(KmgModelField a, KmgModelField b)
            {
                return a.getName().compareTo(b.getName());
            }
        };
    }

}
