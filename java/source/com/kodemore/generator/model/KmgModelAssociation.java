package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaDaoAssociation;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.KmNamedEnumIF;
import com.kodemore.utility.Kmu;

public class KmgModelAssociation
    extends KmgModelAttribute
{
    //##################################################
    //# enum
    //##################################################

    private enum Relation
        implements KmNamedEnumIF
    {
        Child("child"),
        Parent("parent"),
        Reference("reference"),
        WeakReference("weakReference"),
        Calculated("calculated");

        public static Relation findName(String s)
        {
            for ( Relation e : values() )
                if ( e.getName().equals(s) )
                    return e;
            return null;
        }

        private String _name;

        private Relation(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    private enum OnCopy
        implements KmNamedEnumIF
    {
        Clear("clear"),
        Share("share"),
        Copy("copy"),
        Noop("noop");

        private String _name;

        private OnCopy(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    //##################################################
    //# constructor
    //##################################################

    public KmgModelAssociation(KmgElement parent)
    {
        super(parent);
        _delegates = new KmList<>();
        _onChangeMethods = new KmList<>();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The name of the field.  The name should be all lower case
     * using a space to separate the words.
     */
    private String                   _name;

    /**
     * A description suitable for display to users.
     */
    private String                   _help;

    /**
     * Additional description intended for developers.
     */
    private String                   _comment;

    private String                   _modelReferenceName;

    private KmList<KmgModelDelegate> _delegates;

    /**
     * The relation this association has with its parent.
     * Examples:
     *      child: site -> address.
     *      strongReference: item -> mfg
     *      weakReference: car -> driver
     *
     */
    private Relation                 _relation;

    private boolean                  _required;

    private boolean                  _abstract;

    private KmList<String>           _onChangeMethods;

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

    public KmList<String> getOnChangeMethods()
    {
        return _onChangeMethods;
    }

    public void addOnChangeMethod(String e)
    {
        _onChangeMethods.add(e);
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
        return _relation == Relation.Parent;
    }

    public OnCopy getOnCopy()
    {
        switch ( _relation )
        {
            case Child:
                return OnCopy.Copy;

            case Parent:
            case WeakReference:
                return OnCopy.Clear;

            case Reference:
                return OnCopy.Share;

            case Calculated:
                return OnCopy.Noop;
        }
        return null;
    }

    public boolean isOnCopyClear()
    {
        return getOnCopy() == OnCopy.Clear;
    }

    public boolean isOnCopyCopy()
    {
        return getOnCopy() == OnCopy.Copy;
    }

    public boolean isOnCopyShare()
    {
        return getOnCopy() == OnCopy.Share;
    }

    //##################################################
    //# cascade
    //##################################################

    public String getCascade()
    {
        switch ( _relation )
        {
            case Child:
                return "all";

            case Parent:
            case Reference:
            case WeakReference:
            case Calculated:
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
        checkAttributeKeys(x, "name", "help", "comment", "modelName", "relation", "required");
        checkChildrenNames(x, "delegate");

        _name = parseRequiredNameAttribute(x);
        _help = parseString(x, "help", null);
        _comment = parseString(x, "comment", null);
        _modelReferenceName = parseRequiredName(x, "modelName");
        _required = parseBoolean(x, "required");

        if ( isAbstract() )
            _relation = Relation.Calculated;
        else
        {
            String s = parseRequiredString(x, "relation");
            _relation = Relation.findName(s);
            if ( _relation == null )
                error("Invalid relation: " + s);
        }

        KmList<KmStfElement> v = x.getChildren("delegate");
        for ( KmStfElement e : v )
            addDelegate().parse(e);
    }

    @Override
    public void validate()
    {
        if ( getModelReference() == null )
            error("Cannot resolve model reference: " + getModelReferenceName());

        validateRelation();

        _validate(_delegates);
    }

    private void validateRelation()
    {
        KmgModelCollection ic = getInverseCollection();
        switch ( _relation )
        {
            case Child:
                if ( ic != null )
                    error("Child association should not have inverse collection.");
                return;

            case Parent:
                if ( ic == null )
                    error("Parent association must have inverse collection.");
                return;

            case Reference:
                if ( ic != null )
                    error("Reference association should not have inverse collection.");
                return;

            case WeakReference:
                if ( ic != null )
                    error("Weak reference association should not have inverse collection.");
                return;

            case Calculated:
                return;
        }
    }

    @Override
    public void postValidate()
    {
        _postValidate(_delegates);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    private KmgModelField getReferenceModelPrimaryKeyField()
    {
        KmList<KmgModelField> pks = getModelReference().getPrimaryKeyFields();

        if ( pks.size() != 1 )
            error("manyToOne must reference a model that has a single field primary key.");

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

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("association(%s)", getName());
    }

}
