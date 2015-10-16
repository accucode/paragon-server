package com.kodemore.generator;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.generator.extend.KmgEnumNameFieldExtender;
import com.kodemore.generator.extend.KmgFieldExtender;
import com.kodemore.generator.extend.KmgUtcTsFieldExtender;
import com.kodemore.generator.model.KmgCssBundle;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelAssociation;
import com.kodemore.generator.model.KmgModelAttribute;
import com.kodemore.generator.model.KmgModelEnum;
import com.kodemore.generator.model.KmgModelField;
import com.kodemore.generator.model.KmgModelType;
import com.kodemore.generator.property.KmgPropertyFile;
import com.kodemore.proto.KmProtoType;
import com.kodemore.proto.KmProtoTypes;
import com.kodemore.stf.KmStfElement;
import com.kodemore.stf.KmStfParser;
import com.kodemore.stf.KmStfRoot;
import com.kodemore.stf.KmStfShortcut;
import com.kodemore.utility.Kmu;

public class KmgRoot
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,KmProtoType> _baseTypes;
    private KmList<KmgModelType>      _types;
    private KmList<KmgModel>          _models;
    private KmgPropertyFile           _propertyFile;

    private KmList<String> _pageClassNames;
    private KmList<String> _pagePackageNames;

    private String _applicationName;
    private String _applicationPackage;
    private String _applicationPrefix;

    private String _defaultModelSuperClass;

    private KmList<KmgFieldExtender> _extenders;

    private KmList<KmgCssBundle> _cssBundles;

    //##################################################
    //# constructor
    //##################################################

    public KmgRoot()
    {
        super(null);
        _baseTypes = KmProtoTypes.getAll();
        _types = new KmList<>();
        _models = new KmList<>();
        _pageClassNames = new KmList<>();
        _pagePackageNames = new KmList<>();
        _extenders = getDefaultExtenders();
        _cssBundles = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getApplicationName()
    {
        return _applicationName;
    }

    public void setApplicationName(String e)
    {
        _applicationName = e;
    }

    public String getApplicationPackage()
    {
        return _applicationPackage;
    }

    public void setApplicationPackage(String e)
    {
        _applicationPackage = e;
    }

    public String getApplicationPackagePath()
    {
        return Kmu.replaceAll(getApplicationPackage(), ".", "/");
    }

    public String getApplicationPrefix()
    {
        return _applicationPrefix;
    }

    public void setApplicationPrefix(String e)
    {
        _applicationPrefix = e;
    }

    public KmMap<String,KmProtoType> getBaseTypes()
    {
        return _baseTypes;
    }

    public KmProtoType getBaseType(String name)
    {
        return getBaseTypes().get(name);
    }

    public KmList<KmgModelType> getTypes()
    {
        return _types;
    }

    public KmList<String> getTypeNames()
    {
        KmList<String> v = new KmList<>();
        for ( KmgModelType e : getTypes() )
            v.add(e.getName());
        return v;
    }

    public KmList<KmgModel> getModels()
    {
        return _models;
    }

    public KmList<KmgModel> getCacheModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.isCached() )
                v.add(e);
        return v;
    }

    public KmList<KmgModel> getDatabaseModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasDatabase() )
                v.add(e);
        return v;
    }

    public KmList<KmgModel> getModelBases()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( !e.getSkipModelBase() )
                v.add(e);
        return v;
    }

    public KmList<KmgModel> getPrimaryKeyModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasPrimaryKey() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelAttribute> getMetaFieldsAndDelegates()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();
        for ( KmgModel e : getModels() )
            v.addAll(e.getMetaFieldsAndDelegates());
        return v;
    }

    public KmList<KmgModelAssociation> getMetaAssociations()
    {
        KmList<KmgModelAssociation> v;
        v = new KmList<>();
        for ( KmgModel e : getModels() )
            v.addAll(e.getMetaAssociations());
        return v;
    }

    public KmList<KmgModel> getNonDatabaseModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( !e.hasDatabase() )
                v.add(e);
        return v;
    }

    public KmList<KmgModel> getPageModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasDatabase() && e.getDatabase().getPages() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelEnum> getEnums()
    {
        KmMap<String,KmgModelEnum> v = new KmMap<>();

        for ( KmgModel m : getModels() )
            for ( KmgModelField f : m.getFields() )
                if ( f.hasEnum() )
                {
                    KmgModelEnum e = f.getEnum();
                    v.put(e.getType(), e);
                }
        return v.getValues();
    }

    public KmList<KmgModel> getModelsByAlias(String s)
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasDatabase() && e.getDatabase().hasAlias(s) )
                v.add(e);
        return v;
    }

    public KmList<String> getModelNames()
    {
        KmList<String> v = new KmList<>();
        for ( KmgModel e : getModels() )
            v.add(e.getName());
        return v;
    }

    public KmList<String> getModelAliases()
    {
        KmList<String> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasDatabase() )
                v.add(e.getDatabase().getAlias());
        return v;
    }

    public KmgPropertyFile getPropertyFile()
    {
        return _propertyFile;
    }

    public String getDefaultModelSuperClass()
    {
        return _defaultModelSuperClass;
    }

    public void setDefaultModelSuperClass(String e)
    {
        _defaultModelSuperClass = e;
    }

    public KmList<String> getPageClassNames()
    {
        return _pageClassNames;
    }

    public KmList<String> getPagePackageNames()
    {
        return _pagePackageNames;
    }

    public KmList<KmgCssBundle> getCssBundles()
    {
        return _cssBundles;
    }

    public KmgCssBundle addCssBundle(String name)
    {
        KmgCssBundle e;
        e = new KmgCssBundle();
        e.setName(name);

        _cssBundles.add(e);

        return e;
    }

    //##################################################
    //# extenders
    //##################################################

    public KmList<KmgFieldExtender> getExtenders()
    {
        return _extenders;
    }

    public void addExtender(KmgFieldExtender e)
    {
        _extenders.add(e);
    }

    public void clearExtenders()
    {
        _extenders.clear();
    }

    private KmList<KmgFieldExtender> getDefaultExtenders()
    {
        KmList<KmgFieldExtender> v;
        v = new KmList<>();
        v.add(new KmgEnumNameFieldExtender());
        v.add(new KmgUtcTsFieldExtender());
        return v;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmgRoot getRoot()
    {
        return this;
    }

    public KmgModelType getType(String name)
    {
        for ( KmgModelType e : getTypes() )
            if ( e.hasName(name) )
                return e;

        return null;
    }

    public KmgModel getModel(String name)
    {
        for ( KmgModel e : getModels() )
            if ( e.hasName(name) )
                return e;

        return null;
    }

    public KmgModelField getField(String modelName, String fieldName)
    {
        return getModel(modelName).getField(fieldName);
    }

    //##################################################
    //# install
    //##################################################

    public void installTypes(String path)
    {
        KmStfParser parser;
        parser = new KmStfParser();
        parser.parseFile(path);

        KmStfElement root;
        root = parser.getRoot();

        for ( KmStfElement c : root.getChildren() )
        {
            KmgModelType e;
            e = new KmgModelType(this);
            e.parse(c);

            _types.add(e);
        }

        _types.sortOn(KmgModelType.getNameComparator());

        _validate(_types);
        checkDuplicates("type.name", getTypeNames());
    }

    public void installProperties(String path)
    {
        KmgPropertyFile e;
        e = new KmgPropertyFile(this);
        e.parseFile(path);
        e.validate();
        _propertyFile = e;
    }

    //##################################################
    //# install models
    //##################################################

    public void installModels(String dir)
    {
        System.out.println("Installing models...");
        KmFileTraverser e = new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                if ( f.hasExtension("stf") )
                    installModel(f);
            }
        };
        e.processAll(dir);
        _models.sortOn(KmgModel.getNameComparator());
    }

    public void validateModels()
    {
        _validate(_models);
        checkDuplicates("model.name", getModelNames());
        checkDuplicateAliases();
        _postValidate(_models);
    }

    private void installModel(KmFile f)
    {
        System.out.println("    " + f.getName());

        KmStfRoot root;
        root = parseModel(f);

        KmgModel e;
        e = new KmgModel(this);
        e.parse(root);

        if ( !f.hasShortName(e.getName()) )
            throw newFatal(
                "Model name (%s) should match file name (%s).",
                e.getName(),
                f.getName());

        _models.add(e);
    }

    private KmStfRoot parseModel(KmFile f)
    {
        String s;
        s = f.readString();

        KmStfParser p;
        p = new KmStfParser();
        p.setIncludeFolder(f.getParent().getSibling("include"));

        KmStfShortcut sc;

        sc = p.addShortcut();
        sc.setElementPath("**/enum/value");
        sc.setArgumentPrefix("#");
        sc.setAttributeKey("code");

        sc = p.addShortcut();
        sc.setElementPath("**/enum/value");
        sc.setAttributeKey("name");

        p.parseSource(s);

        return p.getRoot();
    }

    private void checkDuplicateAliases()
    {
        String alias = getModelAliases().getDuplicates().getFirstSafe();
        if ( alias == null )
            return;

        KmList<KmgModel> models = getModelsByAlias(alias);
        KmList<String> names = new KmList<>();

        for ( KmgModel m : models )
            names.add(m.getName());

        throw newFatal("Cannot have duplicate alias(%s), see models: %s.", alias, names.join());
    }

    public void installExtensions()
    {
        for ( KmgFieldExtender e : getExtenders() )
            e.extendAll(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "root";
    }

    //##################################################
    //# support
    //##################################################

    public String format_ApplicationPrefix()
    {
        return Kmu.toCamelCase(getApplicationPrefix());
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validate()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void postValidate()
    {
        throw new UnsupportedOperationException();
    }

}
