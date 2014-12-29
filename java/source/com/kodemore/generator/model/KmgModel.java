package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmComparator;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModel
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String                          _name;
    private String                          _help;
    private String                          _comment;
    private boolean                         _skipModelBase;
    private String                          _superclass;
    private KmList<KmgModelField>           _fields;
    private KmList<KmgModelCollection>      _collections;
    private KmList<KmgModelValueCollection> _valueCollections;
    private KmList<KmgModelAssociation>     _associations;
    private KmgModelDatabase                _database;

    //##################################################
    //# constructor
    //##################################################

    public KmgModel(KmgElement parent)
    {
        super(parent);

        _fields = new KmList<>();
        _collections = new KmList<>();
        _valueCollections = new KmList<>();
        _associations = new KmList<>();
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

    public boolean hasName(String s)
    {
        return _name.equals(s);
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

    public boolean getSkipModelBase()
    {
        return _skipModelBase;
    }

    public String getSuperclass()
    {
        return _superclass;
    }

    public void setSuperclass(String e)
    {
        _superclass = e;
    }

    public KmList<KmgModelAttribute> getAttributes()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();
        v.addAll(getFields());
        v.addAll(getAssociations());
        v.addAll(getCollections());
        v.addAll(getValueCollections());
        v.addAll(getDelegates());
        return v;
    }

    public KmgModelAttribute getAttributeNamed(String s)
    {
        for ( KmgModelAttribute e : getAttributes() )
            if ( e.hasName(s) )
                return e;
        return null;
    }

    public KmList<KmgModelAttribute> getFieldsAndDelegates()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();
        v.addAll(getFields());
        v.addAll(getDelegates());
        return v;
    }

    public KmList<KmgModelAttribute> getEditableFieldsAndDelegates()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();
        v.addAll(getEditableFields());
        v.addAll(getEditableDelegates());
        return v;
    }

    public KmList<KmgModelAttribute> getMetaFieldsAndDelegates()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();
        v.addAll(getMetaFields());
        v.addAll(getMetaDelegates());
        return v;
    }

    public KmList<?> getFieldsDelegatesAndAssociations()
    {
        KmList<Object> v = new KmList<>();
        v.addAll(getFields());
        v.addAll(getDelegates());
        v.addAll(getAssociations());
        return v;
    }

    public KmList<KmgModelField> getFields()
    {
        return _fields;
    }

    public KmList<KmgModelField> getEditableFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( e.isEditable() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelField> getPropertyFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( e.isEditable() && e.getProtoType().isProperty() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelField> getMetaFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( e.isMeta() )
                v.add(e);
        return v;
    }

    public KmgModelField getField(String name)
    {
        for ( KmgModelField e : _fields )
            if ( e.hasName(name) )
                return e;
        return null;
    }

    public boolean hasField(String name)
    {
        return getField(name) != null;
    }

    public KmList<KmgModelCollection> getCollections()
    {
        return _collections;
    }

    public KmgModelCollection getCollectionReferencing(KmgModelAssociation ref)
    {
        for ( KmgModelCollection e : getCollections() )
            if ( e.hasAssociationReference(ref) )
                return e;
        return null;
    }

    public KmList<KmgModelValueCollection> getValueCollections()
    {
        return _valueCollections;
    }

    public boolean hasIntegerId()
    {
        KmgModelField f = getField("id");
        if ( f == null )
            return false;
        return f.getProtoType().isInteger();
    }

    public KmList<KmgModelAssociation> getAssociations()
    {
        return _associations;
    }

    public KmList<KmgModelAssociation> getEditableAssociations()
    {
        KmList<KmgModelAssociation> v = new KmList<>();
        for ( KmgModelAssociation e : getAssociations() )
            if ( e.isEditable() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelAssociation> getMetaAssociations()
    {
        KmList<KmgModelAssociation> v = new KmList<>();
        for ( KmgModelAssociation e : getAssociations() )
            if ( e.isMeta() )
                v.add(e);
        return v;
    }

    public KmgModelAssociation getAssociation(String name)
    {
        for ( KmgModelAssociation e : getAssociations() )
            if ( e.hasName(name) )
                return e;
        return null;
    }

    public KmList<KmgModelAssociation> getAssocitionsWithPrimaryKeys()
    {
        KmList<KmgModelAssociation> v = new KmList<>();
        for ( KmgModelAssociation e : _associations )
            if ( e.hasPrimaryKey() )
                v.add(e);
        return v;
    }

    public boolean hasAssociationsWithPrimaryKeys()
    {
        return getAssocitionsWithPrimaryKeys().isNotEmpty();
    }

    public KmList<KmgModelDelegate> getDelegates()
    {
        KmList<KmgModelDelegate> v = new KmList<>();
        for ( KmgModelAssociation a : getAssociations() )
            v.addAll(a.getDelegates());
        return v;
    }

    public KmList<KmgModelDelegate> getMetaDelegates()
    {
        KmList<KmgModelDelegate> v = new KmList<>();
        for ( KmgModelAssociation a : getAssociations() )
            v.addAll(a.getMetaDelegates());
        return v;
    }

    public KmgModelDelegate getDelegate(String fieldName)
    {
        KmList<KmgModelDelegate> v = getDelegates();
        for ( KmgModelDelegate e : v )
            if ( e.hasName(fieldName) )
                return e;
        return null;
    }

    public KmList<KmgModelDelegate> getEditableDelegates()
    {
        KmList<KmgModelDelegate> v = new KmList<>();
        for ( KmgModelAssociation a : getAssociations() )
            v.addAll(a.getEditableDelegates());
        return v;
    }

    public KmgModelField addField()
    {
        KmgModelField e;
        e = new KmgModelField(this);
        _fields.add(e);
        return e;
    }

    public KmgModelField addAbstractField()
    {
        KmgModelField e;
        e = addField();
        e.setAbstract(true);
        return e;
    }

    public KmgModelField addCustomGetter(
        String name,
        String label,
        String help,
        String body,
        String type)
    {
        KmgModelField f;
        f = addAbstractField();
        f.setName(name);
        f.setLabel(label);
        f.setHelp(help);
        f.setType(type);
        f.setGetter(body);
        return f;
    }

    public KmgModelAssociation addAssociation()
    {
        KmgModelAssociation e;
        e = new KmgModelAssociation(this);
        _associations.add(e);
        return e;
    }

    public KmgModelAssociation addAbstractAssociation()
    {
        KmgModelAssociation e = addAssociation();
        e.setAbstract(true);
        return e;
    }

    public KmgModelCollection addModelCollection()
    {
        KmgModelCollection e;
        e = new KmgModelCollection(this);
        _collections.add(e);
        return e;
    }

    public KmgModelValueCollection addValueCollection()
    {
        KmgModelValueCollection e;
        e = new KmgModelValueCollection(this);
        _valueCollections.add(e);
        return e;
    }

    public KmgModelDatabase getDatabase()
    {
        return _database;
    }

    public boolean hasDatabase()
    {
        return _database != null;
    }

    public boolean hasPrimaryKey()
    {
        for ( KmgModelField e : _fields )
            if ( e.isPrimaryKey() )
                return true;
        return false;
    }

    public boolean hasNoFields()
    {
        return getFields().isEmpty();
    }

    public boolean isCached()
    {
        return hasDatabase() && getDatabase().isCached();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmgModel getModel()
    {
        return this;
    }

    public KmgModelField getPrimaryKeyField()
    {
        KmList<KmgModelField> v = getPrimaryKeyFields();
        if ( !v.isSingleton() )
            error("This model must have exactly one primary key field.");
        return getPrimaryKeyFields().getFirst();
    }

    public KmList<KmgModelField> getPrimaryKeyFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( e.isPrimaryKey() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelField> getNonPrimaryKeyFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( !e.isPrimaryKey() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelField> getEditableNonPrimaryKeyFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( e.isEditable() && e.isNotPrimaryKey() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelField> getGeneralFields()
    {
        KmList<KmgModelField> v = new KmList<>();
        for ( KmgModelField e : getFields() )
            if ( e.isEditable() && e.isNotPrimaryKey() && e.isNotLockVersion() )
                v.add(e);
        return v;
    }

    public KmgModelField getIdentityField()
    {
        for ( KmgModelField f : getPrimaryKeyFields() )
            if ( f.isIdentity() )
                return f;
        return null;
    }

    public KmList<KmgModelAttribute> getDatabaseAttributes()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();

        for ( KmgModelField e : getFields() )
            if ( e.isEditable() )
                v.add(e);

        for ( KmgModelAssociation e : getAssociations() )
            if ( e.isEditable() )
                v.add(e);

        return v;
    }

    public boolean isSequenceIF()
    {
        for ( KmgModelField e : getFields() )
            if ( e.isSequence() )
                return true;
        return false;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isIdentity()
    {
        return getIdentityField() != null;
    }

    public boolean isNotIdentity()
    {
        return !isIdentity();
    }

    public boolean hasSingleton()
    {
        for ( KmgModelField e : getFields() )
            if ( e.isSingleton() )
                return true;
        return false;
    }

    public boolean hasAvailable()
    {
        for ( KmgModelField e : getFields() )
            if ( e.isAvailable() )
                return true;

        return false;
    }

    public boolean hasUnique()
    {
        for ( KmgModelField e : getFields() )
            if ( e.isUnique() )
                return true;

        return false;
    }

    public KmList<String> getFieldNames()
    {
        KmList<String> v = new KmList<>();

        for ( KmgModelField e : getFields() )
            v.add(e.getName());

        return v;
    }

    public KmList<String> getOnChangeMethods()
    {
        KmList<String> v = new KmList<>();

        for ( KmgModelField e : getFields() )
            v.addAllDistinct(e.getOnChangeMethods());

        for ( KmgModelAssociation e : getAssociations() )
            v.addAllDistinct(e.getOnChangeMethods());

        v.sort();
        return v;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        parseModel(x);
        parseDatabase(x);
        parseAttributes(x);

        if ( hasDatabase() && getDatabase().getLockVersion() )
            addLockVersionField();
    }

    private void parseModel(KmStfElement root)
    {
        KmStfElement x = root.getChild("model");
        checkAttributeKeys(x, "name", "help", "comment", "skipModelBase", "superclass");

        _name = parseRequiredNameAttribute(x);
        _help = parseString(x, "help", null);
        _comment = parseString(x, "comment", null);
        _skipModelBase = parseBoolean(x, "skipModelBase");
        _superclass = parseString(x, "superclass", null);
    }

    private void parseDatabase(KmStfElement root)
    {
        KmStfElement x = root.getChild("database");
        if ( x == null )
            return;

        _database = new KmgModelDatabase(this);
        _database.parse(x);
    }

    private void parseAttributes(KmStfElement root)
    {
        KmStfElement x = root.getChild("attributes");
        if ( x == null )
            return;

        KmList<KmStfElement> v;

        v = x.getChildren("field");
        for ( KmStfElement e : v )
            addField().parse(e);

        v = x.getChildren("abstractField");
        for ( KmStfElement e : v )
            addAbstractField().parse(e);

        v = x.getChildren("association");
        for ( KmStfElement e : v )
            addAssociation().parse(e);

        v = x.getChildren("abstractAssociation");
        for ( KmStfElement e : v )
            addAbstractAssociation().parse(e);

        v = x.getChildren("collection");
        for ( KmStfElement e : v )
            addModelCollection().parse(e);

        v = x.getChildren("valueCollection");
        for ( KmStfElement e : v )
            addValueCollection().parse(e);
    }

    @Override
    public void validate()
    {
        checkDuplicates("field.name", getFieldNames());

        _validate(getFields());
        _validate(getCollections());
        _validate(getValueCollections());
        _validate(getAssociations());
        _validate(getDatabase());

        int i = 0;
        for ( KmgModelAssociation e : getAssociations() )
            if ( e.isRelationParent() && e.getInverseCollection().isRelationStrong() )
                i++;

        if ( i > 1 )
            error("Model cannot contain multiple (strong) parent associations.");
    }

    @Override
    public void postValidate()
    {
        _postValidate(getFields());
        _postValidate(getCollections());
        _postValidate(getValueCollections());
        _postValidate(getAssociations());
        _postValidate(getDatabase());
    }

    //##################################################
    //# lock version field
    //##################################################

    public KmgModelField getLockVersionField()
    {
        for ( KmgModelField e : getFields() )
            if ( e.isLockVersion() )
                return e;

        return null;
    }

    public boolean hasLockVersionField()
    {
        return getLockVersionField() != null;
    }

    private void addLockVersionField()
    {
        KmgModelField e;
        e = addField();
        e.setName("lockVersion");
        e.setHelp(""
            + "This is used to coordinate optimistic locking in the database. "
            + "This is usually not displayed.");
        e.setType("lockVersion");
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
        return capitalize(getf_name());
    }

    public String getf_Names()
    {
        return pluralize(getf_Name());
    }

    public String getf_NAME()
    {
        return toConstant(getf_name());
    }

    public String getf_Class()
    {
        return formatClass("");
    }

    public String getf_BaseClass()
    {
        return formatClass("Base");
    }

    public String getf_CriteriaClass()
    {
        return formatClass("Criteria");
    }

    public String getf_JunctionClass()
    {
        return formatClass("Junction");
    }

    public String getf_Superclass()
    {
        if ( _superclass == null )
            return getRoot().getDefaultModelSuperClass();
        return _superclass;
    }

    public String getf_sqlTable()
    {
        return getf_name();
    }

    public String getf_Type()
    {
        return getf_Class();
    }

    public String getf_ValidatorClass()
    {
        return formatClass("Validator");
    }

    public String getf_ValidatorBaseClass()
    {
        return formatClass("ValidatorBase");
    }

    public String getf_ToolsClass()
    {
        return formatClass("Tools");
    }

    public String getf_ToolsBaseClass()
    {
        return formatClass("ToolsBase");
    }

    public String getf_daoGetter()
    {
        return Kmu.format("getAccess().get%sDao", getf_Name());
    }

    public String getf_DaoClass()
    {
        return formatClass("Dao");
    }

    public String getf_DaoBaseClass()
    {
        return formatClass("DaoBase");
    }

    public String getf_DaoConstantsIF()
    {
        return formatClass("DaoConstantsIF");
    }

    public String getf_FinderClass()
    {
        return formatClass("Finder");
    }

    public String getf_FilterClass()
    {
        return formatClass("Filter");
    }

    public String getf_FilterBaseClass()
    {
        return formatClass("FilterBase");
    }

    public String getf_List()
    {
        return "KmList" + getf_GenericClass();
    }

    public String getf_GenericClass()
    {
        return "<" + formatClass("") + ">";
    }

    public String getf_comment()
    {
        return getComment();
    }

    public String getf_commentJavaString()
    {
        return toJavaString(getComment());
    }

    public String getf_help()
    {
        return getHelp();
    }

    public String getf_helpJavaString()
    {
        return toJavaString(getHelp());
    }

    public String getf_MetaClass()
    {
        return getf_Prefix() + "Meta" + getf_Name();
    }

    //##################################################
    //# support
    //##################################################

    private String formatClass(String suffix)
    {
        return getf_Prefix() + getf_Name() + suffix;
    }

    private String toJavaString(String s)
    {
        return "\"" + Kmu.escapeJavaString(s) + "\"";
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("model(%s)", _name);
    }

    //##################################################
    //# static sort
    //##################################################

    public static KmComparator<KmgModel> getNameComparator()
    {
        return new KmComparator<KmgModel>()
        {
            @Override
            public int compare(KmgModel a, KmgModel b)
            {
                return a.getName().compareTo(b.getName());
            }
        };
    }

}
