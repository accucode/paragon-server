package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaDaoAssociation;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.KmHtmlLineEnding;
import com.kodemore.utility.Kmu;

public class KmgModelAssociation
    extends KmgModelAttribute
{
    //##################################################
    //# enum
    //##################################################

    private enum Relation
        implements KmEnumIF
    {
        child,
        parent,
        reference,
        weakReference,
        calculated;
    }

    private enum OnCopy
        implements KmEnumIF
    {
        clear,
        share,
        copy,
        noop;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The name of the field.  The name should be all lower case
     * using a space to separate the words.
     */
    private String _name;

    private String _label;

    /**
     * A description suitable for display to users.
     */
    private String _help;

    /**
     * Additional description intended for developers.
     */
    private String _comment;

    private String _modelReferenceName;

    private KmList<KmgModelDelegate> _delegates;

    /**
     * The relation this association has with its parent.
     * Examples:
     *      child: site -> address.
     *      strongReference: item -> mfg
     *      weakReference: car -> driver
     *
     */
    private Relation _relation;

    private boolean _required;

    private boolean _abstract;

    /**
     * The list of attributes that I depend on, and what
     * to do when any of those attributes changes.
     */
    private KmgModelDependsOn _dependsOn;

    private KmList<String> _onChangeMethods;

    /**
     * The optional default value.
     */
    private String _defaultValue;

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

    public KmgModelAssociation(KmgElement parent)
    {
        super(parent);
        _delegates = new KmList<>();
        _onChangeMethods = new KmList<>();
        _auditLogMode = "true";
    }

    //##################################################
    //# abstract
    //##################################################

    @Override
    public boolean requiresVariable()
    {
        return isEditable();
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

    public boolean hasLabel()
    {
        // emtpy string is a valid label.
        return _label != null;
    }

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

    public String getModelReferenceName()
    {
        return _modelReferenceName;
    }

    public void setModelReferenceName(String s)
    {
        _modelReferenceName = s;
    }

    public boolean hasModelReference(KmgModel e)
    {
        return Kmu.isEqual(getModelReference(), e);
    }

    public KmgModel getModelReference()
    {
        return getRoot().getModel(_modelReferenceName);
    }

    public KmgModelField getPrimaryKeyField()
    {
        return getModelReference().getPrimaryKeyField();
    }

    public KmList<KmgModelDelegate> getDelegates()
    {
        return _delegates;
    }

    public KmList<KmgModelDelegate> getEditableDelegates()
    {
        KmList<KmgModelDelegate> v = new KmList<>();
        for ( KmgModelDelegate e : _delegates )
            if ( e.isEditable() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelDelegate> getMetaDelegates()
    {
        KmList<KmgModelDelegate> v = new KmList<>();
        for ( KmgModelDelegate e : _delegates )
            if ( e.isMeta() )
                v.add(e);
        return v;
    }

    public KmgModelDelegate addDelegate()
    {
        KmgModelDelegate e = new KmgModelDelegate(this);
        _delegates.add(e);
        return e;
    }

    public boolean isRequired()
    {
        return _required;
    }

    public boolean hasInverseCollection()
    {
        return getInverseCollection() != null;
    }

    public KmgModelCollection getInverseCollection()
    {
        return getModelReference().getCollectionReferencing(this);
    }

    public void setAbstract(boolean e)
    {
        _abstract = e;
    }

    public boolean isAbstract()
    {
        return _abstract;
    }

    public boolean isEditable()
    {
        return !isAbstract();
    }

    public KmgModelDependsOn getDependsOn()
    {
        return _dependsOn;
    }

    public boolean hasDependsOn()
    {
        return getDependsOn() != null;
    }

    public KmList<String> getOnChangeMethods()
    {
        return _onChangeMethods;
    }

    public void addOnChangeMethod(String e)
    {
        _onChangeMethods.add(e);
    }

    public String getDefaultValue()
    {
        return _defaultValue;
    }

    public boolean hasDefaultValue()
    {
        return Kmu.hasValue(getDefaultValue());
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
    //# relation
    //##################################################

    public Relation getRelation()
    {
        return _relation;
    }

    public boolean isRelationParent()
    {
        return _relation == Relation.parent;
    }

    public OnCopy getOnCopy()
    {
        switch ( _relation )
        {
            case child:
                return OnCopy.copy;

            case parent:
            case weakReference:
                return OnCopy.clear;

            case reference:
                return OnCopy.share;

            case calculated:
                return OnCopy.noop;
        }
        return null;
    }

    public boolean isOnCopyClear()
    {
        return getOnCopy() == OnCopy.clear;
    }

    public boolean isOnCopyCopy()
    {
        return getOnCopy() == OnCopy.copy;
    }

    public boolean isOnCopyShare()
    {
        return getOnCopy() == OnCopy.share;
    }

    //##################################################
    //# cascade
    //##################################################

    public String getCascade()
    {
        switch ( _relation )
        {
            case child:
                return "all";

            case parent:
            case reference:
            case weakReference:
            case calculated:
                return "none";
        }
        throw new RuntimeException("Unhandled relation");
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
        String attrClass = isMetaDao()
            ? Kmu.getSimpleClassName(KmMetaDaoAssociation.class)
            : Kmu.getSimpleClassName(KmMetaAssociation.class);

        String modelClass = getModel().getf_Class();
        String type = getf_Type();

        return Kmu.format("%s<%s,%s>", attrClass, modelClass, type);
    }

    public boolean isMetaDao()
    {
        return !isAbstract();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmgModel getModel()
    {
        return (KmgModel)getParent();
    }

    public boolean hasPrimaryKey()
    {
        return getModelReference().hasPrimaryKey();
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
            "help",
            "label",
            "comment",
            "modelName",
            "relation",
            "required",
            "default",
            "auditLog",
            "onChange");

        checkChildrenNames(x, "delegate", "dependsOn");

        _name = parseRequiredNameAttribute(x);
        _label = parseString(x, "label", null);
        _help = parseString(x, "help", null);
        _comment = parseString(x, "comment", null);
        _modelReferenceName = parseRequiredName(x, "modelName");
        _required = parseBoolean(x, "required");
        _defaultValue = parseString(x, "default", null);

        _onChangeMethods.addAll(parseStrings(x, "onChange"));

        _auditLogMode = parseString(x, "auditLog", "true");
        if ( !Kmu.matchesAny(_auditLogMode, "true", "false", "mask") )
            throw newError(x, "Unknown audit log: %s", _auditLogMode);

        if ( isAbstract() )
            _relation = Relation.calculated;
        else
        {
            String s = parseRequiredString(x, "relation");
            try
            {
                _relation = Relation.valueOf(s);
            }
            catch ( IllegalArgumentException ex )
            {
                throw newError("Invalid relation: " + s);
            }
        }

        KmList<KmStfElement> v = x.getChildren("delegate");
        for ( KmStfElement e : v )
            addDelegate().parse(e);

        _dependsOn = parseDependsOn(x);
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
        if ( getModelReference() == null )
            throw newError("Cannot resolve model reference: " + getModelReferenceName());

        validateRelation();

        _validate(_delegates);

        if ( hasDependsOn() )
            getDependsOn().validate();
    }

    private void validateRelation()
    {
        KmgModelCollection ic = getInverseCollection();
        switch ( _relation )
        {
            case child:
                if ( ic != null )
                    throw newError("Child association should not have inverse collection.");
                return;

            case parent:
                if ( ic == null )
                    throw newError("Parent association must have inverse collection.");
                return;

            case reference:
                if ( ic != null )
                    throw newError("Reference association should not have inverse collection.");
                return;

            case weakReference:
                if ( ic != null )
                    throw newError(
                        "Weak reference association should not have inverse collection.");
                return;

            case calculated:
                return;
        }
    }

    @Override
    public void postValidate()
    {
        _postValidate(_delegates);

        if ( hasDependsOn() )
            getDependsOn().postValidate();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    private KmgModelField getReferenceModelPrimaryKeyField()
    {
        KmList<KmgModelField> pks = getModelReference().getPrimaryKeyFields();

        if ( pks.size() != 1 )
            throw newError("manyToOne must reference a model that has a single field primary key.");

        KmgModelField f = pks.getFirst();
        return f;
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public String getf_name()
    {
        return Kmu.toKneelingCamelCase(getName());
    }

    @Override
    public String getf_Name()
    {
        return Kmu.toCamelCase(getName());
    }

    public String getf_PkName()
    {
        return Kmu.format("%s%s", getf_Name(), getPrimaryKeyField().getf_Name());
    }

    public String getf_PK_NAME()
    {
        return Kmu.format("%s_%s", getf_NAME(), getPrimaryKeyField().getf_NAME());
    }

    @Override
    public String getf_NAME()
    {
        return Kmu.formatAsConstant(getName());
    }

    public String getf_label()
    {
        if ( hasLabel() )
            return getLabel();

        return Kmu.formatCamelCaseAsWords(getf_Name());
    }

    public String getf_help()
    {
        return getHelp();
    }

    public String getf_helpHtml()
    {
        if ( !hasHelp() )
            return "";

        String s;
        s = getHelp();
        s = Kmu.escapeHtml(s, KmHtmlLineEnding.BreakElement);
        s = Kmu.replaceAll(s, "<br>", "<br><br>");
        return s;
    }

    public String getf_helpJavaString()
    {
        return Kmu.encodeJavaString(getHelp());
    }

    @Override
    public String getf_Type()
    {
        return getModelReference().getf_Type();
    }

    public String format_variable()
    {
        return getf_name();
    }

    @Override
    public String getf_getMethod()
    {
        return "get" + getf_Name();
    }

    @Override
    public String getf_setMethod()
    {
        return "set" + getf_Name();
    }

    @Override
    public String getf_sqlColumn()
    {
        KmgModelField f = getReferenceModelPrimaryKeyField();
        return f.getf_sqlForeignKeyColumn(getName());
    }

    public String getf_sqlColumnDefinition()
    {
        KmgModelField f = getReferenceModelPrimaryKeyField();
        return f.getf_sqlForeignKeyDefinition(getName());
    }

    public String getf_cascade()
    {
        return getCascade();
    }

    public String getf_defaultValue()
    {
        return getDefaultValue();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("association(%s)", getName());
    }

}
